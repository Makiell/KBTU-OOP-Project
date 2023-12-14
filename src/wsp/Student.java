package wsp;
import java.util.*;

import database.*;
import utils.*;
import wsp.*;
import enums.*;

public class Student extends User {
	Vector<Course> courses = new Vector<Course>();
	Integer gpa = null;
	Map<Course, Mark> transcript = new HashMap<Course, Mark>();
	Faculty faculty;
//	Vector<Journal> journals;
	Organisation organisation;


    public Student(String username, String password, String firstName, String lastName, Faculty faculty) {
		super(username, password, firstName, lastName);
		this.faculty = faculty;
        this.organisation = new Organisation();
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
				", organisation=" + organisation.getName() +
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

	public void viewMarks() {
        int i = 1;
        int nextI = 1;
        for(Course c: courses){
            System.out.println(i + " - "+ c);
            i = ++nextI;
        }
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your choice:");
        int coursechoice = s.nextInt();
        Course course = courses.get(coursechoice - 1);
	    if (!courses.contains(course)) {
	        System.out.println("Student not registered in course");
	        return;
	    }
	    Mark mark = transcript.get(course);
	    if (mark == null) {
	        System.out.println("Course doesnt have marks");
	        return;
	    }
	    System.out.println("Course: " + course.getName() + " Mark: " + mark.toString());
	}
	public void getCourseFromDB(){
         Vector<Course> databasecourses = Database.getInstance().getCourses();
         Vector<Course> aftercourses = new Vector<>();
         for(Course c: databasecourses){
            if(!courses.contains(c)){
                aftercourses.add(c);
            }
         }
        int i = 1;
        int nextI = 1;
         for(Course c: aftercourses){
            System.out.println(i + " - " + c);
            i = ++nextI;
         }
         Scanner s  = new Scanner(System.in);
         int coursechoice;
         while(true){
             coursechoice = s.nextInt();
             if(coursechoice <= aftercourses.size() && coursechoice >=1){
                 break;
             }
             else{
                 System.out.println("Please enter number from 1 to " + aftercourses.size());
             }
         }
         registerToCourse(aftercourses.get(coursechoice-1));
    }

	public void registerToCourse(Course course) {
        if(!courses.contains(course)) {
            this.courses.add(course);
            System.out.println("Course " + course.getName() + " registration successful!");
        }
        else{
            System.out.println("You already registered this course");
        }
	}
/*	public void viewTeacherForCourse(Course course) {
	    if (!courses.contains(course)) {
	        System.out.println("Student not registered for this course");
        return;
    }
	   Vector<Teacher> teachers = course.getTeachers();
	   if (teachers == null || teachers.isEmpty()) {
	        System.out.println("No teachers");
	        return;
	    }
	    System.out.println("Teachers for course " + course.getName() + ":");
	    for (Teacher teacher : teachers) {
        System.out.println(teacher.getName() + " (" + teacher.getRole() + ")");
	    }
	}
	*/
	public void viewCourses() {
	    Vector<Course> databaseCourses = Database.getInstance().getCourses();
	    System.out.println("Courses:");
        int i = 1;
        int nextI = 1;
	    for (Course course : databaseCourses) {
            if(!courses.contains(course)){
                System.out.println(i + " - " + course.getName());
                i = ++nextI;
            }
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
	public void joinOrganisation() {
        int i = 1;
        int nextI = 1;
        System.out.println("List of organisation:");
        Vector<Organisation> dborganisations = Database.getInstance().getOrganisations();
        for(Organisation o: dborganisations){
            System.out.println(i + " - "  + o);
            i = ++nextI;
        }
        Scanner s = new Scanner(System.in);
        if(!dborganisations.isEmpty()) {
            int orgchoice;
            if(!dborganisations.isEmpty()){
            while(true) {
                orgchoice = s.nextInt();
                if (orgchoice <= dborganisations.size() && orgchoice >= 1) {
                    break;
                } else {
                    System.out.println("Please enter number from 1 to " + dborganisations.size());
                }
            }
            }
        }else {
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
        Database.getInstance().addOrganisations(organisation);
	}
    public void viewMenu() {
        while (true) {
            String[] options = new String[]{
                    "View Transcript",
                    "View Marks for a Course",
                    "Register for a Course",
                    "View Teacher for a Course",
                    "View All Courses",
                    "Rate Teachers",
                    "Organisation",
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
			    }// else if (choice == 6) {
//			    	rateTeachers(null, null);
//			    }
              else if (choice == 7) {
                System.out.println("Please enter your choice:");
                System.out.println("1 - Join in a organisation");
                System.out.println("2 - Leave in a organisation");
                System.out.println("3 - Create in a organisation");
                int choiceorg = Integer.parseInt(Scanner.nextLine());
                if (choiceorg == 1) {
                    joinOrganisation();
                } else if (choiceorg == 2) {
                    leaveOrganisation();

                } else if (choiceorg == 3) {
                    createOrganisation();
                }
                else{}
            }
			    else if(choice == 8){
                break;
            }
        }
    }
}
