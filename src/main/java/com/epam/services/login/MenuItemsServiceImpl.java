package com.epam.services.login;

import java.util.List;

import com.epam.dao.login.LoginDAOImp;


public class MenuItemsServiceImpl implements MenuItemsService {

	private static final long serialVersionUID = 1L;
	@Override
	public List<Menu> getMenuItems(int roleid) {
		return new LoginDAOImp().getMenuItems(roleid);
	}

}
