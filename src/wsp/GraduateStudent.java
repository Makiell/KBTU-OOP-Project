package wsp;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import enums.*;
import database.*;
import utils.Organisation;
import utils.StaticMethods;

public class GraduateStudent extends Student implements Serializable {
    Grade grade;
    public GraduateStudent(String username, String password, String firstName, String lastName, Faculty faculty, Grade grade) {
        super(username, password, firstName, lastName, faculty);
        this.grade = grade;
        Researcher<GraduateStudent> researcher = new Researcher<>(this);
        Database.getInstance().addResearcher(researcher);
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraduateStudent that)) return false;
        if (!super.equals(o)) return false;

        return grade == that.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }

    @Override
    public String toString() {
        return "GraduateStudent [grade=" + grade +
                "] " + super.toString();
    }
    
    public void changeInfo() {
    	System.out.println("What do you want to change?");
		
		String[] options = new String[] {
				"Username", "Password", "First name", "Last name", "Grade"
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
			if(this.grade == Grade.MASTER) {
				this.grade = Grade.PHD;
			}
			else {
				this.grade = Grade.MASTER;
			}
			System.out.println("New grade " + this.grade);
		}
    }

    @Override
    public void joinOrganisation() {
        super.joinOrganisation();
    }

    @Override
    public void leaveOrganisation() {
        super.leaveOrganisation();
    }

    @Override
    public void createOrganisation() {
        super.createOrganisation();
    }

    @Override
    public void viewMenu() {
        super.viewMenu();
    }



    public int compareTo(GraduateStudent s) {

        return super.compareTo(s);
    }

}
