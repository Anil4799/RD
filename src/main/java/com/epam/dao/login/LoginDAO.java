package com.epam.dao.login;

import java.util.List;

import com.epam.services.login.Menu;

public interface LoginDAO {
	int login(String email,String password);
	public List<Menu> getMenuItems(int roleid);
}
