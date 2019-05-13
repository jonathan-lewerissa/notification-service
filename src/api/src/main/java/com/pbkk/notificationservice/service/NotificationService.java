package com.pbkk.notificationservice.service;

import java.util.List;

import com.pbkk.notificationservice.model.Notification;

public interface NotificationService {
	List<Notification> getUserNotifications(Integer userId);
	Notification createNotification(Notification notification);
	
}
