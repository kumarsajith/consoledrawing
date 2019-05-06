/**
 * 
 * CanvasCommand.java
 * 
 * Command to initialize the canvas with given size.
 * 
 * 
 */
package canvas.controller;

import canvas.util.Constants;
import canvas.view.DrawingBoard;

/**
 * @author sajith
 * @date 25, Apr 2019
 * @modified 28, Apr 2019
 * 
 */
public final class CanvasCommand extends AbstractCommand {

	
	/* (non-Javadoc)
	 * @see canvas.controller.Command#execute(canvas.view.DrawingBoard)
	 */
	public void execute(String[] arguments, DrawingBoard board) throws BoardException, CommandException {
		
		//canvas argument must be 2. e.g C 20 30
		if (arguments == null || arguments.length != 2 ) {
			throw new CommandException(CommandException.COMMAND_CANVAS_SYNTAX_ERROR);
		}
		if (board == null) {
			throw new BoardException(BoardException.BOARD_NOT_INITIALIZED);
		}
		try {
			int height = Integer.parseInt(arguments[0]);
			int width = Integer.parseInt(arguments[1]);
			
			if (height < 0 || width < 0) {
				throw new BoardException(BoardException.BOARD_SIZE_NOT_NUMBER);
			}
			
			if (height >  Constants.BOARD_MAX_ROWS || width > Constants.BOARD_MAX_COLS) {
				throw new BoardException(BoardException.BOARD_MAX_LIMIT_EXCEEDED);
			}
			
			board.initBoard(height, width);
			
		}catch(NumberFormatException nfe) {
			throw new BoardException(BoardException.BOARD_SIZE_NOT_NUMBER);
		}

	}

}
