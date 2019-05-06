/**
 * 
 * CommandCompilerTest.java
 * 
 * 
 * 
 */

package canvas.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import canvas.model.CommandData;

/**
 * @author sajith
 * @date 28, Apr 2019
 * 
 */

public class CommandCompilerTest {

	
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#parse(java.lang.String)}.
	 */
	@Test(expected=CommandException.class)
	public void testParse_Null() throws Exception {
		CommandCompiler.parse(null);
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#parse(java.lang.String)}.
	 */
	@Test(expected=CommandException.class)
	public void testParse_Empty() throws Exception {
		CommandCompiler.parse("");
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#parse(java.lang.String)}.
	 */
	@Test(expected=CommandException.class)
	public void testParse_Spaces() throws Exception {
		CommandCompiler.parse("  ");
	}

	/**
	 * Test method for {@link canvas.controller.CommandCompiler#parse(java.lang.String)}.
	 */
	@Test
	public void testParse_Canvas() throws Exception {
		CommandData comData = CommandCompiler.parse("C 2 3");
		assertTrue(comData.getCommand().equals("C"));
		assertTrue(comData.getArguments().length == 2);
		assertTrue(comData.getArguments()[0].equals("2"));
		assertTrue(comData.getArguments()[1].equals("3"));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#parse(java.lang.String)}.
	 */
	@Test
	public void testParse_Line() throws Exception {
		CommandData comData = CommandCompiler.parse("L 1 240 4 20");
		assertTrue(comData.getCommand().equals("L"));
		assertTrue(comData.getArguments().length == 4);
		assertTrue(comData.getArguments()[0].equals("1"));
		assertTrue(comData.getArguments()[1].equals("240"));
		assertTrue(comData.getArguments()[2].equals("4"));
		assertTrue(comData.getArguments()[3].equals("20"));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#parse(java.lang.String)}.
	 */
	@Test
	public void testParse_Rectangle() throws Exception {
		CommandData comData = CommandCompiler.parse("R 3 45 2000 12");
		assertTrue(comData.getCommand().equals("R"));
		assertTrue(comData.getArguments().length == 4);
		assertTrue(comData.getArguments()[0].equals("3"));
		assertTrue(comData.getArguments()[1].equals("45"));
		assertTrue(comData.getArguments()[2].equals("2000"));
		assertTrue(comData.getArguments()[3].equals("12"));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#parse(java.lang.String)}.
	 */
	@Test
	public void testParse_Fill() throws Exception {
		CommandData comData = CommandCompiler.parse("B 150 230 K");
		assertTrue(comData.getCommand().equals("B"));
		assertTrue(comData.getArguments().length == 3);
		assertTrue(comData.getArguments()[0].equals("150"));
		assertTrue(comData.getArguments()[1].equals("230"));
		assertTrue(comData.getArguments()[2].equals("K"));
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#parse(java.lang.String)}.
	 */
	@Test
	public void testParse_Quit() throws Exception {
		CommandData comData = CommandCompiler.parse("Q");
		assertTrue(comData.getCommand().equals("Q"));
		assertTrue(comData.getArguments() == null);
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#parse(java.lang.String)}.
	 */
	@Test (expected=CommandException.class)
	public void testParse_Invalid() throws Exception {
		CommandCompiler.parse("ABCD Test");
	}

	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#getCommand(java.lang.String)}.
	 */
	@Test(expected=CommandException.class)
	public void testGetCommand_Null() throws Exception {
		CommandCompiler.getCommand(null);
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#getCommand(java.lang.String)}.
	 */
	@Test(expected=CommandException.class)
	public void testGetCommand_Empty() throws Exception {
		CommandCompiler.getCommand("");
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#getCommand(java.lang.String)}.
	 */
	@Test(expected=CommandException.class)
	public void testGetCommand_Spaces() throws Exception {
		CommandCompiler.getCommand(" ");
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#getCommand(java.lang.String)}.
	 */
	@Test(expected=CommandException.class) 
	public void testGetCommand_Invalid() throws Exception {
		CommandCompiler.getCommand("CL B R Q");
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#getCommand(java.lang.String)}.
	 */
	@Test
	public void testGetCommand_Line() throws Exception {
		Command cmd = CommandCompiler.getCommand("L");
		assertTrue(cmd instanceof LineCommand);
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#getCommand(java.lang.String)}.
	 */
	@Test
	public void testGetCommand_Rectangle() throws Exception {
		Command cmd = CommandCompiler.getCommand("R");
		assertTrue(cmd instanceof RectangleCommand);
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#getCommand(java.lang.String)}.
	 */
	@Test
	public void testGetCommand_Bucket() throws Exception {
		Command cmd = CommandCompiler.getCommand("B");
		assertTrue(cmd instanceof BucketFillCommand);
	}
	
	/**
	 * Test method for {@link canvas.controller.CommandCompiler#getCommand(java.lang.String)}.
	 */
	@Test
	public void testGetCommand_Canvas() throws Exception {
		Command cmd = CommandCompiler.getCommand("C");
		assertTrue(cmd instanceof CanvasCommand);
	}

	/**
	 * Test method for {@link canvas.controller.CommandCompiler#getCommand(java.lang.String)}.
	 */
	@Test
	public void testGetCommand_Quit() throws Exception {
		Command cmd = CommandCompiler.getCommand("Q");
		assertTrue(cmd instanceof QuitCommand);
	}
}
