/**
 *  RectangleCommandTest.java
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

public class RectangleCommandTest {

	
	private DrawingBoard board;

	
	private Command command;
	
	@Before
	public void setUp() throws Exception {
		board = BoardFactory.createBoard();
		board.initBoard(20, 30);
		command = new RectangleCommand();
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_NullArguments() throws Exception {
		command.execute(null, board);
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_OneArguments() throws Exception {
		String[] arguments = {"1"};
		command.execute(arguments, board);
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_TwoArguments() throws Exception {
		String[] arguments = {"1","2"};
		command.execute(arguments, board);
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_ThreeArguments() throws Exception {
		String[] arguments = {"1","2","4"};
		command.execute(arguments, board);
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_FiveArguments() throws Exception {
		String[] arguments = {"1","2","4","5","6","7"};
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_ValidArguments() throws Exception {
		String[] arguments = {"1","2","10","12"};
		command.execute(arguments, board);
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_ArgumentsNotNumber() throws Exception {
		String[] arguments = {"D","@","$","&"};
		command.execute(arguments, board);
	}
	
	@Test (expected=BoardException.class)
	public void testExecute_NullBoard() throws Exception {
		String[] arguments = {"1","2", "3","4"};
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
