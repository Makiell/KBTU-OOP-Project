package wsp;

import utils.Order;
import utils.StaticMethods;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Vector;
import database.Database;
import enums.AcceptStatus;

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
    }
    
    public void acceptOrder() {
    	this.viewOrders();
    	int choice = StaticMethods.validate(getOrders().size());
    	Order o = getOrders().get(choice);
    	if(o.getAcceptStatus() == AcceptStatus.REJECTED)
    		System.out.println("ERROR! Order was already rejected!");
    	else if(o.getAcceptStatus() == AcceptStatus.ACCEPTED)
    		System.out.println("ERROR! Order was already accepted");
    	else
    		o.acceptStatus = AcceptStatus.ACCEPTED;
			System.out.println("Order has been accepted!");
    }
    
    public void rejectOrder() {
    	this.viewOrders();
    	int choice = StaticMethods.validate(getOrders().size());
    	Order o = getOrders().get(choice);
    	if(o.getAcceptStatus() == AcceptStatus.REJECTED)
    		System.out.println("ERROR! Order was already rejected!");
    	else if(o.getAcceptStatus() == AcceptStatus.ACCEPTED)
    		System.out.println("ERROR! Order was already accepted");
    	else
    		o.acceptStatus = AcceptStatus.REJECTED;
			System.out.println("Order has been rejected!");
    }
    
    public void viewMenu() {
    	while(true) {
    		String[] options = new String[] {"View orders",
    				"Accept order", "Reject order", "Exit" };
    		System.out.println("/nTech support specialist menu");
    		for(int i = 0; i < options.length; i++) {
    			System.out.println(i + 1 + ". " + options[i]);
    		}
    		
    		System.out.println("Enter your choice: ");
    		int choice = StaticMethods.validate(options.length);
    		
    		if(choice == 1) {
    			this.viewOrders();
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
    			}
    			catch(IOException e){
    				e.printStackTrace();
    			}
    			break;
    		}
    	}
    }
    
    public String toString() {
    	return "Tech Support Specialist " + super.toString();
    }
}
