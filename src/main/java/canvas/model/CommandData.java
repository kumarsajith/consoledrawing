/**
 * CommandData.java
 * 
 * represent the data structure to hold command text data
 * 
 */
package canvas.model;

/**
 * @author sajith
 * @date 26, Apr 2019
 * 
 */
public class CommandData {
	
	
	private String command = null;
	private String[] arguments = null;
	
	public CommandData(String txtCom, String[] args) {
		this.command = txtCom;
		this.arguments = args;
	}
	
	
	/**
	 * @return the arguments
	 */
	public String[] getArguments() {
		return arguments;
	}
	/**
	 * @param arguments the arguments to set
	 */
	public void setArguments(String[] arguments) {
		this.arguments = arguments;
	}


	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}


	/**
	 * @param command the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}
	
	

}
