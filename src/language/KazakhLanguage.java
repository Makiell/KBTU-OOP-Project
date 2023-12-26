package language;

public class KazakhLanguage implements LanguageInterface {
	//---------------------------------------------------------------------------------------------------------------
		@Override
		public void newNotifications() {
			System.out.println("----Жаңа хабарлама----");
			
		}
		@Override
		public void handleEventUser(String paper, String journal, String firstName, String lastName) {
			System.out.println("Қымбатты " + firstName +" "+lastName + " to " + journal + " добавлены новые статьи!\n" + paper);
			
		}

		@Override
		public void news() {
			System.out.println("----Жаңалықтар----");
			
		}

		@Override
		public void noNews() {
			System.out.println("Жаңалықтар жоқ");
			
		}

		@Override
		public void enterTheNumberOfTheNews() {
			System.out.println("Көру үшін жаңалықтар нөмірін немесе шығу үшін 0 енгізіңіз:");
			
		}

		@Override
		public void selectedNews() {
			System.out.println("----Таңдаулы жаңалықтар----");
			
		}

		@Override
		public void doYouWantToAddAComment() {
			System.out.println("Пікір қосқыңыз келе ме? (+/-)");
			
		}

		@Override
		public void yourDecidedThatNoWant() {
			System.out.println("Сіз пікір қоспаймын, деп шешім қабылдадыңыз");
			
		}

		@Override
		public void noCommentsAvailable() {
			System.out.println("Пікірлер жоқ");
			
		}

		@Override
		public void comments() {
			System.out.println("----Пікірлер----");
			
		}

		@Override
		public void enterYourComment() {
			System.out.println("----Өзіңіздің пікіріңізді жазыңыз----");
			
		}

		@Override
		public void commentAddSuccesfully() {
			System.out.println("Пікір сәтті енгізілді.");
			
		}
	//---------------------------------------------------------------------------------------------------------------
		@Override
	    public String[] studentMenu() {
	        return new String[] {
	            "----Студент мәзірі----",
	            "1 - Транскрипті көру",
	            "2 - Курс бойынша бағаларды көру",
	            "3 - Курсқа тіркелу",
	            "4 - Курс бойынша мұғалімдерді көру",
	            "5 - Барлық курстарды көру",
	            "6 - Мұғалімді бағалау",
	            "7 - Ұйымдар",
	            "8 - Жаңалықтарды көру",
	            "0 - Шығу"
	        };
	    }
		
		@Override
		public void viewTranscript() {
			// TODO Auto-generated method stub
			System.out.println("Транскрипт:");
		}

		@Override
		public void courseDoesntHaveMarks() {
			System.out.println("Курс бойынша бағалар жоқ.");
			
		}

		@Override
		public void studentNotRegisteredForThisCourse() {
			System.out.println("Студент осы курсқа жазылмаған.");
			
		}
		
		@Override
		public void courseMark(String courseName, String mark) {
			System.out.println("Курс: " + courseName + " Бағалар: " + mark);
			
		}

		@Override
		public void courseRegistrationSuccesfully(String courseName) {
			System.out.println("Курс: " + courseName + " тіркелу сәтті аяқталды!");
			
		}

		@Override
		public void teacherForCourse(String courseName) {
			System.out.println("Курс бойынша мұғалім " + courseName);
			
		}

		@Override
		public void pleaseSelectTheTeacherYourWantToEvaluate() {
			System.out.println("Баға бергіңіз келетін мұғалімді таңдаңыз:");
			
		}

		@Override
		public void yourAssessmentOfThisTeacher() {
			System.out.println("Осы мұғалімді қалай бағалайсыз:");
			
		}

		@Override
		public String[] organisationMenu() {
			// TODO Auto-generated method stub
			return new String[] {
					"1 - Ұйымға тіркелу",
					"2 - Ұйымнан кету",
					"3 - Жаңа ұйым құрастыру",
					"4 - Шығу"
			};
		}

		@Override
		public void listOfOrganisation() {
			System.out.println("Ұйымдар тізімі:");
			
		}

		@Override
		public void atTheMomentWeDontHaveAnyOrganizations() {
			System.out.println("Осы сәтте ұйымдар тіркелмеген");
			
		}

		@Override
		public void nameYourOrganisation() {
			System.out.println("Өзіңіздің ұйымыңыздың атын атаңыз:");
			
		}

		@Override
		public void whatDoYouWantToChange() {
			System.out.println("Нені өзгерткіңіз келеді:");
			
		}
		public String[] studentResearcherMenu() {
	        return new String[] {
	            "----Студент-Зерттеуші мәзірі----",
	            "1 - Транскрипті көру",
	            "2 - Курс бойынша бағаларды көру",
	            "3 - Курсқа тіркелу",
	            "4 - Курс бойынша мұғалімдерді көру",
	            "5 - Барлық курстарды көру",
	            "6 - Мұғалімді бағалау",
	            "7 - Ұйымдар",
	            "8 - Жаңалықтарды көру",
	            "0 - Шығу",
	            "9 - Зерттеуші мәзірін көру"
	        };
	    }
	//---------------------------------------------------------------------------------------------------------------
		@Override
		public String[] teacherMenu() {
			return new String[] {
		            "----Мұғалім мәзірі----",
		            "1 - Курстарды көру",
		            "2 - Студенттерді көру",
		            "3 - Бағаларды көру",
		            "4 - Баға қою",
		            "5 - Рейтингті қарау",
		            "6 - Бір жаңалықты көру",
		            "7 - Тапсырып беру",
		            "8 - Сұраныс жіберу",
		            "9 - Шығу"
		        };
			
		}
		
		@Override
		public void courseTaughtBy(String username) {
			System.out.println("Оқытылатын курстар " +username + ":");
			
			
		}

		@Override
		public void studentsEnrolledIn(String selectedCourseName) {
			System.out.println("Оқушылар тіркелді " + selectedCourseName + ":");
			
		}

		@Override
		public void marksFor(String selectedCourseName) {
			System.out.println(selectedCourseName+ " бойынша бағалар:");
			
		}

		@Override
		public void noMarks(String mark, String studentUsername) {
			System.out.println(studentUsername + ": " + (mark!= null) + " баға тіркелмеген");
			
		}

		@Override
		public void noStudentEnrolledIn(String selectedCourseName) {
			System.out.println("Ни один студент не записался " + selectedCourseName);
			
		}

		@Override
		public void previousMarksForStudent(String selectedStudentUsername) {
			System.out.println("Предыдущие оценки ученика:" + selectedStudentUsername);
			
		}

		@Override
		public void newMarksForStudents(String selectedStudentUsername) {
			System.out.println(selectedStudentUsername + " студент үшін жаңа баға" );
			
		}

		@Override
		public void teachersRating(double rate) {
			System.out.println("Мұғалімнің рейтингі:" + rate);
			
		}
		
		@Override
		public void enterTheCourse() {
			System.out.println("Курсты басыңыз.");
			
		}

		@Override
		public void noLessonsForThisCourse() {
			System.out.println("Осы курс бойынша сабақтар тіркелмеген.");
			
		}

		@Override
		public void selectSCourseToInputMarks() {
			System.out.println("s курс бойынша баға қою.");
			
		}

		@Override
		public void yourAreNotAssignedToAnyCourses() {
			System.out.println("Сіз бұл курсқа тіркелмегенсіз.");
			
		}

		@Override
		public void noLessonsRecordedForTheCourse() {
			System.out.println("Осы курс бойынша ешқандар сабақтар тіркелмеген.");
			
		}

		@Override
		public void selectAStudentToInputMarks() {
			System.out.println("Баға қою үшін студентті белгілеңіз:");
			
		}

		@Override
		public void chooseAStudentOrExit() {
			
			System.out.println("Студентті таңдаңыз немесе 0-ді басып артақ қайтыңыз");
			
		}

		@Override
		public void firstAttestation() {
			System.out.println("Бірінші аттестация:");
			
		}

		@Override
		public void secondAttestation() {
			System.out.println("Екінші аттестация:");
			
		}

		@Override
		public void finalExam() {
			System.out.println("Соңғы экзамен:");
			
		}

		@Override
		public void theMarksHaveBennSubmittedSuccesfully() {
			System.out.println("Бағалар сәтті жіберілді.");
			
		}

		@Override
		public void ErrorPleaseEnterMarksCorrectly() {
			System.out.println("Қате: Бағаларды дұрыс жазуыңызды сұраймыз.");
			
		}

		@Override
		public String[] teacherResearcherMenu() {

			return new String[] {
		            "----Мұғалім-Зерттеуші мәзірі----",
		            "1 - Курстарды қарау",
		            "2 - Студенттерді қарау",
		            "3 - Бағаларды көру",
		            "4 - Баға қою",
		            "5 - Рейтингі көру",
		            "6 - Бір жаңалықты көру",
		            "7 - Тапсырыс беру",
		            "8 - Сұраныс жіберу",
		            "9 - Шығу",
		            "10 - Зерттеуші мәзірін көру"
		        };
		}
	//---------------------------------------------------------------------------------------------------------------
		@Override
		public String[] adminMenu() {
			// TODO Auto-generated method stub
			return new String[] {
					"----Админ мәзірі----",
					"1 - Жаңа пайдаланушы жасаңыз", 
					"2 - Посмотреть всех пользователей", 
					"3 - Барлық пайдаланушыларды көру", 
					"4 - Пайдаланушыны жою", 
					"5 - Журнал файлдарын қарау",
					"6 - Бір жаңалықты қарау", 
					"7 - Шығу"
			};
		}
		@Override
		public String[] addResearcherOptions() {
			// TODO Auto-generated method stub
			return new String[] {
					"Бар пайдаланушыға зерттеушіні қосыңыз", 
					"Жаңа пайдаланушыдан зерттеуші жасаңыз"
					};
		}
		@Override
		public void whatDoYouWantToDo() {
			// TODO Auto-generated method stub
			System.out.println("Сіз не істегіңіз келеді?");
		}

		@Override
		public void chooseUser() {
			// TODO Auto-generated method stub
			System.out.println("Пайдаланушыны таңдаңыз:");
		}

		@Override
		public void whichUserDoYouWantToCreate() {
			// TODO Auto-generated method stub
			System.out.println("Сіз қандай пайдаланушы жасағыңыз келеді?");
		}

		@Override
		public String[] addResearcherOptionsCreate() {
			// TODO Auto-generated method stub
			return new String[] {
					"Студент","Аспирант","Қызметкер","Мұғалім","Менеджер","техникалық маман","Декан"
			};
		}

		@Override
		public String[] createUserOptions() {
			// TODO Auto-generated method stub
			return new String[] {
					"Студент","Аспирант","Қызметкер","Мұғалім","Менеджер","техникалық маман","Декан","Зерттеуші"
			};
		}

		@Override
		public void updateUserWhichUserDoYouWantToChange() {
			// TODO Auto-generated method stub
			System.out.println("Қай пайдаланушыны өзгерткіңіз келеді? немесе артқа қайту үшін 0-ді басыңыз");
		}

		@Override
		public void removeUserChooseUserToDelete() {
			// TODO Auto-generated method stub
			System.out.println("Жойылатын пайдаланушыны таңдаңыз:");
		}

		@Override
		public void seeLogFilesChooseUserToSeeLogs() {
			// TODO Auto-generated method stub
			System.out.println("Журналдарды көру үшін пайдаланушыны таңдаңыз:");
		}

		@Override
		public void seeLogFilesNoLogsForThisUser() {
			// TODO Auto-generated method stub
			System.out.println("Бұл пайдаланушы үшін журналдар жоқ.");
		}
	//---------------------------------------------------------------------------------------------------------------
		@Override
		public String[] managerMenu() {
			// TODO Auto-generated method stub
			return new String[] { 
					"----Менеджер мәзірі----",
					"1 - Статистикалық есепті құру", 
					"2 - Курс қосыңыз", 
					"3 - Мұғалімге сабақ қосу", 
					"4 - Жаңалық жасау",
					"5 - Сұрауларды қарау", 
					"6 - Жаңалықты өңдеу", 
					"7 - Мұғалімге курс тағайындаңыз", 
					"8 - Оқушыларды көру", 
					"9 - Мұғалімдерді көру", 
					"10 - Журнал жасаңыз",
					"11 - Шығу" 
			};
		}
		
		
		@Override
		public void GPAMAX(double gpamax) {
			System.out.println("4.0 GPA бар студенттер саны:" + gpamax);
			
		}

		@Override
		public void GPAHIGH(double gpahigh) {
			System.out.println("GPA 3,99 мен 3,00 аралығындағы студенттер саны:" + gpahigh);
			
		}
		
		@Override
		public void GPAMEDIUM(double gpamedium) {
			System.out.println("GPA 2,99 мен 2,00 аралығындағы студенттер саны:" + gpamedium);
			
		}

		@Override
		public void COUNTOTHER(double contother) {
			System.out.println("GPA 2.00 төмен студенттер саны:" + contother);
			
		}

		@Override
		public void hINDEX(String maxResearcher) {
			System.out.println("Ең жоғары h-индексі бар зерттеуші:" + maxResearcher);
			
		}

		@Override
		public void enterTheNumverOfCreditsOfTheCourse() {
			System.out.println("Курс кредиттерінің санын енгізіңіз:");
			
		}

		@Override
		public void enterNameOfCourse() {
			System.out.println("Курс атын енгізіңіз:");
			
		}

		@Override
		public void chooseForWhichFacultyIsThisCouse() {
			System.out.println("Бұл курс қай кафедраға арналғанын таңдаңыз:");
			
		}

		@Override
		public void chooseTypeOfThisCoursefor(String faculty) {
			System.out.println("Осы курс түрін таңдаңыз" + faculty + ":");
			
		}

		@Override
		public void courseAdded(String newCourse) {
			System.out.println(newCourse + " курс қосылды.");
			
		}

		@Override
		public void chooseType() {
			System.out.println("Түрді таңдаңыз:");
			
		}

		@Override
		public void newTopic() {
			System.out.println("Жаңалық тақырыбы:");
			
		}

		@Override
		public void newTitle() {
			System.out.println("Жаңалық атауы:");
			
		}

		@Override
		public void newText() {
			System.out.println("Жаңалық мәтіні:");
			
		}

		@Override
		public void listOfRequests() {
			System.out.println("Өтініштер тізімі:");
			
		}

		@Override
		public void whatNewsDoYouWantToChange() {
			System.out.println("Қандай жаңалықты өзгерткіңіз келеді?");
		}

		@Override
		public void whichOfPartDoYouWantToChange() {
			System.out.println("Қай бөлікті өзгерткіңіз келеді?" + "\n 1 - Тақырып" + "\n 2 - Аты"
					+ "\n 3 - Текст" + "\n 0 - Шығу");
			
		}

		@Override
		public void enterNewTopic() {
			System.out.println("Жаңа тақырып енгізіңіз:");
			
		}

		@Override
		public void updateNews(String news) {
			System.out.println("Жаңалықтар жаңартуы:" + news);
			
		}

		@Override
		public void enterNewTitle() {
			System.out.println("Жаңа атау енгізіңіз:");
			
		}

		@Override
		public void enterNewText() {
			System.out.println("Введите новый текст:");
			
		}

		@Override
		public void whichCourseYouWantToAssign() {
			System.out.println("Жаңа мәтінді енгізіңіз:");
			
		}

		@Override
		public void whichTeacherWouldYouLikeToAssignThe(String courseName) {
			System.out.println(courseName + " курсты қай мұғалімге тіркегіңіз келеді?");
			
		}

		@Override
		public void assignedTo(String courseName, String teacherFirstName, String teacherLastName) {
			System.out.println(courseName + " курсы тіркелді: " + teacherFirstName + " " + teacherLastName);
			
		}

		@Override
		public void whichTeacherWouldYouLikeToAddTheLesson() {
			System.out.println("Қай мұғалімге сабақ қосқыңыз келеді?");
			
		}

		@Override
		public void noCoursesForThisTeacher() {
			System.out.println("Бұл мұғалімге арналған курстар жоқ");
			
		}

		@Override
		public void toWhichCourseOf(String teacherName, String teacherLastName) {
			System.out.println("Қайсқы курсқа: " + teacherName + " " + teacherLastName + " сабаққа тіркегіңіз келеді?");
			
		}

		@Override
		public void enterTheTypeOfLesson() {
			System.out.println("Сабақ түрін енгізіңіз:");
			
		}

		@Override
		public void enterTheDay() {
			System.out.println("Күнді енгізіңіз:");
			
		}

		@Override
		public void enterTheLessonStartTime() {
			System.out.println("Сабақтың басталу уақытын енгізіңіз:");
			
		}

		@Override
		public void enterTheRoom() {
			System.out.println("Кабинет нөмірін енгізіңіз:");
			
		}

		@Override
		public void added(String newLesson) {
			System.out.println(newLesson + " қосылды.");
			
		}

		@Override
		public void enterTheName() {
			System.out.println("Есім енгізіңіз:");
			
		}

		@Override
		public void newJournalCreated(String newJournal) {
			System.out.println(newJournal + " атты жаңа журнал жасалды.");
			
		}

		@Override
		public String[] managerResearcherMenu() {
			// TODO Auto-generated method stub
			return new String[] { 
					"----Менеджер-Зерттеуші мәзірі----",
					"1 - Статистикалық есепті құру", 
					"2 - Курс қосыңыз", 
					"3 - Мұғалімге сабақ қосу", 
					"4 - Жаңалық құрастыру",
					"5 - Сұраныстарды қарау", 
					"6 - Жаңалықты өңдеу", 
					"7 - Мұғалімге курс тағайындаңыз", 
					"8 - Оқушыларды көру", 
					"9 - Мұғалімдерді көру", 
					"10 - Журнал құрастыру",
					"11 - Шығу",
					"12 - Зерттеуші мәзірін қарау"
			};
		}
	//---------------------------------------------------------------------------------------------------------------
		@Override
		public String[] techSupportSpecialistMenu() {
			// TODO Auto-generated method stub
			return new String[] {
					"----Техникалық маман мәзірі----  ",
					"1 - Сұраныстарды қарау",
					"2 - Сұраныстарды қабылдау", 
					"3 - Сұраныстарды қабылдамау", 
					"4 - Шығу" 
					};
		}
		
		@Override
		public void orderWasAlreadyRejected() {
			System.out.println("Қате! Тапсырыс әлдеқашан кері қайтарылған!");
			
		}

		@Override
		public void orderWasAlreadyAccepted() {
			System.out.println("Қате! Тапсырыс әлдеқашан қабылданған");
			
		}

		@Override
		public void orderHasBeenAccepted() {
			System.out.println("Тапсырыс қабылданады");
			
		}

		@Override
		public void orderHasBeenRejected() {
			System.out.println("Тапсырыс қабылданбады!");
			
		}

		@Override
		public String[] techSupportSpecialistResearcherMenu() {
			// TODO Auto-generated method stub
			return new String[] {
					"----Техникалық маман-Зерттеуші мәзірі----  ",
					"1 - Тапсырыстарды қарау",
					"2 - Тапсырыстарды қабылдау", 
					"3 - Тапсырыстарды кері қайтару", 
					"4 - Шығу",
					"5 - Зерттеуші мәзірін қарау"
					};
		}
	//---------------------------------------------------------------------------------------------------------------
		@Override
		public String[] deanMenu() {
			// TODO Auto-generated method stub
			return new String[] {
					"----Декан мәзірі----",
					"1 - Барлық сұраныстарды қарау",
					"2 - Сұраныстарға қол қою", 
					"3 - Бір жаңалықты қарау", 
					"4 - Шығу"
			};
		}
		
		@Override
		public void chooseFaculty() {
			System.out.println("Факультетті таңдаңыз:");
			
		}

		@Override
		public void noRequests() {
			System.out.println("Сұраныстар жоқ!");
			
		}

		@Override
		public void emergencyRequests() {
			System.out.println("----Төтенше жағдайдағы сұраныстар----");
			
		}

		@Override
		public void enterTheRequestNumberToSign() {
			System.out.println("Қол қою үшін сұрау нөмірін енгізіңіз (немесе шығу үшін 0):");
			
		}

		@Override
		public void deanSignedRequest(String selectedRequest) {
			System.out.println("Декан қол қойды:" + selectedRequest);
			
		}

		@Override
		public void TheRequestWasSuccesfully() {
			System.out.println("Сұрауға сәтті қол қойылды және жойылды.");
			
		}

		@Override
		public String[] deanResearcherMenu() {
			
			return new String[] {
					"----Декан-Зерттеуші мәзірі----",
					"1 - Барлық сұраныстарды қарау",
					"2 - Сұраныстарға қол қою", 
					"3 - Бір жаңалықты көру", 
					"4 - Шығу",
					"5 - Зерттеуші мәзірін қарау"
			};
		}
	//---------------------------------------------------------------------------------------------------------------
		@Override
		public String[] graduateStudentMenu() {
			// TODO Auto-generated method stub
			return new String[] { 
					"----Аспирант мәзірі----",
					"1 - Транскрипті көру", 
					"2 - Курс бойынша бағаларды көру", 
					"3 - Курсқа тіркелу",
					"4 - Курс мұғалімдерін қараңыз", 
					"5 - Барлық курстарды көру", 
					"6 - Мұғалімдерді бағалаңыз", 
					"7 - Ұйымдар", 
					"8 - Бір жаңалықты қараңыз", 
					"9 - Шығу", 
					"10 - Зерттеуші мәзірін көру" 
					};
		}
		
		@Override
		public void newGrade(double grade) {
			System.out.println("Жаңа баға: " + grade);
			
		}
	//---------------------------------------------------------------------------------------------------------------
		@Override
		public String[] employeeMenu() {
			// TODO Auto-generated method stub
			return new String[]{
					"----Қызметкер мәзірі----",
					"1 - Сұраныс жіберу", 
					"2 - Тапсырыс беру", 
					"3 - Бір жаңалықты қарау", 
					"4 - Шығу"
					};
		}
		
		@Override
		public void SendingMessageTo(String message, String Username) {
			System.out.println(Username + " хабарлама жіберді: " + message);
			
		}

		@Override
		public void noDeans() {
			System.out.println("Декан жоқ");
		}

		@Override
		public void chooseTheDean() {
			System.out.println("Деканды таңдаңыз:");
			
		}

		@Override
		public void enterTheEmergencyLevel() {
			System.out.println("Төтенше жағдай деңгейін енгізіңіз:");
			
		}

		@Override
		public void enterTheMessage() {
			System.out.println("Хабарламаны енгізіңіз:");
			
		}

		@Override
		public void sentSuccesfully(String newRequest) {
			System.out.println(newRequest + " сәтті жіберілді!");
			
		}

		@Override
		public void noTechSupports() {
			System.out.println("Ешқандай техникалық көмек жоқ");
			
		}

		@Override
		public void chooseTheTechSupport() {
			System.out.println("Техникалық көмекті таңдаңыз:");
			
		}

		@Override
		public String[] employeeResearcherMenu() {
			
			return new String[]{
					"----Қызметкер-Зерттеуші мәзірі----",
					"1 - Сұраныс жіберу", 
					"2 - Тапсырыс беру", 
					"3 - Бір жаңалықты қарау", 
					"4 - Шығу", 
					"5 - Зерттеуші мәзірін қарау"
					};
		}
	//---------------------------------------------------------------------------------------------------------------
		@Override
		public String[] researcherMenu() {
			// TODO Auto-generated method stub
			return new String[] {
					"----Зерттеуші мәзірі----",
					"1 - Құжаттарды қарау", 
					"2 - Құжат құрастыру", 
					"3 - Проект көру", 
					"4 - Журналдарды қарау", 
					"5 - Журналға мақала қосыңыз", 
					"6 - Шығу"
			};
		}
		
		@Override
		public void noPapers() {
			System.out.println("Құжат жоқ");
			
		}

		@Override
		public void noProjects() {
			System.out.println("Проект жоқ");
			
		}

		@Override
		public void noJournals() {
			System.out.println("Журнал жоқ");
			
		}

		@Override
		public void chooseTheJournal() {
			System.out.println("Журналды таңдаңыз:");
			
		}

		@Override
		public void choosePaperToAdd() {
			System.out.println("Құжатты таңдаңыз:");
			
		}

		@Override
		public void addedTo(String paper, String journalName) {
			System.out.println(paper + " " + journalName + "-ға сәтті қосылды!");	
		}

		@Override
		public void enterTheNumberOfPages() {
			System.out.println("Беттер санын енгізіңіз:");
			
		}

		@Override
		public void enterValidNumberOfPages() {
			System.out.println("Шектеу қойылған беттер санын енгізіңіз.");
			
		}

		@Override
		public void enterValidNumber() {
			System.out.println("Жарамды нөмерді енгізіңіз!");
			
		}

		@Override
		public void enterTheDoi() {
			System.out.println("doi енгізіңіз:");
			
		}

		@Override
		public void newPaperAdded(String newPaper) {
			System.out.println(newPaper + " атты жаңа құжат сәтті қосылды!");
			
		}
	//---------------------------------------------------------------------------------------------------------------
		
		@Override
		public void enterReturnBack() {
			// TODO Auto-generated method stub
			System.out.println("Артқа қайту үшін, 0-ді басыңыз.");
		}


		@Override
		public void noCoursesYet() {
			System.out.println("Қазіргі сәтті курстар жоқ.");
			
		}

		@Override
		public void noCourses() {
			System.out.println("Курстар жоқ.");
			
		}

		@Override
		public void allCourses() {
			System.out.println("Барлық курстар:");
			
		}

		@Override
		public void enterYourChoice() {
			System.out.println("Таңдаңыз:");
			
		}

		@Override
		public void noTeachers() {
			System.out.println("Мұғалімдер жоқ.");
			
		}

		@Override
		public void courses() {
			System.out.println("Курстар:");
			
		}


		@Override
		public String[] changeInfoOptions() {
			// TODO Auto-generated method stub
			return new String[] {
					"1 - Пайдаланушы аты",
					"2 - Құпиясөх",
					"3 - Есімі",
					"4 - Фамилиясы"
			};
		}

		@Override
		public void enterNewUsername() {
			System.out.println("Жаңа пайдаланушы атын енгізіңіз");
			
		}

		@Override
		public void enterNewPassword() {
			System.out.println("Жаңа құпия сөзді енгізіңіз");
			
		}

		@Override
		public void enterNewFirstName() {
			System.out.println("Жаңа есім енгізіңіз");
			
		}

		@Override
		public void enterNewLastName() {
			System.out.println("Жаңа фамилия енгізіңіз");
			
		}
}
