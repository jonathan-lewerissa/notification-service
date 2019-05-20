package com.pbkk.notificationservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbkk.notificationservice.model.Notification;
import com.pbkk.notificationservice.model.NotificationBridge;
import com.pbkk.notificationservice.model.User;
import com.pbkk.notificationservice.service.NotificationService;
import com.pbkk.notificationservice.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/notification/user/{userId}")
	public List<Notification> getAllNotificationsByUserId(@PathVariable Long userId) {
		return notificationService.getUserNotifications(userId);
	}
	
	@PostMapping("/notification")
	public Notification createNotification(@RequestBody NotificationBridge notification) {
		Notification toSave = new Notification();
		
		User user = userService.getSingleUser(notification.getUserId());
		
		toSave.setSender(notification.getSender());
		toSave.setType(notification.getType());
		toSave.setMessage(notification.getMessage());
		toSave.setCallbackUrl(notification.getCallbackUrl());
		toSave.setIsEmail(notification.getIsEmail());
		toSave.setTitle(notification.getTitle());
		toSave.setUser(user);
		
		return notificationService.createNotification(user, toSave, notification.getIsEmail());
	}
	
	@GetMapping("/user/{userId}")
	public User getSingleUser(@PathVariable Long userId) {
		return userService.getSingleUser(userId);
	}
	
	@PostMapping("/user")
	public User registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
}
