/**
 *  GraphDataExceptionTest.java
 *  
 *  
 *  
 */
package canvas.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import canvas.util.Util;

/**
 * @author sarimbra
 * @date 2 May 2019
 * 
 */
public class GraphDataExceptionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link canvas.model.GraphDataException#getMessage()}.
	 */
	@Test
	public void testGetMessage_Null() {
		String errCode = null;
		GraphDataException ex = new GraphDataException(errCode);
		assertEquals(ex.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.model.GraphDataException#getMessage()}.
	 */
	@Test
	public void testGetMessage_Empty() {
		String errCode = "";
		GraphDataException ex = new GraphDataException(errCode);
		assertEquals(ex.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.model.GraphDataException#getMessage()}.
	 */
	@Test
	public void testGetMessage_Space() {
		String errCode = " ";
		GraphDataException ex = new GraphDataException(errCode);
		assertEquals(ex.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.model.GraphDataException#getMessage()}.
	 */
	@Test
	public void testGetMessage_SizeNegative() {
		String errCode = GraphDataException.GRAPH_SIZE_NEGATIVE;
		GraphDataException ex = new GraphDataException(errCode);
		assertEquals(ex.getMessage(), Util.getDisplayMessage(errCode));
	}
	
	/**
	 * Test method for {@link canvas.model.GraphDataException#getMessage()}.
	 */
	@Test
	public void testGetMessage_InvalidCode() {
		String errCode = "some invalid code";
		GraphDataException ex = new GraphDataException(errCode);
		assertEquals(ex.getMessage(), Util.getDisplayMessage(errCode));
	}

	/**
	 * Test method for {@link canvas.model.GraphDataException#logError(java.lang.Exception)}.
	 */
	@Test
	public void testLogError() {
		String errCode = "some invalid code";
		GraphDataException ex = new GraphDataException(errCode);
		ex.logError(ex);
	}

	/**
	 * Test method for {@link canvas.model.GraphDataException#getErrorCode()}.
	 */
	@Test
	public void testGetErrorCode_Invalid() {
		String errCode = "some invalid code";
		GraphDataException ex = new GraphDataException(errCode);
		assertEquals(ex.getErrorCode(), errCode);
	}
	
	/**
	 * Test method for {@link canvas.model.GraphDataException#getErrorCode()}.
	 */
	@Test
	public void testGetErrorCode_Null() {
		String errCode = null;
		GraphDataException ex = new GraphDataException(errCode);
		assertEquals(ex.getErrorCode(), errCode);
	}
	
	/**
	 * Test method for {@link canvas.model.GraphDataException#getErrorCode()}.
	 */
	@Test
	public void testGetErrorCode_Empty() {
		String errCode = "";
		GraphDataException ex = new GraphDataException(errCode);
		assertEquals(ex.getErrorCode(), errCode);
	}
	
	/**
	 * Test method for {@link canvas.model.GraphDataException#getErrorCode()}.
	 */
	@Test
	public void testGetErrorCode_Space() {
		String errCode = " ";
		GraphDataException ex = new GraphDataException(errCode);
		assertEquals(ex.getErrorCode(), errCode);
	}
	
	/**
	 * Test method for {@link canvas.model.GraphDataException#getErrorCode()}.
	 */
	@Test
	public void testGetErrorCode_Number() {
		String errCode = "123";
		GraphDataException ex = new GraphDataException(errCode);
		assertEquals(ex.getErrorCode(), errCode);
	}
}
