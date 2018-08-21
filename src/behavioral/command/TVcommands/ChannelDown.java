package behavioral.command.TVcommands;

import behavioral.strategy.ChannelControl;

public class ChannelDown implements TVCommand{
	protected ChannelControl tv;
	
	public ChannelDown(ChannelControl tv) {
		this.tv = tv;
	}
	
	@Override
	public void execute() {
		tv.channelDown();
	}
}
