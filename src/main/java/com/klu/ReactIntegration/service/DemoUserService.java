package com.klu.ReactIntegration.service;

import java.net.http.HttpResponse;
import java.util.List;

import com.klu.ReactIntegration.model.DemoUser;

public interface DemoUserService {

	//Get users
	
	public List<DemoUser> getAll();
	
	//Post users
	String addUserString(DemoUser user);
	
	Boolean addUserBoolean(DemoUser user);
}
