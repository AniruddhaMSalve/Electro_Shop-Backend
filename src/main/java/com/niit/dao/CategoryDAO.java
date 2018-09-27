package com.niit.dao;
import java.util.List;

import com.niit.model.Category;

public interface CategoryDAO 
{
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public List<Category> listCategories();
	public Category getCategory(int categoryId);
	
}
