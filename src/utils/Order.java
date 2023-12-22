package utils;

import wsp.*;

import java.io.Serializable;

import enums.*;

public class Order implements Serializable {
    private Status status;
    private String message; 
    private TechSupportSpecialist to;

    public Order(String message, TechSupportSpecialist to) {
        this.status = Status.NEW;  
        this.message = message;
        this.to = to;
        to.getOrders().add(this);
    }

    public Status getStatus() {
        return status; }

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
    + message + ", to=" + to;
    
    }

}
