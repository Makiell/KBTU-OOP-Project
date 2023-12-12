package utils;

import enums.*;
import wsp.*;

public class Request {

    private Emergency emergency;
    private String message;
    private Dean to;


    public Request(Emergency emergency, String message, Dean to) {
        this.emergency = emergency;
        this.message = message;
        this.to = to;
    }


    @Override
    public String toString() {
        return "Request [emergency=" + emergency + ", message=" + message + ", to=" + to + "]";
    }


}
