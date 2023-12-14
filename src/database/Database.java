package database;

import java.io.*;
import java.util.Vector;

import wsp.*;
import utils.*;

public class Database implements Serializable {
	
	private static Database INSTANCE;
	
//	private static final long serialVersionUID = 1454407583937359068L;
	
	private Vector<User> users = new Vector<User>();
	
	private Vector<Student> students = new Vector<Student>();
	private Vector<Employee> employees = new Vector<Employee>();
	private Vector<Course> courses = new Vector<Course>();
	private Vector<News> news = new Vector<News>();
	private Vector<Request> requests = new Vector<Request>();
	private Vector<Order> orders = new Vector<Order>();
//	private Vector<Log> logs;
	private Vector<Researcher> researchers = new Vector<Researcher>();
	private Vector<Organisation> organisations = new Vector<Organisation>();;
	
	
	static{
		if(new File("database.ser").exists()) {
			try {
				INSTANCE = loadDatabase();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			INSTANCE = new Database();
		}
	}
	
	
	private Database() {
	}
	
	public static Database getInstance() {
		return INSTANCE;
	}
	
	private static Database loadDatabase() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("database.ser"));
		return (Database) ois.readObject();
	}
	
	public void saveDatabase() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("database.ser"));
		oos.writeObject(INSTANCE);
		oos.close();
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
				System.out.print(4);
				e.printStackTrace();
			}
			
		}
		
		authentificatedUser.authentification();
		
	}

	public Vector<User> getUsers() {
		return users;
	}

	public Vector<Student> getStudents() {
		return students;
	}

	public Vector<Employee> getEmployees() {
		return employees;
	}

	public Vector<Course> getCourses() {
		return courses;
	}

	public Vector<News> getNews() {
		return news;
	}

	public Vector<Request> getRequests() {
		return requests;
	}

	public Vector<Order> getOrders() {
		return orders;
	}

	public Vector<Researcher> getResearchers() {
		return researchers;
	}

	public Vector<Organisation> getOrganisations() {
		return organisations;
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
	
	public void addOrganisation(Organisation or) {
		this.organisations.add(or);
	}


    public Vector<Organisation> getOrganisations() {
        return organisations;
    }
}
