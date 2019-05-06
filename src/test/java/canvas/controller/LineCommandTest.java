/**
 *  LineCommandTest.java
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

public class LineCommandTest {

	
	private DrawingBoard board;
	
	
	private Command command;
	
	@Before
	public void setUp() throws Exception {
		board = BoardFactory.createBoard();
		board.initBoard(20, 30);
		command = new LineCommand();
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
	
	@Test (expected=CommandException.class)
	public void testExecute_ArgumentsNotNumber() throws Exception {
		String[] arguments = {"A","b","c","d"};
		command.execute(arguments, board);
	}
	
	
	@Test 
	public void testExecute_ForwardLine() throws Exception {
		String[] arguments = {"1","2","4","5"};
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_HorizontalLine() throws Exception {
		String[] arguments = {"1","2","1","5"};
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_HorizontalLineY1Y2Asc() throws Exception {
		String[] arguments = {"1","8","1","2"};
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_VerticalLine() throws Exception {
		String[] arguments = {"5","6","10","6"};
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_VerticalLineX1X2Asc() throws Exception {
		String[] arguments = {"15","2","7","2"};
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_BackwardLine() throws Exception {
		String[] arguments = {"10","10","2","3"};
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_LineX1X2Desc() throws Exception {
		String[] arguments = {"10","10","5","3"};
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_LineXYRange() throws Exception {
		String[] arguments = {"1","1","20","30"};
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_LineY1Y2Desc() throws Exception {
		String[] arguments = {"10","8","5","2"};
		command.execute(arguments, board);
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_LineXOutside() throws Exception {
		String[] arguments = {"1","1","100","20"};
		command.execute(arguments, board);
	}
	
	@Test (expected=CommandException.class)
	public void testExecute_LineYOutside() throws Exception {
		String[] arguments = {"1","100","1","20"};
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
