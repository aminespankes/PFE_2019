package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;

import com.example.demo.repository.adminRepository;


@Service("adminServiceImp")
public class adminServiceImp implements adminService {
	@Autowired
	adminRepository adminrepository;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	adminService adminservice;
	@Override
	public Admin findAdminByEmail(String email) {
		return adminrepository.findByEmail(email);	
		}

	@Override
	public void saveAdmin(Admin admin) {
		admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
		adminrepository.save(admin);
	}

	@Override
	public List<Admin> listAll() {
		 return (List<Admin>) adminrepository.findAll();
	}

	@Override
	public Admin getAdminById(int id) {
		 return adminrepository.getOne(id);
		
	}

	@Override
	public void delete(int id) {
		adminrepository.deleteById(id);
		
	}

	@Override
	public void updateAdmin(Admin admin) {
		adminservice.updateAdmin(admin);
		
	}

}
