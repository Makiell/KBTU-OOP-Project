package utils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import database.Database;
import database.Log;
import wsp.User;

public class StaticMethods {

	
	public static void printList(List list) {
		for(int i = 0; i<list.size(); i++) {
			System.out.println(i+1+ ") " + list.get(i));
		}
	}
	
	public static int validate(int n) {
		Scanner s = new Scanner(System.in);
		int choice;
		while(true) {
			try {
				choice = s.nextInt();
				if (0 <= choice && choice <= n) {
					break;
				}
				else {
					System.out.println("Please enter number from 0 to " + n);
				}
				
			}
			catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                s.nextLine();
            }

		}
		return choice;
	}
	
	public static int validate(int a, int n) {
		Scanner s = new Scanner(System.in);
		int choice;
		while(true) {
			try {
				choice = s.nextInt();
				if (a <= choice && choice <= n) {
					break;
				}
				else {
					System.out.println("Please enter number from " + a + " to " + n);
				}
				
			}
			catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                s.nextLine();
            }

		}
		return choice;
	}
	
	public static String getValidInput(String promt, String regex) {
		Scanner in = new Scanner(System.in);
		System.out.println(promt);
		
		while(!in.hasNext(regex)) {
			System.out.print("Invalid input. Please enter a valid name (only letters:");
			in.next();
		}
		
		return in.next();
	}
	
	public static void subscribeJournal(User u) {
		Vector<ResearchJournal> journals = Database.getInstance().getJournals();
		if(journals.isEmpty()) {
			System.out.println("No journals");
			return;
		}
		
		System.out.println("Enter 0 to return back");
		System.out.println("Choose journal:");
		
		
		
		printList(journals);
		
		int choice = validate(journals.size());
		
		if(choice == 0) {
			return;
		}
		
		ResearchJournal journal = journals.get(choice-1);
		
		journal.addObserver(u);
		u.getJournals().add(journal);
		
		System.out.println("Subscribed to " + journal.getName());
		
		Database.getInstance().addLog(u, new Log(u.getUsername() + " subscribed to journal " + journal.getName()));
	}
}
