package creational.factory;

public class OrionTVRemote extends TVRemote {

	public OrionTVRemote(TV tv) {
		super(tv);
	}

//	@Override
//	protected void setButtons() {
//		buttons = new HashMap<String, DeviceButton>();
//		buttons.put("On", new DeviceButton(new TurnOnCommand(theTV)));
//		buttons.put("Off", new DeviceButton(new TurnOffCommand(theTV)));
//		/* some more buttons */
//	}
}
