package utils;

import enums.Day;

public class LessonTime {
	private Day dayOfTheWeek;
	private int time;
	
	
	public LessonTime(Day dayOfTheWeek, int time) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.time = time;
	}
	
	public String toString() {
		return this.dayOfTheWeek + " " + time + ":00 - " + time+1 + ":00";
	}
	
}
