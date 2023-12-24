package wsp;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import database.Database;
import enums.Faculty;
import enums.TeacherTitle;
import enums.TypeManager;
import utils.StaticMethods;

public class EmployeeFactory {
	
	public Employee getEmployee(int choice) {
		
		if(choice == 4) {
			return addEmployee();
		}
		if(choice == 5) {
			return addTeacher();
		}
		if(choice == 6) {
			return addManager();
		}
		if(choice == 7) {
			return addTechSupport();
		}
		if(choice == 8) {
			return addDean();
		}
		return null;
	}
	
	public Employee addEmployee() {
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
        
        return newEmployee;
        
	}
	
	public Employee addTeacher() {
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
        
        int facultyChoice = StaticMethods.validate(1, options.length);
        
        Faculty faculty = options[facultyChoice-1];
        
        TeacherTitle[] optionsTitle = TeacherTitle.values();
        
        StaticMethods.printList(List.of(optionsTitle));
        
        int titleChoice = StaticMethods.validate(1, optionsTitle.length);
        
        TeacherTitle title = optionsTitle[titleChoice-1];
        
        Teacher newTeacher = new Teacher(username, password, firstName, lastName, title, faculty);
		
        Database.getInstance().addEmployee(newTeacher);
        
        System.out.println("Teacher added " + newTeacher);
        
        return newTeacher;
	}
	
	public Employee addManager() {
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
        
        TypeManager title = options[choice-1];
        
        Manager newManager = new Manager(username, password, firstName, lastName, title);
		
        Database.getInstance().addEmployee(newManager);
        
        System.out.println("Manager added " + newManager);
        
        return newManager;
	}
	
	public Employee addTechSupport() {
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
        
        return newTechSupport;
	}
	
	public Employee addDean() {
		Scanner in = new Scanner(System.in);
		
		Faculty[] options = Faculty.values();
        
        StaticMethods.printList(List.of(options));
        
        int facultyChoice = StaticMethods.validate(options.length);
        
        Faculty faculty = options[facultyChoice-1];
        
        Vector<Employee> employees = Database.getInstance().getEmployees();
        boolean deanExists = employees.stream()
        		.filter(employee -> employee instanceof Dean)
        		.map(employee -> (Dean) employee)
        		.anyMatch(dean -> dean.getFaculty() == faculty);
        
        if(deanExists) {
        	System.out.println("Dean of the " + faculty + " already exists!");
        	return null;
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
        
        return newDean;
	}
}
