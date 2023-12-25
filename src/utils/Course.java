package utils;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

import database.Database;
import enums.*;
import wsp.*;

public class Course implements Serializable {
	private int id;
	private int credits;
	private Vector<Teacher> teachers = new Vector<Teacher>();
	private String name;
	private TypeCourse type;
	private Faculty faculty;


	public Course(int credits, String name, TypeCourse type, Faculty faculty) {
		if(Database.getInstance().getCourses().isEmpty()) {
			this.id = 1;
		}
		else {
			int nextid = Database.getInstance().getCourses().lastElement().id;
			this.id = ++nextid;
		}
		this.credits = credits;
		this.name = name;
		this.type = type;
		this.faculty = faculty;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return credits == other.credits && faculty == other.faculty && Objects.equals(name, other.name)
				&& type == other.type;
	}


	public String getName() {
		return name;
	}

	public Vector<Teacher> getTeachers() {
		return teachers;
	}
	
	public void addTeacher(Teacher t) {
		this.teachers.add(t);
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", credits=" + credits + ", name=" + name + ", type="
				+ type + ", faculty=" + faculty + "]";
	}
	
	
}
