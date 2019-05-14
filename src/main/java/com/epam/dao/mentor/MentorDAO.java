package com.epam.dao.mentor;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.epam.mentor.bean.MentorBean;
import com.epam.utils.DBManager;

public class MentorDAO {

	public int createMentor(MentorBean mentor) throws SQLException
	{
		Connection con = DBManager.getConnection();
	
		PreparedStatement ps = con.prepareStatement("insert into Mentor_info values(?,?,?,?,?,?,?)");
		
		ps.setString(1,mentor.getEmail());
		ps.setString(2, mentor.getName());
		ps.setDate(3, new java.sql.Date((mentor.getMentorStartDate().getTime())));
		ps.setDate(4, new java.sql.Date((mentor.getMentorEndDate().getTime())));
		ps.setInt(5, mentor.getMaxNoOfMentees());
		ps.setString(6, mentor.getTechnologyStream());
		ps.setString(7, mentor.getStatus());
		int insert = ps.executeUpdate();
		return insert;
		
	}
	
	
	
	
}
