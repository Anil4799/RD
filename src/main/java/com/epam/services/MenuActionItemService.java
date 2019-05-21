package com.epam.services;

import java.sql.Connection;
import java.util.List;

import com.epam.dao.admin.MenuAction;

public interface MenuActionItemService {
	public List<MenuAction> getMenuActionList(Connection con,int role);


}
