package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.epam.dao.admin.AdminStudent;
import com.epam.services.admin.AdminStudentInfoServiceImpl;
import com.epam.utils.DBManager;

class AllStudentListServletTest {
	static DBManager db;
	static AdminStudentInfoServiceImpl student;
	static Connection con=null;
	List<AdminStudent> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		student=new AdminStudentInfoServiceImpl();
		db=new DBManager();
	}
     

		
	@Test 
	 void test1() throws Exception {
	
	    con=DBManager.getConnection();
	    String sql="call student();";
		CallableStatement cs= con.prepareCall(sql);
		ResultSet rs = cs.executeQuery();
	    int expected=0;
	    
	        
	    	if(rs != null)
	    	    {
	    	//fail("Value given is not as expected");
	    	
	    while(rs.next())
	    {
	    	expected++;
	    }
	    
	 lsactual =student.getAllStudentDetails(DBManager.getConnection());
		assertEquals(expected, lsactual.size());

			
	}
	}
	    	
	    	
	    	
	@Test
	void test2()
	{   lsactual =student.getAllStudentDetails(DBManager.getConnection());
	AdminStudent s= lsactual.get(1);
	String name=null;
	String batch=null;
	String coreSkill=null;
	String mentor=null;
	String status=null;
		name=s.getName();
		batch=s.getBatch();
		coreSkill=s.getcoreSkill();
		mentor=s.getMentor();
		status=s.getStatus();
		
		assertNotNull(name);
		assertNotNull(batch);
		assertNotNull(coreSkill);
		assertNotNull(mentor);
		assertNotNull(status);

		
		}
	
        
	 
	
		

	@Test
	void exceptionTesting() {
	    Throwable exception = assertThrows(SQLException.class, () ->
	    { 
	       throw new SQLException("a message");
	    });
	    assertEquals("a message", exception.getMessage());
	}
	

	@Test
	  void testExpectedExceptionWithSuperType() {
		 Throwable exception =assertThrows(Exception.class, () -> {
	    	throw new Exception("actual message");
	    });
	    assertEquals("actual message", exception.getMessage());
	  }
	

/*	
@Test
void testExpectedException() {
	  Assertions.assertThrows(SQLException.class,() -> {
      student.getAllStudentDetails(con);
    });
}
*/
	
	
}


