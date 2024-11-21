package com.klu.ReactIntegration.service;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.ReactIntegration.model.DemoUser;
import com.klu.ReactIntegration.repository.DemoUserRepo;

@Service
public class DemoUserServiceImpl implements DemoUserService{

	@Autowired
	private DemoUserRepo userRepo;
	
	@Override
	public List<DemoUser> getAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public String addUserString(DemoUser user) {
		// TODO Auto-generated method stub
		
		try {
			userRepo.save(user);
			return "Added User Successfully";
		} catch (Exception e) {
			return "Error while adding User:"+e.getLocalizedMessage();
		}
		
	}

	@Override
	public Boolean addUserBoolean(DemoUser user) {
		try {
			userRepo.save(user);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	}

}
