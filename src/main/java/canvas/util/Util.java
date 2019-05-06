/**
 * Util.java
 * 
 * utility methods used in the app
 * 
 */
package canvas.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author sajith
 * @date 25, Apr 2019
 * @modified 28, Apr 2019.
 */
public final class Util {
	
	private static final ResourceBundle contentBundle = ResourceBundle.getBundle("props.content");
	private static final String CONTENT_FILE_MISSING = "Resource file props/content.properties file is missing. This is required to display system messages";
	
	/**
	 * return true if passed sting is either null or empty. Spaces are considered empty
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isEmpty(String  text) {
		
		return (text==null || text.trim().equals(""));
	}

	/**
	 * get the message from content resource bundle with the given key. Return content missing message in case key not found.
	 * 
	 * @param resourceKey
	 * @return
	 */
	public static String getDisplayMessage(String resourceKey) {
		String content  = null;
		try {
			content  = contentBundle.getString(resourceKey);
		}catch(NullPointerException npe) {
			return CONTENT_FILE_MISSING;
		}catch(MissingResourceException mre) {
			return CONTENT_FILE_MISSING;
		}
		
		
		if (Util.isEmpty(content)) {
			return CONTENT_FILE_MISSING;
		}
		return content;
		
	}
}
