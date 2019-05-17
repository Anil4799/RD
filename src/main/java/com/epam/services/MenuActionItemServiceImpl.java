package com.epam.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dao.admin.MenuAction;
import com.epam.utils.DBManager;

public class MenuActionItemServiceImpl implements MenuActionItemService {
	private static final Logger LOGGER = Logger.getLogger(MenuActionItemServiceImpl.class);


	@Override
	public List<MenuAction> getMenuActionList(Connection con, int role) {
		List<MenuAction> actionList = new ArrayList<>();
		String sql = "call menuAction(?);";
		try(CallableStatement callableStatement= con.prepareCall(sql);)
		{
			callableStatement.setInt(1, role);
			try(ResultSet rs = callableStatement.executeQuery();)
			{
				while(rs.next())
				{
					LOGGER.debug("call batchAction 3 ...............");

					MenuAction action=new MenuAction();
					action.setStatusName(rs.getString("StatusName"));
					action.setAction(rs.getString("Action"));
					actionList.add(action);
				}
						
			}
			
		}
		catch(Exception e)
		{
			actionList=null;
			LOGGER.debug(e.getMessage());

		}
		
		
		return actionList;
	}

}
