package utils;

import wsp.*;

import java.io.Serializable;

import enums.*;

public class Order implements Serializable {
    private Status status;
    private String message; 
    private TechSupportSpecialist to;
    public boolean isAccept = false;
    public boolean isReject = false;

    public Order(Status status, String message, TechSupportSpecialist to) {  super();
        this.status = status;  this.message = message;
        this.to = to; 
        this.to = to;
        to.viewOrders().add(this);
        to.getOrders().add(this);
    }

    public Status getStatus() {
        return status; }
    
    public boolean isAccepted() {
    	return isAccept;
    }
    
    public boolean isRejected() {
    	return isReject;
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
    public String toString() {  return "Order [status=" + status + ", message=" + message + ", to=" + to + "]";
    public String toString() {  return "Order [status=" + status + ", message="
    + message + ", to=" + to + "order" + (this.isAccepted()? "was not acepted!" : "was accepted")  + "]";
    
    }

}
