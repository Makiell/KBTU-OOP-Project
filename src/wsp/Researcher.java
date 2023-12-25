package wsp;

import java.io.Serializable;
import java.util.*;

import database.Database;
import utils.*;

/**
 * The Researcher class represents a researcher in the academic system.
 * It provides functionalities for viewing papers, creating papers, viewing projects,
 * viewing journals, and adding papers to a journal.
 *
 * @param <T> The type of user associated with the researcher.
 */
public class Researcher<T> implements Serializable {
	
    private static final long serialVersionUID = -8619146448875960868L;
    
	private T user;
	private Vector<ResearchProject> projects;
	private Vector<ResearchPaper> papers;
	private int hIndex = 0;
	
	/**
     * Constructs a Researcher object with the specified user.
     *
     * @param user The user associated with the researcher.
     */
	public Researcher(T user) {
		this.user = user;
		this.papers = new Vector<ResearchPaper>();
		this.projects = new Vector<ResearchProject>();
	}

	/**
     * Gets the user associated with the researcher.
     *
     * @return The user associated with the researcher.
     */
	public T getUser() {
		return user;
	}

	/**
     * Sets the user associated with the researcher.
     *
     * @param user The new user to set.
     */
	public void setUser(T user) {
		this.user = user;
	}
	
	
	/**
     * Gets the h-index of the researcher.
     *
     * @return The h-index of the researcher.
     */
    public int gethIndex(){
        return hIndex;
    }
	
    /**
     * Gets the list of papers associated with the researcher.
     *
     * @return The list of papers associated with the researcher.
     */
	public Vector<ResearchPaper> getPapers() {
		return papers;
	}

    public int calculatehIndex(){
        Vector<Integer> citations = new Vector<Integer>();

        if(this.papers == null){
            System.out.println("You does not have any research papers.");
        }
        else{
            Comparator<ResearchPaper> citaComparator = new PaperCitationsComparator();
            this.papers.sort(citaComparator);
            for(int i = 0; i < this.papers.size(); i++){
                ResearchPaper researchPaper = this.papers.get(i);
                citations.add(researchPaper.getCitations());
            }
        }
        for (int i = 0; i < citations.size(); i++) {
            if (citations.get(i) >= hIndex + 1) {
                hIndex++;
            } else {
                break;
            }
        }
        return hIndex;

    }
	public void viewPapers() {
		
		if(papers.isEmpty()) {
			System.out.println("No papers");
			return;
		}
		
		System.out.println("In which order do you want to get papers?");
    	System.out.println("1. Sorted by date");
    	System.out.println("2. Sorted by citations");
    	System.out.println("3. Sorted by number of pages");
    	
    	int choice = StaticMethods.validate(1, 3);
    	
    	if(choice == 1) {
    		Collections.sort(this.papers, new PaperDateComparator());
    		StaticMethods.printList(papers);
    		return;
    	}
    	if(choice == 2) {
    		Collections.sort(this.papers, new PaperCitationsComparator());
    		StaticMethods.printList(papers);
    		return;
    	}
    	if(choice == 3) {
    		Collections.sort(this.papers, new PaperPagesComparator());
    		StaticMethods.printList(papers);
    		return;
    	}
		
		StaticMethods.printList(papers);
	}
	
	
	/**
     * Views the projects associated with the researcher.
     */
	public void viewProjects() {
		
		if(projects.isEmpty()) {
			System.out.println("No projects");
			return;
		}
		
		StaticMethods.printList(projects);
	}
	
	
	/**
     * Adds a paper to a research journal.
     */
	public void addPaperToJournal() {
		
		Vector<ResearchJournal> journals = Database.getInstance().getJournals();
		
		if(journals.isEmpty()) {
			System.out.println("No journals.");
			return;
		}
		
		System.out.println("Enter 0 to return back.");
		System.out.println("Choose the journal:");
		
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
		
		System.out.println(paper + " added to " + journal.getName());
	}
	
	
	/**
     * Views the research journals in the system.
     */
	public void viewJournals() {
		StaticMethods.printList(Database.getInstance().getJournals());
	}
	
	
	/**
     * Views the menu for the researcher, providing options to view papers, create papers, view projects,
     * view journals, and add papers to a journal.
     */
	public void viewMenu() {
		
		while(true) {
			String userMenu = "Exit to " + user.getClass().getName().substring(4) + " menu";
			String[] options = new String[] {
					"View papers", "Create paper", "View projects", "View journals", "Add paper to journal", userMenu
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
				viewJournals();
			}
			else if(choice == 5) {
				addPaperToJournal();
			}
			else if(choice==6) {
				break;
			}
		}
		
	}


	/**
     * Creates a new research paper. Asks the researcher for paper details such as name, pages, and DOI.
     */
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
		
		if(!Database.getInstance().getPapersWithoutThis(this).isEmpty()) {
			
			System.out.println("Do you want to cite?\n1-Yes \n2-No");
			
			int choice = StaticMethods.validate(1, 2);
			
			if(choice == 1) {
				System.out.println("Which paper do you want to cite?");
				
				Vector<ResearchPaper> papers = Database.getInstance().getPapersWithoutThis(this);
				
				StaticMethods.printList(papers);
				
				int paperChoice = StaticMethods.validate(1, papers.size());
				
				ResearchPaper paper = papers.get(paperChoice-1);
				
				paper.increaseCitations();
				
			}
		}
		
		ResearchPaper newPaper = new ResearchPaper(name, authors, pages, doi);
		
		this.papers.add(newPaper);
		
		Database.getInstance().addPaper(newPaper);
		
		System.out.println("New paper added " + newPaper);
		
	}


	@Override
	public String toString() {
		return "Researcher [user=" + user + ", hIndex=" + hIndex + "]";
	}
	
	
}
