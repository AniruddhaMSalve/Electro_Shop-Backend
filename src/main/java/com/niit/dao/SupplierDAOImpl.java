package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addSupplier(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateSupplier(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Supplier> listSupplier() 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> listSupplier = query.list();
		session.close();
		return listSupplier;
	}

	@Override
	public Supplier getSupplier(int supplierId) 
	{
		Session session = sessionFactory.openSession();
		Supplier supplier = (Supplier) session.get(Supplier.class, supplierId);
		session.close();
		return supplier;
	}
}
