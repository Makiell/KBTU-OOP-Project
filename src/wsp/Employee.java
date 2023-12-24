package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import wsp.*;
import database.*;
import enums.*;
import utils.*;

public class Employee extends User implements Serializable {
	
	private static final long serialVersionUID = 3585353902952762348L;

    public Employee(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
        // TODO Auto-generated constructor stub
    }

    public void sendMessage(String message, User user) {
        System.out.println("Sending message to " + user.getUsername() + ": " + message);
    }

    public void sendRequest() {
    	
    	Vector<Dean> deans = Database.getInstance().getDeans();
    	
    	if(deans.isEmpty()) {
    		System.out.println("No deans");
    		return;
    	}
    	
    	System.out.println("Enter 0 to return back.");
    	System.out.println("Choose the dean:");
    	
    	StaticMethods.printList(deans);
    	
    	int choice = StaticMethods.validate(deans.size());
    	
    	if(choice==0) {
    		return;
    	}
    	
    	Dean dean = deans.get(choice-1);
    	
    	System.out.println("Enter the emergency level:");
    	
    	Emergency[] emergencyList = Emergency.values();
    	
    	StaticMethods.printList(List.of(emergencyList));
    	
    	int emergencyChoice = StaticMethods.validate(1, emergencyList.length);
    	
    	Emergency emergency = emergencyList[emergencyChoice-1];
    	
    	System.out.println("Enter the message:");
    	Scanner in = new Scanner(System.in);
    	String message = in.nextLine();
    	
    	Request newRequest = new Request(emergency, message, dean);
    	
        Database.getInstance().addRequest(newRequest);
        
        System.out.println(newRequest + " sent successfully");

    }

    public void sendOrder() {
    	Vector<TechSupportSpecialist> TechSupportSpecialists = Database.getInstance().getTechSupports();
    	
    	if(TechSupportSpecialists.isEmpty()) {
    		System.out.println("No tech supports");
    		return;
    	}
    	
    	System.out.println("Enter 0 to return back.");
    	System.out.println("Choose the tech support:");
    	
    	StaticMethods.printList(TechSupportSpecialists);
    	
    	int choice = StaticMethods.validate(TechSupportSpecialists.size());
    	
    	if(choice==0) {
    		return;
    	}
    	
    	TechSupportSpecialist techSupport = TechSupportSpecialists.get(choice-1);
    	
    	System.out.println("Enter the message:");
    	Scanner in = new Scanner(System.in);
    	String message = in.nextLine();
    	
    	Order newOrder = new Order(message, techSupport);
    	
        Database.getInstance().addOrder(newOrder);
        System.out.println(newOrder + " sent successfully");
    }

	@Override
	public void viewMenu() {
		String[] options;
    	
    	Researcher researcher = Database.getInstance().isResearcher(this);
    	
    	if(researcher == null) {
    		 options = new String[]{"Send request", "Send order", "View one News", "Exit"};
    	}
    	else {
    		 options = new String[]{"Send request", "Send order", "View one News", "Exit", "View researcher menu"};
    	}
       

        while (true) {
            System.out.println();
            System.out.println("----Employee Menu----");
            StaticMethods.printList(List.of(options));

            int choice = StaticMethods.validate(1, options.length);
            
            if(choice == 1) {
            	sendRequest();
            }
            if (choice == 2) {
                sendOrder();
            } 
            else if (choice == 3) {
            	viewOneNews();
            }
            else if (choice == 4) {
                try {
                    Database.getInstance().saveDatabase();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            else if(researcher != null) {
				if(choice == 5) {
					researcher.viewMenu();
				}
			}
        }
		
	}

	
	public String toString() {
		return "Employee " + super.toString();
	}

	public void changeInfo() {
    	System.out.println("What do you want to change?");
		
		String[] options = new String[] {
				"Username", "Password", "First name", "Last name"
		};
		
		StaticMethods.printList(List.of(options));
		System.out.println("Enter 0 to return back");
		int choice = StaticMethods.validate(options.length);
		Scanner in = new Scanner(System.in);
		
		if(choice == 0) {
			return;
		}
		else if(choice == 1) {
			System.out.println("Enter new username");
			String newUsername = in.nextLine();
			this.setUsername(newUsername);
		}
		else if(choice == 2) {
			System.out.println("Enter new password");
			String newPassword = in.nextLine();
			this.setPassword(newPassword);
		}
		else if(choice == 3) {
			String firstName = StaticMethods.getValidInput("Enter new first name:", "[a-zA-Z]+");
			this.setFirstName(firstName);
		}
		else if(choice == 4) {
			String lastName = StaticMethods.getValidInput("Enter new last name:", "[a-zA-Z]+");
			this.setLastName(lastName);
		}
    }
}
