package behavioral.strategy;

public class ChannelController implements ChannelControl {

	private int currentChannel;
	private int minNoChannels = 9;
	private int noChannels;

	public ChannelController(int noChannels) {
		if (noChannels < minNoChannels)
			throw new RuntimeException("You must choose a number above ." + minNoChannels);

		this.noChannels = noChannels;
		currentChannel = 1;
	}

	@Override
	public int channelUp() {
		if (currentChannel < noChannels)
			currentChannel++;
		return currentChannel;
	}

	@Override
	public int channelDown() {
		if (currentChannel > 0)
			currentChannel--;
		return currentChannel;
	}

	@Override
	public int switchChannel(int channel) {
		if (channel <= noChannels && channel > 0)
			currentChannel = channel;
		else
			throw new IllegalArgumentException("There is no channel " + channel + "!");

		return currentChannel;
	}

	@Override
	public int getCurrentChannel() {
		return currentChannel;
	}

}
