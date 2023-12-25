package utils;

import java.util.Comparator;

public class PaperPagesComparator implements Comparator<ResearchPaper> {

	@Override
	public int compare(ResearchPaper o1, ResearchPaper o2) {
		return Integer.compare(o1.getPages(), o2.getPages());
	}

}
