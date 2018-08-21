package behavioral.strategy;

public class VolumeController implements VolumeControl {
	private int minVolume = 0;
	private int maxVolume;
	private int volume;

	public VolumeController(int maxVolume) {
		if(maxVolume <=1)
			throw new RuntimeException("You must choose a number above 1.");
		
		this.maxVolume = maxVolume;
		volume = 0;
	}

	@Override
	public int getVolume() {
		return volume;
	}

	@Override
	public int volumeUp() {
		if (volume < maxVolume)
			volume++;
		return volume;
	}

	@Override
	public int volumeDown() {
		if (volume > minVolume)
			volume--;
		return volume;
	}

	@Override
	public void mute() {
		volume = minVolume;

	}

}
