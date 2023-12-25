package wsp;

import database.Log;
import enums.*;
import utils.*;
import database.Database;

import javax.xml.crypto.Data;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The Manager class represents a manager in the academic system.
 * It extends the Employee class and provides functionalities specific to managers.
 */
public class Manager extends Employee{
	
	private TypeManager typeManager;

	 /**
     * Constructs a Manager object with the specified parameters.
     *
     * @param username    The username of the manager.
     * @param password    The password of the manager.
     * @param firstName   The first name of the manager.
     * @param lastName    The last name of the manager.
     * @param typeManager The type of manager (e.g., Academic Manager, Research Manager).
     */
	public Manager(String username, String password, String firstName, String lastName, TypeManager typeManager) {
		super(username, password, firstName, lastName);
		this.typeManager = typeManager;
	}
	
	/**
     * Gets the type of manager (e.g., Academic Manager, Research Manager).
     *
     * @return The type of manager.
     */
	public TypeManager getTypeManager() {
		return typeManager;
	}

	/**
     * Sets the type of manager (e.g., Academic Manager, Research Manager).
     *
     * @param typeManager The new type of manager to set.
     */
	public void setTypeManager(TypeManager typeManager) {
		this.typeManager = typeManager;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Manager manager = (Manager) o;
		return typeManager == manager.typeManager;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), typeManager);
	}

	/**
     * Creates a statistical report based on the GPA distribution of students and the highest h-index researcher.
     */
	public void createStatisticReport() {
        Vector<Student> students = Database.getInstance().getStudents();
        Vector<Researcher> researchers = Database.getInstance().getResearchers();
        int gpamax = 0;
        int gpahigh = 0;
        int gpamedium = 0;
        int countother = 0;
        Researcher maxResearcher = researchers.get(0);
        for(int i  = 1; i < researchers.size(); i++){
            Researcher curResearcher = researchers.get(i);
            if(curResearcher.calculatehIndex() > maxResearcher.calculatehIndex()){
                maxResearcher = curResearcher;
            }
        }
        for(Student s: students){
            if(s.getGpa() == 4.00){
                gpamax++;
            }
            else if( s.getGpa() < 4.00 && s.getGpa() >= 3.00){
                gpahigh++;
            }
            else if(s.getGpa() < 3.00 && s.getGpa() >= 2.00){
                gpamedium++;
            }
            else if(s.getGpa() < 2.00){
                countother++;
            }
        }

		System.out.println("The number of students with GPA 4.0:" + gpamax);
        System.out.println("The number of students with GPA from 3.99 to 3.00:" + gpahigh);
        System.out.println("The number of students with GPA from 2.99 to 2.00:" + gpamedium);
        System.out.println("The number of students with GPA is less than 2.00:" + countother);
		System.out.println("The researcher with the highest H-index:" + maxResearcher.toString());
        Database.getInstance().addLog(this, new Log("Manager " + this.getUsername() + " created statistic report"));
	}

	 /**
     * Adds a new course to the system. Takes input from the manager for course details.
     */
	public void addCourse() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter 0 to return back.");
		System.out.println("Enter the number of credits of the course: ");
		
		int input = StaticMethods.validate(10);
		
		if(input == 0) {
			return;
		}
		
		System.out.println("Enter name of course:");
		String name = in.nextLine();
		
		System.out.println("Choose for which faculty is this course:");
		Faculty[] options = Faculty.values();
		StaticMethods.printList(List.of(options));
		int facultyChoice = StaticMethods.validate(1, options.length);
		Faculty faculty = options[facultyChoice-1];
		
		System.out.println("Choose type of this course for " + faculty + ":");
		TypeCourse[] optionsType = TypeCourse.values();
		StaticMethods.printList(List.of(optionsType));
		int typeCourse = StaticMethods.validate(1, optionsType.length);
		TypeCourse type = optionsType[typeCourse-1];
		
		Course newCourse = new Course(input, name, type, faculty);
		
		Database.getInstance().addCourse(newCourse);
		
		System.out.println("Course added " + newCourse);

        Database.getInstance().addLog(this, new Log("Manager " + this.getUsername() + " added new Course " + newCourse.getName()));

	}
	
	/**
     * Changes the information of the manager, including username, password, first name, last name, and type.
     */
	public void changeInfo() {
    	System.out.println("What do you want to change?");
		
		String[] options = new String[] {
				"Username", "Password", "First name", "Last name", "Type"
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
			System.out.println("Choose type:");
	        
	        TypeManager[] optionsType = TypeManager.values();
	        
	        StaticMethods.printList(List.of(optionsType));
	        
	        int choiceType = StaticMethods.validate(optionsType.length);
	        
	        TypeManager type = optionsType[choiceType-1];
	        
	        this.typeManager = type;
		}
    }
	
	/**
     * Creates a news entry in the system. Takes input from the manager for news details.
     */
	public void createNews() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("News topic:");
		String topic = s.nextLine();
		
		System.out.println("News title:");
		String title = s.nextLine();
		
		System.out.println("News text:");
		String text = s.nextLine();
		
		News newNews = new News(topic, title, text);
		
		Database.getInstance().addNews(newNews);
        Database.getInstance().addLog(this, new Log("Manager " + this.getUsername() + " create new News"));
	}

	/**
     * Views all requests in the system.
     */
	public void viewRequests() {
		Vector<Request> dbrequests = Database.getInstance().getRequests();
		System.out.println("List of Requests:");
		StaticMethods.printList(dbrequests);
        Database.getInstance().addLog(this, new Log("Manager " + this.getUsername() + " viewed all requests"));
	}

	/**
     * Edits an existing news entry. Allows the manager to modify the topic, title, or text of the news.
     */
	public void editNews() {
		System.out.println("What news do you want to change?");
		Scanner s = new Scanner(System.in);
		
		Vector<News> dbnews = Database.getInstance().getNews();
		StaticMethods.printList(dbnews);
		System.out.println("Enter 0 to return back");
		
		int newschoice = StaticMethods.validate(dbnews.size());
		
		if(newschoice == 0) {
			return;
		}
		
		News news = dbnews.get(newschoice - 1);
		
		System.out.println("Which of part do you want to change?" + "\n 1 - Topic" + "\n 2 - Title"
				+ "\n 3 - Text" + "\n 0 - exit");
		
		int editchoice = StaticMethods.validate(3);

		if (editchoice == 1) {
			System.out.println("Enter new topic:");
			String topic = s.nextLine();
			news.setTopic(topic);
			System.out.println("Update news:" + news.toString());
            Database.getInstance().addLog(this, new Log("Manager " + this.getUsername() + " updated the news topic " + news.getTitle()));
		} 
		else if (editchoice == 2) {
			System.out.println("Enter new title:");
			String title = s.nextLine();
			news.setTitle(title);
			System.out.println("Update news:" + news.toString());
            Database.getInstance().addLog(this, new Log("Manager " + this.getUsername() + " updated the news title " + news.getTitle()));
		} 
		else if (editchoice == 3) {
			System.out.println("Enter new text:");
			String text = s.nextLine();
			news.setText(text);
			System.out.println("Update news:" + news.toString());
            Database.getInstance().addLog(this, new Log("Manager " + this.getUsername() + " updated the news text " + news.getTitle()));
		} 
		else if (editchoice == 0) {
			return;
		}

	}

	/**
     * Assigns a course to a teacher. Allows the manager to choose a course and a teacher for the assignment.
     */
	public void assignCourseForTeacher() {
		System.out.println("Enter 0 to return back.");
		System.out.println("Which course you want to assign:");
		
		Vector<Course> courses = Database.getInstance().getCourses();
		
		StaticMethods.printList(courses);
		
		int courseChoice = StaticMethods.validate(courses.size());
		
		if(courseChoice == 0) {
			return;
		}
		
		Course course = courses.get(courseChoice-1);
		
		System.out.println("Which teacher would you like to assign the " + course.getName() + " course to?");
		
		Vector<Teacher> teachers = Database.getInstance().getTeachers();
		
		StaticMethods.printList(teachers);
		
		int teacherChoice = StaticMethods.validate(1, teachers.size());
		
		Teacher teacher = teachers.get(teacherChoice-1);
		
		teacher.getCourses().add(course);
		
		course.addTeacher(teacher);
		
		teacher.getLessons().put(course, new Vector<Lesson>());
		
		System.out.println(course.getName() + " assigned to " + teacher.getFirstName() + " " + teacher.getLastName());
        Database.getInstance().addLog(this, new Log("Manager " + this.getUsername()+ " Assigned course " + course.getName() + " with teacher " + teacher.getFirstName() + " " + teacher.getLastName()));
	}
	
	/**
     * Adds a lesson to a teacher for a specific course. Allows the manager to choose a teacher, course, and lesson details.
     */
	public void addLesson() {
		
		Vector<Teacher> teachers = Database.getInstance().getTeachers();
		
		if(teachers.isEmpty()) {
			System.out.println("No teachers");
			return;
		}
		
		System.out.println("Enter 0 to return back.");
		System.out.println("To which teacher would you like to add the lesson?");

        StaticMethods.printList(teachers);
		
		int teacherChoice = StaticMethods.validate(teachers.size());
		
		if(teacherChoice == 0) {
			return;
		}
		
		Teacher teacher = teachers.get(teacherChoice-1);
		
		if(teacher.getCourses().isEmpty()) {
			System.out.println("No courses for this teacher");
			return;
		}
		
		System.out.println("To which course of " + teacher.getFirstName() + " " + teacher.getLastName() + " do you want to add lesson?");
		
		Vector<Course> courses = teacher.getCourses();
		
		StaticMethods.printList(courses);
		
		int courseChoice = StaticMethods.validate(1, courses.size());
		
		Course course = courses.get(courseChoice-1);
		
		System.out.println("Enter the type of lesson:");
		
		TypeLesson[] types = TypeLesson.values();
		
		StaticMethods.printList(List.of(types));
		
		int typeChoice = StaticMethods.validate(1, types.length);
		
		TypeLesson typeLesson = types[typeChoice-1];
		
		System.out.println("Enter the day:");
		
		Day[] days = Day.values();
		
		StaticMethods.printList(List.of(days));
		
		int dayChoice = StaticMethods.validate(1, days.length);
		
		Day day = days[dayChoice-1];
		
		System.out.println("Enter the lesson start time:");
		
		int time = StaticMethods.validate(8, 18);
		
		System.out.println("Enter the room");
		
		int room = StaticMethods.validate(100, 700);
		
		Vector<Lesson> lessons = teacher.getLessons().get(course);
		
		Lesson newLesson = new Lesson(typeLesson, new LessonTime(day, time), room);
		
		lessons.add(newLesson);
		
		teacher.getLessons().put(course, lessons);
		
		System.out.println("Added " + newLesson);
        Database.getInstance().addLog(this, new Log("Manager " + this.getUsername() + " added Lesson " + newLesson));
		
	}
	
	/**
     * Views the list of students in the system.
     */
	public void viewStudents() {
		StaticMethods.printList(Database.getInstance().getStudents());
        Database.getInstance().addLog(this, new Log("Manager " + this.getUsername() + " viewed all Students"));
	}

	/**
     * Views the list of teachers in the system.
     */
	public void viewTeachers() {

        Vector<Teacher> teachers = Database.getInstance().getTeachers();
        
        if(teachers.isEmpty()) {
        	System.out.println("No teachers");
        	return;
        }

        StaticMethods.printList(teachers);
        Database.getInstance().addLog(this, new Log("Manager " + this.getUsername() + " viewed all Teachers"));
	}
	
	 /**
     * Creates a research journal in the system. Takes input from the manager for the name of the journal.
     */
	public void createJournal() {
		System.out.println("Enter 0 to return back");
		System.out.println("Enter the name:");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		if(name.equals("0")) {
			return;
		}
		
		ResearchJournal newJournal = new ResearchJournal(name);
		
		Database.getInstance().addJournal(newJournal);
		
		System.out.println("New journal created " + newJournal);
        Database.getInstance().addLog(this, new Log("Manager " + this.getUsername() + " created a Journal " + name));
	}

	/**
	 * Displays the manager's menu, allowing them to perform various actions such as creating a statistical report,
	 * adding a course, adding a lesson to a teacher, creating news, viewing requests, editing news, assigning a course
	 * for a teacher, viewing students, viewing teachers, creating a journal, viewing all papers, and
	 * exiting. 
	 * If the manager is also a researcher, an additional option to view the researcher menu is available.
	 */
	public void viewMenu() {
		String[] options;
		
    	Researcher researcher = Database.getInstance().isResearcher(this);
		while (true) {
			
			if(researcher == null) {
				options = new String[] { "Create a statistical report", "Add course", "Add lesson to teacher", "Create news",
						"View Requests", "Edit news", "Assign Course For Teacher", "View Students", "View Teachers", "Create journal",
						"View all papers",
						"Exit" };
			}
			else {
				options = new String[] { "Create a statistical report", "Add course", "Add lesson to teacher", "Create news",
						"View Requests", "Edit news", "Assign Course For Teacher", "View Students", "View Teachers", "Create journal",
						"Exit", "View all papers", "View researcher menu"};
			}
			
			System.out.println("----Manager Menu----");
			StaticMethods.printList(List.of(options));
			
			System.out.print("Enter your choice: ");
			int choice = StaticMethods.validate(1, options.length);
			
			if (choice == 1) {
				createStatisticReport();
			}
			else if (choice == 2) {
				addCourse();
			}
			else if (choice == 3) {
				addLesson();
			}
			else if (choice == 4) {
				createNews();
			}
			else if (choice == 5) {
				viewRequests();
			} 
			else if (choice == 6) {
				editNews();
			} 
			else if (choice == 7) {
				assignCourseForTeacher();
			} 
			else if (choice == 8) {
				viewStudents();
			} 
			else if (choice == 9) {
				viewTeachers();
			}
			else if (choice == 10) {
				createJournal();
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
                    Database.getInstance().addLog(this, new Log("Manager " + this.getUsername() + " went to the researcher menu"));
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Manager [typeManager=" + typeManager + "] " + super.toString();
	}
	
	
}
