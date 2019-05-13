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
	
	@Override
	public List<Notification> getUserNotifications(Integer userId) {
		return notificationRepository.findByUserId(userId);
	}

	@Override
	public Notification createNotification(Notification notification) {
		Notification savedNotification = notificationRepository.save(notification);
		
		return savedNotification;
	}

}
