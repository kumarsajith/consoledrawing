/**
 * 
 * AbstractCommand.java
 * 
 * Command interface to abstract all executable commands that can be done on the drawing board.
 * 
 * 
 */
package canvas.controller;

import canvas.view.DrawingBoard;

/**
 * @author sajith
 * @date 25, Apr 2019
 * @modified 28,Apr 2019
 * 
 */
public abstract class AbstractCommand implements Command {

	/* (non-Javadoc)
	 * @see canvas.controller.Command#isExit()
	 */
	public boolean isExit() {
		return false;
	}

	
	/* (non-Javadoc)
	 * @see canvas.controller.Command#execute(canvas.view.DrawingBoard)
	 */
	public void execute(String[] arguments, DrawingBoard board) throws BoardException, CommandException {
		checkBoardInitialized(board);
	}
	
	/**
	 * check if board is initialized. throw exception otherwise.
	 * @param board
	 * @throws BoardException
	 */
	protected void checkBoardInitialized(DrawingBoard board)  throws BoardException {
		if (board == null || !board.isInitialized()) {
			throw new BoardException(BoardException.BOARD_NOT_INITIALIZED);
		}
		
	}
	
	/**
	 * check if given point x is within the canvas rows range.
	 * @param x
	 * @param board
	 * @throws CommandException - throw exception otherwise
	 */
	protected void checkRangeX(int x, DrawingBoard board) throws CommandException {
		
		if (x <= 0 || x > board.getGraphData().getRows()) {
			throw new CommandException(CommandException.COMMAND_POINTS_OUT_OF_RANGE);
		}
	}
	
	/**
	 * check if given point y is within the canvas columns range.
	 * 
	 * @param y
	 * @param board
	 * @throws CommandException
	 */
	protected void checkRangeY(int y, DrawingBoard board) throws CommandException {
		
		if (y <= 0 || y > board.getGraphData().getColumns()) {
			throw new CommandException(CommandException.COMMAND_POINTS_OUT_OF_RANGE);
		}
	}

}
