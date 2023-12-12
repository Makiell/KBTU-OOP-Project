package wsp;
import java.util.*;

import database.Database;
import utils.*;
import wsp.*;
import enums.*;

public class Student extends User {
	Vector<Course> courses = new Vector<Course>();
	Integer gpa = null;
	Map<Course, Mark> transcript = new HashMap<Course, Mark>();
	Faculty faculty;
//	Vector<Journal> journals;
	Organisation organisation = null;
	
	public Student(String username, String password, String firstName, String lastName, Faculty faculty) {
		super(username, password, firstName, lastName);
		this.faculty = faculty;
	}
	
	public Vector<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public void setGpa(Integer gpa) {
		this.gpa = gpa;
	}
	
	public Map<Course, Mark> getTranscript() {
		return transcript;
	}
	
	public void setTranscript(Map<Course, Mark> transcript) {
		this.transcript = transcript;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
//	public Vector<Journal> getJournals() {
//		return journals;
//	}
//	
//	public void setJournals(Vector<Journal> journals) {
//		this.journals = journals;
//	}
//	
	public Organisation getOrganisation() {
		return organisation;
	}
	
	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}
	@Override
	public String toString() {
		return "Student[" + "username=" + getUsername()  +
				", password="+ this.getPassword() +", courses=" + courses +
				", gpa=" + gpa +
				", transcript=" + transcript +
				", faculty=" + faculty +
				", organisation=" + organisation +
				']';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Student student)) return false;
		if (!super.equals(o)) return false;
        return Objects.equals(courses, student.courses) && Objects.equals(gpa, student.gpa) && Objects.equals(transcript, student.transcript) && faculty == student.faculty && Objects.equals(organisation, student.organisation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), courses, gpa, transcript, faculty, organisation);
	}

	public void viewTranscript() {
		System.out.println("Transcript:");
		for (Map.Entry<Course, Mark> entry : transcript.entrySet()) {
		    System.out.println(entry.getKey() + " - " + entry.getValue().toString());
		}
	}
	
	public void viewMarks(Course course) {
	    if (!courses.contains(course)) {
	        System.out.println("Student not registered in course");
	        return;
	    }
	    Mark mark = transcript.get(course);
	    if (mark == null) {
	        System.out.println("Course doesnt have marks");
	        return;
	    }
	    System.out.println("Course: " + course.getName() + " Mark: " + mark);
	}
	
	
	public void registerToCourse(Course course) {
	    if (courses.contains(course)) {
	        System.out.println("Already registered");
	    } else {
	        courses.add(course);
	        transcript.put(course, new Mark());
	        System.out.println("Registration successful");
	        for(Course c: courses) {
	        	System.out.println(c);
	        }
	    }
	}
//	public void viewTeacherForCourse(Course course) {
//	    if (!courses.contains(course)) {
//	        System.out.println("Student not registered for this course");
//	        return;
//	    }	    
//	   Vector<Teacher> teachers = course.getTeachers();
//	   if (teachers == null || teachers.isEmpty()) {
//	        System.out.println("No teachers");
//	        return;
//	    }
//	    System.out.println("Teachers for course " + course.getName() + ":");
//	    for (Teacher teacher : teachers) {
//	        System.out.println(teacher.getName() + " (" + teacher.getRole() + ")");
//	    }
//	}
	public void viewCourses() {
	    Vector<Course> databaseCourses = Database.getCourses();
	    System.out.println("Courses:");
	    for (Course course : databaseCourses) {
	        System.out.println("- " + course.getName());
	    }
	}

	public void viewMenu() {
		while(true) {
			String[] options = new String[]{
			        "View Transcript",
			        "View Marks for a Course",
			        "Register for a Course",
			        "View Teacher for a Course",
			        "View All Courses",
			        "Exit"
			    };
				Scanner Scanner = new Scanner(System.in);
			    System.out.println("\nStudent Menu:");
			    for (int i = 0; i < options.length; i++) {
			        System.out.println((i + 1) + ". " + options[i]);
			    }
			    System.out.print("Enter your choice: ");
			    int choice = Integer.parseInt(Scanner.nextLine());
			    if (choice == 1) {
			        viewTranscript();
			    }
//			    } else if (choice == 2) {
//			        viewMarks(Course course);
//			    } else if (choice == 3) {
//			        registerToCourse(Course course);
//			    } else if (choice == 4) {
//			        viewTeacherForCourse(Course course);
//			    } else if (choice == 5) {
//			        viewCourses();
//			    } else if (choice == 6) {
//			    	
//			    }
		}
		
	}

	@Override
	public void viewNews() {
		// TODO Auto-generated method stub
		
	}
	public void rateTeachers(Map<Teacher,  Integer> ratings) {
		for (Map.Entry<Teacher, Integer> entry : ratings.entrySet()) {
			Teacher teacher = entry.getKey();
			Integer rating = entry.getValue();
		}
	}
	public void joinOrganisation(Organisation organisation) {
		organisation.addMember(this);
		this.organisation = organisation;
	}
	public void leaveOrganisation(Organisation organisation) {
		organisation.removeMember(this);
		this.organisation = null;
	}
	public void createOrganisation(String name, Student head) {
		Organisation organisation = new Organisation(name, head);
		this.organisation = organisation;
		organisation.addMember(this);
	}
}