package pl.edu.pjatk.tau;

public interface IAlarmClock {

	public boolean shouldRing();
	public void addAlarmTime(Time time);
	public void clearAlarmTime(Time time);
	
}
