package utils;


import java.util.*;
import java.io.Serializable;

import enums.*;

public class Lesson implements Serializable {
	private TypeLesson type;
	private LessonTime dateOfLesson;
	private int room;

	
	
	public Lesson(TypeLesson type, LessonTime dateOfLesson, int room) {
		this.type = type;
		this.dateOfLesson = dateOfLesson;
		this.room = room;

	}



	@Override
	public String toString() {
		return "Lesson [type=" + type + ", time=" + dateOfLesson + ", room=" + room + "]";
	}
}
