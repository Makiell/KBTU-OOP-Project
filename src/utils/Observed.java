package utils;

import wsp.*;

public interface Observed {
	void addObserver(User observer);
	
	void removeObserver(User observer);
	
	void notifyObservers(ResearchPaper paper, ResearchJournal rj);
}
