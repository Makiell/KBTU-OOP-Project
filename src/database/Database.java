package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import wsp.*;
import utils.*;

public final class Database {
	
	private static final Database INSTANCE = new Database();
	
	private Vector<User> users = new Vector<User>();
	
	private Vector<Student> students = new Vector<Student>();
//	private Vector<Employee> Employees;
	private Vector<Course> courses = new Vector<Course>();
	private Vector<News> news = new Vector<News>();
	private Vector<Request> requests = new Vector<Request>();
	private Vector<Order> orders = new Vector<Order>();
//	private Vector<Log> logs;
	private Vector<Researcher> researchers = new Vector<Researcher>();
	private Vector<Organisation> organisations = new Vector<Organisation>();
	
	private Database() {}
	
	public static Database getInstance() {
		return INSTANCE;
	}
	
	public Vector<Course> getCourses() {
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
	
	public void addStudent(Student s) {
		this.students.add(s);
	}
	
	public void addCourse(Course c) {
		this.courses.add(c);
	}
	
	public void addNews(News n) {
		this.news.add(n);
	}
	
	public void addRequest(Request r) {
		this.requests.add(r);
	}
	
	public void addOrder(Order o) {
		this.orders.add(o);
	}
	
	
	
	public void addResearcher(Researcher r) {
		this.researchers.add(r);
	}
	
	public void addOrganisations(Organisation or) {
		this.organisations.add(or);
	}
	
	

}
