package utils;

import java.util.List;
import java.util.Vector;

public interface Observer {
	public void handleEvent(Vector<ResearchPaper> papers);
}
