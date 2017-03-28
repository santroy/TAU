package pl.edu.pjatk.tau;

public class Time implements ITime {
	
	private int hours;
	private int minutes;

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	public Time(int hours, int minutes) {
		setHours(hours);
		setMinutes(minutes);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hours != other.hours)
			return false;
		if (minutes != other.minutes)
			return false;
		return true;
	}

	@Override
	public Time getTime() {
		return this;
	}

}
