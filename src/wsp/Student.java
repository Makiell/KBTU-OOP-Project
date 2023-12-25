package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import database.*;
import utils.*;
import wsp.*;
import enums.*;


/**
 * The Student class represents a student in the academic system.
 * It extends the User class and implements the Comparable interface.
 * It provides functionalities for viewing transcript, marks, courses,
 * teachers, all courses, subscribed journals, rating teachers, organization-related actions,
 * viewing news, subscribing journals, viewing all papers, and accessing the researcher menu.
 */
public class Student extends User implements Serializable, Comparable<Student> {
	
	private static final long serialVersionUID = -1763612314337268589L;
	
    private Vector<Course> courses;
    private Double gpa = null;
    private HashMap<Course, Mark> transcript;
    private Faculty faculty;
    private Organisation organisation;

    
    /**
     * Constructs a Student object with the specified attributes.
     *
     * @param username The username of the student.
     * @param password The password of the student.
     * @param firstName The first name of the student.
     * @param lastName The last name of the student.
     * @param faculty The faculty of the student.
     */
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
    	calculateGpa();
        return gpa != null ? gpa.doubleValue() : 0.0;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa != null ? gpa : 0.0;
    }
    
    /**
     * Calculates the GPA of the student based on the transcript.
     */
    public void calculateGpa() {
    	double sum = 0;
    	double sumCredit = 0;
    	for(Map.Entry<Course, Mark> entry: transcript.entrySet()) {
    		Mark mark = entry.getValue();
    		Course course = entry.getKey();
    		sum += mark.getGpa()*course.getCredits();
    		sumCredit += course.getCredits();
    	}
    	this.gpa = sum / sumCredit;
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

    public int compareTo(Student s) {
        if(this.gpa > s.gpa) return 1;
        if(this.gpa < s.gpa) return -1;
        return 0;
    }

    /**
     * Views the transcript of the student.
     */
    public void viewTranscript() {
        System.out.println("Transcript:");
        for (Map.Entry<Course, Mark> entry : transcript.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        }
        Database.getInstance().addLog(this, new Log("Student " + this.getUsername() + " viewed Transcript"));
    }

    /**
     * Views the marks for a specific course chosen by the student.
     */
    public void viewMarks() {
        if(courses.isEmpty()) {
            System.out.println("No courses");
            return;
        }
        else{
            StaticMethods.printList(courses);
        }

        System.out.println("Please enter your choice:");

        System.out.println("Enter 0 to return back");
        int coursechoice = StaticMethods.validate(courses.size());

        if(coursechoice == 0) {
            return;
        }

        Course course = courses.get(coursechoice - 1);

        Mark mark = transcript.get(course);
        if (mark == null) {
            System.out.println("Course doesnt have marks");
            return;
        }
        else {
            System.out.println("Course: " + course.getName() + " Mark: " + mark.toString());
            Database.getInstance().addLog(this, new Log("Student " + this.getUsername()+ " viewed Marks for Course " + course.getName()));
        }

    }

    /**
     * Retrieves a course from the database and registers the student for that course.
     */
    public void getCourseFromDB() {
        if(Database.getInstance().getCourses().isEmpty()) {
            System.out.println("No courses yet...");
            return;
        }

        Vector<Course> databasecourses = Database.getInstance().getCourses();
        Vector<Course> coursesToShow = databasecourses.stream()
                .filter(c -> !courses.contains(c))
                .collect(Collectors.toCollection(Vector::new));

        StaticMethods.printList(coursesToShow);

        System.out.println("Enter 0 to return back");
        int coursechoice = StaticMethods.validate(coursesToShow.size());
        if(coursechoice == 0) {
            return;
        }

        registerToCourse(coursesToShow.get(coursechoice - 1));
    }

    /**
     * Registers the student for a specific course.
     * This method exists separately so that in the future it may be 
     * possible to register students for the course through managers
     */
    public void registerToCourse(Course course) {
        this.courses.add(course);
        this.transcript.put(course, new Mark());
        System.out.println("Course " + course.getName() + " registration successful!");
        Database.getInstance().addLog(this, new Log("Student " + this.getUsername() + " registrated to course " + course.getName()));
    }

    /**
     * Views the teacher for a specific course chosen by the student.
     */
    public void viewTeacherForCourse() {
    	if(this.courses.isEmpty()) {
    		System.out.println("No courses");
    		return;
    	}
        System.out.println("All courses:");
        StaticMethods.printList(courses);
        int coursechoice = StaticMethods.validate(courses.size());
        Course course = courses.get(coursechoice - 1);
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
            System.out.println(teacher.toString() + " (" + teacher.getTypeTeacher() + ")");
            Database.getInstance().addLog(this, new Log("Student " + this.getUsername() + " viewed all Teachers"));
        }
    }


    /**
     * Views all the courses available in the system.
     */
    public void viewCourses() {

        if(Database.getInstance().getCourses().isEmpty()) {
            System.out.println("No courses yet...");
        }

        System.out.println("Courses:");
        StaticMethods.printList(Database.getInstance().getCourses());
        Database.getInstance().addLog(this, new Log("Student " + this.getUsername() + " viewed All courses"));
    }

    /**
     * Rates teachers by providing an assessment.
     */
    public void rateTeachers() {
        System.out.println("All Teachers:");
        Vector<Teacher> teachers = Database.getInstance().getTeachers();

        StaticMethods.printList(teachers);

        System.out.println("Please select the teacher you want to evaluate:");
        
        int teacherchoice = StaticMethods.validate(1, teachers.size());
        Teacher teacher = teachers.get(teacherchoice - 1);
        
        System.out.println("Your assessment of this teacher:");
        
        int rate = StaticMethods.validate(10);
        
        teacher.setRate(rate);
        
        Database.getInstance().addLog(this, new Log("Student " + this.getUsername()+ " appreciated teacher " + teacher.getFirstName() + " " + teacher.getLastName()));
    }
    
    /**
     * Displays the organization-related menu, providing options to join, leave, or create an organization.
     */
    public void organisationMenu() {
        System.out.println("Please enter your choice:");
        System.out.println("1 - Join in a organisation");
        System.out.println("2 - Leave in a organisation");
        System.out.println("3 - Create in a organisation");
        System.out.println("Enter 0 to return back");
        int choiceorg = StaticMethods.validate(3);
        if(choiceorg == 0) {
            return;
        }
        else if (choiceorg == 1) {
            joinOrganisation();

        }
        else if (choiceorg == 2) {
            leaveOrganisation();
        }
        else if (choiceorg == 3) {
            createOrganisation();
        }
    }

    
    /**
     * Joins an existing organization chosen by the student.
     */
    public void joinOrganisation() {
    	
        Vector<Organisation> organisations = Database.getInstance().getOrganisations();

        organisations.remove(this.organisation);


        if (!organisations.isEmpty()) {
        	
        	System.out.println("List of organisation:");
        	StaticMethods.printList(organisations);
            System.out.println("Enter 0 to return back");
            int orgchoice = StaticMethods.validate(organisations.size());

            if(orgchoice == 0) {
                return;
            }

            Organisation organisation = organisations.get(orgchoice - 1);

            if(this.organisation != null) {
                this.organisation.removeMember(this);
            }

            this.organisation = organisation;
            organisation.addMember(this);
            Database.getInstance().addLog(this, new Log("Student " + this.getUsername() + " viewed joined organisation" + organisation.getName()));
        }
        else {
            System.out.println("At the moment we dont have any organisations");
        }
    }

    
    /**
     * Leaves the current organization of the student.
     */
    public void leaveOrganisation() {
    	if(this.organisation == null) {
    		System.out.println("You are not in organisation.");
    		return;
    	}
        organisation.removeMember(this);
        this.organisation = null;
        Database.getInstance().addLog(this, new Log("Student " + this.getUsername() + " viewed left organisation" + organisation.getName()));
    }

    /**
     * Creates a new organization with the student as the creator and a specified name.
     */
    public void createOrganisation() {
        Scanner s = new Scanner(System.in);
        System.out.println("Name your organisation:");
        String name = s.nextLine();
        Organisation organisation = new Organisation(name, this);
        this.organisation = organisation;
        Database.getInstance().addOrganisation(organisation);
        Database.getInstance().addLog(this, new Log("Student " + this.getUsername()+ " viewed created organisation" + organisation.getName()));
    }

    
    /**
     * Changes the information of the student, such as username, password, first name, or last name.
     */
    public void changeInfo() {
        System.out.println("What do you want to change?");

        String[] options = new String[] {
                "Username", "Password", "First name", "Last name"
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

    }

    
    /**
     * Displays the student's menu, allowing them to perform various actions such as viewing transcripts, marks,
     * registering for courses, viewing teachers for courses, viewing all courses, viewing subscribed journals,
     * rating teachers, accessing the organization menu, viewing news, subscribing to a journal, viewing all papers,
     * and exiting. 
     * If the student is also a researcher, an additional option to view the researcher menu is available.
     */
    public void viewMenu() {
        while (true) {
        	String[] options;
			
			Researcher researcher = Database.getInstance().isResearcher(this);
			
			if(researcher != null) {
				options = new String[] { "View Transcript", "View Marks for a Course", "Register for a Course",
						"View Teacher for a Course", "View All Courses", "View subscribed journals", "Rate Teachers", "Organisation", "View one News", "Subscribe journal", "View all papers", "Exit", "View researcher menu" };
			}
			else {
				options = new String[] { "View Transcript", "View Marks for a Course", "Register for a Course",
						"View Teacher for a Course", "View All Courses", "View subscribed journals", "Rate Teachers", "Organisation", "View one News", "Subscribe journal", "View all papers", "Exit" };
			}
			
            System.out.println("\n----Student Menu----");
            StaticMethods.printList(List.of(options));

            System.out.print("Enter your choice: ");
            int choice = StaticMethods.validate(1, options.length);

            if (choice == 1) {
                viewTranscript();
            }
            else if (choice == 2) {
                viewMarks();
            }
            else if (choice == 3) {
                getCourseFromDB();
            }
            else if (choice == 4) {
                viewTeacherForCourse();
            }
            else if (choice == 5) {
                viewCourses();
            } 
            else if(choice == 6) {
            	viewJournals();
            }
            else if (choice == 7) {
                rateTeachers();
            }
            else if (choice == 8) {
                organisationMenu();
            }
            else if (choice == 9) {
                viewOneNews();
                Database.getInstance().addLog(this, new Log("Student " + this.getUsername() + " viewed a one News"));
            }
            else if(choice == 10) {
            	StaticMethods.subscribeJournal(this);
            }
            else if(choice == 11) {
            	Database.getInstance().getAllPapers();
            }
            else if (choice == 12) {
                try {
                    Database.getInstance().saveDatabase();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            }
            else if(researcher != null) {
				if(choice == 13) {
					researcher.viewMenu();
                    Database.getInstance().addLog(this, new Log("Student " + this.getUsername() + " went to the researcher menu"));
				}
			}
        }
    }
    
    
}
