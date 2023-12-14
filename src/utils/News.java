package utils;

import java.io.Serializable;
import java.util.Vector;

public class News implements Serializable {
	
	private String topic;
	private String title;
	private String text;
	private Vector<String> comments;
	
	public News(String topic, String title, String text) {
		this.topic = topic;
		this.title = title;
		this.text = text;
		this.comments = new Vector<String>();
	}



	@Override
	public String toString() {
		return "News [topic=" + topic + ", title=" + title + ", text=" + text + ", comments=" + comments + "]";
	}
	
	
}
