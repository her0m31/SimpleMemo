package uka.ayagi.simplememo;

import java.io.Serializable;

public class Data implements Serializable{
	private static final long serialVersionUID = -8055950644401537591L;
	private String date;
	private String text;

	public String getDate() {
	        return date;
	}

	public void setDate(String date) {
	        this.date = date;
	 }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
