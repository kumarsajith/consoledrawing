/**
 * 
 * BucketFillCommandTest.java
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

/**
 * @author sajith
 * @date 28, Apr 2019
 * 
 */

public class BucketFillCommandTest {
	
	
	private DrawingBoard board;
	private Command command;
	
	@Before
	public void setUp() throws Exception {
		
		board = BoardFactory.createBoard();
		board.initBoard(20, 30);
		command = new BucketFillCommand();
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
	public void testExecute_TwoArguments() throws Exception {
		String[] arguments = {"1","2"};//two arguments
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_ValidArguments() throws Exception {
		String[] arguments = {"10","20","o"};//two arguments
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_ArgumentsDiagonals() throws Exception {
		String[] arguments = {"5","5","o"};//two arguments
		command.execute(arguments, board);
		//do again to go through diagonal points.
		command.execute(arguments, board);
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_ArgumentsNotNumber() throws Exception {
		String[] arguments = {"a4","b2","1"};//two arguments
		command.execute(arguments, board);
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_InvalidColor() throws Exception {
		String[] arguments = {"1","2", "test"};//two arguments
		command.execute(arguments, board);
	}

	
	@Test (expected=BoardException.class)
	public void testExecute_NullBoard() throws Exception {
		String[] arguments = {"1","2", "c"};//two arguments
		command.execute(arguments, null);
	}
	
	
	@Test
	public void testIsExit() {
		assertFalse(command.isExit());
	}

	
}
