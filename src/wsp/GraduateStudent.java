package wsp;

import enums.Faculty;

public class GraduateStudent extends Student{
    Grade grade;
    public GraduateStudent(String username, String password, String firstName, String lastName, Faculty faculty) {
        super(username, password, firstName, lastName, faculty);
    }
}
