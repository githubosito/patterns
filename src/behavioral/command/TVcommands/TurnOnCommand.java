package behavioral.command.TVcommands;

import creational.factory.TV;

public class TurnOnCommand implements TVCommand {

//	public TurnOnCommand(CommandMgr commandMgr) {
//		super(commandMgr);
//	}
	
	protected TV device;
	
	public TurnOnCommand(TV device) {
		this.device = device;
	}

	@Override
	public void execute() {
		//commandMgr.TurnOn(this);
		device.turnOn();
	}

}
