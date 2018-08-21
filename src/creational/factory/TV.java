package creational.factory;

import java.awt.Dimension;

import behavioral.strategy.VolumeControl;
import behavioral.strategy.VolumeController;
import creational.factory.TVFactory.Brand;

public abstract class TV implements VolumeControl, ElectronicDevice {
	protected static int deviceCounter = 0;
	protected VolumeControl vc;

	protected Brand brand;
	protected Dimension resolution;
	protected boolean isOn;

	public TV() {
		vc = new VolumeController(8);
		isOn = true;
	}

	public Brand getBrand() {
		return brand;
	}

	public Dimension getResolution() {
		return resolution;
	}

	public int getVolume() {
		return vc.getVolume();
	}

	public abstract String getState();

	public boolean isOn() {
		return isOn;
	}

	@RemoteCommand(label = "On")
	public void turnOn() {
		if (isOn()) {
		} else {
			isOn = true;
		}
	}

	@RemoteCommand(label = "Off")
	public void turnOff() {
		if (isOn()) {
			isOn = false;
		}
	}

	@RemoteCommand(label = "volUp")
	public int volumeUp() {
		if (isOn)
			return vc.volumeUp();
		return vc.getVolume();
	}

	@RemoteCommand(label = "volDown")
	public int volumeDown() {
		if (isOn)
			return vc.volumeDown();
		return vc.getVolume();
	}

	@RemoteCommand(label = "mute")
	public void mute() {
		if (isOn)
			vc.mute();
	}
}
