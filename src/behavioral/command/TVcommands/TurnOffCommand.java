package behavioral.command.TVcommands;

import creational.factory.TV;

public class TurnOffCommand implements TVCommand {

//	public TurnOffCommand(CommandMgr commandMgr) {
//		super(commandMgr);
//	}

	protected TV device;
	
	public TurnOffCommand(TV device) {
		this.device = device;
	}

	@Override
	public	void execute() {
		//commandMgr.TurnOn(this);
		device.turnOff();
	}

}
