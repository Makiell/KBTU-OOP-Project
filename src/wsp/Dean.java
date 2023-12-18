package wsp;

import java.io.Serializable;
import java.util.Map;
import java.util.Vector;

import enums.Faculty;
import enums.TeacherTitle;
import utils.*;
import utils.Course;
import utils.Lesson;

public class Dean extends Teacher implements Serializable {

    Vector <Request> requests = new Vector<>();
    public Dean(String username, String password, String firstName, String lastName,
                Faculty faculty) {
        super(username, password, firstName, lastName, null, faculty);
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
        System.out.println("Signed: " + request.toString());
        // кароч он добавляеть один элемент в список запросов
    }
    public void addRequest(Request request){
        requests.add(request);
    }
    
    public String toString() {
    	return "Dean " + super.toString();
    }
}

