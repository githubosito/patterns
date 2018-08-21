package creational.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

import behavioral.command.DeviceButton;
import behavioral.command.TVcommands.TVCommand;

public abstract class TVRemote {
	protected TV theTV;
	protected HashMap<String, DeviceButton> buttons;

	public TVRemote(TV tv) {
		this.theTV = tv;
		setButtons();
	}

	public Set<String> getButtonLabels() {
		return buttons.keySet();
	}

	protected void setButtons() {
		buttons = new HashMap<String, DeviceButton>();
		Class<? extends TV> TVClass = theTV.getClass();
		for (Method mth : TVClass.getMethods()) {
			RemoteCommand rc = mth.getAnnotation(RemoteCommand.class);
			if (rc != null) {

				if (!rc.label().equals("ch")) {
					buttons.put(rc.label(), new DeviceButton(new TVCommand() {

						@Override
						public void execute() {
							try {
								mth.invoke(theTV, null);
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}));
				} else {
					for (int i = 1; i < 10; i++) {
						String ch = Integer.toString(i);
						buttons.put(ch, new DeviceButton(new TVCommand() {

							@Override
							public void execute() {
								try {
									mth.invoke(theTV, Integer.parseInt(ch));
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									e.printStackTrace();
								}
							}
						}));
					}
				}
			}
		}
	}

	public void press(String button) {
		DeviceButton found = buttons.get(button);
		if (found != null) {
			found.press();
		} else {
			System.out.println("\nThere's no " + button + " button!\n");
		}
	}
}
