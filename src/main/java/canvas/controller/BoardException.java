/**
 * Exception class for capturing exceptional cases while drawing in the board
 */
package canvas.controller;

import canvas.util.Util;

/**
 * @author sajith
 * @date 25, Apr 2019
 * 
 */
public class BoardException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//board size must be specified as height and width.
	public static final String BOARD_SIZE_MISSING = "board.error.BRD-001";

	//board size must be a valid positive number
	public static final String BOARD_SIZE_NOT_NUMBER = "board.error.BRD-002";

	//board limit exceed max limit Constants.BOARD_MAX_ROWS, BOARD_MAX_COLS
	public static final String BOARD_MAX_LIMIT_EXCEEDED = "board.error.BRD-003";

	//board limit exceed max limit Constants.BOARD_MAX_ROWS, BOARD_MAX_COLS
	public static final String BOARD_NOT_INITIALIZED = "board.error.BRD-004";

	//baord size cannot be negative
	public static final String BOARD_SIZE_NEGATIVE = "board.error.BRD-005";
	
	
	private String errorCode = null;
	
	/**
	 * 
	 */
	public BoardException(String errCode) {
		super(errCode);
		this.errorCode = errCode;
	}

	@Override
	public String getMessage() {
		return Util.getDisplayMessage(this.errorCode);
	}

	/**
	 * Log the exception to trouble shooting
	 * @param e
	 */
	public void logError(Exception e) {
		//TODO 
	}
	
}
