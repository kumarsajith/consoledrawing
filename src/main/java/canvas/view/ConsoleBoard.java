/**
 * 
 * ConsoleBoard.java
 * 
 * Console based graphic view.
 * 
 */
package canvas.view;

import canvas.controller.BoardException;
import canvas.model.GraphData;
import canvas.model.GraphDataException;
import canvas.util.Constants;
import canvas.util.Util;

/**
 * @author sarimbra
 * @date 29, Apr 2019
 */
public final class ConsoleBoard implements DrawingBoard {

	//to hold grid data of the graph
	private GraphData graphData = null;
	private boolean isInitialized = false;
	
	//cache for printing horizontal border for the console graph while printing. this will be initialized when board is initialized
	private String xAxisBorder ="";
	
	@Override
	public void clean() {
		

	}

	@Override
	public void display() {
		if (isInitialized()) {
			displayMessage(xAxisBorder); //top horizontal border
			for(int i=0; i< this.graphData.getRows(); i++) {
				StringBuffer rowText = new StringBuffer("|");//row starts with vertical row border
				for(int j=0;j<this.graphData.getColumns(); j++) {
					rowText.append(graphData.getData(i, j));
				}
				rowText.append("|");//row ends with vertical row border
				displayMessage(rowText.toString());
			}
			displayMessage(xAxisBorder); //bottom horizontal border
		}
	}
	
	private void initXAxisBorder() {
		StringBuffer rowText = new StringBuffer("-");
		for(int j=0;j< this.graphData.getColumns(); j++) {
			rowText.append("-");
		}
		rowText.append("-");
		xAxisBorder = rowText.toString();
	}
	
	

	/**
	 * 
	 * @param isInitialized
	 */
	private void setInitialized(boolean isInitialized) {
		this.isInitialized = isInitialized;
	}
	
	/**
	 * check if rows and cols are within allowed range.
	 * @param rows
	 * @param cols
	 * @throws BoardException
	 */
	private void validateBoardLimit(int rows, int cols) throws BoardException {
		
		if (rows ==0 || cols == 0 || rows > Constants.BOARD_MAX_ROWS || cols > Constants.BOARD_MAX_ROWS)  {
			throw new BoardException(BoardException.BOARD_MAX_LIMIT_EXCEEDED);
		}
		
	}
	
	@Override
	public void initBoard(int height, int width) throws BoardException {
		validateBoardLimit(height, width);
		try {
			graphData = new GraphData(height, width);
		}catch(GraphDataException gd) {
			throw new BoardException(BoardException.BOARD_SIZE_NEGATIVE);
		}
		setInitialized(true);
		initXAxisBorder();
	}

	@Override
	public GraphData getGraphData() {
		return this.graphData;
	}

	@Override
	public void displayMessage(String message) {
		if (!Util.isEmpty(message)) {
			System.out.println(message);
		}
	}

	@Override
	public boolean isInitialized() {
		return isInitialized;
	}

}
