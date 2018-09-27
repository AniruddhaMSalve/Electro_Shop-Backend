package com.niit.dao;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.OrderDetail;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean insertOrderDetail(OrderDetail orderDetail) 
	{
		try 
		{ 
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
