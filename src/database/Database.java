package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import wsp.*;
import utils.*;

public class Database {
	
	private Vector<User> users = new Vector<User>();
	
	private Vector<Student> students = new Vector<Student>();
//	private Vector<Employee> Employees;
	private static Vector<Course> courses = new Vector<Course>();
	private Vector<News> news = new Vector<News>();
	private Vector<Request> requests = new Vector<Request>();
	private Vector<Order> orders = new Vector<Order>();
//	private Vector<Log> logs;
	private Vector<Researcher> researchers = new Vector<Researcher>();
	
	public static Vector<Course> getCourses() {
		return courses;
	}

	public void login() {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		User authentificatedUser = null;
		
		authentification:
		while(true) {
			try {
				System.out.println("Введите имя пользоваля: ");
				String username = reader.readLine();
				
				System.out.println("Введите пароль: ");
				String password = reader.readLine();
				System.out.println(username + " " + password);
				
				for(User u : this.users) {
					if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
						authentificatedUser = u;
						break authentification;
					}	
				}
				
				System.out.println("Логин или пароль неверные!");
				
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		authentificatedUser.authentification();
		
	}

	public void addUser(User u) {
		this.users.add(u);
	}

}
