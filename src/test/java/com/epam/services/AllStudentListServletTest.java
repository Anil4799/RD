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

import com.epam.dao.Student;
import com.epam.utils.DBManager;

class AllStudentListServletTest {
	static DBManager db;
	static StudentInfoServiceImpl student;
	static Connection con=null;
	List<Student> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		student=new StudentInfoServiceImpl();
		db=new DBManager();
	}
     
		
	@Test 
	 void test1() throws SQLException {
	
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


