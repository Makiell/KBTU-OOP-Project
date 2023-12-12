package utils;

import java.util.Date;
import enums.*;

public class Lesson {
	private TypeLesson type;
	private Date start;
	private Date end;
	private int room;
	
	
	public Lesson(TypeLesson type, Date start, Date end, int room) {
		this.type = type;
		this.start = start;
		this.end = end;
		this.room = room;
	}


	@Override
	public String toString() {
		return "Lesson [type=" + type + ", start=" + start + ", end=" + end + ", room=" + room + "]";
	}
}
