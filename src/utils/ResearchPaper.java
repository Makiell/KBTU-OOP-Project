package utils;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import wsp.*;

public class ResearchPaper implements Serializable {
	
	private String name;
	private Vector<Researcher> authors;
	private int citations;
	private int pages;
	private Date date;
	private String doi;
	
	public ResearchPaper(String name, Vector<Researcher> authors, int pages, String doi) {
		this.name = name;
		this.authors = authors;
		this.pages = pages;
		this.date = new Date();
		this.doi = doi;
		this.citations = 0;
	}

	@Override
	public String toString() {
		return "ResearchPaper [name=" + name + ", authors=" + authors.size() + ", citations=" + citations + ", pages=" + pages
				+ ", date=" + date + ", doi=" + doi + "]";
	}
	
	
}
