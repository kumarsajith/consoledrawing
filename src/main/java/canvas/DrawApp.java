/**
 * 
 * DrawApp.java
 * 
 * Main App to launch Drawing Board.
 * Usage: java -cp canvas-0.0.1-SNAPSHOT canvas.DrawApp
 * 
 * 
 */
package canvas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import canvas.controller.BoardException;
import canvas.controller.Command;
import canvas.controller.CommandCompiler;
import canvas.controller.CommandException;
import canvas.model.CommandData;
import canvas.util.Constants;
import canvas.util.Util;
import canvas.view.BoardFactory;
import canvas.view.DrawingBoard;


/**
 * @author sajith
 * @date  25, Apr 2019
 * @modified 28, Apr 2019
 * 
 */
public  final class DrawApp {
	
	//instance of drawing board
	private DrawingBoard board = null;
	
	//reader instance to read input from line
	private BufferedReader lineReader = null;
	
	public DrawApp() {
		lineReader = new BufferedReader(new InputStreamReader(System.in));
		board = BoardFactory.createBoard();
	}
	

	/**
	 * 
	 * @param args 
	 * 
	 */
	public static void main(String[] args) {
		DrawApp app = new DrawApp();
		app.start();
		app.clean();
	}

	/**
	 * release the resources and close all input streams.
	 */
	private void clean() {
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_EXIT_MESSAGE));
		board.clean();
		try {
			lineReader.close();
		} catch (IOException e) {
			//LOG
		}
	}
	
	/**
	 * Display app wel come message.
	 */
	private void printWelcome() {
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_WELCOME_MESSAGE));
		
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_USAGE_TITLE));
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_USAGE_RULE1));
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_USAGE_RULE2));
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_USAGE_RULE3));
		
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_COMMAND_HELP));
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_COMMAND_CANVAS));
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_COMMAND_LINE));
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_COMMAND_RECTANGLE));
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_COMMAND_BUCKET));
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_COMMAND_QUIT));
		
		board.displayMessage(Util.getDisplayMessage(Constants.SYS_PROMPT_INPUT));
	}
	
	/**
	 * Start the console for accepting commands, execute commands and manage life cycle.
	 * 
	 */
	private void start() {
		printWelcome();
		while(true) {
			
			Command command;
			try {
				CommandData parser = getNextCommand();
				String  textCommand = parser.getCommand();
				command = CommandCompiler.getCommand(textCommand);
				if  (command.isExit()) {
					break;
				}
				command.execute(parser.getArguments(), board);
				board.display();
			} catch (CommandException ce) {
				board.displayMessage(ce.getMessage());
			} catch (BoardException be) {
				board.displayMessage(be.getMessage());
			}
		}
	}

	/**
	 * read the command from line input and return the commands as typed.
	 * in  case of invalid commands, throw Command exception.
	 * 
	 * @return Command 
	 */
	private CommandData getNextCommand() throws CommandException {
		
		try {
			String lineCommand =  lineReader.readLine();
			return CommandCompiler.parse(lineCommand);
		} catch (IOException e) {
			CommandException ce = new CommandException(CommandException.COMMAND_READ_IO_ERROR);
			ce.logError(ce);
			throw ce;
		}
	}
	
	
}
