/**
 * GraphDataTest.java
 * 
 */
package canvas.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GraphDataTest {

	private GraphData graph;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testGraphData_Valid() throws Exception {
		graph = new GraphData(2,3);
	}
	
	@Test(expected = GraphDataException.class)
	public void testGraphData_Negative() throws Exception {
		graph = new GraphData(-1, -3);
	}
	
	@Test(expected = GraphDataException.class)
	public void testGraphData_RowNegative() throws Exception {
		graph = new GraphData(-1, 12);
	}
	
	@Test(expected = GraphDataException.class)
	public void testGraphData_ColumnNegative() throws Exception {
		graph = new GraphData(1, -1);
	}
	
	@Test
	public void testGraphData_Min() throws Exception {
		graph = new GraphData(0, 0);
	}

	@Test
	public void testGraphData_ZeroNeg() throws Exception {
		graph = new GraphData(-0, -0);
	}
	
	
	@Test
	public void testClearData() throws Exception{
		String[][] data = {
				{ GraphData.SYMBOL_CLEAR, GraphData.SYMBOL_CLEAR, GraphData.SYMBOL_CLEAR},
				{ GraphData.SYMBOL_CLEAR, GraphData.SYMBOL_CLEAR, GraphData.SYMBOL_CLEAR}
		};
		graph = new GraphData(2,3);
		
		//check if all data are clear
		for (int i=0; i<graph.getRows(); i++) {
			for (int j=0; j<graph.getColumns(); j++) {
				if (!graph.getData(i, j).equals(data[i][j])) {
					assertFalse(true);
				}
			}
		}
		
		//set some data first
		graph.setData(0, 1, "X");
		graph.setData(0, 2, "Y");
		graph.setData(1, 2, "Z");
		
		graph.clearData();
		//check if all data are cleared
		for (int i=0; i<graph.getRows(); i++) {
			for (int j=0; j<graph.getColumns(); j++) {
				if (!graph.getData(i, j).equals(data[i][j])) {
					assertFalse(true);
				}
			}
		}
	}

	
	
	@Test
	public void testGetRows() throws Exception {
		graph = new GraphData(2,3);
		assertTrue(graph.getRows() == 2);
	}

	@Test
	public void testSetRows() throws Exception{
		graph = new GraphData(2,3);
		graph.setRows(10);
		assertTrue(graph.getRows() == 10);
	}

	@Test
	public void testGetColumns()throws Exception {
		graph = new GraphData(2,3);
		assertTrue(graph.getColumns() == 3);
	}

	@Test
	public void testSetColumns()throws Exception {
		graph = new GraphData(2,3);
		graph.setColumns(15);
		assertTrue(graph.getColumns() == 15);
	}

	@Test
	public void testGetData()throws Exception {
		graph = new GraphData(2,3);
		graph.setData(1, 2, "@");
		assertTrue(graph.getData(1, 2).equals("@"));
	}

	@Test
	public void testSetData()throws Exception {
		graph = new GraphData(2,3);
		graph.setData(0, 1, "ABCD");
		assertTrue(graph.getData(0,1).equals("ABCD"));
	}

}
