package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOManualTest //to test CategoryDao addCategory method
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		Category category=new Category();
		category.setCategoryId(8);
		category.setCategoryName("Asus Mobile");
		category.setCategoryDesc("All Asus samrt phones");
		categoryDAO.addCategory(category);
		System.out.println("Categroy Inserted");
	}
}