/**
 * QuitCommand.java
 * 
 * Command to quit the app.
 * 
 */
package canvas.controller;

import canvas.view.DrawingBoard;

/**
 * @author sajith
 * @date 26, Apr 2019
 * 
 */
public final class QuitCommand extends AbstractCommand {

	
	
	/**
	 * return true as this command is to quit application.
	 */
	@Override
	public boolean isExit() {
		return true;
	}

	/* (non-Javadoc)
	 * @see canvas.controller.AbstractCommand#execute(java.lang.String[], canvas.view.DrawingBoard)
	 */
	@Override
	public void execute(String[] arguments, DrawingBoard board) throws BoardException , CommandException{
		if (board!= null) {
			board.clean();
		}
	}

}
