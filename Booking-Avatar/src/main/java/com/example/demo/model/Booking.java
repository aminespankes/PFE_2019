package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

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
	 
	 @Column(name = "starttime")
	 private String starttime;
	 
	 @Column(name = "timefin")
	 private Time timefin;
	 
	 @Column(name = "endtime")
	 private String endtime;
	
	 @Column(name = "description")
	 private String description; 
	 
	 @Column(name = "payement")
		private int payement;
	
	 @Column(name = "active")
		private int active;
	 
	 @Column(name = "userimage")
		private String userimage;
	
	 @Column(name = "avatarimage")
		private String avatarimage;
	 
	 @Column(name = "usercountry")
		private String usercountry;
	 
	 @Column(name = "avatarcountry")
		private String avatarcountry;
	 
	 @Column(name = "usercity")
		private String usercity;
	 
	 @Column(name = "avatarcity")
		private String avatarcity;
	 
	 @Column(name = "avatarphone")
		private String avatarphone;
	
	 @Column(name = "userphone")
		private String userphone;
	 
	 @OneToMany(cascade=CascadeType.ALL)
		@JoinTable(name="booking_avatar_user_table",joinColumns=@JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="user_id"))
		private List<Avatar> avatarList = new ArrayList<>();
	 
	 @OneToMany(cascade=CascadeType.ALL)
		@JoinTable(name="booking_avatar_user_table",joinColumns=@JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="user_id1"))
		private List<User> avatarList1 = new ArrayList<>();
	 

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

	public String getUserimage() {
		return userimage;
	}

	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}

	public String getAvatarimage() {
		return avatarimage;
	}

	public void setAvatarimage(String avatarimage) {
		this.avatarimage = avatarimage;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getUsercountry() {
		return usercountry;
	}

	public void setUsercountry(String usercountry) {
		this.usercountry = usercountry;
	}

	public String getAvatarcountry() {
		return avatarcountry;
	}

	public void setAvatarcountry(String avatarcountry) {
		this.avatarcountry = avatarcountry;
	}

	public String getUsercity() {
		return usercity;
	}

	public void setUsercity(String usercity) {
		this.usercity = usercity;
	}

	public String getAvatarcity() {
		return avatarcity;
	}

	public void setAvatarcity(String avatarcity) {
		this.avatarcity = avatarcity;
	}

	public String getAvatarphone() {
		return avatarphone;
	}

	public void setAvatarphone(String avatarphone) {
		this.avatarphone = avatarphone;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public List<Avatar> getAvatarList() {
		return avatarList;
	}

	public void setAvatarList(List<Avatar> avatarList) {
		this.avatarList = avatarList;
	}

	public List<User> getAvatarList1() {
		return avatarList1;
	}

	public void setAvatarList1(List<User> avatarList1) {
		this.avatarList1 = avatarList1;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", username=" + username + ", emailuser=" + emailuser + ", avatarname="
				+ avatarname + ", emailavatar=" + emailavatar + ", date=" + date + ", timedeb=" + timedeb
				+ ", starttime=" + starttime + ", timefin=" + timefin + ", endtime=" + endtime + ", description="
				+ description + ", payement=" + payement + ", active=" + active + ", userimage=" + userimage
				+ ", avatarimage=" + avatarimage + ", usercountry=" + usercountry + ", avatarcountry=" + avatarcountry
				+ ", usercity=" + usercity + ", avatarcity=" + avatarcity + ", avatarphone=" + avatarphone
				+ ", userphone=" + userphone + "]";
	}
	 

}
