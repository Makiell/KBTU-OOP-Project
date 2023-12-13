package wsp;

import java.util.Objects;

import enums.*;
import database.*;
import utils.Organisation;

public class GraduateStudent extends Student{
    Grade grade;
    public GraduateStudent(String username, String password, String firstName, String lastName, Faculty faculty, Grade grade) {
        super(username, password, firstName, lastName, faculty);
        this.grade = grade;
        Researcher<GraduateStudent> researcher = new Researcher<>(this);
        Database.getInstance().addResearcher(researcher);
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraduateStudent that)) return false;
        if (!super.equals(o)) return false;

        return grade == that.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }

    @Override
    public String toString() {
        return "GraduateStudent[" + "username=" + getUsername()  +
                "courses=" + courses +
                ", gpa=" + gpa +
                ", transcript=" + transcript +
                ", faculty=" + faculty +
                ", organisation=" + organisation +
                ", grade=" + grade +
                "] ";
    }

    @Override
    public void joinOrganisation() {
        super.joinOrganisation();
    }

    @Override
    public void leaveOrganisation() {
        super.leaveOrganisation();
    }

    @Override
    public void createOrganisation() {
        super.createOrganisation();
    }

    @Override
    public void viewMenu() {
        super.viewMenu();
    }
}
