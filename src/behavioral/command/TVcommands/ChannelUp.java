package behavioral.command.TVcommands;

import behavioral.strategy.ChannelControl;

public class ChannelUp implements TVCommand {
	protected ChannelControl tv;

	public ChannelUp(ChannelControl tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.channelUp();
	}
}
