package wsp;

import java.io.Serializable;
import enums.*;

import java.util.Vector;

import database.Database;

import java.util.Scanner;
import enums.Faculty;
import enums.TeacherTitle;
import utils.*;
import utils.Course;
import utils.Lesson;
	


public class Dean extends Teacher implements Serializable {

	private static final long serialVersionUID = 1L;
	Vector <Request> requests = new Vector<>();
    public Dean(String username, String password, String firstName, String lastName,
                Faculty faculty) {
        super(username, password, firstName, lastName, null, faculty);
        // TODO Auto-generated constructor stub
    }
    public Vector<Request> getRequests(){
        return requests;
    }

    public void setRequests(Vector <Request> requests) {
        this.requests = requests;
    }
    
    public void signRequest(Request request) {
    	System.out.println("Dean signed request: " + request);
    }


    public void signRequests() {
    	while(true) {
	    	if(requests.isEmpty()) {
	    		System.out.println("No requests");
	    		break;
	    	}
	    	
	    	System.out.println("----Emergency Requests----");
	    	for (int i = 0; i<requests.size(); i++) {
	    		System.out.println((i + 1) + ". " + requests.get(i));
	    	}
	    	
	    	System.out.println("Enter the request number to sign (or 0 to exit):");
	    	int choice = StaticMethods.validate(requests.size() + 1);
	    	
	    	if (choice == 0) {
	    		break;
	    	}
	
	    	int index = choice - 1;
	    	
	    	if (index >= 0 && index < requests.size()) {
	    		Request selectedRequest = requests.get(index);
	    		signRequest(selectedRequest);
	    		
	    		requests.remove(selectedRequest);
	    		
	    		System.out.println("The request was successfully signed and deleted.");
	    	}
	    	else {
	    		System.out.println("Invalid request number.");
	    	}
    	}
    }
    
    public void viewMenu() {
    	String[] options = new String[]{
                "Sign Requests", "Exit"
        };
    	
    	while (true) {
    		System.out.println();
    		System.out.println("----Dean Menu----");
    		for (int i = 0; i<options.length; i++) {
    			System.out.println((i + 1) + ". " + options[i]);
    		}
    		
    		int choice = StaticMethods.validate(options.length);
    		if(choice == 1) {
    			signRequests();
    		}

    		else if (choice == 2) {
    			break;
    		}
    	
    	}
    }

    public void addRequest(Request request){
        requests.add(request);
    }
    
    public String toString() {
    	return "Dean " + super.toString();
    }
}