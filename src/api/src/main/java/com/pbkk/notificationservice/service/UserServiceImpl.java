package com.pbkk.notificationservice.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbkk.notificationservice.exception.ResourceNotFoundException;
import com.pbkk.notificationservice.model.User;
import com.pbkk.notificationservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getSingleUser(Long userId) {
		return userRepository.findById(userId)
		.orElseThrow(() -> new ResourceNotFoundException("User","id",String.valueOf(userId)));
	}

	@Override
	public User registerUser(@Valid User user) {
		User userToSave = userRepository.findById(user.getId()).orElse(null);
		
		if(userToSave == null) {
			userToSave = user;
		} else {
			userToSave.setId(user.getId()==null ? userToSave.getId() : user.getId());
			userToSave.setEmail(user.getEmail()==null ? userToSave.getEmail() : user.getEmail());
			userToSave.setFcmToken(user.getFcmToken()==null ? userToSave.getFcmToken() : user.getFcmToken());
		}
		
		return userRepository.save(userToSave);
	}

}
