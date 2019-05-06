/**
 * CommandCompiler.java
 * 
 * parse the command line arguments
 * 
 */
package canvas.controller;

import java.util.Arrays;
import java.util.HashMap;

import canvas.model.CommandData;
import canvas.util.Util;

/**
 * @author sajith
 * @date 25, Apr 2019
 * @modified 28, Apr 2019
 * 
 */
public final class CommandCompiler {
	
	
	//list of availabel command implementations.
	private static HashMap<String, Command> commandMap = new  HashMap<String, Command>();
	
	//initialize the command upon start.
	static {
		commandMap.put("C", new CanvasCommand());
		commandMap.put("Q", new QuitCommand());
		commandMap.put("L", new LineCommand());
		commandMap.put("R", new RectangleCommand());
		commandMap.put("B", new BucketFillCommand());
	}
	
	
	/**
	 * parse the line text for available commands. return the command text if valid
	 * 
	 * If available commands not found, then throw CommandException.
	 * 
	 * 
	 * @param lineCommand
	 * @return Command
	 * @throws CommandException
	 */
	public static CommandData parse(String lineCommand)  throws CommandException {
		
		if (Util.isEmpty(lineCommand)) {
			throw new CommandException(CommandException.COMMAND_EMPTY);
		}
		
		String[] args = lineCommand.trim().toUpperCase().split("\\s+");
		
		
		if (commandMap.containsKey(args[0])) {
			String txtCommand = args[0];
			String[] arguments = args.length >1 ? Arrays.copyOfRange(args, 1, args.length):null;
			return new CommandData(txtCommand, arguments);
		}
		
		throw new CommandException(CommandException.COMMAND_NOT_FOUND);
	
	}
	
	/**
	 * return Command implementation for the given command if available, otherwise throw exception.
	 * 
	 * @param textCommand
	 * @return
	 * @throws CommandException
	 */
	public static Command getCommand(String textCommand)  throws CommandException {
		
		if (Util.isEmpty(textCommand)) {
			throw new CommandException(CommandException.COMMAND_EMPTY);
		}
		
		Command command = commandMap.get(textCommand);
		
		if (command == null) {
			throw new CommandException(CommandException.COMMAND_NOT_FOUND);
		}
		
		return command;
	}


}
