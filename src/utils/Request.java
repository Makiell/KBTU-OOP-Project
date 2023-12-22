package utils;

import enums.*;
import wsp.*;

import java.io.Serializable;
import java.util.*;
public class Request implements Serializable {

    private Emergency emergency;
    private String message;
    private Dean to;
    private Status status;


    public Request(Emergency emergency, String message, Dean to) {
        this.emergency = emergency;
        this.message = message;
        this.to = to;
        this.status = Status.NEW;
        to.addRequest(this);
    }



    public Emergency getEmergency() {
        return emergency;
    }



    public String getMessage() {
        return message;
    }



    public Dean getTo() {
        return to;
    }



    public void setEmergency(Emergency emergency) {
        this.emergency = emergency;
    }



    public void setMessage(String message) {
        this.message = message;
    }

    
    public void setStatus(Status status) {
    	this.status = status;
    }


    public void setTo(Dean to) {
        this.to = to;
    }

    public void allRequest(Vector <Request> requests) {
        requests.add(this);
    }



    @Override
    public String toString() {
        return "Request [emergency=" + emergency + ", status=" + status + ", message=" + message + ", to=" + to + "]";
    }





}
