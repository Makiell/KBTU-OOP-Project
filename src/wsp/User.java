package wsp;

import java.io.Serializable;
import utils.*;
import java.util.Objects;
import java.util.Vector;
import java.util.Scanner;

import database.Database;

public abstract class User implements Serializable {
	
	private int id = 1;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	
	public User(String username, String password, String firstName, String lastName) {
		if(Database.getInstance().getUsers().isEmpty()) {
			this.id = 1;
		}
		else {
			int nextid = Database.getInstance().getUsers().lastElement().id;
			this.id = ++nextid;
		}
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	public void authentification() {
		this.viewNews();
		this.viewMenu();
	}
	
	
	public void viewNews() {
		Vector <News> news = Database.getInstance().getNews();
		System.out.println("----NEWS----");
		
		for (int i = 0; i < news.size(); i++) {
			News n = news.get(i);
			System.out.println((i + 1) + ". " + n.getTopic());
			System.out.println((i + 1) + ". " + n.getTitle());
			System.out.println();
		}
		while (true) {
			System.out.println("Enter the number of the news to view or 0 to exit:");
			int choice = StaticMethods.validate(news.size());
			
			if (choice == 0) {
				break;
			}
			if (choice != 0) {
				News selectedNews = news.get(choice);
				System.out.println("----Selected News----");
				System.out.println(selectedNews.toString());
				System.out.println();
				
				viewComments(selectedNews);
				
				Scanner in = new Scanner(System.in);
				
				System.out.println("Do you want to add a comment? (+/-)");
		        String answer = in.nextLine();

		        if (answer.equals("+")) {
		            addComment(selectedNews);
		        }
			}

		}
		
	}
	public void viewOneNews() {
		Vector <News> news = Database.getInstance().getNews();
		
		System.out.println("Enter the number of the news to view or 0 to exit:");
		int choice = StaticMethods.validate(news.size());

		News selectedNews = news.get(choice);
		System.out.println("----Selected News----");
		System.out.println(selectedNews.toString());
		System.out.println();
			
		viewComments(selectedNews);
		
		Scanner in = new Scanner(System.in);
			
		System.out.println("Do you want to add a comment? (+/-)");
		String answer = in.nextLine();

	    if (answer.equals("+")) {
	        addComment(selectedNews);
	    }
	}
	public void viewComments(News n) {
		Vector <String> comments = n.getComments();
		
		if(comments.isEmpty()) {
			System.out.println("No comments available");
			
		}
		else {
			System.out.println("----Comments----");
			for (String comment : comments) {
				System.out.println(" - " + comment);
			}
		}
	}
	
	public void addComment(News n) {
		System.out.println("----Enter your comment----");
		
		Scanner input = new Scanner(System.in);
		String comment = input.nextLine();
		n.getComments().add(comment);
		System.out.println("Comment add successfully");
		
	}
	
	
	public abstract void viewMenu();
	public abstract void changeInfo();
	
//	public void logOut() {
//		
//	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "[id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	
}
