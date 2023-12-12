package utils;

import java.util.Date;
import java.util.Vector;

import wsp.*;

public class ResearchPaper {
	
	private String name;
	private Vector<Researcher> authors;
	private int citations;
	private int pages;
	private Date date;
	private String doi;
	
	public ResearchPaper(String name, Vector<Researcher> authors, int pages, Date date, String doi) {
		this.name = name;
		this.authors = authors;
		this.pages = pages;
		this.date = date;
		this.doi = doi;
		this.citations = 0;
	}

	@Override
	public String toString() {
		return "ResearchPaper [name=" + name + ", authors=" + authors + ", citations=" + citations + ", pages=" + pages
				+ ", date=" + date + ", doi=" + doi + "]";
	}
	
	
}
