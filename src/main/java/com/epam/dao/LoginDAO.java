package com.epam.dao;

import java.util.ArrayList;

import com.epam.services.login.Menu;

public interface LoginDAO {
	int login(String email,String password);
	public ArrayList<Menu> getMenuItems(int roleid);
}
