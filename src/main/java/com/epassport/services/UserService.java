package com.epassport.services;

import java.util.List;

import com.epassport.entities.User;

public interface UserService {
	public User saveUser(User user);
	public User getUser(Integer userId);
	public List<User> getAllUsers();
	public User updateUser(Integer userId, User user);
	public void deleteUser(Integer userId);
	public User getUserByEmailId(String emailId);
	public User getUserByLoginId(String loginId);
}
