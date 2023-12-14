package wsp;
import enums.*;
import utils.*;
import database.Database;
import java.util.*;
public class Manager extends Employee{
    private TypeManager typeManager;
    public Manager(String username, String password, String firstName, String lastName, TypeManager typeManager) {
        super(username, password, firstName, lastName);
        this.typeManager = typeManager;
    }

    public TypeManager getTypeManager() {
        return typeManager;
    }

    public void setTypeManager(TypeManager typeManager) {
        this.typeManager = typeManager;
    }
    public void createStatisticReport(){

    }
    public void addCourse(){

    }
    public void createNews(){
        Scanner s = new Scanner(System.in);
        System.out.println("News t");
    }
}
