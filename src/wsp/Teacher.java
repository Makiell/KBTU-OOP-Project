package wsp;

import java.io.Serializable;
import java.util.*;

import database.Database;
import utils.*;
import wsp.*;
import enums.*;

public class Teacher extends Employee implements Serializable {

    private TeacherTitle typeTeacher;
    private Vector <Course> courses = new Vector<Course>();
    private Faculty faculty;
    private Map<Course, Vector<Lesson>> lessons = new HashMap <Course, Vector<Lesson>>();
    private double rate = 0.0;


    public Teacher(String username, String password, String firstName, String lastName, TeacherTitle typeTeacher,
                   Faculty faculty) {
        super(username, password, firstName, lastName);
        this.typeTeacher = typeTeacher;
        this.faculty = faculty;
    }


    public TeacherTitle getTypeTeacher() {
        return typeTeacher;
    }

    public Vector<Course> getCourses() {
        return courses;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Map<Course, Vector<Lesson>> getLessons() {
        return lessons;
    }

    public double getRate() {
        return rate;
    }

    public void setTypeTeacher(TeacherTitle typeTeacher) {
        this.typeTeacher = typeTeacher;
    }

    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setLessons(Map<Course, Vector<Lesson>> lessons) {
        this.lessons = lessons;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void viewCourses() {
        System.out.println("Courses taught by " + getUsername() + ":");
        for (Course course : courses) {
            System.out.println("- " + course.getName());
        }
    }

    public void viewStudents(Course course) {
        Vector<Student> students = Database.getInstance().getStudents();
        System.out.println("Students enrolled in " + course.getName() + ":");
        for (Student student : students) {
            if (student.getCourses().contains(course)) {
                System.out.println("- " + student.getUsername());
            }
        }

    }

    public void viewMarks() {
        if(courses.isEmpty()) {
            System.out.println("No courses");
            return;
        }
        int i = 1;
        int nextI = 1;
        for (Course c : courses) {
            System.out.println(i + " - " + c);
            i = ++nextI;
        }
        System.out.println("Please enter your choice:");
        System.out.println("Enter 0 for return back");
        int courseChoice = StaticMethods.validate(courses.size());
        
        if(courseChoice == 0) {
        	return;
        }
        
        Course selectedCourse = courses.get(courseChoice - 1);
        viewMarks(selectedCourse);
    }
    public void viewNews() {
        super.viewNews();
    }
	
    
    public void changeInfo() {
    	System.out.println("What do you want to change?");
		
		String[] options = new String[] {
				"Username", "Password", "First name", "Last name", "Rate"
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
			System.out.println("Введите значение:");

			while(true) {
				if (in.hasNextDouble()) {
	                double rate = in.nextDouble();
	                this.rate = rate;
	                return;
	            } else {
	                System.out.println("Enter valid data");
	            }
			}
		}
    }

    public void viewMarks(Course selectedCourse) {

        if (!lessons.containsKey(selectedCourse)) {
            System.out.println("No lessons for this course");
            return;
        }
        System.out.println("Marks for " + selectedCourse.getName() + ":");
        for (Student student : Database.getInstance().getStudents()) {
            if (student.getCourses().contains(selectedCourse)) {
                Mark mark = student.getTranscript().get(selectedCourse);
                System.out.println(student.getUsername() + ": " + (mark != null ? mark.toString() : "No marks"));
            }
        }
    }

    public void viewRate() {
        System.out.println("Teacher's rating: " + rate);
    }


	@Override
	public String toString() {
		return "Teacher [typeTeacher=" + typeTeacher + " courses=" + lessons + ", faculty=" + this.faculty + "] " + super.toString();
	}

    
    

}
