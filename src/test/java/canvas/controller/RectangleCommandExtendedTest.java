/**
 * RectangleCommandExtendedTest.java
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
 * @author sajith
 * @date 06, May 2019
 * 
 */
@RunWith(Parameterized.class)
public class RectangleCommandExtendedTest {

	//set symbol used to clear graph cells
		private static final String CLR = GraphData.SYMBOL_CLEAR;
		private static final String POINT = GraphData.SYMBOL_POINT;
		
		//TC1: horizontal line along top edge
		public static String[][] graphDataTC1 		= { {CLR,CLR,CLR}, 
														{CLR,CLR,CLR}, 
														{CLR,CLR,CLR} };
		public static String[]   argumentsTC1    	= { "1","1","1","3"}; //horizontal line along top edge
		public static String[][] expectedResultTC1 = { 	{POINT,POINT,POINT}, 
														{CLR,CLR,CLR}, 
														{CLR,CLR,CLR} };
		
		//TC2 horizonal line in middle
		public static String[][] graphDataTC2 		= { {CLR,CLR,CLR}, 
														{CLR,CLR,CLR}, 
														{CLR,CLR,CLR} };
		public static String[]   argumentsTC2    	= { "2","1","2","3"}; 
		public static String[][] expectedResultTC2 = {  {CLR,CLR,CLR}, 
														{POINT,POINT,POINT}, 
														{CLR,CLR,CLR} };
		
		//TC3 horizontal line along bottom edge
		public static String[][] graphDataTC3 		= { {CLR,CLR,CLR}, 
														{CLR,CLR,CLR}, 
														{CLR,CLR,CLR} };
		public static String[]   argumentsTC3    	= { "3","1","3","3"}; 
		public static String[][] expectedResultTC3 = {  {CLR,CLR,CLR}, 
														{CLR,CLR,CLR}, 
														{POINT,POINT,POINT} };
		
		//TC4 vertical line through left edge
		public static String[][] graphDataTC4 		= { {CLR,CLR,CLR}, 
														{CLR,CLR,CLR}, 
														{CLR,CLR,CLR} };
		public static String[]   argumentsTC4    	= { "1","1","3","1"}; 
		public static String[][] expectedResultTC4 = {  {POINT,CLR,CLR}, 
														{POINT,CLR,CLR}, 
														{POINT,CLR,CLR} };
		
		//TC5 vertical line in the middle
		public static String[][] graphDataTC5 		= { {CLR,CLR,CLR}, 
														{CLR,CLR,CLR}, 
														{CLR,CLR,CLR} };
		public static String[]   argumentsTC5    	= { "1","2","3","2"}; 
		public static String[][] expectedResultTC5 = {  {CLR,POINT,CLR}, 
														{CLR,POINT,CLR}, 
														{CLR,POINT,CLR} };
		
		//TC6 vertical line in the right edge
		public static String[][] graphDataTC6 		= { {CLR,CLR,CLR}, 
														{CLR,CLR,CLR}, 
														{CLR,CLR,CLR} };
		public static String[]   argumentsTC6    	= { "1","3","3","3"}; 
		public static String[][] expectedResultTC6 = {  {CLR,CLR,POINT}, 
														{CLR,CLR,POINT}, 
														{CLR,CLR,POINT} };
		
		//TC7 diagonal line through top left corner
		public static String[][] graphDataTC7 		= { {CLR,CLR,CLR}, 
														{CLR,CLR,CLR}, 
														{CLR,CLR,CLR} };
		public static String[]   argumentsTC7    	= { "1","1","3","3"}; 
		public static String[][] expectedResultTC7 = { 	{POINT,POINT,POINT}, 
														{POINT,CLR,POINT}, 
														{POINT,POINT,POINT} };
		
		//TC8 diagonal line through (1)(3)
		public static String[][] graphDataTC8 		= { {CLR,CLR,CLR}, 
														{CLR,CLR,CLR}, 
														{CLR,CLR,CLR} };
		public static String[]   argumentsTC8    	= { "1","3","3","1"}; 
		public static String[][] expectedResultTC8 = { 	{POINT,POINT,POINT}, 
														{POINT,CLR,POINT}, 
														{POINT,POINT,POINT} };
		
		//TC9 
		public static String[][] graphDataTC9 		= { {CLR,CLR,CLR, CLR}, 
														{CLR,CLR,CLR, CLR}, 
														{CLR,CLR,CLR, CLR} };
		public static String[]   argumentsTC9    	= { "2","3","2","4"}; 
		public static String[][] expectedResultTC9 = {  {CLR,CLR,CLR, CLR}, 
														{CLR,CLR,POINT, POINT}, 
														{CLR,CLR,CLR, CLR} };
		
		//TC10 short line starting from edge
		public static String[][] graphDataTC10 		= { {CLR,CLR,CLR, CLR}, 
														{CLR,CLR,CLR, CLR}, 
														{CLR,CLR,CLR, CLR} };
		public static String[]   argumentsTC10   	= { "2","1","2","3"}; 
		public static String[][] expectedResultTC10 = { {CLR,CLR,CLR, CLR}, 
														{POINT,POINT,POINT, CLR}, 
														{CLR,CLR,CLR, CLR} };
		
		//TC11 short line in the box.
		public static String[][] graphDataTC11 		= { {CLR,CLR,CLR, CLR}, 
														{CLR,CLR,CLR, CLR}, 
														{CLR,CLR,CLR, CLR} };
		public static String[]   argumentsTC11   	= { "2","2","2","3"}; 
		public static String[][] expectedResultTC11 = { {CLR,CLR,CLR, CLR}, 
														{CLR,POINT,POINT, CLR}, 
														{CLR,CLR,CLR, CLR} };
		
		//TC12 short vertical line to edge
		public static String[][] graphDataTC12 		= { {CLR,CLR,CLR, CLR}, 
														{CLR,CLR,CLR, CLR}, 
														{CLR,CLR,CLR, CLR},
														{CLR,CLR,CLR, CLR} };
		public static String[]   argumentsTC12   	= { "1","2","2","2"}; 
		public static String[][] expectedResultTC12 = { {CLR,POINT,CLR, CLR}, 
														{CLR,POINT,CLR, CLR}, 
														{CLR,CLR,CLR, CLR},
														{CLR,CLR,CLR, CLR} };
		
		//TC13 short vertical line in the box
		public static String[][] graphDataTC13 		= { {CLR,CLR,CLR, CLR}, 
														{CLR,CLR,CLR, CLR}, 
														{CLR,CLR,CLR, CLR},
														{CLR,CLR,CLR, CLR} };
		public static String[]   argumentsTC13   	= { "3","3","2", "3"}; 
		public static String[][] expectedResultTC13 = { {CLR,CLR,CLR, CLR}, 
														{CLR,CLR,POINT, CLR}, 
														{CLR,CLR,POINT, CLR},
														{CLR,CLR,CLR, CLR} };
		
		//TC14 LINE in a filled box. 
		public static String[][] graphDataTC14 		= { {"K","K","K","K","K","K","K"}, 
														{"K","X","X","X","X","X","K"}, 
														{"K","X","K","K","K","X","K"}, 
														{"K","X","K","K","K","X","K"}, 
														{"K","X","K","K","K","X","K"}, 
														{"K","X","K","K","K","X","K"}, 
														{"K","X","X","X","X","X","K"}, 
														{"K","K","K","K","K","K","K"}  };
		
		public static String[]   argumentsTC14   	= { "4","2","4", "6"}; 
		
		public static String[][] expectedResultTC14 = { {"K","K","K","K","K","K","K"}, 
														{"K","X","X","X","X","X","K"}, 
														{"K","X","K","K","K","X","K"}, 
														{"K",POINT,POINT,POINT,POINT,POINT,"K"}, 
														{"K","X","K","K","K","X","K"}, 
														{"K","X","K","K","K","X","K"}, 
														{"K","X","X","X","X","X","K"}, 
														{"K","K","K","K","K","K","K"}  };
		
		//TC15 BOX IN  FILLED CANVAS
		public static String[][] graphDataTC15 		= { {"K","K","K","K","K","K","K"}, 
														{"K","X","X","X","X","X","K"}, 
														{"K","X","O","O","O","X","K"}, 
														{"K","X","O","O","O","X","K"}, 
														{"K","X","O","O","O","X","K"}, 
														{"K","X","O","O","O","X","K"}, 
														{"K","X","X","X","X","X","K"}, 
														{"K","K","K","K","K","K","K"}  };
		
		public static String[]   argumentsTC15   	= { "2","2","5","6"}; 
		
		public static String[][] expectedResultTC15 = { {"K","K","K","K","K","K","K"}, 
														{"K",POINT,POINT,POINT,POINT,POINT,"K"}, 
														{"K",POINT,"O","O","O",POINT,"K"}, 
														{"K",POINT,"O","O","O",POINT,"K"}, 
														{"K",POINT,POINT,POINT,POINT,POINT,"K"}, 
														{"K","X","O","O","O","X","K"}, 
														{"K","X","X","X","X","X","K"}, 
														{"K","K","K","K","K","K","K"}  };
		
		
		
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
		
		/**
		 * @throws java.lang.Exception
		 */
			
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
			
		@Before
		public void setUp() throws Exception {
			board = BoardFactory.createBoard();
			board.initBoard(graphDataPoints.length, graphDataPoints[0].length);
			command = new RectangleCommand();
			graph = board.getGraphData();
			
			for (int i=0; i<graphDataPoints.length; i++) {
				for (int j=0; j<graphDataPoints[0].length; j++) {
					graph.setData(i, j, graphDataPoints[i][j]);
				}
			}
		}

		/**
		 * Test method for {@link canvas.controller.LineCommand#execute(java.lang.String[], canvas.view.DrawingBoard)}.
		 */
		@Test
		public void testExecute() throws Exception {
			command.execute(arguments, board);
			resultGraph = board.getGraphData();
			assertTrue(tcFailedMessage, compareResult(resultGraph, expectedResult));
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

}
