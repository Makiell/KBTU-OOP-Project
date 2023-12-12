package wsp;

import java.util.Vector;

import database.Database;
import utils.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Database d = new Database();
		Student s = new Student("bac", "a", null, null, null);
		System.out.println(s);
		d.addUser(s);
		d.login();
	}

}
