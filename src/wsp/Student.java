package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import database.*;
import utils.*;
import wsp.*;
import enums.*;

public class Student extends User implements Serializable, Comparable<Student> {
    Vector<Course> courses;
    double gpa = Double.parseDouble(null);
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
    public int compareTo(Student s) {
        if(this.gpa > s.gpa) return 1;
        if(this.gpa < s.gpa) return -1;
        return 0;
    }

    public void viewTranscript() {
        System.out.println("Transcript:");
        for (Map.Entry<Course, Mark> entry : transcript.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        }
        Database.getInstance().addLog(this, new Log("Student " + getUsername() + " viewed Transcript"));
    }

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
            Database.getInstance().addLog(this, new Log("Student " + getUsername() + " viewed Marks for Course " + course.getName()));
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

        StaticMethods.printList(coursesToShow);

        System.out.println("Enter 0 to return back");
        int coursechoice = StaticMethods.validate(coursesToShow.size());
        if(coursechoice == 0) {
            return;
        }

        registerToCourse(coursesToShow.get(coursechoice - 1));
    }

    public void registerToCourse(Course course) {
        this.courses.add(course);
        this.transcript.put(course, new Mark());
        System.out.println("Course " + course.getName() + " registration successful!");
        Database.getInstance().addLog(this, new Log("Student " + getUsername() + " registrated to course " + course.getName()));
    }

    public void viewTeacherForCourse() {
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
            Database.getInstance().addLog(this, new Log("Student " + getUsername() + " viewed all Teachers"));
        }
    }




    public void viewCourses() {

        if(Database.getInstance().getCourses().isEmpty()) {
            System.out.println("No courses yet...");
        }

        System.out.println("Courses:");
        StaticMethods.printList(Database.getInstance().getCourses());
        Database.getInstance().addLog(this, new Log("Student " + getUsername() + " viewed All courses"));
    }

    @Override
    public void viewNews() {
        // TODO Auto-generated method stub

    }

    public void rateTeachers() {
        System.out.println("All Teachers:");
        Vector<Employee> dbemployees = Database.getInstance().getEmployees();
        Vector<Teacher> teachers = new Vector<>();
        for(Employee e: dbemployees){
            if(e instanceof Teacher){
                teachers.add((Teacher) e);
            }
        }
        for(Teacher t : teachers){
            StaticMethods.printList(teachers);
        }

        System.out.println("Please select the teacher you want to evaluate:");
        int teacherchoice = StaticMethods.validate(teachers.size());
        Teacher teacher = teachers.get(teacherchoice - 1);
        System.out.println("Your assessment of this teacher:");
        int rate = StaticMethods.validate(10);
        teacher.setRate(rate);
        Database.getInstance().addLog(this, new Log("Student " + " appreciated teacher " + teacher.getFirstName() + " " + teacher.getLastName()));
    }
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

    public void joinOrganisation() {

        System.out.println("List of organisation:");
        Vector<Organisation> organisations = Database.getInstance().getOrganisations();

        organisations.remove(this.organisation);
        StaticMethods.printList(organisations);


        if (!organisations.isEmpty()) {

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
            Database.getInstance().addLog(this, new Log("Student " + getUsername() + " viewed joined organisation" + organisation.getName()));
        }
        else {
            System.out.println("At the moment we dont have any organisations");
        }
    }

    public void leaveOrganisation() {
        organisation.removeMember(this);
        this.organisation = null;
        Database.getInstance().addLog(this, new Log("Student " + getUsername() + " viewed left organisation" + organisation.getName()));
    }

    public void createOrganisation() {
        Scanner s = new Scanner(System.in);
        System.out.println("Name your organisation:");
        String name = s.nextLine();
        Organisation organisation = new Organisation(name, this);
        this.organisation = organisation;
        Database.getInstance().addOrganisation(organisation);
        Database.getInstance().addLog(this, new Log("Student " + getUsername() + " viewed created organisation" + organisation.getName()));
        s.close();
    }

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

    public void viewMenu() {
        while (true) {
            String[] options = new String[] { "View Transcript", "View Marks for a Course", "Register for a Course",
                    "View Teacher for a Course", "View All Courses", "Rate Teachers", "Organisation","View one News", "Exit" };

            System.out.println("\nStudent Menu:");
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.print("Enter your choice: ");
            int choice = StaticMethods.validate(options.length);

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
            } else if (choice == 6) {
                rateTeachers();
            }
            else if (choice == 7) {
                organisationMenu();
            }
            else if (choice == 8) {
                viewOneNews();
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


}
