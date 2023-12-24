package wsp;

import java.util.List;
import java.util.Scanner;

import database.Database;
import enums.Faculty;
import enums.Grade;
import utils.StaticMethods;

public class StudentFactory {
	
	public Student getStudent(int choice) {
		if(choice == 1) {
			return addStudent();
		}
		if(choice == 2) {
			return addGraduateStudent();
		}
		return null;
	}
	
	public Student addStudent() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        System.out.println("Choose faculty:");
        
        Faculty[] options = Faculty.values();
        
        StaticMethods.printList(List.of(options));
        
        int facultyChoice = StaticMethods.validate(1, options.length);
        
        Faculty faculty = options[facultyChoice-1];
        
        Student newStudent = new Student(username, password, firstName, lastName, faculty);
		
        Database.getInstance().addStudent(newStudent);
        
        System.out.println("Student added " + newStudent);
        
        return newStudent;
        
	}
	
	public Student addGraduateStudent() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        System.out.println("Choose faculty:");
        
        Faculty[] options = Faculty.values();
        
        StaticMethods.printList(List.of(options));
        
        int facultyChoice = StaticMethods.validate(1, options.length);
        
        Faculty faculty = options[facultyChoice-1];
        
        Grade[] optionsGrade = Grade.values();
        
        StaticMethods.printList(List.of(optionsGrade));
        
        int gradeChoice = StaticMethods.validate(1, optionsGrade.length);
        
        Grade grade = optionsGrade[gradeChoice-1];
        
        Student newGraduateStudent = new GraduateStudent(username, password, firstName, lastName, faculty, grade);
		
        Database.getInstance().addStudent(newGraduateStudent);
        
        System.out.println("Student added " + newGraduateStudent);
        
        return newGraduateStudent;
        
	}
}
