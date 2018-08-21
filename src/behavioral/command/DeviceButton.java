package behavioral.command;

import behavioral.command.TVcommands.TVCommand;

public class DeviceButton {
	
	TVCommand command;

	/**
	 * @param command
	 */
	public DeviceButton(TVCommand command) {
		this.command = command;
	}
	
	public void press(){
		command.execute();
	}
}
