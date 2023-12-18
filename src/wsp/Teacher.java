package wsp;

import java.io.Serializable;
import java.util.*;

import database.Database;
import utils.*;
import wsp.*;
import enums.*;

public class Teacher extends Employee implements Serializable {

    TeacherTitle typeTeacher;
    Vector <Course> courses = new Vector<Course>();
    Faculty faculty;
    Map<Course, Vector<Lesson>> lessons = new HashMap <Course, Vector<Lesson>>();
    double rate = 0.0;

    public Teacher(String username, String password, String firstName, String lastName, TeacherTitle typeTeacher,
                   Faculty faculty) {
        super(username, password, firstName, lastName);
        this.typeTeacher = typeTeacher;
        this.faculty = faculty;

    }


    public TeacherTitle getTypeTeacher() {
        return typeTeacher;
    }

    public Vector<Course> getCourses() {
        return courses;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Map<Course, Vector<Lesson>> getLessons() {
        return lessons;
    }

    public double getRate() {
        return rate;
    }

    public void setTypeTeacher(TeacherTitle typeTeacher) {
        this.typeTeacher = typeTeacher;
    }

    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setLessons(Map<Course, Vector<Lesson>> lessons) {
        this.lessons = lessons;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void viewCourses() {
        System.out.println("Courses taught by " + getUsername() + ":");
        for (Course course : courses) {
            System.out.println("- " + course.getName());
        }
    }

    public void viewStudents(Course course) {
        Vector<Student> students = Database.getInstance().getStudents();
        System.out.println("Students enrolled in " + course.getName() + ":");
        for (Student student : students) {
            if (student.getCourses().contains(course)) {
                System.out.println("- " + student.getUsername());
            }
        }

    }

    public void viewMarks(Course course) {
    }

    public void putMarks(Course course, Student student, Mark mark) {

    }

    public void viewRate() {
        System.out.println("Teacher's rating: " + rate);
    }


	@Override
	public String toString() {
		return "Teacher [typeTeacher=" + typeTeacher + ", faculty=" + this.faculty + "] " + super.toString();
	}

    
    

}
