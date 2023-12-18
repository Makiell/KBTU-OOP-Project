package wsp;

import enums.*;
import utils.*;
import database.Database;

import javax.xml.crypto.Data;
import java.util.*;

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
		while (true) {
			Scanner s = new Scanner(System.in);
			Vector<News> dbnews = Database.getInstance().getNews();
			for (int i = 1; i <= dbnews.size(); i++) {
				News n = dbnews.get(i - 1);
				System.out.println(i + " - " + n);

			}
			int newschoice = s.nextInt();
			if (newschoice <= dbnews.size() && newschoice >= 1) {
				News news = dbnews.get(newschoice - 1);
				System.out.println("Which of part do you want to change?" + "\n 1 - Topic" + "\n 2 - Title"
						+ "\n 3 - Text" + "\n 4 - exit");

				int editchoice = s.nextInt();

				if (editchoice == 1) {
					s.nextLine();
					String topic = s.nextLine();
					news.setTopic(topic);
					System.out.println("Update news:" + news.toString());
				} else if (editchoice == 2) {
					s.nextLine();
					String title = s.nextLine();
					news.setTitle(title);
					System.out.println("Update news:" + news.toString());
				} else if (editchoice == 3) {
					s.nextLine();
					String text = s.nextLine();
					news.setText(text);
					System.out.println("Update news:" + news.toString());
				} else if (editchoice == 4) {
					break;
				} else {
					System.out.println("Please enter number from 1 to 4");
				}
			} else {
				System.out.println("Please enter number from 1 to " + dbnews.size());
			}
		}
	}

	public void assignCourseForTeacher() {
	}

	public void viewStudents() {
	}

	public void viewTeachers() {
	}

	public void viewMenu() {
		while (true) {
			String[] options = new String[] { "Create a statistical report", "Add course", "Create news",
					"View Requests", "Edit news", "Assign Course For Teacher", "view Students", "view Teachers",
					"Exit" };
			Scanner Scanner = new Scanner(System.in);
			System.out.println("\nStudent Menu:");
			for (int i = 0; i < options.length; i++) {
				System.out.println((i + 1) + ". " + options[i]);
			}
			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(Scanner.nextLine());
			if (choice == 1) {
				createStatisticReport();
			}

			else if (choice == 2) {
				addCourse();
			} else if (choice == 3) {
				createNews();
			}

			else if (choice == 4) {
				viewRequests();
			} else if (choice == 5) {
				editNews();
			} else if (choice == 6) {
				assignCourseForTeacher();
			} else if (choice == 7) {
				viewStudents();
			} else if (choice == 8) {
				viewTeachers();
			} else if (choice == 9) {
				break;
			} else {
				System.out.println("Please enter number from 1 to 9");
			}
		}
	}

	@Override
	public String toString() {
		return "Manager [typeManager=" + typeManager + "] " + super.toString();
	}
	
	
}
