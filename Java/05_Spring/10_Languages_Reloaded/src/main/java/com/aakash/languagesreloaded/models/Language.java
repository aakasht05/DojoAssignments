package com.tony.languagesreloaded.models;

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
public class Language {
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	@Size(min=2,max=20,message="Name must be between 2-20 characters.")
	private String name;
	
	@Column
	@Size(min=2,max=20,message="Creator must be between 2-20 characters.")
	private String creator;
	
	@Column
	@NotNull
	private double version;
	
	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date created_at;
	
	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date updated_at;
	
	@PrePersist
	protected void onCreated(){this.created_at = new Date();}
	
	@PreUpdate
	protected void onUpdated(){this.updated_at = new Date();}
	
	public Language(){}
	
	public Language(String name,String creator,double version){
		this.name    = name;
		this.creator = creator;
		this.version = version;
	}
	
	public void setId(long id){this.id=id;}
	public long getId(){return id;}
	
	public void setName(String name){this.name=name;}
	public String getName(){return name;}
	
	public void setCreator(String creator){this.creator=creator;}
	public String getCreator(){return creator;}

	public void setVersion(double version){this.version = version;}
	public double getVersion(){return version;}
}
