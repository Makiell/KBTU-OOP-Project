package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import database.*;
import utils.*;
import enums.*;


public class Admin extends User implements Serializable {
	
	private static final long serialVersionUID = 6257279098772643532L;


	public Admin(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public void addResearcher() {
		String[] options = new String[] {
				"Add researcher to existing user", "Create researcher from new user"
		};
		
		StaticMethods.printList(List.of(options));
		
		System.out.println("What do you want to do?");
		int choice = StaticMethods.validate(1, 2);
		
		if(choice == 1) {
			StaticMethods.printList(Database.getInstance().getUsers());
			System.out.println("Choose user:");
			
			int userChoice = StaticMethods.validate(1, Database.getInstance().getUsers().size());
			
			Researcher r = new Researcher(Database.getInstance().getUsers().get(userChoice-1));
			
			Database.getInstance().addResearcher(r);
		}
		else if(choice == 2) {
			
			System.out.println("Which user do you want to create?");
			
			String[] optionsToCreate = new String[] {
					"Student", "Graduate Student", "Employee", "Teacher", "Manager", "Tech Support Specialist", "Dean", 
			};
			
			StaticMethods.printList(List.of(optionsToCreate));
			int choiceUser = StaticMethods.validate(1, optionsToCreate.length);
			
			if(choice>=1 && choice<=2) {
				StudentFactory studentFactory = new StudentFactory();
				Student newStudent = studentFactory.getStudent(choiceUser);
				Researcher r = new Researcher(newStudent);
				Database.getInstance().addResearcher(r);
			}
			else if(choice>=3) {
				EmployeeFactory employeeFactory = new EmployeeFactory();
				Employee newEmployee = employeeFactory.getEmployee(choice);
				Researcher r = new Researcher(newEmployee);
				Database.getInstance().addResearcher(r);
			}
		}
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
		else if(choice>=1 && choice<=2) {
			StudentFactory studentFactory = new StudentFactory();
			studentFactory.getStudent(choice);
		}
		else if(choice == 3) {
			addResearcher();
		}
		else if(choice >= 4) {
			EmployeeFactory employeeFactory = new EmployeeFactory();
			employeeFactory.getEmployee(choice);
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
	
	public void seeLogFiles() {
		System.out.println("Enter 0 to return back");
		System.out.println("Choose user to see logs:");
		
		Vector<User> users = Database.getInstance().getUsers();
		
		StaticMethods.printList(users);
		
		int choice = StaticMethods.validate(users.size());
		
		if(choice==0) {
			return;
		}
		
		User u = users.get(choice-1);
		
		Vector<Log> logs = Database.getInstance().seeLogs(u);
				
		if(logs==null) {
			System.out.println("No logs for this user.");
			return;
		}
		
		StaticMethods.printList(logs);
	}

	@Override
	public void viewMenu() {
		
		String[] options = new String[] {
				"Create new user", "See all users", "Update info of user", "Remove user", "See log files","View one news", "Exit"
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
			else if (choice == 5) {
				seeLogFiles();
			}
			else if (choice == 6) {
				viewOneNews();
			}
			else if(choice == 7) {
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
