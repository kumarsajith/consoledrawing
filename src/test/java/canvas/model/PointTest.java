/**
 *  PointTest.java
 *  
 *  
 *  
 */
package canvas.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author sarimbra
 * @date 2 May 2019
 * 
 */
public class PointTest {

	private Point point;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link canvas.model.Point#Point(int, int)}.
	 */
	@Test
	public void testPoint() {
		point = new Point(0, 0);
		point = new Point(1000, 1000);
		point = new Point(0, 100);
		point = new Point(50, 50);
		point = new Point(-1, -3);
	}

	/**
	 * Test method for {@link canvas.model.Point#getX()}.
	 */
	@Test
	public void testGetX() {
		point = new Point(0, 0);
		assertTrue( point.getX() == 0);
		
		point = new Point(12, 25);
		assertTrue( point.getX() == 12);
		
		point = new Point(-1, 1);
		assertTrue( point.getX() == -1);
		
	}

	/**
	 * Test method for {@link canvas.model.Point#setX(int)}.
	 */
	@Test
	public void testSetX() {
		point = new Point(0, 0);
		point.setX(16);
		assertTrue( point.getX() == 16);
		
		point.setX(-1);
		assertTrue( point.getX() == -1);
		
	}

	/**
	 * Test method for {@link canvas.model.Point#getY()}.
	 */
	@Test
	public void testGetY() {
		point = new Point(0, 0);
		assertTrue( point.getY() == 0);
		
		point = new Point(12, 25);
		assertTrue( point.getY() == 25);
		
		point = new Point(1, -1);
		assertTrue( point.getY() == -1);
	}

	/**
	 * Test method for {@link canvas.model.Point#setY(int)}.
	 */
	@Test
	public void testSetY() {
		point = new Point(0, 0);
		point.setY(16);
		assertTrue( point.getY() == 16);
		
		point.setY(-10);
		assertTrue( point.getY() == -10);
	}

}
