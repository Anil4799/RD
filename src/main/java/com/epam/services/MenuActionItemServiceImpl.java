package com.epam.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dao.admin.BatchAction;
import com.epam.utils.DBManager;

public class MenuActionItemServiceImpl implements MenuActionItemService {
	private static final Logger LOGGER = Logger.getLogger(MenuActionItemServiceImpl.class);


	@Override
	public List<BatchAction> getMenuActionList(Connection con, int role) {
		// TODO Auto-generated method stub
		List<BatchAction> actionList = new ArrayList<BatchAction>();
		CallableStatement cs=null;
		ResultSet rs=null;
		try
		{
			LOGGER.debug("call batchAction  ...............");
			String sql = "call menuAction(?);";
			cs=con.prepareCall(sql);
			cs.setInt(1,role);
			rs=cs.executeQuery();
			LOGGER.debug("call batchAction  ...............");

			LOGGER.debug("---"+cs);
			
			
			while(rs.next())
			{
				LOGGER.debug("call batchAction 3 ...............");

				BatchAction action=new BatchAction();
				action.setStatus(rs.getString("StatusName"));
				action.setAction(rs.getString("Action"));
				actionList.add(action);
			}
			
						
		}
		catch(Exception e)
		{
			actionList=null;
		}
		finally {
			try {
				cs.close();
				rs.close();
			} catch (SQLException e) {
				
			}
		}
		
		return actionList;
	}
//	public static void main(String args[])
//	{
//		try
//		{
//			MenuActionItemServiceImpl b=new MenuActionItemServiceImpl();
//			Connection con = DBManager.getConnection();
//			List<BatchAction> lb=b.getBatchActionList(con, 1,1);
//			for (BatchAction batchAction : lb) {
//				System.out.println(batchAction.getStatus());
//			}
//		}
//		catch(Exception e)
//		{
//			
//		}
//	}

}
