/**
 * LineCommand.java
 * 
 * Command to execute drawing a given line in the board.
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
public class LineCommand extends AbstractCommand {

	/* (non-Javadoc)
	 * @see canvas.controller.AbstractCommand#execute(java.lang.String[], canvas.view.DrawingBoard)
	 */
	/**
	 * execute line command
	 */
	@Override
	public void execute(String[] arguments, DrawingBoard board) throws BoardException,CommandException {
		//check board validations
		super.execute(arguments, board);
		
		if (arguments == null || arguments.length != 4) {
			throw new CommandException(CommandException.COMMAND_LINE_SYNTAX_ERROR);
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
			
			drawLine(graph, x1, y1, x2, y2);
			
		}catch(NumberFormatException nfe) {
			throw new CommandException(CommandException.COMMAND_POINTS_NOT_A_NUMBER);
		}
	}

	
	/**
	 * @param graph
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	protected void drawLine(GraphData graph, int x1, int y1, int x2, int y2) {
		if (x1 ==  x2) {
			drawVerticalLine(graph, x1, y1, y2);
			return;
		}
		
		if (y1 ==  y2) {
			drawHorizontalLine(graph, x1, y1, x2);
			return;
		}
		
		horizontalApproximation(graph, x1, y1, x2, y2);
		
		verticalApproximation(graph, x1, y1, x2, y2);
	}

	/**
	 * equation of a line from x axis perspective 
	 *  x = m * y + c [ m is slope and c is constant]
 	 * 
	 *  m = x1-x2/y1-y2
	 *  c = x2y1-x1y2/y1-y2
	 *  
	 *  take all y from y1 till y2 and compute x values. this can be used to do approximations 
	 *  
	 * @param graph
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	protected void verticalApproximation(GraphData graph, int x1, int y1, int x2, int y2) {
		float yLength = y1-y2;
		float slopeMy = (x1-x2)/yLength;
		float conCy =  ((x2*y1)-(x1*y2))/yLength;
		
		int start = y1;
		int end = y2;
		
		if (y2<y1) {
			start = y2;
			end = y1;
		}
		
		for (int i=start; i<= end; i++) {
			int x = Math.round( (slopeMy * i) + conCy);
			
			graph.setData(x-1, i-1, GraphData.SYMBOL_POINT);
		}
	}

	/**
	 * equation of a line y = m * x + c [ m is slope and c is constant]
 	 * 
	 *  m = y1-y2/x1-x2
	 *  c = y2x1-y1x2/x1-x2
	 *  
	 *  take all x from x1 till x2 and compute y values.
	 * 
	 * @param graph
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	protected void horizontalApproximation(GraphData graph, int x1, int y1, int x2, int y2) {
		float xLength = x1-x2;
		float slopeM = (y1-y2)/xLength;
		float conC =  ((y2*x1)-(y1*x2))/xLength;
		
		int start = x1; 
		int end = x2; 
		
		if (x2 < x1) {
			start = x2;
			end = x1;
		}
		
		for (int i=start; i<= end; i++) {
			int y = Math.round( (slopeM * i) + conC);
			
			graph.setData(i-1, y-1, GraphData.SYMBOL_POINT);
		}
	}

	/**
	 * draw horizontal line from through y1.
	 * 
	 * @param graph
	 * @param x1
	 * @param y1
	 * @param x2
	 */
	protected void drawHorizontalLine(GraphData graph, int x1, int y1, int x2) {
		
		int start = x1; 
		int end = x2; 
		
		if (x2 < x1) {
			start = x2;
			end = x1;
		}
		
		for (int i=start; i<=end; i++) {
			graph.setData(i-1, y1-1, GraphData.SYMBOL_POINT);
		}
		return;
	}

	/**
	 *  * draw horizontal line from through x1.
	 * @param graph
	 * @param x1
	 * @param y1
	 * @param y2
	 */
	protected void drawVerticalLine(GraphData graph, int x1, int y1, int y2) {
		
		int start = y1; 
		int end = y2;
		
		if (y2 < y1) {
			start = y2;
			end = y1;
		}
		
		for (int i=start; i<=end; i++) {
			graph.setData(x1-1, i-1, GraphData.SYMBOL_POINT);
		}
		return;
	}

}
