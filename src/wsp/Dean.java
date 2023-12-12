package wsp;

import java.util.Map;
import java.util.Vector;

import enums.Faculty;
import enums.TeacherTitle;
import utils.*;
import utils.Course;
import utils.Lesson;

public class Dean extends Teacher {

    Vector <Request> requests = new Vector<>();
    public Dean(String username, String password, String firstName, String lastName, TeacherTitle typeTeacher,
                Vector<Course> courses, Faculty faculty, Map<Course, Vector<Lesson>> lessons, double rate) {
        super(username, password, firstName, lastName, typeTeacher, courses, faculty, lessons, rate);
        // TODO Auto-generated constructor stub
    }
    public Vector<Request> getRequests(){
        return requests;
    }

    public void setRequests(Vector <Request> requests) {
        this.requests = requests;
    }


    public void signRequests(Request request) {
        if (requests.isEmpty()) {
            System.out.println("Requests is empty");
        }
        System.out.println("Signing requests");
        request.setTo(this);
        System.out.println("Signed: " + request.toString());

        request.allRequest(requests); // кароч он добавляеть один элемент в список запросов
    }
}

