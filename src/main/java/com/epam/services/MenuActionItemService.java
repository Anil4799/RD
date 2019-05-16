package com.epam.services;

import java.sql.Connection;
import java.util.List;

import com.epam.dao.admin.BatchAction;

public interface MenuActionItemService {
	public List<BatchAction> getMenuActionList(Connection con,int role);


}
