package wsp;

import java.util.*;
import wsp.*;
import database.*;
import enums.*;
import utils.*;

public class Employee extends User {

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
        dean.signRequests(request);
        System.out.println("Request sent successfully");

    }

    public void sendOrder(Order order) {
        Database.getInstance().addOrder(order);

        TechSupportSpecialist specialist = order.getTo();
        specialist.addOrder(order);
        System.out.println("Order sent successfully to " + specialist.getUsername());
    }
}

@Override
public void viewNews() {
    // TODO Auto-generated method stub
}

@Override
public void viewMenu() {
    // TODO Auto-generated method stub

}



}
