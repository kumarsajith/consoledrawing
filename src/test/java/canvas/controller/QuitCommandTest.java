/**
 *  QuitCommandTest.java
 *  
 *  
 *  
 */
package canvas.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import canvas.view.BoardFactory;
import canvas.view.DrawingBoard;


public class QuitCommandTest {

	private DrawingBoard board = BoardFactory.createBoard();
	
	private Command command;
	
	@Before
	public void setUp() throws Exception {
		command = new QuitCommand();
	}
	
	@Test 
	public void testExecute_NullArguments() throws Exception {
		command.execute(null, board);
	}
	
	@Test 
	public void testExecute_OneArguments() throws Exception {
		//prepare mock data
		String[] arguments = {"1"};
		command.execute(arguments, board);
	}
	
	@Test 
	public void testExecute_NullBoard() throws Exception {
		command.execute(null, null);
	}
	
	/**
	 * Test method for {@link canvas.controller.AbstractCommand#isExit()}.
	 */
	@Test
	public void testIsExit() {
		assertTrue(command.isExit());
	}

}
