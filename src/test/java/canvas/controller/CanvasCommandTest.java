/**
 * 
 * CanvasCommandTest.java
 * 
 * 
 * 
 */
package canvas.controller;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import canvas.view.BoardFactory;
import canvas.view.DrawingBoard;


public class CanvasCommandTest {

	private DrawingBoard board;
	
	private Command command;
	
	@Before
	public void setUp() throws Exception {
		command = new CanvasCommand();
		board = BoardFactory.createBoard();
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_NullArguments() throws Exception {		
		command.execute(null, board);
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_OneArguments() throws Exception {
		
		String[] arguments = {"1"};//single argument
		command.execute(arguments, board);
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_ThreeArguments() throws Exception {
		//prepare mock data
		
		String[] arguments = {"1","2","3"};//two arguments
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_ValidArguments() throws Exception {
		//prepare mock data
		
		String[] arguments = {"10","20"};//two arguments
		command.execute(arguments, board);
	}
	
	@Test (expected=BoardException.class)
	public void testExecute_ArgumentsNotNumber() throws Exception {
		//prepare mock data
		
		String[] arguments = {"a","b"};//two arguments
		command.execute(arguments, board);
	}
	
	@Test (expected=BoardException.class)
	public void testExecute_ArgumentsNegativeNumber() throws Exception {
		//prepare mock data
		
		String[] arguments = {"-10","-1"};//two arguments
		command.execute(arguments, board);
	}
	
	@Test (expected=BoardException.class)
	public void testExecute_ArgumentsZero() throws Exception {
		//prepare mock data
		
		String[] arguments = {"0","0"};//two arguments
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_ArgumentsMax() throws Exception {
		//prepare mock data
		
		String[] arguments = {"1000","1000"};//two arguments
		command.execute(arguments, board);
	}
	
	@Test (expected=BoardException.class)
	public void testExecute_ArgumentsExceededMax() throws Exception {
		//prepare mock data
		
		String[] arguments = {"10000","1001"};//two arguments
		command.execute(arguments, board);
	}
	
	@Test (expected=BoardException.class)
	public void testExecute_NullBoard() throws Exception {
		String[] arguments = {"1","2"};//two arguments
		command.execute(arguments, null);
	}
	
	/**
	 * Test method for {@link canvas.controller.AbstractCommand#isExit()}.
	 */
	@Test
	public void testIsExit() {
		assertFalse(command.isExit());
	}

}
