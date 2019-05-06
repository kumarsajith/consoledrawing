package canvas.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	BucketFillCommandTest.class, 
	CanvasCommandTest.class, 
	CommandCompilerTest.class, 
	LineCommandTest.class,
	QuitCommandTest.class, 
	RectangleCommandTest.class ,
	BoardExceptionTest.class,
	CommandExceptionTest.class
})

public class AllTests {

}
