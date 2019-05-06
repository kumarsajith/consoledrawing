/**
 * CommandData.java
 * 
 * represent the data structure to hold graph data
 * 
 */
package canvas.model;

import java.util.Arrays;

/**
 * @author sajith
 * @date 27, Apr 2019
 * @modified 28, Apr 2019
 */
public class GraphData {
	
	public static final String SYMBOL_POINT = "X";
	public static final String SYMBOL_CLEAR = " ";
	
	private String[][] graphData = null;
	
	private int rows = 0;
	private int columns = 0;
	
	public GraphData(int rows, int col) throws GraphDataException {
		
		if (rows <0 || col <0) {
			throw new GraphDataException(GraphDataException.GRAPH_SIZE_NEGATIVE);
		}
		
		this.rows = rows;
		this.columns = col;
		this.graphData = new String[this.rows][this.columns];
		this.clearData();
	}
	
	public void clearData() {
		for (int i=0; i< this.rows; i++) {
			Arrays.fill(this.graphData[i], GraphData.SYMBOL_CLEAR);
		}
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public String getData(int x, int y) {
		
		return this.graphData[x][y];
	}
	
	public void setData(int x, int y, String pointSymbol) {
		this.graphData[x][y] = pointSymbol;
	}

	
}
