/**
 *
 * CommandDataTest.java
 * 
 */
package canvas.model;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CommandDataTest {

	private CommandData commandData;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testCommandData_Null() {
		commandData = new CommandData(null, null);
		assertFalse (commandData.getArguments() != null);
		assertFalse (commandData.getCommand() != null);
	}
	
	@Test
	public void testCommandData_Empty() {
		String[] arg = {};
		commandData = new CommandData("", arg);
		assertFalse (!commandData.getCommand().equals(""));
		assertFalse (!Arrays.equals(commandData.getArguments(), arg));
	}

	@Test
	public void testCommandData_Spaces() {
		String[] arg = {" "};
		commandData = new CommandData(" ", arg);
		assertFalse (!commandData.getCommand().equals(" "));
		assertFalse (!Arrays.equals(commandData.getArguments(), arg));
	}
	
	@Test
	public void testCommandData_AlphaNumberic() {
		String[] arg = {"&","a", "("};
		commandData = new CommandData("A$@123", arg);
		assertFalse (!commandData.getCommand().equals("A$@123"));
		assertFalse (!Arrays.equals(commandData.getArguments(), arg));
	}
	
	@Test
	public void testCommandData_SingleChar() {
		String[] arg = {"10","5", "6", "5"};
		commandData = new CommandData("C", arg);
		assertFalse (!commandData.getCommand().equals("C"));
		assertFalse (!Arrays.equals(commandData.getArguments(), arg));
	}
	
	@Test
	public void testGetArguments() {
		String arg[] = {"20", "30"};
		commandData = new CommandData("C", arg);
		assertFalse (!Arrays.equals(commandData.getArguments(), arg));
	}

	@Test
	public void testSetArguments() {
		String arg[] = {"20", "30"};
		commandData = new CommandData("C", arg);
		String[] arg2 = {"12","4","5", "6"};
		commandData.setArguments(arg2);
		assertFalse (!Arrays.equals(commandData.getArguments(), arg2));
	}

	@Test
	public void testGetCommand() {
		String[] arg = {"1","1", "100", "200"};
		commandData = new CommandData("L", arg);
		assertFalse (!commandData.getCommand().equals("L"));
	}

	@Test
	public void testSetCommand() {
		String[] arg = {"1","1", "100", "200"};
		commandData = new CommandData("L", arg);
		commandData.setCommand("R");
		assertFalse (!commandData.getCommand().equals("R"));
	}

}
