/**
 * DrawingBoard.java
 * 
 * represent abstraction of a drawing board.
 * 
 */
package canvas.view;

import canvas.controller.BoardException;
import canvas.model.GraphData;

/**
 * @author sajith
 *
 */
public interface DrawingBoard {

	/**
	 * clear all the drawing from board.
	 */
	public void clean();
	
	/**
	 * display the current board with its drawing
	 */
	public void display();
	
	/**
	 * initialize the board with a height and width
	 * @param height
	 * @param width
	 */
	public void initBoard(int height, int width) throws BoardException;

	/**
	 * 
	 * @return GraphData representing this graph
	 */
	public GraphData getGraphData();
	
	
	/**
	 * 
	 * Display user messages to console (error, usage, etc)
	 * 
	 * throw BoardException - in case board is not initialized or any other unexpected error.
	 */
	public void displayMessage(String message);
	
	/**
	 * return  true if board is initialized with a valid canvas command
	 * 
	 */
	public boolean isInitialized();
}
