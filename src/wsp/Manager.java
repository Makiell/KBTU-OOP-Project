package wsp;

import enums.*;
import utils.*;
import database.Database;

import javax.xml.crypto.Data;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Manager extends Employee {
	private TypeManager typeManager;

	public Manager(String username, String password, String firstName, String lastName, TypeManager typeManager) {
		super(username, password, firstName, lastName);
		this.typeManager = typeManager;
	}

	public TypeManager getTypeManager() {
		return typeManager;
	}

	public void setTypeManager(TypeManager typeManager) {
		this.typeManager = typeManager;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Manager manager = (Manager) o;
		return typeManager == manager.typeManager;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), typeManager);
	}

	public void createStatisticReport() {

	}

	public void addCourse() {

	}
	
	public void changeInfo() {
    	System.out.println("What do you want to change?");
		
		String[] options = new String[] {
				"Username", "Password", "First name", "Last name", "Type"
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
			System.out.println("Choose type:");
	        
	        TypeManager[] optionsType = TypeManager.values();
	        
	        StaticMethods.printList(List.of(optionsType));
	        
	        int choiceType = StaticMethods.validate(optionsType.length);
	        
	        TypeManager type = optionsType[choiceType-1];
	        
	        this.typeManager = type;
		}
    }

	public void createNews() {
		Scanner s = new Scanner(System.in);
		System.out.println("News topic:");
		String topic = s.nextLine();
		System.out.println("News title:");
		String title = s.nextLine();
		System.out.println("News text:");
		String text = s.nextLine();
		Database.getInstance().addNews(new News(topic, title, text));
	}

	public void viewRequests() {
		Vector<Request> dbrequests = Database.getInstance().getRequests();
		System.out.println("List of Requests:");
		for (Request r : dbrequests) {
			System.out.println(r);
		}
	}

	public void editNews() {
		System.out.println("What news do you want to change?");
		Scanner s = new Scanner(System.in);
		
		Vector<News> dbnews = Database.getInstance().getNews();
		StaticMethods.printList(dbnews);
		System.out.println("Enter 0 to return back");
		
		int newschoice = StaticMethods.validate(dbnews.size());
		
		if(newschoice == 0) {
			return;
		}
		
		News news = dbnews.get(newschoice - 1);
		
		System.out.println("Which of part do you want to change?" + "\n 1 - Topic" + "\n 2 - Title"
				+ "\n 3 - Text" + "\n 0 - exit");
		
		int editchoice = StaticMethods.validate(3);

		if (editchoice == 1) {
			s.nextLine();
			String topic = s.nextLine();
			news.setTopic(topic);
			System.out.println("Update news:" + news.toString());
		} 
		else if (editchoice == 2) {
			s.nextLine();
			String title = s.nextLine();
			news.setTitle(title);
			System.out.println("Update news:" + news.toString());
		} 
		else if (editchoice == 3) {
			s.nextLine();
			String text = s.nextLine();
			news.setText(text);
			System.out.println("Update news:" + news.toString());
		} 
		else if (editchoice == 0) {
			return;
		}


	}

	public void assignCourseForTeacher() {
	}

	public void viewStudents() {
		for(Student s : Database.getInstance().getStudents()) {
			System.out.println(s);
		}
	}

	public void viewTeachers() {
		Vector<Employee> employees = Database.getInstance().getEmployees();
		Vector<Teacher> teachers = employees.stream()
        		.filter(employee -> employee instanceof Teacher)
        		.map(employee -> (Teacher) employee)
        		.collect(Collectors.toCollection(Vector::new));
		
		for(Teacher t : teachers) {
			System.out.println(t);
		}
	}

	public void viewMenu() {
		while (true) {
			String[] options = new String[] { "Create a statistical report", "Add course", "Create news",
					"View Requests", "Edit news", "Assign Course For Teacher", "view Students", "view Teachers",
					"Exit" };
			
			System.out.println("\nManager Menu:");
			StaticMethods.printList(List.of(options));
			
			System.out.print("Enter your choice: ");
			int choice = StaticMethods.validate(options.length);
			
			if (choice == 1) {
				createStatisticReport();
			}
			else if (choice == 2) {
				addCourse();
			} 
			else if (choice == 3) {
				createNews();
			}
			else if (choice == 4) {
				viewRequests();
			} 
			else if (choice == 5) {
				editNews();
			} 
			else if (choice == 6) {
				assignCourseForTeacher();
			} 
			else if (choice == 7) {
				viewStudents();
			} 
			else if (choice == 8) {
				viewTeachers();
			} 
			else if (choice == 9 || choice == 0) {
				try {
					Database.getInstance().saveDatabase();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "Manager [typeManager=" + typeManager + "] " + super.toString();
	}
	
	
}
