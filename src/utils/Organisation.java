package utils;

import java.io.Serializable;
import java.util.Vector;

import wsp.*;

public class Organisation implements Serializable {
	
	private String name;
	private Student head;
	private Vector<Student> members;
	public Organisation(){

    }
	
	public Organisation(String name, Student head) {
		this.name = name;
		this.head = head;
		this.members = new Vector<Student>();
	}


	@Override
	public String toString() {
		return "Organisation [name=" + name + ", head=" + head.getFirstName()  + ", members=" + members.size() + "]";
	}


    public void addMember(Student student) {
        members.add(student);
    }

    public void removeMember(Student student) {
        members.remove(student);
    }

    public String getName() {
        return name;
    }
}