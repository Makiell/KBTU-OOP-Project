package utils;

import java.io.Serializable;
import java.util.Vector;

import wsp.User;

public class ResearchJournal implements Serializable, Observed {
	String name;
	Vector<ResearchPaper> papers = new Vector<>();
	Vector<User> subscribers = new Vector<>();
	
	public ResearchJournal(String name) {
		this.name = name;
	}
	
	public void addPaper(ResearchPaper paper) {
		this.papers.add(paper);
		this.notifyObservers(paper);
	}
	
	public void removePaper(ResearchPaper paper) {
		this.papers.remove(paper);
	}
	
	@Override
	public void addObserver(User observer) {
		this.subscribers.add(observer);
		
	}
	@Override
	public void removeObserver(User observer) {
		this.subscribers.remove(observer);
		
	}
	
	@Override
	public void notifyObservers(ResearchPaper paper) {
		for(User u: subscribers) {
			u.handleEvent(paper);
		}
		
	}

}