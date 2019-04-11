package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Admin;


public interface adminService {
	
	public Admin findAdminByEmail(String email);
	
	public void saveAdmin(Admin admin);
	
	
	public List<Admin> listAll() ;
	
	
	Admin getAdminById(int id);
	
	public void delete(int id);
	
	public void updateAdmin(Admin admin);
	 

}
