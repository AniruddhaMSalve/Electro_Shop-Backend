package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.dao.OrderDAO;
import com.niit.model.CartItem;
import com.niit.model.OrderDetail;

public class OrderDAOTest 
{

	static OrderDAO orderDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		orderDAO = (OrderDAO) context.getBean("orderDAO");
	}
	
	@Ignore
	@Test
	public void insertOrderDetailTest()
	{
		OrderDetail orderDetail=new OrderDetail();
		
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setPmode("CC");
		orderDetail.setUsername("User1");
		orderDetail.setTotalShoppingAmount(15000);
		
		assertTrue("Problem in Adding the Cart Item:",orderDAO.insertOrderDetail(orderDetail));
	}
	
//	@Ignore
	@Test
	public void retreiveOrderTest()
	{
		List<OrderDetail> listOrder=orderDAO.retrieveOrder("Admin");
		
		assertTrue("Problem in retreiving Order:",listOrder.size()>0);
		
		for(OrderDetail orderDetail:listOrder)
		{
			System.out.println(orderDetail.getOrderId()+":::"+orderDetail.getUsername()+":::"+orderDetail.getTotalShoppingAmount()+":::"+orderDetail.getPmode());
		}
	}
}
