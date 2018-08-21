package creational.factory;

import java.awt.Dimension;

import behavioral.strategy.VolumeController;
import creational.factory.TVFactory.Brand;

class OrionTV extends TV {

	private static final Dimension DEFAULT_RESOLUTION = new Dimension(640, 480);

	public OrionTV() {
		super();
		resolution = DEFAULT_RESOLUTION;
		brand = Brand.ORION;
		vc = new VolumeController(10);
		System.out.println("-" + brand + " Television " + (++OrionTV.deviceCounter) + " created.-");
		System.out.println(getState());
	}

	@Override
	public String getState() {
		return brand + ", " + ((isOn) ? "On" : "Off") + ", volume: " + vc.getVolume();
	}

}
