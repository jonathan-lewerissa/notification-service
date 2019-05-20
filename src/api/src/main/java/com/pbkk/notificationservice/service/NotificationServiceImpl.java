package com.pbkk.notificationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbkk.notificationservice.model.Notification;
import com.pbkk.notificationservice.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	NotificationRepository notificationRepository;
	
	@Autowired
	EmailService emailService;
	
	@Override
	public List<Notification> getUserNotifications(Long userId) {
		return notificationRepository.findByUserId(userId);
	}

	@Override
	public Notification createNotification(Notification notification, Boolean isEmail) {
		Notification savedNotification = notificationRepository.save(notification);
	    if (isEmail) {
	    	// Fetch email user
	    	emailService.sendEmail("joel.sembilan8@gmail.com", "Test", notification.toString());
	    }
		return savedNotification;
	}

}
