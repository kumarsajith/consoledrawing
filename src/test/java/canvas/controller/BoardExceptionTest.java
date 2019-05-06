/**
 * 
 * BoardExceptionTest.java
 * 
 * 
 * 
 */

package canvas.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import canvas.util.Util;

public class BoardExceptionTest {

	@Before
	public void setUp() throws Exception {
	}

	

	@Test
	public void testGetMessage_Null() {
		String errCode = null;
		BoardException boardEx = new BoardException(errCode);
		assertEquals(boardEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	@Test
	public void testGetMessage_Empty() {
		String errCode = "";
		BoardException boardEx = new BoardException(errCode);
		assertEquals(boardEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	@Test
	public void testGetMessage_Space() {
		String errCode = " ";
		BoardException boardEx = new BoardException(errCode);
		assertEquals(boardEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	@Test
	public void testGetMessage_MaxLimit() {
		String errCode = BoardException.BOARD_MAX_LIMIT_EXCEEDED;
		BoardException boardEx = new BoardException(errCode);
		assertEquals(boardEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	@Test
	public void testGetMessage_BoardInit() {
		String errCode = BoardException.BOARD_NOT_INITIALIZED;
		BoardException boardEx = new BoardException(errCode);
		assertEquals(boardEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	@Test
	public void testGetMessage_BoardSize() {
		String errCode = BoardException.BOARD_SIZE_MISSING;
		BoardException boardEx = new BoardException(errCode);
		assertEquals(boardEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	@Test
	public void testGetMessage_BoardSizeNegative() {
		String errCode = BoardException.BOARD_SIZE_NEGATIVE;
		BoardException boardEx = new BoardException(errCode);
		assertEquals(boardEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	@Test
	public void testGetMessage_BoardSizeNumber() {
		String errCode = BoardException.BOARD_SIZE_NOT_NUMBER;
		BoardException boardEx = new BoardException(errCode);
		assertEquals(boardEx.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	@Test
	public void testGetMessage_InvalidErr() {
		String errCode = "some test message data";
		BoardException boardEx = new BoardException(errCode);
		assertEquals(boardEx.getMessage(), Util.getDisplayMessage(errCode));
	}

	@Test
	public void testLogError() {
		String errCode = "test";
		BoardException boardEx = new BoardException(errCode);
		boardEx.logError(boardEx);
	}

}
