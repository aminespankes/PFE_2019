package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "username")
	 private String username; 
	
	@Column(name = "emailuser")
	 private String emailuser; 
	
	@Column(name = "avatarname")
	 private String avatarname; 
	
	@Column(name = "emailavatar")
	 private String emailavatar;
	
	 @Column(name = "date")
	 private Date date;
	
	 @Column(name = "timedeb")
	 private Time timedeb;
	 
	 @Column(name = "timefin")
	 private Time timefin;
	
	 @Column(name = "description")
	 private String description; 
	 
	 @Column(name = "payement")
		private int payement;
	
	 @Column(name = "active")
		private int active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailuser() {
		return emailuser;
	}

	public void setEmailuser(String emailuser) {
		this.emailuser = emailuser;
	}

	public String getAvatarname() {
		return avatarname;
	}

	public void setAvatarname(String avatarname) {
		this.avatarname = avatarname;
	}

	public String getEmailavatar() {
		return emailavatar;
	}

	public void setEmailavatar(String emailavatar) {
		this.emailavatar = emailavatar;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTimedeb() {
		return timedeb;
	}

	public void setTimedeb(Time timedeb) {
		this.timedeb = timedeb;
	}

	public Time getTimefin() {
		return timefin;
	}

	public void setTimefin(Time timefin) {
		this.timefin = timefin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPayement() {
		return payement;
	}

	public void setPayement(int payement) {
		this.payement = payement;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	 

}
