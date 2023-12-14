package utils;

import java.util.Vector;

public class News {
	
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Vector<String> getComments() {
        return comments;
    }

    public void setComments(Vector<String> comments) {
        this.comments = comments;
    }

    @Override
	public String toString() {
		return "News [topic=" + topic + ", title=" + title + ", text=" + text + ", comments=" + comments + "]";
	}
	
	
}
