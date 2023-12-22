package wsp;

import utils.Order;
import utils.StaticMethods;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;
import database.Database;
import enums.*;

public class TechSupportSpecialist extends Employee implements Serializable {
	
	private Vector<Order> orders;

    public TechSupportSpecialist(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
        this.orders = new Vector<Order>();
    }
    
    public Vector<Order> getOrders(){
    	return orders;
    }
    
    public void viewOrders() {
    	StaticMethods.printList(this.getOrders());
    }
    
    public void acceptOrder() {
    	if(orders.isEmpty()) {
    		System.out.println("No orders");
    		return;
    	}
    	System.out.println("Choose order:");
    	this.viewOrders();
    	int choice = StaticMethods.validate(getOrders().size());
    	Order o = getOrders().get(choice-1);
    	if(o.getStatus() == Status.REJECTED) {
    		System.out.println("ERROR! Order was already rejected!");
    	}
    	else if(o.getStatus() == Status.ACCEPTED) {
    		System.out.println("ERROR! Order was already accepted");
    	}
    	else {
    		o.setStatus(Status.ACCEPTED);
			System.out.println("Order has been accepted!");
    	}
    }
    
    public void rejectOrder() {
    	if(orders.isEmpty()) {
    		System.out.println("No orders");
    		return;
    	}
    	System.out.println("Choose order:");
    	this.viewOrders();
    	int choice = StaticMethods.validate(getOrders().size());
    	Order o = getOrders().get(choice-1);
    	if(o.getStatus() == Status.REJECTED) {
    		System.out.println("ERROR! Order was already rejected!");
    	}
    	else if(o.getStatus() == Status.ACCEPTED) {
    		System.out.println("ERROR! Order was already accepted");
    	}
    	else {
    		o.setStatus(Status.ACCEPTED);
			System.out.println("Order has been rejected!");
    	}
    }
    
    public void viewMenu() {
    	String[] options = new String[] {"View orders",
				"Accept order", "Reject order","View one News", "Exit" };
    	
    	while(true) {
    		
    		System.out.println();
    		System.out.println("Tech support specialist menu");
    		
    		StaticMethods.printList(List.of(options));
    		
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
    		else if (choice == 4) {
    			viewOneNews();
    		}
    		else if(choice == 5 || choice == 0) {
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

	public void addOrder(Order order) {
		this.orders.add(order);
		
	}
}
