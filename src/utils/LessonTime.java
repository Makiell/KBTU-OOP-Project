package utils;

import enums.Day;

public class LessonTime {
	private Day dayOfTheWeek;
	private int startTime;
	private int endTime;
	
	
	public LessonTime(Day dayOfTheWeek, int time) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.startTime = time;
		this.endTime = time + 1;
	}
	
	public String toString() {
		return this.dayOfTheWeek + " " + startTime + ":00 - " + endTime + ":00";
	}
	
}
