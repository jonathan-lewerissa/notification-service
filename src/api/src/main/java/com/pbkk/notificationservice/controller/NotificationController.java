package com.pbkk.notificationservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbkk.notificationservice.model.Notification;
import com.pbkk.notificationservice.repository.NotificationRepository;

@RestController
@RequestMapping("/api")
public class NotificationController {
	@Autowired
	NotificationRepository notificationRepository;
	
	@GetMapping("/notifications")
	public List<Notification> getAllNotifications() {
		return notificationRepository.findAll();
	}
	
	@PostMapping("/notifications")
	public Notification createNotification(@Valid @RequestBody Notification notification) {
		return notificationRepository.save(notification);
	}
	
//	@GetMapping("/notifications/{id}")
}
