package wsp;

import utils.Order;

import java.io.Serializable;

public class TechSupportSpecialist extends Employee implements Serializable {

    public TechSupportSpecialist(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }

    public void addOrder(Order order) {
    }
}
