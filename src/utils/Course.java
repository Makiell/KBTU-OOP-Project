package utils;

import java.util.Vector;

import enums.*;
import wsp.*;

public class Course {
	private int id;
	private int credits;
	private Vector<Teacher> teachers;
	private String name;
	private TypeCourse type;
	private Faculty faculty;


	public Course(int id, int credits, Vector<Teacher> teachers, String name, TypeCourse type, Faculty faculty) {
		this.id = id;
		this.credits = credits;
		this.teachers = teachers;
		this.name = name;
		this.type = type;
		this.faculty = faculty;
	}
	
	
	public String getName() {
		return name;
	}

	public Vector<Teacher> getTeachers() {
		return teachers;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", credits=" + credits + ", teachers=" + teachers + ", name=" + name + ", type="
				+ type + ", faculty=" + faculty + "]";
	}
	
	
}
