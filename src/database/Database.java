package database;

import java.io.*;
import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collectors;

import wsp.*;
import utils.*;

public class Database implements Serializable {

    private static Database INSTANCE;
//    private static final long serialVersionUID = 5909273364633485948L;

    private static final long serialVersionUID = 4496003716159423929L;

    private Vector<Admin> admins = new Vector<Admin>();

    private Vector<User> users = new Vector<User>();

    private Vector<Student> students = new Vector<Student>();
    private Vector<Employee> employees = new Vector<Employee>();
    private Vector<Course> courses = new Vector<Course>();
    private Vector<News> news = new Vector<News>();
    private Vector<Request> requests = new Vector<Request>();
    private Vector<Order> orders = new Vector<Order>();
    private HashMap<User, Vector<Log>> userLogs = new HashMap<User, Vector<Log>>();
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
            INSTANCE.initializeDefaultAdmin();
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

    private void initializeDefaultAdmin() {
        Admin defaultAdmin = new Admin("admin", "admin", "AdminName", "AdminSurname");
        addAdmin(defaultAdmin);
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
//				System.out.println(username + " " + password);

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

    public Vector<Teacher> getTeachers(){
        Vector<Teacher> teachers = employees.stream()
                .filter(employee -> employee instanceof Teacher)
                .map(employee -> (Teacher) employee)
                .collect(Collectors.toCollection(Vector::new));

        return teachers;
    }

    public Vector<Dean> getDeans() {
        Vector<Dean> deans = employees.stream()
                .filter(employee -> employee instanceof Dean)
                .map(employee -> (Dean) employee)
                .collect(Collectors.toCollection(Vector::new));

        return deans;
    }

    public Vector<TechSupportSpecialist> getTechSupports() {
        Vector<TechSupportSpecialist> TechSupportSpecialists = employees.stream()
                .filter(employee -> employee instanceof TechSupportSpecialist)
                .map(employee -> (TechSupportSpecialist) employee)
                .collect(Collectors.toCollection(Vector::new));

        return TechSupportSpecialists;
    }

    public Vector<Organisation> getOrganisations() {
        return organisations;
    }

    public Vector<Admin> getAdmins(){
        return admins;
    }

    public void addUser(User u) {
        this.users.add(u);
    }

    public void addStudent(Student s) {
        this.students.add(s);
        addUser(s);
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

    public void addAdmin(Admin a) {
        this.admins.add(a);
        addUser(a);
    }
    public void addLog(User u, Log l) {
    	Vector<Log> logs;
    	if (this.userLogs.get(u) == null) {
            logs = new Vector<>();
        }
    	else {
    		logs = this.userLogs.get(u);
    	}
         
        logs.add(l);
        this.userLogs.put(u, logs);
    }
    
    public Vector<Log> seeLogs(User u){
    	return userLogs.get(u);
    }
    
    public Researcher isResearcher(User u) {
		for(Researcher r : researchers) {
			if(r.getUser() == u) {
				return r;
			}
		}
		return null;
	}
}
