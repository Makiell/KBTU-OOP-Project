package utils;

import java.util.Vector;

import wsp.*;

public class Organisation {
	
	private String name;
	private Student head;
	private Vector<Student> members;
	public Organisation(){

    }
	
	public Organisation(String name, Student head) {
		this.name = name;
		this.head = head;
		this.members = new Vector<Student>();
		this.members.add(head);
	}


	@Override
	public String toString() {
		return "Organisation [name=" + name + ", head=" + head.getUsername() + ", members=" + members + "]";
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