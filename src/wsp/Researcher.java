package wsp;

import java.io.Serializable;
import java.util.Vector;

import utils.*;

public class Researcher<T> implements Serializable {
	
	private T user;
	private Vector<ResearchProject> projects;
	private Vector<ResearchPaper> papers;
	private int hIndex;
	
	public Researcher(T user) {
		this.user = user;
	}
	
	
	public void printPapers() {
		
		for(ResearchPaper p : papers) {
			System.out.println(p);
		}
	}
	

	public T getUser() {
		return user;
	}


	public void setUser(T user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Researcher [user=" + user + ", hIndex=" + hIndex + "]";
	}
	
	
	
	
}
