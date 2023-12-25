package utils;

import java.io.Serializable;
import java.util.Vector;

/**
 * The ResearchProject class represents a research project that consists of multiple research papers.
 */
public class ResearchProject implements Serializable {
	
	private Vector<ResearchPaper> papers;
	
	/**
     * Creates a new research project with an empty list of research papers.
     */
    public ResearchProject() {
        this.papers = new Vector<>();
    }
}
