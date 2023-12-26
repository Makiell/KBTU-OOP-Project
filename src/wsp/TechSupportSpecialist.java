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


/**
 * The TechSupportSpecialist class represents a technical support specialist
 * who can view, accept, and reject orders.
 */
public class TechSupportSpecialist extends Employee implements Serializable {
	
	private Vector<Order> orders;

    public TechSupportSpecialist(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
        this.orders = new Vector<Order>();
    }
    
    public Vector<Order> getOrders(){
    	return orders;
    }
    
    /**
     * Displays and marks orders as viewed by the tech support specialist.
     */
    public void viewOrders() {
    	Vector<Order> orders = this.getOrders();
    	for(Order o : orders) {
    		if(o.getStatus()==Status.NEW) {
    			o.setStatus(Status.VIEWED);
    		}
    	}
    	StaticMethods.printList(orders);
        Database.getInstance().addLog(this, new Log("Tech Support Specialist " + this.getUsername() + " viewed all orders "));
    }
    
    
    /**
     * Accepts a selected order, updates its status.
     * Displays an error message if the order was already rejected or accepted.
     */
    public void acceptOrder() {
    	this.viewOrders();
    	int choice = StaticMethods.validate(getOrders().size());
    	Order o = getOrders().get(choice-1);
    	if(o.getStatus() == Status.REJECTED)
    	{
    		this.getLanguage().orderWasAlreadyRejected();
    		return;
    	}
    	if(o.getStatus() == Status.ACCEPTED)
    	{
    		this.getLanguage().orderWasAlreadyAccepted();
    		return;
    	}
    	else {
    		o.setStatus(Status.ACCEPTED);
    		this.getLanguage().orderHasBeenAccepted();
            Database.getInstance().addLog(this, new Log("Tech Support Specialist " + this.getUsername() + " accepted order "));
    	}
    		
    }
    
    
    /**
     * Rejects a selected order, updates its status.
     * Displays an error message if the order was already rejected or accepted.
     */
    public void rejectOrder() {
    	this.viewOrders();
    	int choice = StaticMethods.validate(getOrders().size());
    	Order o = getOrders().get(choice-1);
    	if(o.getStatus() == Status.REJECTED)
    	{
    		this.getLanguage().orderWasAlreadyRejected();
    		return;
    	}
    		
    	if(o.getStatus() == Status.ACCEPTED)
    	{
    		this.getLanguage().orderHasBeenAccepted();
    		return;
    	}
    		
    	else
    	{
    		o.setStatus(Status.REJECTED);
    		this.getLanguage().orderHasBeenRejected();
			Database.getInstance().addLog(this, new Log("Tech Support Specialist " + this.getUsername() + " rejected the order"));
    	}
    		
    }
    
    
    /**
     * Displays the menu for the tech support specialist, allowing them to view orders,
     * accept or reject orders, view all papers, save the database, and exit.
     * If the tech support specialist is also a researcher, an additional option to
     * view the researcher menu is available.
     */
    public void viewMenu() {
    	
    	String[] options;
    	
    	Researcher researcher = Database.getInstance().isResearcher(this);
    	
    	if(researcher == null) {
    		options = this.getLanguage().techSupportSpecialistMenu();
    	}
    	else {
    		options = this.getLanguage().techSupportSpecialistResearcherMenu();
    	}
    	
    	
    	while(true) {
    		 
    		this.getLanguage().techSupportSpecialistHeader();
    		
    		StaticMethods.printList(List.of(options));
    		
    		this.getLanguage().enterYourChoice();
    		int choice = StaticMethods.validate(1, options.length);
    		
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
            	Database.getInstance().getAllPapers();
            }
    		
    		else if(choice == 5) {
    			this.changeLanguage();
    		}
    		else if(choice == 6) {
            	StaticMethods.subscribeJournal(this);
            }
    		else if(choice == 7) {
            	StaticMethods.unsubscribeJournal(this);
            }
    		else if(choice == 8) {
    			try {
					Database.getInstance().saveDatabase();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			break;
    		}
    		
    		else if(researcher != null) {
				if(choice == 9) {
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
