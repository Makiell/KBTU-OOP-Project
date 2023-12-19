package wsp;

import java.io.Serializable;
import java.util.*;
import wsp.*;
import database.*;
import enums.*;
import utils.*;

public class Employee extends User implements Serializable {

    public Employee(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
        // TODO Auto-generated constructor stub
    }

    public void sendMessage(String message, User user) {
        System.out.println("Sending message to " + user.getUsername() + ": " + message);
    }

    public void sendRequest(Request request) {

        Database.getInstance().addRequest(request);
        Dean dean = request.getTo();

        System.out.println("Response from the dean: " + dean.getUsername());
        dean.addRequest(request);
        System.out.println("Request sent successfully");

    }

    public void sendOrder(Order order) {
        Database.getInstance().addOrder(order);

        TechSupportSpecialist specialist = order.getTo();
        specialist.addOrder(order);
        Database.getInstance().addOrder(order);
        System.out.println("Order sent successfully to " + specialist.getUsername());
    }

	@Override
	public void viewNews() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewMenu() {
		// TODO Auto-generated method stub
		
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
