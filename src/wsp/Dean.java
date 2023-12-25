package wsp;

import java.io.IOException;
import java.io.Serializable;

import database.Log;
import enums.Faculty;
import enums.Status;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import database.Database;
import utils.Request;
import utils.StaticMethods;

public class Dean extends Teacher implements Serializable {

	private static final long serialVersionUID = 3623621447508671844L;
	private Vector<Request> requests = new Vector<>();

    public Dean(String username, String password, String firstName, String lastName, Faculty faculty) {
        super(username, password, firstName, lastName, null, faculty);
    }

    public Vector<Request> getRequests() {
        return requests;
    }

    public void setRequests(Vector<Request> requests) {
        this.requests = requests;
    }
    
    public void changeInfo() {
    	System.out.println("What do you want to change?");
		
		String[] options = new String[] {
				"Username", "Password", "First name", "Last name", "Faculty"
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
		else if(choice == 5) {
			System.out.println("Choose faculty:");
	        
	        Faculty[] optionsFaculty = Faculty.values();
	        
	        StaticMethods.printList(List.of(optionsFaculty));
	        
	        int facultyChoice = StaticMethods.validate(options.length);
	        
	        Faculty faculty = optionsFaculty[facultyChoice-1];
	        
	        this.setFaculty(faculty);
		}
    }
    
    public void viewRequests() {
    	StaticMethods.printList(Database.getInstance().getRequests());
        Database.getInstance().addLog(this, new Log("Dean " + this.getUsername() + " view all requests "));
    }

    public void signRequests() {

        if (requests.isEmpty()) {
            System.out.println("No requests");
            return;
        }

        System.out.println("----Emergency Requests----");
        
        StaticMethods.printList(requests);

        System.out.println("Enter the request number to sign (or 0 to exit):");

        int choice = StaticMethods.validate(requests.size());
        
        if(choice == 0) {
        	return;
        }

        Request selectedRequest = requests.get(choice-1);
        selectedRequest.setStatus(Status.ACCEPTED);
        requests.remove(selectedRequest);
        
        System.out.println("Dean signed request: " + selectedRequest);
        System.out.println("The request was successfully signed and deleted.");
        Database.getInstance().addLog(this, new Log("Dean " + this.getUsername() + " signed request"));
    
    }

    public void viewMenu() {
    	String[] options;
    	
    	Researcher researcher = Database.getInstance().isResearcher(this);
    	
    	if(researcher == null) {
    		 options = new String[]{"View all requests", "Sign Requests", "View one News", "View all papers", "Exit"};
    	}
    	else {
    		 options = new String[]{"View all requests", "Sign Requests", "View one News", "View all papers", "Exit", "View researcher menu"};
    	}
       

        while (true) {
            System.out.println();
            System.out.println("----Dean Menu----");
            StaticMethods.printList(List.of(options));

            int choice = StaticMethods.validate(1, options.length);
            
            if(choice == 1) {
            	viewRequests();
            }
            if (choice == 2) {
                signRequests();
            } 
            else if (choice == 3) {
            	viewOneNews();
                Database.getInstance().addLog(this, new Log("Dean " + this.getUsername() + " viewed a one News"));
            }
            else if(choice == 4) {
            	Database.getInstance().getAllPapers();
            }
            else if (choice == 5) {
                try {
                    Database.getInstance().saveDatabase();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            else if(researcher != null) {
				if(choice == 6) {
					researcher.viewMenu();
                    Database.getInstance().addLog(this, new Log("Dean " + this.getUsername() + " went to the researcher menu"));
				}
			}
        }
    }

    public void addRequest(Request request) {
        requests.add(request);
    }

    @Override
    public String toString() {
        return "Dean " + super.toString();
    }
}
