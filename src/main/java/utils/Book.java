package utils;

import java.io.InputStream;
import java.sql.Date;

public class Book {
	public int id,views;
 public String title,publication,author,category;
 public InputStream file;
 public java.sql.Date date;

public Book() {}
public Book(int id,int views,String title,String publication,String author,String category,InputStream file)
{
	this.id=id;
	this.views=views;
	this.title=title;
	this.publication= publication;
	this.author=author;
	this.category=category;
	this.file=file;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getViews() {
	return views;
}

public void setViews(int views) {
	this.views = views;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getPublication() {
	return publication;
}

public void setPublication(String publication) {
	this.publication = publication;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}
public java.sql.Date getDate(){
	return date;
}
public void setDate(Date date) {
	this.date=date;
	
}
public InputStream getFile() {
	return file;
}
public void setFile(InputStream file) {
	this.file=file;
}
 
}
