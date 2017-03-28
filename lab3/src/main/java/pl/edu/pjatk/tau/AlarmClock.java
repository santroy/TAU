package pl.edu.pjatk.tau;

import java.util.ArrayList;
import java.util.List;

public class AlarmClock implements IAlarmClock {
	
	private List<Time> alarmTiggers;
	private Time currentTime;
	private Time lastAlert;
	private ITime time = currentTime;
	
	public AlarmClock() {
		alarmTiggers = new ArrayList<Time>();
		lastAlert = new Time(0,0); 
	}

	@Override
	public boolean shouldRing() {
		
		time.getTime();
		
		for(Time t : this.alarmTiggers) {		
			if(currentTime.equals(t) && !lastAlert.equals(t)) {
				lastAlert = t;
				return true;		
			} 		
		}
		return false;
	}
	
	public Time getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Time currentTime) {
		this.currentTime = currentTime;
	}

	@Override
	public void addAlarmTime(Time time) {
		this.alarmTiggers.add(time);
	}

	@Override
	public void clearAlarmTime(Time time) {
		this.alarmTiggers.remove(time);
	}

}
