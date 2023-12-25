package language;


public interface LanguageInterface {

    String[] studentMenu();

    String[] studentResearcherMenu();
    
    String[] teacherMenu();
    
    String[] teacherResearcherMenu();
    // Админ на русском языке
    String[] adminMenu();
    
    String[] addResearcherOptions();
    void whatDoYouWantToDo();
    void chooseUser();
    void whichUserDoYouWantToCreate();
    String[] addResearcherOptionsCreate();
    String[] createUserOptions();
    void enterReturnBack();
    void updateUserWhichUserDoYouWantToChange();
    void removeUserChooseUserToDelete();
    void seeLogFilesChooseUserToSeeLogs();
    void seeLogFilesNoLogsForThisUser();
    
    
    String[] managerMenu();
    
    String[] managerResearcherMenu();
    
    String[] deanMenu();
    
    String[] deanResearcherMenu();
    
    String[] techSupportSpecialistMenu();
    
    String[] techSupportSpecialistResearcherMenu();
    
    String[] graduateStudentMenu();
    
    String[] employeeMenu();
    
    String[] employeeResearcherMenu();
    
    String[] researcherMenu();
    
}

