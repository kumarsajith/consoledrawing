/**
 * AllTests.java
 * 
 */
package canvas.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	CommandDataTest.class, 
	GraphDataTest.class, 
	PointTest.class,
	GraphDataExceptionTest.class
})


public class AllTests {

}
