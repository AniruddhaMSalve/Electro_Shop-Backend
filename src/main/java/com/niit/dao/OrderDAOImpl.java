package com.niit.dao;



import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CartItem;
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

	@Override
	public List<OrderDetail> retrieveOrder(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from OrderDetail where username=:username");
		query.setParameter("username",username);
		List<OrderDetail> listOrder=query.list();
		session.close();
		return listOrder;
	}

	@Override
	public OrderDetail getOrder(int orderId) 
	{
		Session session=sessionFactory.openSession();
		OrderDetail orderDetail=session.get(OrderDetail.class,orderId);
		session.close();
		return orderDetail;
	}
}
