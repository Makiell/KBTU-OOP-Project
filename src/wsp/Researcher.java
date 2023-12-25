package wsp;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import database.Database;
import utils.*;

public class Researcher<T> implements Serializable {
    private static final long serialVersionUID = -8619146448875960868L;
	private T user;
	private Vector<ResearchProject> projects;
	private Vector<ResearchPaper> papers;
	private int hIndex;
	
	public Researcher(T user) {
		this.user = user;
		this.papers = new Vector<ResearchPaper>();
		this.projects = new Vector<ResearchProject>();
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
    public int gethIndex(){
        return hIndex;
    }
	
	public void viewPapers() {
		
		if(papers.isEmpty()) {
			System.out.println("No papers");
			return;
		}
		
		StaticMethods.printList(papers);
	}
	
	public void viewProjects() {
		
		if(projects.isEmpty()) {
			System.out.println("No projects");
			return;
		}
		
		StaticMethods.printList(projects);
	}
	
	public void addPaperToJournal() {
		
		System.out.println("Enter 0 to return back.");
		System.out.println("Choose the journal:");
		
		Vector<ResearchJournal> journals = Database.getInstance().getJournals();
		
		StaticMethods.printList(journals);
		
		int choice = StaticMethods.validate(journals.size());
		
		if(choice == 0) {
			return;
		}
		
		ResearchJournal journal = journals.get(choice-1);
		
		System.out.println("Choose paper to add:");
		
		StaticMethods.printList(papers);
		
		int choicePaper = StaticMethods.validate(1, papers.size());
		
		ResearchPaper paper = papers.get(choicePaper-1);
		
		journal.addPaper(paper);
		
		System.out.println(paper + " added to " + journal);
	}
	
	public void viewMenu() {
		
		while(true) {
			String userMenu = "View " + user.getClass().getName() + " menu";
			String[] options = new String[] {
					"View papers", "Create paper", "View projects", "Add paper to journal", userMenu, "Exit"
			};
			
			StaticMethods.printList(List.of(options));
			
			int choice = StaticMethods.validate(1, options.length);
			
			if(choice == 1) {
				viewPapers();
			}
			else if(choice == 2) {
				createPaper();
			}
			else if(choice == 3) {
				viewProjects();
			}
			else if(choice == 4) {
				addPaperToJournal();
			}
			
			else if(choice==6) {
				break;
			}
		}
		
	}


	private void createPaper() {
		System.out.println("Enter 0 to return back.");
		System.out.println("Enter the name:");
		
		Scanner in = new Scanner(System.in);
		
		String name = in.nextLine();
		
		if(name.equals("0")) {
			return;
		}
		
		Vector<Researcher> authors = new Vector<Researcher>();
		authors.add(this);
		
		System.out.println("Enter the number of pages:");
		
		
		int pages;
		while(true) {
			try {
				pages = in.nextInt();
				while(pages<=0) {
					
					System.out.println("Enter valid number of pages.");
					pages = in.nextInt();
					
				}
				in.nextLine();
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("Enter valid number");
				in.nextLine();
			}
		}
		
		System.out.println("Enter the doi:");
		
		String doi = in.nextLine();
		
		ResearchPaper newPaper = new ResearchPaper(name, authors, pages, doi);
		
		this.papers.add(newPaper);
		
		System.out.println("New paper added " + newPaper);
		
	}


	@Override
	public String toString() {
		return "Researcher [user=" + user + ", hIndex=" + hIndex + "]";
	}
	
	
	
	
}
