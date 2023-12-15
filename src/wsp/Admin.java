package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import database.Database;
import utils.StaticMethods;
import enums.*;


public class Admin extends User implements Serializable {

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

        String firstName = getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = getValidInput("Enter last name:", "[a-zA-Z]+");
        
        System.out.println("Choose faculty:");
        
        Faculty[] options = Faculty.values();
        
        StaticMethods.printList(List.of(options));
        
        int facultyChoice = StaticMethods.validate(options.length);
        
        Faculty faculty = options[facultyChoice-1];
        
        Student newStudent = new Student(username, password, firstName, lastName, faculty);
		
        Database.getInstance().addStudent(newStudent);
        
        System.out.println("Student added " + newStudent);
        
	}
	
	
	private String getValidInput(String promt, String regex) {
		Scanner in = new Scanner(System.in);
		System.out.println(promt);
		
		while(!in.hasNext(regex)) {
			System.out.print("Invalid input. Please enter a valid name (only letters:");
			in.next();
		}
		
		return in.next();
	}
	
	
	public void createUser() {
		System.out.println("Which user do you want to create?");
		String[] options = new String[] {
				"Student", "Graduate Student", "Researcher", "Employee", "Teacher", "Manager", "Tech Support Specialist", "Dean", 
		};
		
		StaticMethods.printList(List.of(options));
		int choice = StaticMethods.validate(options.length);
		
		if(choice == 1) {
			addStudent();
		}
		
	}


	@Override
	public void viewNews() {
	}

	@Override
	public void viewMenu() {
		
		String[] options = new String[] {
				"Create new user", "Update info of user", "Remove user", "See log files", "Exit"
		};
		
		while(true) {
			System.out.println("----Admin Menu----");
			StaticMethods.printList(List.of(options));
			int choice = StaticMethods.validate(options.length);
			
			if(choice == 1) {
				createUser();
			}
			
			else if(choice == 5) {
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

}
