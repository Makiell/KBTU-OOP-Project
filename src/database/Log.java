package database;
import utils.*;
import wsp.*;

import java.io.Serializable;

import enums.*;

public class Log implements Serializable {

    private String action;
    public Log( String action){
        this.action = action;
    }
    
    public String toString() {
    	return action;
    }

}
