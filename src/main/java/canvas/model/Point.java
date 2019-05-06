/**
 * Point.java
 * 
 * represent the point structure to hold x,y point
 * 
 */
package canvas.model;

/**
 * @author sajith
 * @date 28, Apr 2019
 * 
 */
public class Point {

	private int x;
	private int y;
	
	public Point(int x1, int y1) {
		this.x = x1;
		this.y = y1;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
