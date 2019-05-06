/**
 * Command.java
 * 
 * Command Interface to abstract executable comamnds in the  board.
 * 
 */
package canvas.controller;

import canvas.view.DrawingBoard;

/**
 * @author sajith
 * @date 25, April 2019
 * 
 */
public interface Command {

	/**
	 * 
	 * @return  true if the command is to quit the drawing  app
	 */
	public boolean isExit();

	/**
	 * execute  drawing command on the Board.
	 * 
	 * @param DrawingBoard
	 */
	public void execute(String[] arguments, DrawingBoard board) throws BoardException, CommandException;
	
	

}
