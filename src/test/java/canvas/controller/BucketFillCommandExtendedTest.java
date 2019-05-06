/**
 *  BucketFillCommandExtendedTest.java
 *  
 *  
 *  
 */
package canvas.controller;

import static org.junit.Assert.*;

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
 * @author sarimbra
 * @date 3 May 2019
 * 
 */
@RunWith(Parameterized.class)
public class BucketFillCommandExtendedTest {
	
	//set symbol used to clear graph cells
	private static final String CLR = GraphData.SYMBOL_CLEAR;
	private static final String POINT = GraphData.SYMBOL_POINT;
	
	//TC1: 3x3 clean board and fill with o
	public static String[][] graphDataTC1 		= { {CLR,CLR,CLR}, 
													{CLR,CLR,CLR}, 
													{CLR,CLR,CLR} };
	public static String[]   argumentsTC1    	= { "2","2","o"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC1 = { 	{"o","o","o"}, 
													{"o","o","o"}, 
													{"o","o","o"} };
	
	//TC2 3x3 board with horizontal line in middle and fill the line with +
	public static String[][] graphDataTC2 		= { {CLR,CLR,CLR}, 
													{POINT,POINT,POINT}, 
													{CLR,CLR,CLR} };
	public static String[]   argumentsTC2    	= { "2","2","+"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC2 = {  {CLR,CLR,CLR}, 
													{"+","+","+"}, 
													{CLR,CLR,CLR} };
	
	//TC3 3x3 board with vertical line in middle and fill the line with U
	public static String[][] graphDataTC3 		= { {CLR,POINT,CLR}, 
													{CLR,POINT,CLR}, 
													{CLR,POINT,CLR} };
	public static String[]   argumentsTC3    	= { "2","2","U"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC3 = {  {CLR,"U",CLR}, 
													{CLR,"U",CLR}, 
													{CLR,"U",CLR}};
	
	//TC4 3x3 board with diagonal line from (1)(1) and fill the line with F
	public static String[][] graphDataTC4 		= { {POINT,CLR,CLR}, 
													{CLR,POINT,CLR}, 
													{CLR,CLR,POINT} };
	public static String[]   argumentsTC4    	= { "2","2","F"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC4 = {  {"F",CLR,CLR}, 
													{CLR,"F",CLR}, 
													{CLR,CLR,"F"}};
	
	//TC5 3x3 board with horizontal line in middle and fill the part above the line with o
	public static String[][] graphDataTC5 		= { {CLR,CLR,CLR}, 
													{POINT,POINT,POINT}, 
													{CLR,CLR,CLR} };
	public static String[]   argumentsTC5    	= { "1","1","o"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC5 = {  {"o","o","o"}, 
													{POINT,POINT,POINT}, 
													{CLR,CLR,CLR} };
	
	//TC6 3x3 board with horizontal line in middle and fill the part below the line with o
	public static String[][] graphDataTC6 		= { {CLR,CLR,CLR}, 
													{POINT,POINT,POINT}, 
													{CLR,CLR,CLR} };
	public static String[]   argumentsTC6    	= { "3","3","o"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC6 = {  {CLR,CLR,CLR}, 
													{POINT,POINT,POINT}, 
													{"o","o","o"} };
	
	//TC7 3x3 board with vertical line in middle and fill the part left with U
	public static String[][] graphDataTC7 		= { {CLR,POINT,CLR}, 
													{CLR,POINT,CLR}, 
													{CLR,POINT,CLR} };
	public static String[]   argumentsTC7    	= { "1","1","U"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC7 = {  {"U",POINT,CLR}, 
													{"U",POINT,CLR}, 
													{"U",POINT,CLR}};
	
	//TC8 3x3 board with vertical line in middle and fill the part right with V
	public static String[][] graphDataTC8 		= { {CLR,POINT,CLR}, 
													{CLR,POINT,CLR}, 
													{CLR,POINT,CLR} };
	public static String[]   argumentsTC8    	= { "1","3","V"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC8 = {  {CLR,POINT,"V"}, 
													{CLR,POINT,"V"}, 
													{CLR,POINT,"V"}};
	
	//TC9 3x3 board with diagonal line from (1)(1) and fill the left part with D
	public static String[][] graphDataTC9 		= { {POINT,CLR,CLR}, 
													{CLR,POINT,CLR}, 
													{CLR,CLR,POINT} };
	public static String[]   argumentsTC9    	= { "2","1","D"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC9 = {  {POINT,CLR,CLR}, 
													{"D",POINT,CLR}, 
													{"D","D",POINT}};
	
	//TC10 3x3 board with diagonal line from (1)(1) and fill the RIGHT part with G
	public static String[][] graphDataTC10 		= { {POINT,CLR,CLR}, 
													{CLR,POINT,CLR}, 
													{CLR,CLR,POINT} };
	public static String[]   argumentsTC10   	= { "1","3","G"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC10 = { {POINT,"G","G"}, 
													{CLR,POINT,"G"}, 
													{CLR,CLR,POINT}};
	
	//TC11 3x3 board with special cases: diagonal line with part right is filled with some and left part should be filled with another color.
	public static String[][] graphDataTC11 		= { {POINT,"G","G"}, 
													{CLR,POINT,"G"}, 
													{CLR,CLR,POINT}};
	public static String[]   argumentsTC11   	= { "2","1","H"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC11 = { {POINT,"G","G"}, 
													{"H",POINT,"G"}, 
													{"H","H",POINT}};
	
	//TC12 3x3 board with special cases: diagonal line with part left is filled with some and right part should be filled with another color.
	public static String[][] graphDataTC12 		= { {POINT,CLR,CLR}, 
													{"H",POINT,CLR}, 
													{"H","H",POINT}};
	public static String[]   argumentsTC12   	= { "1","3","K"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC12 = { {POINT,"K","K"}, 
													{"H",POINT,"K"}, 
													{"H","H",POINT}};
	
	//TC13 3x3 board with special cases: diagonal line with all points filled and paint left portion of line with color *
	public static String[][] graphDataTC13 		= { {POINT,"K","K"}, 
													{"H",POINT,"K"}, 
													{"H","H",POINT}};
	public static String[]   argumentsTC13   	= { "2","1","*"}; //bucket fill point from (2,2) with 'o'
	public static String[][] expectedResultTC13 = { {POINT,"K","K"}, 
													{"*",POINT,"K"}, 
													{"*","*",POINT}};
	
	//TC14 8x7 board with special cases: rectangle from (2)(2) to (7)(6)
	public static String[][] graphDataTC14 		= { {"K","K","K","K","K","K","K"}, 
													{"K","X","X","X","X","X","K"}, 
													{"K","X","K","K","K","X","K"}, 
													{"K","X","K","K","K","X","K"}, 
													{"K","X","K","K","K","X","K"}, 
													{"K","X","K","K","K","X","K"}, 
													{"K","X","X","X","X","X","K"}, 
													{"K","K","K","K","K","K","K"}  };
	
	public static String[]   argumentsTC14   	= { "3","3","O"}; //bucket fill point from (3,3) with 'o'
	
	public static String[][] expectedResultTC14 = { {"K","K","K","K","K","K","K"}, 
													{"K","X","X","X","X","X","K"}, 
													{"K","X","O","O","O","X","K"}, 
													{"K","X","O","O","O","X","K"}, 
													{"K","X","O","O","O","X","K"}, 
													{"K","X","O","O","O","X","K"}, 
													{"K","X","X","X","X","X","K"}, 
													{"K","K","K","K","K","K","K"}  };
	
	//TC15 8x7 board with special cases: rectangle from (2)(2) to (7)(6) and fill everything outside as ^
	public static String[][] graphDataTC15 		= { {"K","K","K","K","K","K","K"}, 
													{"K","X","X","X","X","X","K"}, 
													{"K","X","O","O","O","X","K"}, 
													{"K","X","O","O","O","X","K"}, 
													{"K","X","O","O","O","X","K"}, 
													{"K","X","O","O","O","X","K"}, 
													{"K","X","X","X","X","X","K"}, 
													{"K","K","K","K","K","K","K"}  };
	
	public static String[]   argumentsTC15   	= { "1","1","^"}; //bucket fill point from (2,2) with '^'
	
	public static String[][] expectedResultTC15 = { {"^","^","^","^","^","^","^"}, 
													{"^","X","X","X","X","X","^"}, 
													{"^","X","O","O","O","X","^"}, 
													{"^","X","O","O","O","X","^"}, 
													{"^","X","O","O","O","X","^"}, 
													{"^","X","O","O","O","X","^"}, 
													{"^","X","X","X","X","X","^"}, 
													{"^","^","^","^","^","^","^"}  };
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{ graphDataTC1, argumentsTC1,  expectedResultTC1, "TC1 failed"   }, // last argument will be used to print failed test cases.
			{ graphDataTC2, argumentsTC2,  expectedResultTC2, "TC2 failed"   },
			{ graphDataTC3, argumentsTC3,  expectedResultTC3, "TC3 failed"   },
			{ graphDataTC4, argumentsTC4,  expectedResultTC4, "TC4 failed"   },
			{ graphDataTC5, argumentsTC5,  expectedResultTC5, "TC5 failed"   },
			{ graphDataTC6, argumentsTC6,  expectedResultTC6, "TC6 failed"   },
			{ graphDataTC7, argumentsTC7,  expectedResultTC7, "TC7 failed"   },
			{ graphDataTC8, argumentsTC8,  expectedResultTC8, "TC8 failed"   },
			{ graphDataTC9, argumentsTC9,  expectedResultTC9, "TC9 failed"   },
			{ graphDataTC10, argumentsTC10,  expectedResultTC10, "TC10 failed"   },
			{ graphDataTC11, argumentsTC11,  expectedResultTC11, "TC11 failed"   },
			{ graphDataTC12, argumentsTC12,  expectedResultTC12, "TC12 failed"   },
			{ graphDataTC13, argumentsTC13,  expectedResultTC13, "TC13 failed"   },
			{ graphDataTC14, argumentsTC14,  expectedResultTC14, "TC14 failed"   },
			{ graphDataTC15, argumentsTC15,  expectedResultTC15, "TC15 failed"   }
		});
	}
	
	@Parameter
	public String[][] graphDataPoints;
	
	@Parameter(1)
	public String[] arguments;
	
	@Parameter(2)
	public String[][] expectedResult;
	
	@Parameter(3)
	public String tcFailedMessage;
	
	private DrawingBoard board;
	private Command command;
	private GraphData graph;
	private GraphData resultGraph;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		board = BoardFactory.createBoard();
		board.initBoard(graphDataPoints.length, graphDataPoints[0].length);
		command = new BucketFillCommand();
		graph = board.getGraphData();
		
		for (int i=0; i<graphDataPoints.length; i++) {
			for (int j=0; j<graphDataPoints[0].length; j++) {
				graph.setData(i, j, graphDataPoints[i][j]);
			}
		}
	}

	/**
	 * utility class to check the graph is same as expected result.
	 * assume the test cases are 3x3 dimension.
	 * 
	 * @param graph1
	 * @param graph2
	 * @return
	 */
	private boolean compareResult(GraphData graph1, String[][] graph2) {
		
		if (graph1.getRows() != graph2.length) {
			return false;
		}
		
		if (graph1.getColumns() != graph2[0].length) {
			return false;
		}
		
		for (int i=0; i<graph2.length; i++) {
			for (int j=0; j<graph2[0].length; j++) {
				if (!graph.getData(i, j).equals(graph2[i][j])) {
					return false;
				}
			}
		}
		
		return true;
	}

	/**
	 * Test method for {@link canvas.controller.BucketFillCommand#execute(java.lang.String[], canvas.view.DrawingBoard)}.
	 */
	@Test
	public void testExecute()throws Exception {
		command.execute(arguments, board);
		resultGraph = board.getGraphData();
		assertTrue(tcFailedMessage, compareResult(resultGraph, expectedResult));
	}

}
