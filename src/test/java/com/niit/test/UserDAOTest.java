package com.niit.test;




import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserDAOTest 
{
	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void registerUserTest()
	{
		User user = new User();
		user.setUsername("ani");
		user.setPassword("Salve");
		user.setCustomerName("Aniruddha Mahendra Salve");
		user.setEmailId("anisalve39@outlook.com");
		user.setMobileNo("9773616437");
		user.setEnabled(true);
		user.setRole("Premium User");
//ERROR IN NEXT LINE
		assertTrue("Problem in registering user",userDAO.addUser(user));//condition is false, it should be true!!!
	}
	
	@Ignore
	@Test
	public void modifyUserTest()
	{
		User user = new User();
		user = userDAO.getUser(1);
		user.setCustomerName("CHANGED");
		assertTrue("Problem in modifying user",userDAO.editUser(user));
	}
	
	
	@Ignore
	@Test
	public void deleteUserTest()
	{
		User user=new User();
		user=userDAO.getUser(1);
		assertTrue("Problem in deleting user",userDAO.deleteUser(user));
	}
	
	@Ignore
	@Test
	public void singleUsersTest() 
	{
		User singleUser=new User();
		singleUser=userDAO.getUser(81);
		assertNotNull("Problem in listing users:", singleUser);
		System.out.println(singleUser.getCustomerName() + ": "+singleUser.getUsername()+": "+singleUser.getPassword()+": "+singleUser.getEmailId()+": "+singleUser.getMobileNo()+": "+singleUser.getRole()+": "+singleUser.getEnabled());
	}
	
	//@Ignore
	@Test
	public void listUsersTest() 
	{
		List<User> listUser = userDAO.listUser();
		assertNotNull("Problem in listing users:", listUser);
		for (User user : listUser) 
		{
			System.out.println(user.getCustomerName() + ": "+user.getUsername()+": "+user.getPassword()+": "+user.getEmailId()+": "+user.getMobileNo()+": "+user.getRole()+": "+user.getEnabled());
		}
	}
}