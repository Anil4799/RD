package com.epam.services.login;

import java.util.ArrayList;
import com.epam.dao.LoginDAOImp;


public class GetMenuItemsServiceImpl implements GetMenuItemsService {
	//ArrayList<Menu> menu;
	@Override
	public ArrayList<Menu> getMenuItems(int roleid) {
		return new LoginDAOImp().getMenuItems(roleid);
	}

}
