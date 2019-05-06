/**
 *  GraphDataException.java
 *  
 *  
 *  
 */
package canvas.model;

import canvas.util.Util;

/**
 * @author sarimbra
 * @date 2 May 2019
 * 
 */
public class GraphDataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String GRAPH_SIZE_NEGATIVE = "graph.size.negative";

	public static final String GRAPH_POINT_OUT_OF_RANGE = "graph.range.outside";
	
	private String errorCode = null;
	
	/**
	 * 
	 */
	public GraphDataException(String errCode) {
		super(errCode);
		this.errorCode = errCode;
	}

	@Override
	public String getMessage() {
		return Util.getDisplayMessage(this.errorCode);
	}

	/**
	 * Log the exception to trouble shooting
	 * @param e
	 */
	public void logError(Exception e) {
		//TODO 
	}
	
	/**
	 * return error code
	 * @return
	 */
	public String getErrorCode() {
		return this.errorCode;
	}

}
