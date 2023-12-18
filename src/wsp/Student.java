package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import database.*;
import utils.*;
import wsp.*;
import enums.*;

public class Student extends User implements Serializable {
	Vector<Course> courses;
	Integer gpa = null;
	HashMap<Course, Mark> transcript;
	Faculty faculty;
//	Vector<Journal> journals;
	Organisation organisation;

	public Student(String username, String password, String firstName, String lastName, Faculty faculty) {
		super(username, password, firstName, lastName);
		this.faculty = faculty;
		this.organisation = null;
		this.courses = new Vector<Course>();
		this.transcript = new HashMap<Course, Mark>();
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

	public void setTranscript(HashMap<Course, Mark> transcript) {
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
		return "Student [courses=" + courses
				+ ", gpa=" + gpa + ", transcript=" + transcript + ", faculty=" + faculty + ", organisation="
				+ organisation + "] " + super.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Student student))
			return false;
		if (!super.equals(o))
			return false;
		return Objects.equals(courses, student.courses) && Objects.equals(gpa, student.gpa)
				&& Objects.equals(transcript, student.transcript) && faculty == student.faculty
				&& Objects.equals(organisation, student.organisation);
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
		
		int coursechoice = validate(courses.size());
		
		Course course = courses.get(coursechoice - 1);

		Mark mark = transcript.get(course);
		if (mark == null) {
			System.out.println("Course doesnt have marks");
			return;
		}
		else {
			System.out.println("Course: " + course.getName() + " Mark: " + mark.toString());
		}
		
	}

	public void getCourseFromDB() {
		if(Database.getInstance().getCourses().isEmpty()) {
			System.out.println("No courses yet...");
			return;
		}
		
		Vector<Course> databasecourses = Database.getInstance().getCourses();
		Vector<Course> coursesToShow = databasecourses.stream()
												      .filter(c -> !courses.contains(c))
												      .collect(Collectors.toCollection(Vector::new));
		
		printList(coursesToShow);
		
		int coursechoice = validate(coursesToShow.size());
		
		registerToCourse(coursesToShow.get(coursechoice - 1));
	}

	public void registerToCourse(Course course) {
		this.courses.add(course);
		this.transcript.put(course, new Mark());
		System.out.println("Course " + course.getName() + " registration successful!");
	}

	/*
	 * public void viewTeacherForCourse(Course course) { if
	 * (!courses.contains(course)) {
	 * System.out.println("Student not registered for this course"); return; }
	 * Vector<Teacher> teachers = course.getTeachers(); if (teachers == null ||
	 * teachers.isEmpty()) { System.out.println("No teachers"); return; }
	 * System.out.println("Teachers for course " + course.getName() + ":"); for
	 * (Teacher teacher : teachers) { System.out.println(teacher.getName() + " (" +
	 * teacher.getRole() + ")"); } }
	 */
	
	public void viewCourses() {
		
		if(Database.getInstance().getCourses().isEmpty()) {
			System.out.println("No courses yet...");
		}

		System.out.println("Courses:");
		printList(Database.getInstance().getCourses());
	}

	private void printList(List list) {
		for(int i = 0; i<list.size(); i++) {
			System.out.println(i+1+ "." + list.get(i));
		}
	}

	@Override
	public void viewNews() {
		// TODO Auto-generated method stub

	}

	public void rateTeachers(Map<Teacher, Integer> ratings) {
		for (Map.Entry<Teacher, Integer> entry : ratings.entrySet()) {
			Teacher teacher = entry.getKey();
			Integer rating = entry.getValue();
		}
	}
	
	
	private int validate(int n) {
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		while (!(1 <= choice && choice <= n)) {
			System.out.println("Please enter number from 1 to " + n);
		}

		return choice;
	}
	
	public void organisationMenu() {
		System.out.println("Please enter your choice:");
		System.out.println("1 - Join in a organisation");
		System.out.println("2 - Leave in a organisation");
		System.out.println("3 - Create in a organisation");
		int choiceorg = validate(3);
		if (choiceorg == 1) {
			joinOrganisation();
		} 
		else if (choiceorg == 2) {
			leaveOrganisation();
		} 
		else if (choiceorg == 3) {
			createOrganisation();
		}
	}

	public void joinOrganisation() {
		int i = 1;
		int nextI = 1;
		System.out.println("List of organisation:");
		Vector<Organisation> organisations = Database.getInstance().getOrganisations();
		
		organisations.remove(this.organisation);
		for (Organisation o : organisations) {
			System.out.println(i + " - " + o);
			i = ++nextI;
		}
		
		
		if (!organisations.isEmpty()) {

			int orgchoice = validate(organisations.size());
			
			Organisation organisation = organisations.get(orgchoice - 1);

			if(this.organisation != null) {
				this.organisation.removeMember(this);
			}
			
			this.organisation = organisation;
			organisation.addMember(this);
			
		} 
		else {
			System.out.println("At the moment we dont have any organisations");
		}
	}

	public void leaveOrganisation() {
		organisation.removeMember(this);
		this.organisation = null;
	}

	public void createOrganisation() {
		Scanner s = new Scanner(System.in);
		System.out.println("Name your organisation:");
		String name = s.nextLine();
		Organisation organisation = new Organisation(name, this);
		this.organisation = organisation;
		Database.getInstance().addOrganisation(organisation);
		s.close();
	}
	
	public void changeInfo() {
		
	}

	public void viewMenu() {
		while (true) {
			String[] options = new String[] { "View Transcript", "View Marks for a Course", "Register for a Course",
					"View Teacher for a Course", "View All Courses", "Rate Teachers", "Organisation", "Exit" };
			
			System.out.println("\nStudent Menu:");
			for (int i = 0; i < options.length; i++) {
				System.out.println((i + 1) + ". " + options[i]);
			}
			
			System.out.print("Enter your choice: ");
			int choice = this.validate(options.length);
			
			if (choice == 1) {
				viewTranscript();
			}
			else if (choice == 2) {
				viewMarks();
			} 
			else if (choice == 3) {
				getCourseFromDB();
			}

//         else if (choice == 4) {
//                System.out.println("Please select course(1-n):");
//                for(Course c: courses){
//                    System.out.println(c);
//                }
//                int coursechoice = Integer.parseInt(Scanner.nextLine());
//                viewTeacherForCourse(Database.courses(coursechoice-1));
//			    }
			else if (choice == 5) {
				viewCourses();
			} // else if (choice == 6) {
//			    	rateTeachers(null, null);
//			    }
			else if (choice == 7) {
				organisationMenu();
			} 
			else if (choice == 8) {
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
}
