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
		while (!(1 <= choice && choice <= n)) {
			System.out.println("Please enter number from 1 to " + n);
			choice = s.nextInt();
		}

		return choice;
	}
}
