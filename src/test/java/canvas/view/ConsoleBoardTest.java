/**
 *  ConsoleBoardTest.java
 *  
 *  
 *  
 */
package canvas.view;

import static org.junit.Assert.assertTrue;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import canvas.controller.BoardException;

/**
 * @author sarimbra
 * @date 2 May 2019
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class ConsoleBoardTest {
	
	private DrawingBoard board;

	
	PrintStream print;
	
	PrintStream sysOut;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		board = BoardFactory.createBoard();
		sysOut = System.out;
		print = Mockito.mock(PrintStream.class);
		System.setOut(print);
	}
	
	@After
	public void doAfter() {
		System.setOut(sysOut);
	}

	/**
	 * Test method for {@link canvas.view.ConsoleBoard#clean()}.
	 */
	@Test
	public void testClean() {
		
		board.clean();
	}

	/**
	 * Test method for {@link canvas.view.ConsoleBoard#display()}.
	 */
	@Test
	public void testDisplay() throws Exception {
		board.initBoard(2, 2);
		board.display();
		Mockito.verify(print, Mockito.atMost(2)).println(Mockito.startsWith("----"));
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#display()}.
	 */
	@Test
	public void testDisplay_Invalid() throws Exception {
		board.display();
		Mockito.verify(print, Mockito.never()).println();
	}

	/**
	 * Test method for {@link canvas.view.ConsoleBoard#initBoard(int, int)}.
	 */
	@Test
	public void testInitBoard_Valid() throws Exception {
		board.initBoard(10, 20);
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#initBoard(int, int)}.
	 */
	@Test (expected=BoardException.class)
	public void testInitBoard_XLimitExceeded() throws Exception {
		board.initBoard(1001, 200);
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#initBoard(int, int)}.
	 */
	@Test (expected=BoardException.class)
	public void testInitBoard_YLimitExceeded() throws Exception {
		board.initBoard(100, 2000);
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#initBoard(int, int)}.
	 */
	@Test (expected=BoardException.class)
	public void testInitBoard_LimitExceeded() throws Exception {
		board.initBoard(1001, 2000);
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#initBoard(int, int)}.
	 */
	@Test (expected=BoardException.class)
	public void testInitBoard_NegativeSize() throws Exception {
		board.initBoard(-10, -200);
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#initBoard(int, int)}.
	 */
	@Test (expected=BoardException.class)
	public void testInitBoard_ZeroSize() throws Exception {
		board.initBoard(0,0);
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#initBoard(int, int)}.
	 */
	@Test 
	public void testInitBoard_MaxSize() throws Exception {
		board.initBoard(999,999);
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#initBoard(int, int)}.
	 */
	@Test 
	public void testInitBoard_XMaxSize() throws Exception {
		board.initBoard(999,10);
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#initBoard(int, int)}.
	 */
	@Test 
	public void testInitBoard_YMaxSize() throws Exception {
		board.initBoard(10,999);
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#getGraphData()}.
	 */
	@Test
	public void testGetGraphData() throws Exception {
		board.initBoard(10, 20);
		assertTrue(board.getGraphData()!= null);
	}

	/**
	 * Test method for {@link canvas.view.ConsoleBoard#displayMessage(java.lang.String)}.
	 */
	@Test
	public void testDisplayMessage_Valid() {
		String msg = "test";
		board.displayMessage(msg);
		Mockito.verify(print, Mockito.atMost(1)).println(msg);
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#displayMessage(java.lang.String)}.
	 */
	@Test
	public void testDisplayMessage_Null() {
		String msg = null;
		board.displayMessage(msg);
		Mockito.verify(print, Mockito.never()).println(msg);
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#displayMessage(java.lang.String)}.
	 */
	@Test
	public void testDisplayMessage_Empty() {
		String msg = "";
		board.displayMessage(msg);
		Mockito.verify(print, Mockito.never()).println(msg);
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#displayMessage(java.lang.String)}.
	 */
	@Test
	public void testDisplayMessage_Space() {
		String msg = "  ";
		board.displayMessage(msg);
		Mockito.verify(print, Mockito.never()).println(msg);
	}

	/**
	 * Test method for {@link canvas.view.ConsoleBoard#isInitialized()}.
	 */
	@Test
	public void testIsInitialized() throws Exception {
		board.initBoard(10, 20);
		assertTrue(board.isInitialized());
	}
	
	/**
	 * Test method for {@link canvas.view.ConsoleBoard#isInitialized()}.
	 */
	@Test
	public void testIsInitialized_Invalid() throws Exception {
		assertTrue(!board.isInitialized());
	}
	
}
