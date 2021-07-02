package com.entities;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class note {

	@Id
	private int id;
	private String title;
	@Column(length=1500)
	private String content;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public note(String title, String content, Date date) {
		super();
		this.id = new Random().nextInt(10000);
		this.title = title;
		this.content = content;
		this.date = date;
	}
	public note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
