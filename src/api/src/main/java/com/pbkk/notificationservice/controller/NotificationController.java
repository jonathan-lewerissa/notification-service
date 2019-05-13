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
import com.pbkk.notificationservice.service.NotificationService;

@RestController
@RequestMapping("/api")
public class NotificationController {
	@Autowired
	NotificationService notificationService;
	
	@GetMapping("/notification/user/{userId}")
	public List<Notification> getNotifications(@PathVariable Integer userId) {
		return notificationService.getUserNotifications(userId);
	}
	
	@PostMapping("/notification")
	public Notification createNotification(@Valid @RequestBody Notification notification) {
		return notificationService.createNotification(notification);
	}
}
