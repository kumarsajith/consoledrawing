/**
 *  UtilTest.java
 *  
 *  
 *  
 */
package canvas.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author sarimbra
 * @date 2 May 2019
 * 
 */
public class UtilTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link canvas.util.Util#isEmpty(java.lang.String)}.
	 */
	@Test
	public void testIsEmpty_Null() {
		
		assertTrue(Util.isEmpty(null));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#isEmpty(java.lang.String)}.
	 */
	@Test
	public void testIsEmpty_Blank() {
		
		assertTrue(Util.isEmpty(""));
	}

	/**
	 * Test method for {@link canvas.util.Util#isEmpty(java.lang.String)}.
	 */
	@Test
	public void testIsEmpty_Space() {
		
		assertTrue(Util.isEmpty("  "));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#isEmpty(java.lang.String)}.
	 */
	@Test
	public void testIsEmpty_Alpha() {
		
		assertTrue(!Util.isEmpty(" test space "));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#isEmpty(java.lang.String)}.
	 */
	@Test
	public void testIsEmpty_Numeric() {
		
		assertTrue(!Util.isEmpty(" 123.456 "));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_WinTitle() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_BOARD_WINDOW_TITLE)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_BucketCommand() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_COMMAND_BUCKET)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_CanvasCommand() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_COMMAND_CANVAS)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_CommandHelp() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_COMMAND_HELP)));
	}

	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_CommandLine() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_COMMAND_LINE)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_CommandQuit() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_COMMAND_QUIT)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_CommandRectangle() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_COMMAND_RECTANGLE)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_Exit() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_EXIT_MESSAGE)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_PromptInput() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_PROMPT_INPUT)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_UsageRule1() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_USAGE_RULE1)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_UsageRule2() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_USAGE_RULE2)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_UsageRule3() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_USAGE_RULE3)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_UsageTitle() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_USAGE_TITLE)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_Welcome() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage(Constants.SYS_WELCOME_MESSAGE)));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_KeyMissing() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage("non.existing-key-for-testing")));
	}
	
	/**
	 * Test method for {@link canvas.util.Util#getDisplayMessage(java.lang.String)}.
	 */
	@Test
	public void testGetDisplayMessage_ValueMissing() {
		assertTrue(!Util.isEmpty(Util.getDisplayMessage("test.property.empty.key.value")));
	}
	
	
}
