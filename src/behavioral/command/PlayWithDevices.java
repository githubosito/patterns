package behavioral.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import creational.factory.TV;
import creational.factory.TVFactory;
import creational.factory.TVRemote;
import creational.factory.TVRemoteFactory;

public class PlayWithDevices implements Runnable, ActionListener {
	protected TVGui tvGui;
	protected TV tv;
	protected TVRemote remote;

	public PlayWithDevices() {

		tv = TVFactory.getTV(TVFactory.Brand.DAEWOO);
		remote = TVRemoteFactory.getTVRemote(tv);

		tvGui = TVGui.getInstance(tv);
		tvGui.addRemoteListener(this);
	}

	public void run() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * Egy nagy switch helyett be lehet rakni a következő sort, ha
		 * megfelelően karban vannak tartva a gui címkéi:
		 */
		remote.press(e.getActionCommand());
		tvGui.setTVState();
		System.out.println(tv.getState());
	}
}
