package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import database.Database;
import utils.*;
import wsp.*;
import enums.*;

public class Teacher extends Employee implements Serializable {

    TeacherTitle typeTeacher;
    Vector <Course> courses = new Vector<Course>();
    Faculty faculty;
    Map<Course, Vector<Lesson>> lessons = new HashMap <Course, Vector<Lesson>>();
    double rate = 0.0;


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

    public void viewStudents() {
        if (courses.isEmpty()) {
            System.out.println("No courses");
            return;
        }
        
        System.out.println("Enter the course:");
        for (int i = 0; i<courses.size(); i++) {
    		Course c = courses.get(i);
    		System.out.println((i + 1) + ". " + c.getName());
    	}
    	System.out.println();

        System.out.println("Please enter your choice:");
        System.out.println("Enter 0 to exit");
        int courseChoice = StaticMethods.validate(courses.size());

        if (courseChoice == 0) {
            return;
        }

        Course selectedCourse = courses.get(courseChoice-1);

        Vector<Student> students = Database.getInstance().getStudents();

        System.out.println("Students enrolled in " + selectedCourse.getName() + ":");
        for (Student student : students) {
            if (student.getCourses().contains(selectedCourse)) {
                System.out.println("- " + student.getUsername());
            }
        }
    }

    public void viewMarks() {
        if(courses.isEmpty()) {
            System.out.println("No courses");
            return;
        }
        
        System.out.println("Please enter your choice:");
        StaticMethods.printList(courses);
        
        System.out.println("Enter 0 for return back");
        int courseChoice = StaticMethods.validate(courses.size());
        
        if(courseChoice == 0) {
        	return;
        }
        
        Course selectedCourse = courses.get(courseChoice-1);
        viewMarks(selectedCourse);
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
 
    public void putMarks(Course course, Student student, Mark mark) {
    	Scanner input = new Scanner(System.in);
    
    	if (!courses.contains(course)) {
            System.out.println("Teacher is not assigned to the course: " + course.getName());
            return;
        }

        if (!student.getCourses().contains(course)) {
            System.out.println("Student is not enrolled in the course: " + course.getName());
            return;
        }

        if (!lessons.containsKey(course)) {
            System.out.println("No lessons recorded for the course: " + course.getName());
            return;
        }

        Vector<Lesson> courseLessons = lessons.get(course);
        if (courseLessons == null || courseLessons.isEmpty()) {
            System.out.println("No lessons recorded for the course: " + course.getName());
            return;
        }
        System.out.println("put marks for Student:" + student.getUsername());
        
        Mark previesMark = student.getTranscript().get(course);
        if (previesMark != null) {
        	System.out.println("Previous marks Student: " + student.getUsername());
        }
        else {
        	System.out.println("new marks for Student: " + student.getUsername());
        }
        
        while(true) {
        	System.out.println("First attestation: ");
        	double attestation1 = input.nextDouble();
        	
        	System.out.println("Second attestation: ");
        	double attestation2 = input.nextDouble();
        	
        	System.out.println("Final exam: ");
        	double finalExam = input.nextDouble();
        	
        	if (attestation1 > 30 || attestation2 > 30 || (attestation1 + attestation2) > 60 || finalExam > 40) {
        		System.out.println("Error: please write marks correctly");
        	}
        	else {
        		Mark newMark = new Mark(attestation1, attestation2, finalExam);
        		student.getTranscript().put(course, newMark);
        		System.out.println("The grades have been submitted successfully!");
        		break;
        	}
        }
    }

    public void putMarks() {
    	System.out.println("Select s course to input marks: ");
    	
    	if(courses.isEmpty()) {
    		System.out.println("You are not assigned to any courses");
    		return;
    	}

    	for (int i = 0; i<courses.size(); i++) {
    		Course c = courses.get(i);
    		System.out.println((i + 1) + ". " + c.getName());
    	}
    	System.out.println();
    	
    	int courseChoice = StaticMethods.validate(courses.size());
    	
    	if (courseChoice == 0) {
    		return;
    	}
    	Course selectedCourse = courses.get(courseChoice-1);
    	
    	Vector <Lesson> courseLessons = lessons.get(selectedCourse);
    	if (courseLessons.isEmpty()) {
    		System.out.println("No lessons recorded for the course");
    		return;
    	}
    	
    	
    	Vector <Student> students = Database.getInstance().getStudents().stream()
    			.filter(s -> s.getCourses().contains(selectedCourse))
    			.collect(Collectors.toCollection(Vector::new));
    			
    	if(students.isEmpty()) {
    		System.out.println("No student enrolled in " + selectedCourse.getName());
    		return;
    	}
    	
    	System.out.println("Select a student to input marks:");
    	System.out.println("Students enrolled in " + selectedCourse.getName() + ":");
    	
    	StaticMethods.printList(students);
    	
    	System.out.println("Choose a student or enter 0 to exit");
    	int studentChoice = StaticMethods.validate(students.size());
    	
    	if (studentChoice == 0) {
    		return;
    	}
    	Student selectedStudent = Database.getInstance().getStudents().get(studentChoice);
    	
    	Mark previousMark = selectedStudent.getTranscript().get(selectedCourse);
    	
    	if(previousMark != null) {
    		System.out.println("Previous marks for student: " + selectedStudent.getUsername() + ": " + previousMark.toString());
    	}
    	else {
    		System.out.println("New marks for student: " + selectedStudent.getUsername());
    		
    		Scanner input = new Scanner(System.in);
        	while(true) {
        		
        		System.out.println("First attestation: ");
        		double attestation1 = Math.abs(input.nextDouble());
        		
        		System.out.println("Second attestation: ");
        		double attestation2 = Math.abs(input.nextDouble());
        		
        		System.out.println("Final exam: ");
        		double finalExam = Math.abs(input.nextDouble());
        		
        		if(attestation1 + attestation2 > 60 || finalExam > 40) {
        			System.out.println("Error: please enter marks correctly!");
        		}
        		else {
        			Mark newMark = new Mark(attestation1, attestation2, finalExam);
        			selectedStudent.getTranscript().put(selectedCourse, newMark);
        			System.out.println("The marks have been submitted succesfully");
        			break;
        		}
        	}
    	}
    }
    @Override
    public void viewMenu() {
    	
    	String[] options = new String[] { "View courses", "View students", "View marks","Put marks",
    										"View rate","View one News", "Send order", "Send request", "Exit" };
    	
    	
    	while (true) {
    		System.out.println();
    		System.out.println("----Teacher Menu----");
    		StaticMethods.printList(List.of(options));
        	int choice = StaticMethods.validate(options.length);
    		
    		if (choice == 1) {
    			viewCourses();
    		}
    		else if(choice == 2) {
    			viewStudents();
    		}
    		else if (choice == 3) {
    			viewMarks();
    		}
    		else if (choice == 4) {
    			putMarks();
    		}
    		else if (choice == 5) {
    			viewRate();
    		}
    		else if (choice == 6) {
    			viewOneNews();
    		}
    		else if (choice == 7) {
    			sendOrder();
    		}
    		else if (choice == 8) {
    			sendRequest();
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


    public void viewRate() {
        System.out.println("Teacher's rating: " + rate);
    }


	@Override
	public String toString() {
		return "Teacher [typeTeacher=" + typeTeacher + " courses=" + lessons + ", faculty=" + this.faculty + "] " + super.toString();
	}

    
    

}
