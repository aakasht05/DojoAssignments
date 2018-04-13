package com.tony.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Song{
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	@Size(min=5,message="Name must be 5 characters minimum.")
	private String name;
	
	@Column
	@Size(min=5,message="Artist must be 5 characters minimum.")
	private String artist;
	
	@Column
	@NotNull
	private int rating;
	
	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date created_at;
	
	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date updated_at;
	
	
	@PrePersist
	public void onCreate(){this.created_at = new Date();}

	@PreUpdate
	public void onUpdate(){this.updated_at = new Date();}
	
	
	public Song(){}
	
	public Song(String name,String artist,int rating){
		this.name = name;
		this.artist = artist;
		this.rating = rating;
	}
	
	public void setId(long id){this.id=id;}
	public long getId(){return id;}
	
	public void setName(String name){this.name=name;}
	public String getName(){return name;}

	public void setArtist(String artist){this.artist=artist;}
	public String getArtist(){return artist;}
	
	public void setRating(int rating){this.rating=rating;}
	public int getRating(){return rating;}
	
	public void setCreatedAt(Date date){this.created_at = date;}
	public Date getCreatedAt(){return created_at;}

	public void setUpdatedAt(Date date){this.updated_at = date;}
	public Date getUpdatedAt(){return updated_at;}
}
