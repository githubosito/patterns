package behavioral.strategy;

import java.util.List;

public class TwoWayMenu implements TwoWayMenuControl {

	protected boolean isActive;

	protected List<TwoWayMenu> items;

	@Override
	public void openMenu() {
		isActive = true;

	}

	@Override
	public void exitMenu() {
		isActive = false;
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub

	}

	@Override
	public void up() {
		// TODO Auto-generated method stub

	}

	@Override
	public void down() {
		// TODO Auto-generated method stub

	}

	@Override
	public void back() {
		// TODO Auto-generated method stub

	}

}
