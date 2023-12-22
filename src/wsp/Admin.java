package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import database.Database;
import utils.StaticMethods;
import enums.*;


public class Admin extends User implements Serializable {
	
	private static final long serialVersionUID = 6257279098772643532L;


	public Admin(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public void addStudent() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        System.out.println("Choose faculty:");
        
        Faculty[] options = Faculty.values();
        
        StaticMethods.printList(List.of(options));
        
        int facultyChoice = StaticMethods.validate(options.length);
        
        if(facultyChoice == 0) {
        	return;
        }
        
        Faculty faculty = options[facultyChoice-1];
        
        Student newStudent = new Student(username, password, firstName, lastName, faculty);
		
        Database.getInstance().addStudent(newStudent);
        
        System.out.println("Student added " + newStudent);
        
	}
	
	public void addGraduateStudent() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        System.out.println("Choose faculty:");
        
        Faculty[] options = Faculty.values();
        
        StaticMethods.printList(List.of(options));
        
        int facultyChoice = StaticMethods.validate(options.length);
        
        Faculty faculty = options[facultyChoice-1];
        
        if(facultyChoice == 0) {
        	return;
        }
        
        Grade[] optionsGrade = Grade.values();
        
        StaticMethods.printList(List.of(optionsGrade));
        
        int gradeChoice = StaticMethods.validate(optionsGrade.length);
        
        if(facultyChoice == 0) {
        	return;
        }
        
        Grade grade = optionsGrade[gradeChoice-1];
        
        Student newGraduateStudent = new GraduateStudent(username, password, firstName, lastName, faculty, grade);
		
        Database.getInstance().addStudent(newGraduateStudent);
        
        System.out.println("Student added " + newGraduateStudent);
        
	}
	
	public void addEmployee() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        Employee newEmployee = new Employee(username, password, firstName, lastName);
		
        Database.getInstance().addEmployee(newEmployee);
        
        System.out.println("Employee added " + newEmployee);
        
	}
	
	public void addTeacher() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        System.out.println("Choose faculty:");
        
        Faculty[] options = Faculty.values();
        
        StaticMethods.printList(List.of(options));
        
        int facultyChoice = StaticMethods.validate(options.length);
        
        if(facultyChoice == 0) {
        	return;
        }
        
        Faculty faculty = options[facultyChoice-1];
        
        TeacherTitle[] optionsTitle = TeacherTitle.values();
        
        StaticMethods.printList(List.of(optionsTitle));
        
        int titleChoice = StaticMethods.validate(optionsTitle.length);
        
        if(titleChoice == 0) {
        	return;
        }
        
        TeacherTitle title = optionsTitle[titleChoice-1];
        
        Teacher newTeacher = new Teacher(username, password, firstName, lastName, title, faculty);
		
        Database.getInstance().addEmployee(newTeacher);
        
        System.out.println("Teacher added " + newTeacher);
	}
	
	public void addManager() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        System.out.println("Choose type:");
        
        TypeManager[] options = TypeManager.values();
        
        StaticMethods.printList(List.of(options));
        
        int choice = StaticMethods.validate(options.length);
        
        if(choice == 0) {
        	return;
        }
        
        TypeManager title = options[choice-1];
        
        Manager newManager = new Manager(username, password, firstName, lastName, title);
		
        Database.getInstance().addEmployee(newManager);
        
        System.out.println("Manager added " + newManager);
	}
	
	
	public void addTechSupport() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        TechSupportSpecialist newTechSupport = new TechSupportSpecialist(username, password, firstName, lastName);
		
        Database.getInstance().addEmployee(newTechSupport);
        
        System.out.println("Tech Support added " + newTechSupport);
	}
	
	
	public void addDean() {
		Scanner in = new Scanner(System.in);
		
		Faculty[] options = Faculty.values();
        
        StaticMethods.printList(List.of(options));
        
        int facultyChoice = StaticMethods.validate(options.length);
        
        if(facultyChoice == 0) {
        	return;
        }
        
        Faculty faculty = options[facultyChoice-1];
        
        Vector<Employee> employees = Database.getInstance().getEmployees();
        boolean deanExists = employees.stream()
        		.filter(employee -> employee instanceof Dean)
        		.map(employee -> (Dean) employee)
        		.anyMatch(dean -> dean.getFaculty() == faculty);
        
        if(deanExists) {
        	System.out.println("Dean of the " + faculty + " already exists!");
        	return;
        }
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        Dean newDean = new Dean(username, password, firstName, lastName, faculty);
		
        Database.getInstance().addEmployee(newDean);
        
        System.out.println("Dean added " + newDean);
	}
	
	
	public void createUser() {
		System.out.println("Which user do you want to create?");
		String[] options = new String[] {
				"Student", "Graduate Student", "Researcher", "Employee", "Teacher", "Manager", "Tech Support Specialist", "Dean", 
		};
		
		StaticMethods.printList(List.of(options));
		System.out.println("Enter 0 to return back.");
		int choice = StaticMethods.validate(options.length);
		
		if(choice == 0) {
			return;
		}
		else if(choice == 1) {
			addStudent();
		}
		else if(choice == 2) {
			addGraduateStudent();
		}
		else if(choice == 4) {
			addEmployee();
		}
		else if(choice == 5) {
			addTeacher();
		}
		else if(choice == 6) {
			addManager();
		}
		else if(choice == 7) {
			addTechSupport();
		}
		else if(choice == 8) {
			addDean();
		}
	}
	
	private void seeAllUsers() {
		StaticMethods.printList(Database.getInstance().getUsers());
	}
	
	public void updateUser() {
		StaticMethods.printList(Database.getInstance().getUsers());
		System.out.println("Which user do you want to change? 0 for return back");
		
		int choice = StaticMethods.validate(Database.getInstance().getUsers().size());
		
		if(choice == 0) {
			return;
		}
		
		Database.getInstance().getUsers().elementAt(choice-1).changeInfo();
	}
	
	
	public void removeUser() {
		System.out.println("Choose user to delete:");
		
		StaticMethods.printList(Database.getInstance().getUsers());
		
		System.out.println("Enter 0 to return back");
		
		int choice = StaticMethods.validate(Database.getInstance().getUsers().size());
		
		if(choice == 0) {
			return;
		}
		
		System.out.println(Database.getInstance().getUsers().elementAt(choice-1) + " was deleted");
		
		Database.getInstance().getUsers().remove(choice-1);
		
		
	}

	@Override
	public void viewMenu() {
		
		String[] options = new String[] {
				"Create new user", "See all users", "Update info of user", "Remove user", "See log files", "Exit"
		};
		
		while(true) {
			System.out.println();
			System.out.println("----Admin Menu----");
			StaticMethods.printList(List.of(options));
			int choice = StaticMethods.validate(options.length);
			
			if(choice == 1) {
				createUser();
			}
			
			else if(choice == 2) {
				seeAllUsers();
			}
			
			else if(choice == 3) {
				updateUser();
			}
			
			else if(choice == 4) {
				removeUser();
			}
			
			else if(choice == 6) {
				try {
					Database.getInstance().saveDatabase();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		
		}
		
	}

	
	public String toString() {
		return "Admin " + super.toString();
	}



	@Override
	public void changeInfo() {
	}
	

}
