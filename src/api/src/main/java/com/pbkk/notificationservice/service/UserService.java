package com.pbkk.notificationservice.service;

import java.util.List;

import com.pbkk.notificationservice.model.User;

public interface UserService {
	List<User> getAllUsers();
	User getSingleUser(Long userId);
	User registerUser(User user);
}
