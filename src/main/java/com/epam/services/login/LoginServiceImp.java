package com.epam.services.login;

import com.epam.dao.login.LoginDAOImp;

public class LoginServiceImp implements LoginService {
	@Override
	public int login(String email, String password) {
		return new LoginDAOImp().login(email,password);
	}
}
