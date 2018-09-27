package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductDAOTest 
{
	static ProductDAO productDAO;

	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	//@Ignore         
	@Test           
	public void addProductTest() 
	{
		Product product = new Product();
		product.setProductName("Xiomi");
		product.setProductDesc("A smart mobile");
		product.setQuantity(9);
		product.setPrice(33000);
		product.setSupplierId(2);
		product.setCategoryId(1);
		assertTrue("Problem in adding product:", productDAO.addProduct(product));	
	}

	@Ignore
	@Test
	public void updateProductTest() 
	{
		Product product = productDAO.getProduct(11);
		product.setProductDesc("All Lenovo mobile with smart features");
		assertTrue("Problem in updating category:", productDAO.updateProduct(product));
	}

	@Ignore
	@Test
	public void deleteProductTest() 
	{
		Product product = productDAO.getProduct(11);
		product.setProductDesc("All Lenovo mobile with smart features");
		assertTrue("Problem in deleting category:", productDAO.deleteProduct(product));
	}

//	@Ignore
	@Test
	public void listProductsTest() 
	{
		List<Product> listProducts = productDAO.listProducts();
		assertNotNull("Problem in listing category:", listProducts);
		for (Product product : listProducts) 
		{
			System.out.println(product.getProductId() + ": "+product.getProductName()+": "+product.getProductDesc());
		}
	}
}