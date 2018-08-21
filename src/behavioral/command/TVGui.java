package behavioral.command;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import behavioral.strategy.ChannelControl;
import creational.factory.DaewooTV;
import creational.factory.TV;
import creational.factory.TVFactory.Brand;
import creational.factory.TVRemote;
import creational.factory.TVRemoteFactory;

@SuppressWarnings("serial")
public class TVGui extends JFrame {

	protected static TVGui instance;
	protected static TV theTV;
	protected JPanel remotePnl;
	protected JPanel tvPnl;

	public static synchronized TVGui getInstance(TV TV) {
		if (instance == null) {
			instance = new TVGui(TV);
		}
		return instance;
	}

	private TVGui(TV TV) {
		theTV = TV;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		rootPane.setLayout(new GridLayout(1, 2));
		rootPane.removeAll();

		tvPnl = buildTV(TV);
		remotePnl = buildRemote(TVRemoteFactory.getTVRemote(TV));
		rootPane.add(remotePnl);
		rootPane.add(tvPnl);
		setTVState();

		setVisible(true);
		pack();
	}

	protected JPanel buildTV(TV TV) {
		JPanel tvPanel = new JPanel();
		tvPanel.setPreferredSize(
				new Dimension(200, 100));/* TV-ben kell megadni */
		JLabel label = new JLabel(theTV.getState());
		tvPanel.add(label);
		tvPanel.setVisible(true);

		return tvPanel;
	}

	protected JPanel buildRemote(TVRemote TVRemote) {
		Set<String> buttonsLabels = TVRemote.getButtonLabels();

		// JPanel remotePnl = new JPanel(new GridLayout(buttonsLabels.size() /
		// 2, 2));
		JPanel remotePnl = new JPanel();
		remotePnl.setVisible(true);

		for (String label : buttonsLabels) {
			JButton btn = new JButton(label);
			btn.setForeground(new Color(80, 80, 80));
			btn.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			btn.setVisible(true);
			remotePnl.add(btn);
		}
		return remotePnl;
	}

	public void setTVState() {
 		if (theTV.isOn()) {
			Class<?>[] ifaces = theTV.getClass().getInterfaces();
			for (int i = 0; i < ifaces.length; i++) {
				if (ifaces[i].getName().equals(ChannelControl.class.getName())) {
					int scale = 255 / 9;
					tvPnl.setBackground(new Color(255, ((ChannelControl)theTV).getCurrentChannel() * scale, 255));
					break;
				}
				tvPnl.setBackground(Color.WHITE);
			}
		} else
			tvPnl.setBackground(Color.BLACK);

		pack();
	}

	public void addRemoteListener(ActionListener lstnr) {
		for (int i = 0; i < remotePnl.getComponentCount(); i++) {
			((JButton) remotePnl.getComponent(i)).addActionListener(lstnr);
		}
	}

}
