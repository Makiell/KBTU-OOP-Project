package utils;

import java.io.Serializable;
import java.util.Vector;

import wsp.User;

public class ResearchJournal implements Serializable, Observed {
	
	private static final long serialVersionUID = -8045146890425399823L;
	
	String name;
	Vector<ResearchPaper> papers = new Vector<>();
	Vector<User> subscribers = new Vector<>();
	
	public ResearchJournal(String name) {
		this.name = name;
	}
	
	public void addPaper(ResearchPaper paper) {
		this.papers.add(paper);
		this.notifyObservers(paper, this);
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
	public void notifyObservers(ResearchPaper paper, ResearchJournal rj) {
		for(User u: subscribers) {
			u.handleEvent(paper, rj);
		}
		
	}
	
	public String toString() {
		return "Journal " + name + ", papers =" + papers + ", subs =" + subscribers;
	}

	public String getName() {
		return this.name;
	}

}