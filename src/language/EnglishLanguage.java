package language;

public class EnglishLanguage implements LanguageInterface{
	@Override
	public void newNotifications() {
	    System.out.println("----New Notification----");

	}
	@Override
	public void handleEventUser(String paper, String journal, String firstName, String lastName) {
	    System.out.println("Dear " + firstName + " " + lastName + ", new articles have been added to " + journal + ":\n" + paper);

	}

	@Override
	public void news() {
	    System.out.println("----News----");

	}

	@Override
	public void noNews() {
	    System.out.println("No news");

	}

	@Override
	public void enterTheNumberOfTheNews() {
	    System.out.println("Enter the news number to view or 0 to exit:");

	}

	@Override
	public void selectedNews() {
	    System.out.println("----Selected News----");

	}

	@Override
	public void doYouWantToAddAComment() {
	    System.out.println("Do you want to add a comment? (+/-)");

	}

	@Override
	public void yourDecidedThatNoWant() {
	    System.out.println("You decided not to leave a comment");

	}

	@Override
	public void noCommentsAvailable() {
	    System.out.println("No available comments");

	}

	@Override
	public void comments() {
	    System.out.println("----Comments----");

	}

	@Override
	public void enterYourComment() {
	    System.out.println("----Enter your comment----");

	}

	@Override
	public void commentAddSuccesfully() {
	    System.out.println("Comment added successfully");

	}
	//---------------------------------------------------------------------------------------------------------------
	@Override
	public String[] studentMenu() {
	    return new String[] {
	        "----Student Menu----",
	        "1 - View Transcript",
	        "2 - View Marks for a Course",
	        "3 - Register for a Course",
	        "4 - View Teacher for a Course",
	        "5 - View All Courses",
	        "6 - Rate Teachers",
	        "7 - Organization",
	        "8 - View News",
	        "0 - Exit"
	    };
	}

	@Override
	public void viewTranscript() {
	    System.out.println("Transcript:");
	}

	@Override
	public void courseDoesntHaveMarks() {
	    System.out.println("Course without marks.");

	}

	@Override
	public void studentNotRegisteredForThisCourse() {
	    System.out.println("Student not registered for this course.");

	}

	@Override
	public void courseMark(String courseName, String mark) {
	    System.out.println("Course: " + courseName + " Marks: " + mark);

	}

	@Override
	public void courseRegistrationSuccesfully(String courseName) {
	    System.out.println("Course: " + courseName + " registration successful!");

	}

	@Override
	public void teacherForCourse(String courseName) {
	    System.out.println("Teachers for the course " + courseName);

	}

	@Override
	public void pleaseSelectTheTeacherYourWantToEvaluate() {
	    System.out.println("Please select the teacher you want to evaluate:");

	}

	@Override
	public void yourAssessmentOfThisTeacher() {
	    System.out.println("Your assessment of this teacher:");

	}

	@Override
	public String[] organisationMenu() {
	    return new String[] {
	        "1 - Join an organization",
	        "2 - Leave an organization",
	        "3 - Create an organization",
	        "4 - Exit"
	    };
	}

	@Override
	public void listOfOrganisation() {
	    System.out.println("List of organizations:");

	}

	@Override
	public void atTheMomentWeDontHaveAnyOrganizations() {
	    System.out.println("At the moment we don't have any organizations");

	}

	@Override
	public void nameYourOrganisation() {
	    System.out.println("Name your organization");

	}

	@Override
	public void whatDoYouWantToChange() {
	    System.out.println("What do you want to change:");

	}
	public String[] studentResearcherMenu() {
	    return new String[] {
	        "----Student-Researcher Menu----",
	        "1 - View Transcript",
	        "2 - View Marks for a Course",
	        "3 - Register for a Course",
	        "4 - View Teacher for a Course",
	        "5 - View All Courses",
	        "6 - Rate Teachers",
	        "7 - Organization",
	        "8 - View News",
	        "9 - View Researcher Menu",
	        "0 - Exit"
	    };
	}
	//---------------------------------------------------------------------------------------------------------------
	@Override
	public String[] teacherMenu() {
	    return new String[] {
	        "----Teacher Menu----",
	        "1 - View Courses",
	        "2 - View Students",
	        "3 - View Marks",
	        "4 - Add Marks",
	        "5 - View Ratings",
	        "6 - View One News",
	        "7 - Send Order",
	        "8 - Send Request",
	        "9 - Exit"
	    };

	}

	@Override
	public void courseTaughtBy(String username) {
	    System.out.println("Courses taught by " + username + ":");

	}

	@Override
	public void studentsEnrolledIn(String selectedCourseName) {
	    System.out.println("Students enrolled in " + selectedCourseName + ":");

	}

	@Override
	public void marksFor(String selectedCourseName) {
	    System.out.println("Marks for " + selectedCourseName + ":");

	}

	@Override
	public void noMarks(String mark, String studentUsername) {
	    System.out.println(studentUsername + ": " + (mark != null) + " No marks");

	}

	@Override
	public void noStudentEnrolledIn(String selectedCourseName) {
	    System.out.println("No student enrolled in " + selectedCourseName);

	}

	@Override
	public void previousMarksForStudent(String selectedStudentUsername) {
	    System.out.println("Previous marks for student: " + selectedStudentUsername);

	}

	@Override
	public void newMarksForStudents(String selectedStudentUsername) {
	    System.out.println("New marks for student: " + selectedStudentUsername);

	}

	@Override
	public void teachersRating(double rate) {
	    System.out.println("Teacher's rating: " + rate);

	}

	@Override
	public void enterTheCourse() {
	    System.out.println("Press the course.");

	}

	@Override
	public void noLessonsForThisCourse() {
	    System.out.println("No lessons for this course.");

	}

	@Override
	public void selectSCourseToInputMarks() {
	    System.out.println("Select a course to input marks.");

	}

	@Override
	public void yourAreNotAssignedToAnyCourses() {
	    System.out.println("You are not assigned to any courses.");

	}

	@Override
	public void noLessonsRecordedForTheCourse() {
	    System.out.println("No lessons recorded for the course.");

	}

	@Override
	public void selectAStudentToInputMarks() {
	    System.out.println("Select a student to input marks.");

	}

	@Override
	public void chooseAStudentOrExit() {
	    System.out.println("Choose a student or press 0 to exit.");

	}

	@Override
	public void firstAttestation() {
	    System.out.println("First attestation:");

	}

	@Override
	public void secondAttestation() {
	    System.out.println("Second attestation:");

	}

	@Override
	public void finalExam() {
	    System.out.println("Final exam:");

	}

	@Override
	public void theMarksHaveBennSubmittedSuccesfully() {
	    System.out.println("Marks have been submitted successfully.");

	}

	@Override
	public void ErrorPleaseEnterMarksCorrectly() {
	    System.out.println("Error: Please enter marks correctly.");

	}

	@Override
	public String[] teacherResearcherMenu() {

	    return new String[] {
	        "----Teacher-Researcher Menu----",
	        "1 - View Courses",
	        "2 - View Students",
	        "3 - View Marks",
	        "4 - Add Marks",
	        "5 - View Ratings",
	        "6 - View One News",
	        "7 - Send Order",
	        "8 - Send Request",
	        "9 - Exit",
	        "10 - View Researcher Menu"
	    };
	}
	//---------------------------------------------------------------------------------------------------------------
	@Override
	public String[] adminMenu() {
	    return new String[] {
	        "----Admin Menu----",
	        "1 - Create a new user",
	        "2 - View all users",
	        "3 - Update user information",
	        "4 - Delete user",
	        "5 - View journal files",
	        "6 - View One News",
	        "7 - Exit"
	    };
	}
	@Override
	public String[] addResearcherOptions() {
	    return new String[] {
	        "Add a researcher to an existing user",
	        "Create a researcher from a new user"
	    };
	}
	@Override
	public void whatDoYouWantToDo() {
	    System.out.println("What do you want to do?");
	}

	@Override
	public void chooseUser() {
	    System.out.println("Choose a user:");

	}

	@Override
	public void whichUserDoYouWantToCreate() {
	    System.out.println("Which user do you want to create?");
	}

	@Override
	public String[] addResearcherOptionsCreate() {
	    return new String[] {
	        "Student", "Graduate student", "Employee", "Teacher", "Head", "Technical support specialist", "Dean"
	    };
	}

	@Override
	public String[] createUserOptions() {
	    return new String[] {
	        "Student", "Graduate student", "Employee", "Teacher", "Head", "Technical support specialist", "Dean", "Researcher"
	    };
	}

	@Override
	public void updateUserWhichUserDoYouWantToChange() {
	    System.out.println("Which user do you want to change? Press 0 to go back.");

	}

	@Override
	public void removeUserChooseUserToDelete() {
	    System.out.println("Choose a user to delete:");

	}

	@Override
	public void seeLogFilesChooseUserToSeeLogs() {
	    System.out.println("Choose a user to view logs:");

	}

	@Override
	public void seeLogFilesNoLogsForThisUser() {
	    System.out.println("No logs for this user.");

	}
	//---------------------------------------------------------------------------------------------------------------
	@Override
	public String[] managerMenu() {
	    return new String[] {
	        "----Manager Menu----",
	        "1 - Create a statistical report",
	        "2 - Add a course",
	        "3 - Add a lesson to a teacher",
	        "4 - Create news",
	        "5 - View requests",
	        "6 - Edit news",
	        "7 - Assign a course to a teacher",
	        "8 - View students",
	        "9 - View teachers",
	        "10 - Create a journal",
	        "11 - Exit"
	    };
	}


	@Override
	public void GPAMAX(double gpamax) {
	    System.out.println("Number of students with a GPA of 4.0: " + gpamax);

	}

	@Override
	public void GPAHIGH(double gpahigh) {
	    System.out.println("Number of students with a GPA from 3.99 to 3.00: " + gpahigh);

	}

	@Override
	public void GPAMEDIUM(double gpamedium) {
	    System.out.println("Number of students with a GPA from 2.99 to 2.00: " + gpamedium);

	}

	@Override
	public void COUNTOTHER(double contother) {
	    System.out.println("Number of students with a GPA less than 2.00: " + contother);

	}

	@Override
	public void hINDEX(String maxResearcher) {
	    System.out.println("The researcher with the highest H-index: " + maxResearcher);

	}

	@Override
	public void enterTheNumverOfCreditsOfTheCourse() {
	    System.out.println("Enter the number of credits for the course:");

	}

	@Override
	public void enterNameOfCourse() {
	    System.out.println("Enter the name of the course:");

	}

	@Override
	public void chooseForWhichFacultyIsThisCouse() {
	    System.out.println("Choose for which faculty this course is:");

	}

	@Override
	public void chooseTypeOfThisCoursefor(String faculty) {
	    System.out.println("Choose the type of this course for " + faculty + ":");

	}

	@Override
	public void courseAdded(String newCourse) {
	    System.out.println("Course added: " + newCourse);

	}
	@Override
	public void chooseType() {
		System.out.println("Choose the type:");
		
	}

	@Override
	public void newTopic() {
		System.out.println("News topic:");
		
	}

	@Override
	public void newTitle() {
		System.out.println("News title:");
		
	}

	@Override
	public void newText() {
		System.out.println("News text:");
		
	}

	@Override
	public void listOfRequests() {
		System.out.println("List of requests:");
		
	}

	@Override
	public void whatNewsDoYouWantToChange() {
		System.out.println("Which news do you want to change?");
	}

	@Override
	public void whichOfPartDoYouWantToChange() {
		System.out.println("Which part do you want to change?" + "\n 1 - Topic" + "\n 2 - Title"
				+ "\n 3 - Text" + "\n 0 - Exit");
		
	}

	@Override
	public void enterNewTopic() {
		System.out.println("Enter a new topic:");
		
	}

	@Override
	public void updateNews(String news) {
		System.out.println("Updating news: " + news);
		
	}

	@Override
	public void enterNewTitle() {
		System.out.println("Enter a new title:");
		
	}

	@Override
	public void enterNewText() {
		System.out.println("Enter a new text:");
		
	}

	@Override
	public void whichCourseYouWantToAssign() {
		System.out.println("Which course do you want to assign:");
		
	}

	@Override
	public void whichTeacherWouldYouLikeToAssignThe(String courseName) {
		System.out.println("Which teacher would you like to assign " + courseName + ":");
		
	}

	@Override
	public void assignedTo(String courseName, String teacherFirstName, String teacherLastName) {
		System.out.println(courseName + " assigned to " + teacherFirstName + " " + teacherLastName);
		
	}

	@Override
	public void whichTeacherWouldYouLikeToAddTheLesson() {
		System.out.println("Which teacher would you like to add a lesson to?");
		
	}

	@Override
	public void noCoursesForThisTeacher() {
		System.out.println("No courses for this teacher");
		
	}

	@Override
	public void toWhichCourseOf(String teacherName, String teacherLastName) {
		System.out.println("To which course of " + teacherName + " " + teacherLastName + " do you want to add a lesson?");
		
	}

	@Override
	public void enterTheTypeOfLesson() {
		System.out.println("Enter the type of lesson:");
		
	}

	@Override
	public void enterTheDay() {
		System.out.println("Enter the day:");
		
	}

	@Override
	public void enterTheLessonStartTime() {
		System.out.println("Enter the lesson start time:");
		
	}

	@Override
	public void enterTheRoom() {
		System.out.println("Enter the room number:");
		
	}

	@Override
	public void added(String newLesson) {
		System.out.println("Added " + newLesson);
		
	}

	@Override
	public void enterTheName() {
		System.out.println("Enter the name:");
		
	}

	@Override
	public void newJournalCreated(String newJournal) {
		System.out.println("A new journal has been created: " + newJournal);
		
	}

	@Override
	public String[] managerResearcherMenu() {
		return new String[] { 
				"----Researcher-Manager Menu----",
				"1 - Create a statistical report", 
				"2 - Add a course", 
				"3 - Add a lesson to a teacher", 
				"4 - Create news",
				"5 - View requests", 
				"6 - Edit news", 
				"7 - Assign a course to a teacher", 
				"8 - View students", 
				"9 - View teachers", 
				"10 - Create a journal",
				"11 - Exit",
				"12 - View Researcher Menu"
		};
	}
//---------------------------------------------------------------------------------------------------------------
	@Override
	public String[] techSupportSpecialistMenu() {
		return new String[] {
				"----Tech Support Specialist Menu----  ",
				"1 - View orders",
				"2 - Accept order", 
				"3 - Reject order", 
				"4 - Exit" 
		};
	}
	
	@Override
	public void orderWasAlreadyRejected() {
		System.out.println("ERROR! The order has already been rejected!");
		
	}

	@Override
	public void orderWasAlreadyAccepted() {
		System.out.println("ERROR! The order has already been accepted");
		
	}

	@Override
	public void orderHasBeenAccepted() {
		System.out.println("The order has been accepted");
		
	}

	@Override
	public void orderHasBeenRejected() {
		System.out.println("The order has been rejected!");
		
	}

	@Override
	public String[] techSupportSpecialistResearcherMenu() {
		return new String[] {
				"----Researcher-Tech Support Specialist Menu----  ",
				"1 - View orders",
				"2 - Accept order", 
				"3 - Reject order", 
				"4 - Exit",
				"5 - View Researcher Menu"
		};
	}
//---------------------------------------------------------------------------------------------------------------
	@Override
	public String[] deanMenu() {
		return new String[] {
				"----Dean Menu----",
				"1 - View all requests",
				"2 - Sign requests", 
				"3 - View one news", 
				"4 - Exit"
		};
	}
	
	@Override
	public void chooseFaculty() {
		System.out.println("Choose the faculty:");
		
	}

	@Override
	public void noRequests() {
		System.out.println("No requests");
		
	}

	@Override
	public void emergencyRequests() {
		System.out.println("----Emergency Requests----");
		
	}

	@Override
	public void enterTheRequestNumberToSign() {
		System.out.println("Enter the request number to sign (or 0 to exit):");
		
	}

	@Override
	public void deanSignedRequest(String selectedRequest) {
		System.out.println("Dean signed request: " + selectedRequest);
		
	}

	@Override
	public void TheRequestWasSuccesfully() {
		System.out.println("The request was successfully signed and removed.");
		
	}

	@Override
	public String[] deanResearcherMenu() {
		return new String[] {
				"----Researcher-Dean Menu----",
				"1 - View all requests",
				"2 - Sign requests", 
				"3 - View one news", 
				"4 - Exit",
				"5 - View Researcher Menu"
		};
	}
//---------------------------------------------------------------------------------------------------------------
	@Override
	public String[] graduateStudentMenu() {
		return new String[] { 
				"----Graduate Student Menu----",
				"1 - View transcript", 
				"2 - View marks for a course", 
				"3 - Register for a course",
				"4 - View teacher for a course", 
				"5 - View all courses", 
				"6 - Rate teachers", 
				"7 - Organization", 
				"8 - View one news", 
				"9 - Exit", 
				"10 - View Researcher Menu" 
		};
	}
	
	@Override
	public void newGrade(double grade) {
		System.out.println("New grade: " + grade);
		
	}
//---------------------------------------------------------------------------------------------------------------
	@Override
	public String[] employeeMenu() {
		return new String[]{
				"----Employee Menu----",
				"1 - Send request", 
				"2 - Send order", 
				"3 - View one news", 
				"4 - Exit"
				};
	}
	
	@Override
	public void SendingMessageTo(String message, String Username) {
		System.out.println("Sending message to " + Username + ": " + message);
		
	}

	@Override
	public void noDeans() {
		System.out.println("No deans");
	}

	@Override
	public void chooseTheDean() {
		System.out.println("Choose the dean:");
		
	}

	@Override
	public void enterTheEmergencyLevel() {
		System.out.println("Enter the emergency level:");
		
	}

	@Override
	public void enterTheMessage() {
		System.out.println("Enter the message:");
		
	}

	@Override
	public void sentSuccesfully(String newRequest) {
		System.out.println(newRequest + " sent successfully");
		
	}

	@Override
	public void noTechSupports() {
		System.out.println("No tech supports");
		
	}

	@Override
	public void chooseTheTechSupport() {
		System.out.println("Choose the tech support:");
		
	}

	@Override
	public String[] employeeResearcherMenu() {
		return new String[]{
				"----Researcher-Employee Menu----",
				"1 - Send request", 
				"2 - Send order", 
				"3 - View one news", 
				"4 - Exit", 
				"5 - View Researcher Menu"
				};
	}
//---------------------------------------------------------------------------------------------------------------
	@Override
	public String[] researcherMenu() {
		return new String[] {
				"----Researcher Menu----",
				"1 - View documents", 
				"2 - Create a paper", 
				"3 - View projects", 
				"4 - View journals", 
				"5 - Add an article to a journal", 
				"6 - Exit"
		};
	}
	
	@Override
	public void noPapers() {
		System.out.println("No documents");
		
	}

	@Override
	public void noProjects() {
		System.out.println("No projects");
		
	}

	@Override
	public void noJournals() {
		System.out.println("No journals");
		
	}

	@Override
	public void chooseTheJournal() {
		System.out.println("Choose the journal:");
		
	}

	@Override
	public void choosePaperToAdd() {
		System.out.println("Choose the paper to add:");
		
	}

	@Override
	public void addedTo(String paper, String journalName) {
		System.out.println(paper + " added to " + journalName);	
	}

	@Override
	public void enterTheNumberOfPages() {
		System.out.println("Enter the number of pages:");
		
	}

	@Override
	public void enterValidNumberOfPages() {
		System.out.println("Enter a valid number of pages.");
		
	}

	@Override
	public void enterValidNumber() {
		System.out.println("Enter a valid number");
		
	}

	@Override
	public void enterTheDoi() {
		System.out.println("Enter the DOI:");
		
	}

	@Override
	public void newPaperAdded(String newPaper) {
		System.out.println("A new document has been added: "+ newPaper);
		
	}
//---------------------------------------------------------------------------------------------------------------
	
	@Override
	public void enterReturnBack() {
		System.out.println("Press 0 to return back.");
	}

	@Override
	public void noCoursesYet() {
		System.out.println("Currently, there are no courses.");
		
	}

	@Override
	public void noCourses() {
		System.out.println("No courses.");
		
	}

	@Override
	public void allCourses() {
		System.out.println("All courses:");
		
	}

	@Override
	public void enterYourChoice() {
		System.out.println("Press your choice:");
		
	}

	@Override
	public void noTeachers() {
		System.out.println("No teachers.");
		
	}

	@Override
	public void courses() {
		System.out.println("Courses:");
		
	}

	@Override
	public String[] changeInfoOptions() {
		return new String[] {
				"1 - Username",
				"2 - Password",
				"3 - First Name",
				"4 - Last Name"
		};
	}

	@Override
	public void enterNewUsername() {
		System.out.println("Enter a new username");
		
	}

	@Override
	public void enterNewPassword() {
		System.out.println("Enter a new password");
		
	}

	@Override
	public void enterNewFirstName() {
		System.out.println("Enter a new first name");
		
	}

	@Override
	public void enterNewLastName() {
		System.out.println("Enter a new last name");
		
	}


}
