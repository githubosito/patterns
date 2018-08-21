package creational.factory;

import java.awt.Dimension;

import behavioral.strategy.ChannelControl;
import behavioral.strategy.ChannelController;
import creational.factory.TVFactory.Brand;

public class DaewooTV extends TV implements ChannelControl{
	private static final Dimension DEFAULT_RESOLUTION = new Dimension(1280, 1024);

	protected ChannelControl cc;

	public DaewooTV() {
		super();
		cc = new ChannelController(9);
		brand = Brand.DAEWOO;
		resolution = DEFAULT_RESOLUTION;
		System.out.println("-" + brand + " Television " + (++DaewooTV.deviceCounter) + " created.-");
		System.out.println(getState());
	}

	public int getCurrentChannel() {
		return cc.getCurrentChannel();
	}

	@Override
	public String getState() {
		return brand  + ((isOn) ? ", On" : ", Off") + ", ch: " + cc.getCurrentChannel() + ",  vol: " + vc.getVolume();
	}

	@RemoteCommand(label = "ch")
	public int switchChannel(int channel) {

		if (isOn)
			return cc.switchChannel(channel);

		return cc.getCurrentChannel();
	}

	@RemoteCommand(label = "chUp")
	public int channelUp() {
		if (isOn) {
			return cc.channelUp();
		}
		return cc.getCurrentChannel();
	}

	@RemoteCommand(label = "chDown")
	public int channelDown() {
		if (isOn) {
			return cc.channelDown();
		}
		return cc.getCurrentChannel();
	}
}
