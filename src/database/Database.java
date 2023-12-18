package database;

import java.io.*;
import java.util.Vector;

import wsp.*;
import utils.*;

public class Database implements Serializable {
	
	private static final Database INSTANCE = loadDatabase();
	
//	private static final long serialVersionUID = 1454407583937359068L;
	
	private Vector<User> users;
	
	private Vector<Student> students;
	private Vector<Employee> employees;
	private Vector<Course> courses;
	private Vector<News> news;
	private Vector<Request> requests;
	private Vector<Order> orders;
//	private Vector<Log> logs;
	private Vector<Researcher> researchers;
	private Vector<Organisation> organisations;
	
	
	private Database() {
		this.users = new Vector<User>();
		this.students = new Vector<Student>();
		this.employees = new Vector<Employee>();
		this.courses = new Vector<Course>();
		this.news = new Vector<News>();
		this.requests = new Vector<Request>();
		this.orders = new Vector<Order>();
		this.researchers = new Vector<Researcher>();
		this.organisations = new Vector<Organisation>();
	}
	
	public static Database getInstance() {
		return INSTANCE;
	}
	
	private static Database loadDatabase() {
		Database db = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("database.ser"))){
			db = (Database) ois.readObject();
		}
		catch(FileNotFoundException e){
			db = new Database();
		}
		catch (IOException | ClassNotFoundException e) {
			System.out.println(2);
			e.printStackTrace();
		}
		return (db != null) ? db : new Database();
	}
	
	public void saveDatabase() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("database.ser"))){
			oos.writeObject(INSTANCE);
		}
		catch(IOException e) {
			System.out.println(3);
			e.printStackTrace();
		}
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
	
	public void addEmployee(Employee e) {
		this.employees.add(e);
		addUser(e);
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


    public void addAdmin(Admin s) {
    }
}
