package utils;

import wsp.*;

import java.io.Serializable;

import database.Database;
import enums.*;

public class Order implements Serializable {
    private Status status;
    public AcceptStatus acceptStatus;
    private String message; 
    private TechSupportSpecialist to;

    public Order(Status status, String message, TechSupportSpecialist to) {  super();
        this.status = status;  this.message = message;
        this.to = to;
        to.getOrders().add(this);
    }

    public Status getStatus() {
        return status; }
    
    public AcceptStatus getAcceptStatus() {
    	return acceptStatus;
    }

    public String getMessage() {
        return message; }

    public TechSupportSpecialist getTo() {
        return to; }

    public void setStatus(Status status) {
        this.status = status; }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTo(TechSupportSpecialist to) {  this.to = to;
    }

    @Override
    public String toString() {  return "Order [status=" + status + ", message="
    + message + ", to=" + to + "order" +
    		(this.getAcceptStatus() == AcceptStatus.ACCEPTED ? "was not acepted!" : "was accepted")  + "]";
    
    }

}
