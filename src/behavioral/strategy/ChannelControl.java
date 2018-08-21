package behavioral.strategy;

public interface ChannelControl {

	public int channelUp();

	public int channelDown();

	public int switchChannel(int channel);

	public int getCurrentChannel();
}
