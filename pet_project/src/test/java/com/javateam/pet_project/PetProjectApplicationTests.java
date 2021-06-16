package com.javateam.pet_project;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PetProjectApplicationTests {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
    private SqlSessionFactory sqlSession; //작성

	 @Test
	public void testSqlSession() throws Exception{
	        System.out.println("sqlSession : " + sqlSession);
	    }


	@Test
	public void testConnection() throws Exception{
		System.out.println("ds : "+ds);
        
        Connection con = ds.getConnection(); //ds(DataSource)에서 Connection을 얻어내고
        
        System.out.println("con : "+con); //확인 후
        
        con.close(); //close
	}

}



