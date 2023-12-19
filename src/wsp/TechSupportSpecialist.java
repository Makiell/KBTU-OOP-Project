package wsp;

import utils.Order;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Vector;

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
    	int i = 1;
    	for(Order o : orders) {
    		System.out.println(i + "-order: "+ o);
    		i++;
    	}
    }
    
    public void acceptOrder() {
    	this.viewOrders();
    	int choice = this.validate(getOrders().size());
    	Order o = getOrders().get(choice);
    	if(!o.isAccepted() && !o.isRejected()) {
	    	o.isAccept = true;
	    	System.out.println("Order has been accepted!");
    	}
    	else
    		System.out.println("ERROR! Order was already rejected!");
    }
    
    public void rejectOrder() {
    	this.viewOrders();
    	int choice = this.validate(getOrders().size());
    	Order o = getOrders().get(choice);
    	if(!o.isAccepted() && !o.isRejected()) {
    		o.isReject = true;
    		System.out.println("Order has been rejected!");
    	}
    	else {
    		System.out.println("ERROR! Order was already accepted");
    	}
    }
    
    private int validate(int n) {
    	Scanner s = new Scanner(System.in);
    	int choice = s.nextInt();
    	while(!(1 <= choice && choice <= n)) {
    		System.out.println("Please enter number from 1 to n: ");
    	}
    	
    	return choice;
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
    		int choice = this.validate(options.length);
    		
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
