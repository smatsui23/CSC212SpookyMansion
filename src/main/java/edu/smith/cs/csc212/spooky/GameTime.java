package edu.smith.cs.csc212.spooky;

public class GameTime {
	
	//store hours 
	private int hour; 
	
	//store how many days have you spent in Ford Hall 
	private int days;
	
	//default constructor 
	public GameTime() {
		this.hour = 0;
	}
	
	
	public void increaseHour() {
		this.hour += 1;
	}
	
	public void time() {
		int instanceHour = this.hour;
		if (instanceHour >= 24) {
			this.days += 1;
			instanceHour %= 24;
		}
		System.out.println("Time is" + this.hour + ":00");
	}
	
	public int getHour() {
		if (this.hour >= 24) {
			int modHours = this.hour;
			modHours %= 24;
			return modHours;
		}else {
			return this.hour;
			
		}
	}
	
	public boolean isNightTime() {
		if(this.getHour() >= 17) {
			return true;
		} else {
			return false;
		}
	}
	

}	


	