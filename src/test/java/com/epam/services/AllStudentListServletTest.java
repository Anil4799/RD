package com.epam.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;

import com.epam.common.servlet.StudentInfoServiceImpl;
import com.epam.dao.admin.StudentBean;
import com.epam.utils.DBManager;

import jdk.nashorn.internal.ir.annotations.Ignore;

class AllStudentListServletTest {
	static DBManager db;
	static StudentInfoServiceImpl student;
	static Connection con=null;
	List<StudentBean> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		student=new StudentInfoServiceImpl();
		db=new DBManager();
	}
     

		
	@Ignore
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
	    	
	    	
	    	
	@Ignore
	void test2()
	{   lsactual =student.getAllStudentDetails(DBManager.getConnection());
	StudentBean s= lsactual.get(1);
	String name=null;
	String batch=null;
	String coreSkill=null;
	String mentor=null;
	String status=null;
//		name=s.getName();
//		batch=s.getBatch();
//		coreSkill=s.getCoreSkill();
//		mentor=s.getMentor();
//		status=s.getStatus();
//		
//		assertNotNull(name);
//		assertNotNull(batch);
//		assertNotNull(coreSkill);
//		assertNotNull(mentor);
//		assertNotNull(status);

		
		}
	
        
	 
	
		

	@Ignore
	void exceptionTesting() {
	    Throwable exception = assertThrows(SQLException.class, () ->
	    { 
	       throw new SQLException("a message");
	    });
	    assertEquals("a message", exception.getMessage());
	}
	

	@Ignore
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


