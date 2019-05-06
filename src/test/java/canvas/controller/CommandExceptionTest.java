/**
 *  CommandExceptionTest.java
 *  
 *  
 *  
 */
package canvas.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import canvas.util.Util;

/**
 * @author sarimbra
 * @date 2 May 2019
 * 
 */
public class CommandExceptionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_Null() {
		String errCode = null;
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_Empty() {
		String errCode = "";
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_Space() {
		String errCode = " ";
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_Bucket() {
		String errCode = CommandException.COMMAND_BUCKET_SYNTAX_ERROR;
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_Canvas() {
		String errCode = CommandException.COMMAND_CANVAS_SYNTAX_ERROR;
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_ColorChar() {
		String errCode = CommandException.COMMAND_COLOR_MUSTBE_CHAR;
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_CommandEmpty() {
		String errCode = CommandException.COMMAND_EMPTY;
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}

	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_Line() {
		String errCode = CommandException.COMMAND_LINE_SYNTAX_ERROR;
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_InvalidCmd() {
		String errCode = CommandException.COMMAND_NOT_FOUND;
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_PointNotNumber() {
		String errCode = CommandException.COMMAND_POINTS_NOT_A_NUMBER;
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_PointsRange() {
		String errCode = CommandException.COMMAND_POINTS_OUT_OF_RANGE;
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_IO() {
		String errCode = CommandException.COMMAND_READ_IO_ERROR;
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_Rectangle() {
		String errCode = CommandException.COMMAND_RECTANGLE_SYNTAX_ERROR;
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#getMessage()}.
	 */
	@Test
	public void testGetMessage_Invalid() {
		String errCode = "some invalid command";
		CommandException cmdEx = new CommandException(errCode);
		assertEquals(cmdEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandException#logError(java.lang.Exception)}.
	 */
	@Test
	public void testLogError() {
		String errCode = "test";
		CommandException cmdEx = new CommandException(errCode);
		cmdEx.logError(cmdEx);
	}

}
