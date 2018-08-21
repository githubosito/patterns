package creational.factory;

public interface TVFactory {
	public enum Brand{ORION, DAEWOO, LG};
	
	public static TV getTV(Brand tvType){
		switch (tvType) {
		case ORION:
			return new OrionTV();
		case DAEWOO:
			return new DaewooTV();
		case LG:
			return new LGTV();
		default:
			throw new IllegalArgumentException("How?");
		}
	}
}
