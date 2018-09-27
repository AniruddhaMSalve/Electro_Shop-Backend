package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;

@Repository("userDAO")
@Transactional

public class UserDAOImpl implements UserDAO 
{
 
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	
	@Override
	public boolean editUser(User user) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(user); 
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}



	@Override
	public boolean deleteUser(User user) 
	{
		try 
		{
			sessionFactory.getCurrentSession().delete(user); 
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	@Override
	public User getUser(int userId) 
	{
		Session session=sessionFactory.openSession();
		User user=session.get(User.class,userId);
		session.close();
		return user;
	}


	@Override
	public List<User> listUser() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> listUsers=query.list();
		session.close();
		return listUsers;
	}


	@Override
	public List<User> singleUser() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> singleUsers=query.list();
		session.close();
		return singleUsers;
	}
}