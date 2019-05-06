/**
 * RectangleCommand.java
 * 
 * Command to execute drawing a given rectangle in the board. 
 * Line command is used to implement this command. a rectangle can be drawn by drawing the four boundary lines that construct it.
 * 
 */
package canvas.controller;

import canvas.model.GraphData;
import canvas.view.DrawingBoard;

/**
 * @author sajith
 * @date 27, Apr 2019
 * @modified 28, Apr 2019
 */
public class RectangleCommand extends LineCommand {

	/**
	 * to draw a rectangle, draw 4 boundary lines of the rectangle.
	 */
	/* (non-Javadoc)
	 * @see canvas.controller.AbstractCommand#execute(java.lang.String[], canvas.view.DrawingBoard)
	 */
	@Override
	public void execute(String[] arguments, DrawingBoard board) throws BoardException, CommandException {
		//check board validations
		checkBoardInitialized(board);
		
		if (arguments == null || arguments.length != 4) {
			throw new CommandException(CommandException.COMMAND_RECTANGLE_SYNTAX_ERROR);
		}
		
		GraphData graph = board.getGraphData();
		
		try {
			int x1 = Integer.parseInt(arguments[0]);
			int y1 = Integer.parseInt(arguments[1]);
			int x2 = Integer.parseInt(arguments[2]);
			int y2 = Integer.parseInt(arguments[3]);
			
			checkRangeX(x1, board);
			checkRangeX(x2, board);
			
			checkRangeY(y1, board);
			checkRangeY(y2, board);
			
			drawLine(graph, x1, y1, x1, y2);// Draw top horizontal line
			drawLine(graph, x2, y1, x2, y2);// Draw bottom horizontal line
			drawLine(graph, x1, y1, x2, y1);// Draw left vertical line
			drawLine(graph, x1, y2, x2, y2);// Draw right vertical line
			
		}catch(NumberFormatException nfe) {
			throw new CommandException(CommandException.COMMAND_POINTS_NOT_A_NUMBER);
		}
		
	}

}
