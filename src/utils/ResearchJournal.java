package utils;

import java.io.Serializable;
import java.util.Vector;

import wsp.User;

public class ResearchJournal implements Serializable, Observed {
	String name;
	Vector<ResearchPaper> papers = new Vector<>();
	Vector<User> subscribers = new Vector<>();
	
	public ResearchJournal(String name) {
		
	}
	
	public void addPaper(ResearchPaper paper) {
		this.papers.add(paper);
		this.notifyObservers();
	}
	
	public void removePaper(ResearchPaper paper) {
		this.papers.remove(paper);
	}
	
	@Override
	public void addObserver(Observer observer) {
		this.subscribers.add((User) observer);
		
	}
	@Override
	public void removeObserver(Observer observer) {
		this.subscribers.remove((User) observer);
		
	}
	@Override
	public void notifyObservers() {
		for(Observer observer: subscribers) {
			observer.handleEvent(this.papers);
		}
		
	}
}