/**
 * 
 * CanvasCommandExtendedTest.java
 * 
 * 
 * 
 */
package canvas.controller;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import canvas.model.GraphData;
import canvas.view.BoardFactory;
import canvas.view.DrawingBoard;

/**
 * @author sajith
 * @date 06, May 2019
 * 
 */
@RunWith(Parameterized.class)
public class CanvasCommandExtendedTest {
	//set symbol used to clear graph cells
	private static final String CLR = GraphData.SYMBOL_CLEAR;
	
	public static int[][] canvasDimTC = {	{1,  1}, //test lower boundary
											{1, 999}, //test upper and lower boundary
											{999, 1},  //test upper and  lower boundary
											{999, 999}, //test upper boundary
											{2,2}, //test even
											{1, 2}, //test odd even
											{4, 3}, // test even odd
											{5,  499},//midpoint
											{499, 500}
 										};
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{ canvasDimTC[0], "TC1 failed"   }, 
			{ canvasDimTC[1], "TC2 failed"   }, 
			{ canvasDimTC[2], "TC3 failed"   }, 
			{ canvasDimTC[3], "TC4 failed"   }, 
			{ canvasDimTC[4], "TC5 failed"   }, 
			{ canvasDimTC[5], "TC6 failed"   }, 
			{ canvasDimTC[6], "TC7 failed"   }, 
			{ canvasDimTC[7], "TC8 failed"   }
		});
	}
	
	private Command command;
	private DrawingBoard board;
	private GraphData graph;
	
	@Parameter
	public int[] dimension;
	
	@Parameter(1)
	public String tcFailedMessage;
	
	private String[] arguments = new String[2];
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		board = BoardFactory.createBoard();
		command = new CanvasCommand();
		arguments[0] = String.valueOf(dimension[0]);
		arguments[1] = String.valueOf(dimension[1]);
		
	}

	/**
	 * Test method for {@link canvas.controller.CanvasCommand#execute(java.lang.String[], canvas.view.DrawingBoard)}.
	 */
	@Test
	public void testExecute() throws Exception {
		command.execute(arguments, board);
		graph = board.getGraphData();
		assertTrue(tcFailedMessage, isResultGraphClean(graph));
	}
	
	/**
	 * check graph contains all clear symbol.
	 * @param graph
	 * @return
	 */
	private boolean isResultGraphClean(GraphData graph) {
		
		if (graph.getRows() != dimension[0]) {
			return false;
		}
		
		if (graph.getColumns() != dimension[1]) {
			return false;
		}
		
		for (int i=0; i<dimension[0]; i++) {
			for (int j=0; j<dimension[1]; j++) {
				if (!graph.getData(i, j).equals(CLR)) {
					return false;
				}
			}
		}
		return true;
	}

}
