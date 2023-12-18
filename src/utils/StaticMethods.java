package utils;

import java.util.List;
import java.util.Scanner;

public class StaticMethods {

	
	public static void printList(List list) {
		for(int i = 0; i<list.size(); i++) {
			System.out.println(i+1+ ") " + list.get(i));
		}
	}
	
	public static int validate(int n) {
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		while (!(0 <= choice && choice <= n)) {
			System.out.println("Please enter number from 1 to " + n);
			choice = s.nextInt();
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
}
