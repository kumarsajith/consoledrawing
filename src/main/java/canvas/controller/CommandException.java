/**
 * CommandException.java
 * 
 * To handle all command related errors.
 * 
 */
package canvas.controller;

import canvas.util.Util;

/**
 * @author sajith
 * @date 25, Apr 2019
 * 
 */
public class CommandException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	//ERROR CODE FOR IO ERROR FROM READING COMMAND
	public static final String COMMAND_READ_IO_ERROR = "command.error.CMD-001";

	//ERROR CODE FOR EMPTY INPUT FOR COMMAND
	public static final String COMMAND_EMPTY = "command.error.CMD-002";
	
	//ERROR CODE FOR INVALID COMMANDS
	public static final String COMMAND_NOT_FOUND = "command.error.CMD-003";
	
	//ERROR CODE FOR POINTS OUT OF RANGE
	public static final String COMMAND_POINTS_OUT_OF_RANGE = "command.error.CMD-004";

	//ERROR CODE FOR POINTS MUST BE NUMBER
	public static final String COMMAND_POINTS_NOT_A_NUMBER = "command.error.CMD-005";

	//ERROR CODE FOR LINE COMMAND SYNTAX ERROR
	public static final String COMMAND_LINE_SYNTAX_ERROR = "command.error.CMD-006";

	//ERROR CODE FOR RECTANGLE COMMAND SYNTAX ERROR
	public static final String COMMAND_RECTANGLE_SYNTAX_ERROR = "command.error.CMD-007";

	//ERROR CODE FOR FILL COMMAND SYNTAX ERROR
	public static final String COMMAND_BUCKET_SYNTAX_ERROR = "command.error.CMD-008";
	
	//ERROR CODE FOR FILL COMMAND COLOR MUST BE CHAR
	public static final String COMMAND_COLOR_MUSTBE_CHAR = "command.error.CMD-009";

	public static final String COMMAND_CANVAS_SYNTAX_ERROR = "command.error.CMD-010";
	
	private String errorCode = null;
	
	public CommandException(String errCode) {
		super(errCode);
		this.errorCode = errCode;
	}
	
	/**
	 * return the message corresponding to the error code from content resource bundle.
	 */
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
