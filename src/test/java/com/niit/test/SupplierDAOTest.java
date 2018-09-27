package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;


public class SupplierDAOTest 
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}
	
	
	@Ignore         
	@Test           
	public void addSupplierTest() 
	{
		Supplier supplier = new Supplier();
		supplier.setSupplierName("Chroma Electronics");
		supplier.setAddress("Metro Mall Dadar");
		assertTrue("Problem in adding supplier", supplierDAO.addSupplier(supplier));							
	}

	@Ignore
	@Test
	public void updateSupplierTest() 
	{
		Supplier supplier = supplierDAO.getSupplier(32);
		supplier.setAddress("Smart city Thane");
		assertTrue("Problem in updating supplier:", supplierDAO.updateSupplier(supplier));
	}

	@Ignore
	@Test
	public void deleteSupplierTest() 
	{
		Supplier supplier = supplierDAO.getSupplier(32);
		assertTrue("Problem in deleting supplier:", supplierDAO.deleteSupplier(supplier));
	}

	//@Ignore
	@Test
	public void listSupplierTest() 
	{
		List<Supplier> listSupplier = supplierDAO.listSupplier();
		assertNotNull("Problem in listing supplier:", listSupplier);
		for (Supplier supplier : listSupplier) 
		{
			System.out.println(supplier.getSupplierId() + ": "+supplier.getSupplierName()+": "+supplier.getAddress());
		}
	}
}