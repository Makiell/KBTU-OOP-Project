package wsp;

import java.util.Vector;

import database.Database;
import enums.*;
import utils.*;
import java.io.*;

public class Test {

	public static void main(String[] args) throws Exception {
//		 TODO Auto-generated method stub
//		Student s = new Student("bac", "a", null, null, null);
//        Teacher t = new Teacher("bacc", "aa", null, null, TeacherTitle.LECTOR, Faculty.SITE);
//        Vector<Teacher>  teacher = new Vector<>();
//        teacher.add(t);
//        Course c = new Course(5, 21, teacher, "Algo", TypeCourse.REQUIRED, Faculty.SITE);
//        Course c2 = new Course(5, 20, teacher, "OOP", TypeCourse.REQUIRED, Faculty.SITE);
//        Database.getInstance().addCourse(c);
//        Database.getInstance().addCourse(c2);
////		System.out.println(s);
//		Database.getInstance().addStudent(s);
//		Database.getInstance().addUser(s);
        Admin s = new Admin("bac", "a", null, null);
        Database.getInstance().addAdmin(s);
		Database.getInstance().addUser(s);
		Database.getInstance().login();
	}

}
