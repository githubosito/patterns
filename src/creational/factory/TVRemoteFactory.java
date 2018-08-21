package creational.factory;

import creational.factory.TVFactory.Brand;

public class TVRemoteFactory {

	public static TVRemote getTVRemote(TV tv) {
		Brand device = tv.getBrand();
		switch (device) {
		case ORION:
			return new OrionTVRemote(tv);
		case DAEWOO:
			return new DaewooTVRemote(tv);
		case LG:
			return new LGTVRemote(tv);
		default:
			throw new IllegalArgumentException("Not supported television!");
		}
	}
}
