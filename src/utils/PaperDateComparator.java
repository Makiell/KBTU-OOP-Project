package utils;

import java.util.Comparator;

public class PaperDateComparator implements Comparator<ResearchPaper> {

	@Override
	public int compare(ResearchPaper o1, ResearchPaper o2) {
		return o1.getDate().compareTo(o2.getDate());
	}

}
