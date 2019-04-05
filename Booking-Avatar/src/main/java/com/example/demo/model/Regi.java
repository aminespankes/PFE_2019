package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regi")
public class Regi {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="regi_id")
	private int id;

	
	@Column(name="regi")
	private String regi;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRegi() {
		return regi;
	}


	public void setRegi(String regi) {
		this.regi = regi;
	}
	
	
}
