/**
 * 
 * BucketFillCommand.java
 * 
 * Command to execute fill area connected to a given point.
 * 
 * 
 */
package canvas.controller;


import java.util.ArrayList;
import java.util.Arrays;

import canvas.model.GraphData;
import canvas.model.GraphDataException;
import canvas.model.Point;
import canvas.util.Util;
import canvas.view.DrawingBoard;

/**
 * @author sajith
 * @date 27, Apr 2019
 * @modified 28, Apr 2019
 * 
 */
public class BucketFillCommand extends AbstractCommand {

	/* (non-Javadoc)
	 * @see canvas.controller.AbstractCommand#execute(java.lang.String[], canvas.view.DrawingBoard)
	 */
	@Override
	public void execute(String[] arguments, DrawingBoard board) throws BoardException, CommandException {
		//check board validations
		super.execute(arguments, board);
		
		//argument of fill command must be 3 [B x, y, c]
		if (arguments == null || arguments.length != 3) {
			throw new CommandException(CommandException.COMMAND_BUCKET_SYNTAX_ERROR);
		}
		
		try {
			int x = Integer.parseInt(arguments[0]);
			int y = Integer.parseInt(arguments[1]);
			String color = arguments[2];
			if (color.length()>1) {
				throw new CommandException(CommandException.COMMAND_COLOR_MUSTBE_CHAR);
			}
			
			checkRangeX(x, board);
			checkRangeY(y, board);
			
			String selectedPoint = board.getGraphData().getData(x-1, y-1);
			scanFillPoint(x-1,y-1, board.getGraphData(), color, selectedPoint);
		}catch(NumberFormatException nfe) {
			throw new CommandException(CommandException.COMMAND_POINTS_NOT_A_NUMBER);
		}
	}

	/**
	 * The algorithm  is to scan from current point to all directions and paint using selected colour.
	 * for straight directions, check if points are same colour as selected point then consider it for scanning its neighbourhood
	 * for diagonal points, if their nearby points adjacent to the given point is listed for scanning then leave it as it will be eventually scanned
	 * now if diagonal points adjacent points are not scanned, then check if adjacent sides are equal then do not scan as this is separating the diagonal point from given point.
	 *  
	 *  e.g consider below examples of diagonal cases where given point is (2)(2) and diagonal point is (1)(1)
	 *  
	 *     (1) (2) (3)						(1) (2) (3)						(1) (2) (3)
	 * (1)  X   Y	X					(1)  X   Y	T					(1)  X   Y	T
	 * (2)  D	X	X					(2)  Y	X	X					(2)  	X	X
	 * (3)  X	X	X					(3)  Y	X	X					(3)  Y	X	X
	 * 
	 * In the above example				In the above example			In the above example	
	 * (1) (1) will be painted 			(1)(1) will NOT be painted 		(1) (1) will be painted
	 * this is because (2)(1) is		this is because (2)(1) is		this is because (2)(1) is
	 * different from (1)(2)			same as (1)(2) and it 			empty though it is different
	 * 									separate (2)(2) from (1)(1)		from (1)(2)
	 * 									
	 * 
	 * 		
	 * 
	 * @param x
	 * @param y
	 * @param graph
	 * @param color
	 * @param selectedPoint
	 */
	private void scanFillPoint(int x, int  y, GraphData graph, String color, String selectedPoint) {
		
		Point startPoint = new Point(x,y);
		ArrayList<Point> scanList = new ArrayList<Point>();
		scanList.add(startPoint);
		
		boolean[][] scannedPoints = new boolean[graph.getRows()][graph.getColumns()];
		for (int i=0; i< graph.getRows(); i++) {
			Arrays.fill(scannedPoints[i], false);
		}
		
		int count = 0;
		int total = graph.getRows() * graph.getColumns();
		
		while(true) {
			if (scanList.size() <= 0 || count > total) {
				break;
			}
			Point scanPoint = scanList.get(0);
			scannedPoints[scanPoint.getX()][scanPoint.getY()]=true;
			graph.setData(scanPoint.getX(), scanPoint.getY(), color);
			//remove current point from scan list
			scanList.remove(0);
			
			//check left point of scanPoint
			boolean leftPointScan = checkLeftPoint(scanPoint, graph, selectedPoint, scanList, scannedPoints);
			
			//check right point of scanPoint
			boolean rightPointScan = checkRightPoint(scanPoint, graph, selectedPoint, scanList, scannedPoints);
			
			//check point above of scanPoint
			boolean upPointScan = checkUpPoint(scanPoint, graph, selectedPoint, scanList, scannedPoints);
			
			//check bottom point of scanPoint
			boolean downPointScan = checkDownPoint(scanPoint, graph, selectedPoint, scanList, scannedPoints);
			
			//check diagonal top left point of scanPoint
			checkDiagTopLeftPoint(scanPoint, graph, selectedPoint, scanList, scannedPoints, upPointScan, leftPointScan);
			
			//check diagonal top right point of scanPoint
			checkDiagTopRightPoint(scanPoint, graph, selectedPoint, scanList, scannedPoints, upPointScan, rightPointScan);
			
			//check diagonal bottom left point of scanPoint
			checkDiagBottomLeftPoint(scanPoint, graph, selectedPoint, scanList, scannedPoints, downPointScan, leftPointScan);
			
			//check diagonal bottom right point of scanPoint
			checkDiagBottomRightPoint(scanPoint, graph, selectedPoint, scanList, scannedPoints, downPointScan, rightPointScan);
			
			count++;
		}
	}


	/**
	 * check left point and to list of points to scan if qualified.
	 * 
	 * @param point
	 * @param graph
	 * @param selectedPoint
	 * @param scanList
	 * @param scannedPoints
	 * @return
	 */
	private boolean checkLeftPoint(
			Point point, 
			GraphData graph, 
			String selectedPoint, 
			ArrayList<Point> scanList,
			boolean[][] scannedPoints) {
		
		boolean isScanPoint = false;
		int x = point.getX();
		int y = point.getY()  - 1;
		
		if ( y >= 0 &&
			 !scannedPoints[x][y] &&  
			 graph.getData(x, y).equalsIgnoreCase(selectedPoint)) { // add to scanned point if point is identical to selected point 
				point = new Point(x, y);
				scanList.add(point);
				scannedPoints[x][y]=true;
				isScanPoint = true;
		}
		return isScanPoint;
	}
	
	/**
	 * check right point to add to list of points to scan
	 * 
	 * @param point
	 * @param graph
	 * @param selectedPoint
	 * @param scanList
	 * @param scannedPoints
	 * @return
	 */
	private boolean checkRightPoint(Point point, GraphData graph, String selectedPoint, ArrayList<Point> scanList,
			boolean[][] scannedPoints) {
		
		boolean isScanPoint = false;
		int x = point.getX();
		int y = point.getY()  + 1;
		
		if ( y < graph.getColumns() &&
			 !scannedPoints[x][y] &&	
			 graph.getData(x, y).equalsIgnoreCase(selectedPoint) ) {// add to scanned point if point is identical to selected point 
				point = new Point(x, y);
				scanList.add(point);
				scannedPoints[x][y]=true;
				isScanPoint = true;
		}
		return isScanPoint;
	}
	
	/**
	 * 
	 * check point up to the list of points to scan
	 * 
	 * @param point
	 * @param graph
	 * @param selectedPoint
	 * @param scanList
	 * @param scannedPoints
	 * @return
	 */
	private boolean checkUpPoint(Point point, GraphData graph, String selectedPoint, ArrayList<Point> scanList,
			boolean[][] scannedPoints) {
		
		boolean isScanPoint = false;
		int x = point.getX()-1;
		int y = point.getY();
		
		if ( x >= 0 &&
			 !scannedPoints[x][y] &&
			 graph.getData(x, y).equalsIgnoreCase(selectedPoint)) {// add to scanned point if point is identical to selected point 
				point = new Point(x, y);
				scanList.add(point);
				scannedPoints[x][y]=true;
				isScanPoint = true;
		}
		return isScanPoint;
	}
	
	/**
	 * check point down to the list of points to scan.
	 * 
	 * @param point
	 * @param graph
	 * @param selectedPoint
	 * @param scanList
	 * @param scannedPoints
	 * @return
	 */
	private boolean checkDownPoint(Point point, GraphData graph, String selectedPoint, ArrayList<Point> scanList,
			boolean[][] scannedPoints) {
		
		boolean isScanPoint = false;
		int x = point.getX()+1;
		int y = point.getY();
		
		if ( x < graph.getRows()  &&
			 !scannedPoints[x][y] &&
			 graph.getData(x, y).equalsIgnoreCase(selectedPoint)) {// add to scanned point if point is identical to selected point 
				point = new Point(x, y);
				scanList.add(point);
				scannedPoints[x][y]=true;
				isScanPoint = true;
		}
		return isScanPoint;
	}
	
	
	/**
	 * 
	 * check top left diagonal point to the list of points to scan.
	 * 
	 * @param point
	 * @param graph
	 * @param selectedPoint
	 * @param scanList
	 * @param scannedPoints
	 * @param isUpScanned
	 * @param isLeftScanned
	 * @return
	 */
	private boolean checkDiagTopLeftPoint(
			Point point, 
			GraphData graph, 
			String selectedPoint, 
			ArrayList<Point> scanList,
			boolean[][] scannedPoints,
			boolean isUpScanned,
			boolean isLeftScanned) {
		
		if ( !isUpScanned && !isLeftScanned) {
			try {
				String dataUp = getDataUp(point, graph);
				String dataLeft = getDataLeft(point, graph);
				
				if (dataUp != null && dataUp.equals(dataLeft) && !Util.isEmpty(dataUp)) {//if they are equal then they separate current point 
					return false;
				}
			}catch(GraphDataException ge) {
				return false;
			}
		}
		
		boolean isScanPoint = false; 
		int x = point.getX()-1;
		int y = point.getY()-1;
		
		if ( x >= 0 &&
			 y >= 0 &&
			 !scannedPoints[x][y] &&
			 graph.getData(x, y).equalsIgnoreCase(selectedPoint) &&
			 !graph.getData(x, y).equals(GraphData.SYMBOL_CLEAR) )  { //either one of up or left must be scanned for diagonal points
				point = new Point(x, y);
				scanList.add(point);
				scannedPoints[x][y]=true;
				isScanPoint = true;
		}
		return isScanPoint;
	}
	
	/**
	 * 
	 * @param point
	 * @param graph
	 * @param selectedPoint
	 * @param scanList
	 * @param scannedPoints
	 * @param isUpScanned
	 * @param isRightScanned
	 * @return
	 */
	private boolean checkDiagTopRightPoint(
			Point point, 
			GraphData graph, 
			String selectedPoint, 
			ArrayList<Point> scanList,
			boolean[][] scannedPoints, 
			boolean isUpScanned,
			boolean isRightScanned) {
		
		if ( !isUpScanned && !isRightScanned) {
			try {
				String dataUp = getDataUp(point, graph);
				String dataRight = getDataRight(point, graph);
				
				if (dataUp != null && dataUp.equals(dataRight) && !Util.isEmpty(dataUp)) {//if they are equal then they separate current point 
					return false;
				}
			}catch(GraphDataException ge) {
				return false;
			}
		}
		
		boolean isScanPoint = false;
		int x = point.getX()-1;
		int y = point.getY()+1;
		
		if ( x >= 0 &&
			 y < graph.getColumns() &&
			 !scannedPoints[x][y] &&
			 graph.getData(x, y).equalsIgnoreCase(selectedPoint) &&
			 !graph.getData(x, y).equals(GraphData.SYMBOL_CLEAR) ) { //either one of up or right must be scanned for diagonal points
				point = new Point(x, y);
				scanList.add(point);
				scannedPoints[x][y]=true;
				isScanPoint = true;
		}
		return isScanPoint;
	}
	
	
	/**
	 * 
	 * @param point
	 * @param graph
	 * @param selectedPoint
	 * @param scanList
	 * @param scannedPoints
	 * @param isDownScanned
	 * @param isLeftScanned
	 * @return
	 */
	private boolean checkDiagBottomLeftPoint(
			Point point, 
			GraphData graph, 
			String selectedPoint, 
			ArrayList<Point> scanList,
			boolean[][] scannedPoints, 
			boolean isDownScanned,
			boolean isLeftScanned) {
		
		if ( !isDownScanned && !isLeftScanned) {
			try {
				String dataDown = getDataDown(point, graph);
				String dataLeft = getDataLeft(point, graph);
				
				if (dataDown != null && dataDown.equals(dataLeft) && !Util.isEmpty(dataDown)) {//if they are equal then they separate current point 
					return false;
				}
			}catch(GraphDataException ge) {
				return false;
			}
		}
		
		boolean isScanPoint = false;
		
		int x = point.getX()+1;
		int y = point.getY()-1;
		
		if ( x < graph.getRows() &&
			 y >= 0 &&
			 !scannedPoints[x][y] &&
			 graph.getData(x, y).equalsIgnoreCase(selectedPoint) &&
			 !graph.getData(x, y).equals(GraphData.SYMBOL_CLEAR) )  { 
				point = new Point(x, y);
				scanList.add(point);
				scannedPoints[x][y]=true;
				isScanPoint = true;
		}
		return isScanPoint;
	}
	
	/**
	 * 
	 * @param point
	 * @param graph
	 * @param selectedPoint
	 * @param scanList
	 * @param scannedPoints
	 * @param isDownScanned
	 * @param isRightScanned
	 * @return
	 */
	private boolean checkDiagBottomRightPoint(
			Point point, 
			GraphData graph, 
			String selectedPoint, 
			ArrayList<Point> scanList,
			boolean[][] scannedPoints,
			boolean isDownScanned,
			boolean isRightScanned) {
		
		if ( !isDownScanned && !isRightScanned) {
			try {
				String dataDown = getDataDown(point, graph);
				String dataRight = getDataRight(point, graph);
				
				if (dataDown != null && dataDown.equals(dataRight) && !Util.isEmpty(dataDown)) {//if they are equal then they separate current point 
					return false;
				}
			}catch(GraphDataException ge) {
				return false;
			}
		}
		
		boolean isScanPoint = false;
		
		int x = point.getX()+1;
		int y = point.getY()+1;
		
		if ( x < graph.getRows() &&
			 y < graph.getColumns() &&
			 !scannedPoints[x][y] &&
			 graph.getData(x, y).equalsIgnoreCase(selectedPoint) &&
			 !graph.getData(x, y).equals(GraphData.SYMBOL_CLEAR))   { //either one of down or right must be scanned for diagonal points
				point = new Point(x, y);
				scanList.add(point);
				scannedPoints[x][y]=true;
				isScanPoint = true;
		}
		return isScanPoint;
	}
	
	/**
	 * 
	 * @param point
	 * @param graph
	 * @return
	 * @throws GraphDataException
	 */
	private String getDataRight(Point point, GraphData graph) throws GraphDataException {
		
		String data = null;
		int x = point.getX();
		int y = point.getY()  + 1;
		
		if ( y < graph.getColumns() ) {
			data = graph.getData(x, y);
			return data;
		}
		
		throw new GraphDataException(GraphDataException.GRAPH_POINT_OUT_OF_RANGE);
	}
	
	/**
	 * 
	 * @param point
	 * @param graph
	 * @return
	 * @throws GraphDataException
	 */
	private String getDataLeft(Point point, GraphData graph) throws GraphDataException {
		
		String data = null;
		int x = point.getX();
		int y = point.getY()  - 1;
		
		if ( y >= 0 ) {
			data = graph.getData(x, y);
			return data;
		}
		
		throw new GraphDataException(GraphDataException.GRAPH_POINT_OUT_OF_RANGE);
	}
	
	/**
	 * 
	 * @param point
	 * @param graph
	 * @return
	 * @throws GraphDataException
	 */
	private String getDataUp(Point point, GraphData graph) throws GraphDataException {
		
		String data = null;
		int x = point.getX() -1;
		int y = point.getY();
		
		if ( x >= 0) {
			data = graph.getData(x, y);
			return data;
		}
		throw new GraphDataException(GraphDataException.GRAPH_POINT_OUT_OF_RANGE);
	}
	
	/**
	 * 
	 * @param point
	 * @param graph
	 * @return
	 * @throws GraphDataException
	 */
	private String getDataDown(Point point, GraphData graph) throws GraphDataException {
		
		String data = null;
		int x = point.getX() + 1;
		int y = point.getY();
		
		if ( x < graph.getRows()) {
			data = graph.getData(x, y);
			return data;
		}
		
		throw new GraphDataException(GraphDataException.GRAPH_POINT_OUT_OF_RANGE);
	}

}
