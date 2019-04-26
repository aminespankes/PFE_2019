package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Persone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	
	@NotNull(message="Please enter an photo")
	@Column(name = "image")
	 private String image; 
	
	@NotNull
	 @Size(min=2,max=20, message=" Name must be between 2 and 30 characters")
	 @Column(name = "name")
	 private String name; 
	
	@NotNull
	@Size(min=3,max=20,message=" UserName must be between 3 and 30 characters")
	 @Column(name = "username",unique=true)
	 private String username;
	 
	@NotNull
	
	 @Column(name = "date")
	 private String date;
	 
	
	
	 
	 @NotNull
	    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid")
		@Column(name = "email",unique=true)
		 private String email;
	

	 @Column(name = "password")
	 private String password;
	 
	 @Column(name = "country")
	 private String country;
	 
	 @Size(min=4,max=20,message=" Verified your city")
	 @Column(name = "city")
	 private String city;
	 
	 @Size(min=4,max=20,message=" Verified your street")
	 @Column(name = "street")
	 private String street;
	 
	 @Column(name = "zip")
	 private String zip;
	 
	 @Column(name = "numtel")
	 private String numtel;
	 
	 @Column(name = "gender")
	 private String gender;
	 
	 @Column(name = "role")
	 private String role;
	 
	 @Column(name = "active")
		private int active;
	 
	 
	 
	 
	 
	 public Persone() {
			
			// TODO Auto-generated constructor stub
		}
		public Persone(int id, String image, String name, String username, String date, String email, String password,
				String country, String city, String street, String zip, String numtel, String gender, String role,
				int active, Set<Regi> regis) {
			super();
			this.id = id;
			this.image = image;
			this.name = name;
			this.username = username;
			this.date = date;
			this.email = email;
			this.password = password;
			this.country = country;
			this.city = city;
			this.street = street;
			this.zip = zip;
			this.numtel = numtel;
			this.gender = gender;
			this.role = role;
			this.active = active;
			this.regis = regis;
		}
	 
	 
	 
	 
	 
	 
		@ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "persone_regi", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "regi_id"))
		private Set<Regi> regis;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
		public String getNumtel() {
			return numtel;
		}
		public void setNumtel(String numtel) {
			this.numtel = numtel;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public int getActive() {
			return active;
		}
		public void setActive(int active) {
			this.active = active;
		}
		public Set<Regi> getRegis() {
			return regis;
		}
		public void setRegis(Set<Regi> regis) {
			this.regis = regis;
		}
		@Override
		public String toString() {
			return "Persone [id=" + id + ", image=" + image + ", name=" + name + ", username=" + username + ", date="
					+ date + ", email=" + email + ", password=" + password + ", country=" + country + ", city=" + city
					+ ", street=" + street + ", zip=" + zip + ", numtel=" + numtel + ", gender=" + gender + ", role="
					+ role + ", active=" + active + ", regis=" + regis + "]";
		}
		
		
		
		
		
		
		

}
