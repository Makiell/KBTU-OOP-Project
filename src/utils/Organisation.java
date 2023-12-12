package utils;

import java.util.Vector;

import wsp.*;

public class Organisation {
	
	private String name;
	private Student head;
	private Vector<Student> members;
	
	
	public Organisation(String name, Student head) {
		this.name = name;
		this.head = head;
		this.members = new Vector<Student>();
		this.members.add(head);
	}


	@Override
	public String toString() {
		return "Organisation [name=" + name + ", head=" + head + ", members=" + members + "]";
	}
	
	
}