package wsp;

import java.util.Vector;

import database.Database;
import enums.*;
import utils.*;
import java.io.*;
public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        Database database = Database.getInstance();
		Student s = new Student("bac", "a", null, null, null);
        Teacher t = new Teacher("bacc", "aa", null, null, TeacherTitle.LECTOR, Faculty.SITE);
        Vector<Teacher>  teacher = new Vector<>();
        teacher.add(t);
        Course c = new Course(5, teacher, "ALgo", TypeCourse.REQUIRED, Faculty.SITE);
        Course c2 = new Course(5, teacher, "OOP", TypeCourse.REQUIRED, Faculty.SITE);
        database.getInstance().addCourse(c);
        database.getInstance().addCourse(c2);
		System.out.println(s);
		Database.getInstance().addStudent(s);
		Database.getInstance().addUser(s);
		Database.getInstance().login();
	}

}
