package creational.factory;

public class DaewooTVRemote extends TVRemote {

	public DaewooTVRemote(TV tv) {
		super(tv);
	}

//	@Override
//	protected void setButtons() {
//		buttons = new HashMap<String, DeviceButton>();
//		buttons.put("On", new DeviceButton(new TurnOnCommand(theTV)));
//		buttons.put("Off", new DeviceButton(new TurnOffCommand(theTV)));
//		/* some more buttons */
//		buttons.put("ChUp", new DeviceButton(new ChannelUp((ChanneledTV)theTV)));
//		buttons.put("ChDown", new DeviceButton(new ChannelDown((ChanneledTV)theTV)));
//	}

}
