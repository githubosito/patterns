package creational.factory;

import java.awt.Dimension;

import behavioral.strategy.ChannelControl;
import behavioral.strategy.ChannelController;
import behavioral.strategy.MenuControl;
import behavioral.strategy.TwoWayMenu;
import behavioral.strategy.VolumeController;
import creational.factory.TVFactory.Brand;

public class LGTV extends TV implements MenuControl, ChannelControl {

	private static final Dimension DEFAULT_RESOLUTION = new Dimension(1920, 1080);
	public static final int MAX_VOLUME = 25;

	protected MenuControl mc;
	protected ChannelControl cc;

	public LGTV() {
		super();
		brand = Brand.LG;
		vc = new VolumeController(MAX_VOLUME);
		cc = new ChannelController(9);
		mc = new TwoWayMenu();
		resolution = DEFAULT_RESOLUTION;
	}

	@Override
	public String getState() {
		return brand + ((isOn) ? ", On" : ", Off") + ",  ch: " + cc.getCurrentChannel() + ",  vol: " + vc.getVolume()
				+ ",  menustate: " + ((mc.isActive()) ? "on" : "off");
	}

	@RemoteCommand(label = "open")
	public void openMenu() {
		if (isOn)
			mc.openMenu();
		// isInMenu = isOn || isInMenu;
	}

	@RemoteCommand(label = "exit")
	public void exitMenu() {
		if (isOn)
			mc.exitMenu();
		// isInMenu = !isOn && isInMenu;
	}

	@RemoteCommand(label = "chUp")
	public int channelUp() {
		if (isOn)
			return cc.channelUp();
		return cc.getCurrentChannel();
	}

	@RemoteCommand(label = "chDown")
	public int channelDown() {
		if (isOn)
			return cc.channelDown();
		return cc.getCurrentChannel();
	}

	@RemoteCommand(label = "ch")
	public int switchChannel(int channel) {
		if (isOn)
			return cc.switchChannel(channel);

		return cc.getCurrentChannel();
	}

	@Override
	public int getCurrentChannel() {
		return cc.getCurrentChannel();
	}

	@Override
	public boolean isActive() {
		return mc.isActive();
	}
}
