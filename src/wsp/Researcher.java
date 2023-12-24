package wsp;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import utils.*;

public class Researcher<T> implements Serializable {
	
	private T user;
	private Vector<ResearchProject> projects;
	private Vector<ResearchPaper> papers;
	private int hIndex;
	
	public Researcher(T user) {
		this.user = user;
	}
	
	
	public void printPapers() {
		
		for(ResearchPaper p : papers) {
			System.out.println(p);
		}
	}
	

	public T getUser() {
		return user;
	}


	public void setUser(T user) {
		this.user = user;
	}
	
	
	public void viewMenu() {
		
		while(true) {
			String userMenu = "View " + user.getClass().getName() + " menu";
			String[] options = new String[] {
					"View papers", "View projects", "Add paper to journal", userMenu, "Exit"
			};
			
			StaticMethods.printList(List.of(options));
			
			int choice = StaticMethods.validate(1, options.length);
			if(choice==5) {
				break;
			}
		}
		
		
		
	}


	@Override
	public String toString() {
		return "Researcher [user=" + user + ", hIndex=" + hIndex + "]";
	}
	
	
	
	
}
