package wsp;

import database.Log;
import utils.Order;
import utils.StaticMethods;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import enums.Status;
import database.Database;

public class TechSupportSpecialist extends Employee implements Serializable {
	
	private Vector<Order> orders;

    public TechSupportSpecialist(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }
    
    public Vector<Order> getOrders(){
    	return orders;
    }
    
    public void viewOrders() {
    	StaticMethods.printList(this.getOrders());
        Database.getInstance().addLog(this, new Log("Tech Support Specialist " + this.getUsername() + " viewed all orders "));
    }
    
    public void acceptOrder() {
    	this.viewOrders();
    	int choice = StaticMethods.validate(getOrders().size());
    	Order o = getOrders().get(choice);
    	if(o.getStatus() == Status.REJECTED)
    		System.out.println("ERROR! Order was already rejected!");
    	else if(o.getStatus() == Status.ACCEPTED)
    		System.out.println("ERROR! Order was already accepted");
    	else
    		o.setStatus(Status.ACCEPTED);
			System.out.println("Order has been accepted!");
            Database.getInstance().addLog(this, new Log("Tech Support Specialist " + this.getUsername() + " accepted order "));
    }
    
    public void rejectOrder() {
    	this.viewOrders();
    	int choice = StaticMethods.validate(getOrders().size());
    	Order o = getOrders().get(choice);
    	if(o.getStatus() == Status.REJECTED)
    		System.out.println("ERROR! Order was already rejected!");
    	else if(o.getStatus() == Status.ACCEPTED)
    		System.out.println("ERROR! Order was already accepted");
    	else
    		o.setStatus(Status.REJECTED);
			System.out.println("Order has been rejected!");
        Database.getInstance().addLog(this, new Log("Tech Support Specialist " + this.getUsername() + " rejected the order"));
    }
    
    public void viewMenu() {
    	
    	String[] options;
    	
    	Researcher researcher = Database.getInstance().isResearcher(this);
    	
    	if(researcher == null) {
    		options = new String[] {"View orders",
    				"Accept order", "Reject order", "Exit" };
    	}
    	else {
    		options = new String[] {"View orders",
    				"Accept order", "Reject order", "Exit", "View researcher menu"};
    	}
    	
    	
    	while(true) {
    		 
    		System.out.println("----Tech support specialist menu----");
    		
    		StaticMethods.printList(List.of(options));
    		
    		System.out.println("Enter your choice: ");
    		int choice = StaticMethods.validate(1, options.length);
    		
    		if(choice == 1) {
    			this.viewOrders();
    			orders.stream().forEach(o -> o.setStatus(Status.VIEWED));
    		}
    		
    		else if(choice == 2) {
    			this.acceptOrder();
    		}
    		
    		else if(choice == 3) {
    			this.rejectOrder();
    		}
    		
    		else if(choice == 4) {
    			try {
					Database.getInstance().saveDatabase();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			break;
    		}
    		else if(researcher != null) {
				if(choice == 5) {
					researcher.viewMenu();
                    Database.getInstance().addLog(this, new Log("Tech Support Specialist " + this.getUsername() + " went to the researcher menu"));
				}
			}
    	}
    }
    
    public String toString() {
    	return "Tech Support Specialist " + super.toString();
    }
}
