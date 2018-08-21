package behavioral.strategy;

public interface VolumeControl {

	public int getVolume();

	public int volumeUp();

	public int volumeDown();

	public void mute();
}
