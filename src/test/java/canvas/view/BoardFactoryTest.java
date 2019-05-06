/**
 *  BoardFactoryTest.java
 *  
 *  
 *  
 */
package canvas.view;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author sarimbra
 * @date 2 May 2019
 * 
 */
public class BoardFactoryTest {
	
	private DrawingBoard board;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link canvas.view.BoardFactory#createBoard()}.
	 */
	@Test
	public void testCreateBoard() {
		board = BoardFactory.createBoard();
		assertTrue(board instanceof ConsoleBoard);
	}

}
