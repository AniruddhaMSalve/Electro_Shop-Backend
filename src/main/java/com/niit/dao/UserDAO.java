package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDAO 
{
	public boolean addUser(User user);
	public boolean editUser(User user);
	public boolean deleteUser(User user);
	public List<User> listUser();
	public List<User> singleUser();
	public User getUser(int userId);
}
