package wsp;

import utils.Order;

import java.io.Serializable;
import java.util.Vector;

public class TechSupportSpecialist extends Employee implements Serializable {
	
	private Vector<Order> orders;

    public TechSupportSpecialist(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
        this.orders = new Vector<Order>();
    }

    public void addOrder(Order order) {
    	this.orders.add(order);
    }
    
    public String toString() {
    	return "Tech Support Specialist " + super.toString();
    }
    
    
}
