package com.epam.services.login;

import com.epam.dao.LoginDAOImp;

public class LoginServiceImp implements LoginService {

	
	@Override
	public int login(String email, String password) {
		// TODO Auto-generated method stub
		return new LoginDAOImp().login(email,password);
	}
}
