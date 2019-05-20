package com.pbkk.notificationservice.service;

import java.util.List;

import com.pbkk.notificationservice.model.Notification;
import com.pbkk.notificationservice.model.User;

public interface NotificationService {
	List<Notification> getUserNotifications(Long userId);
	Notification createNotification(User user, Notification notification, Boolean isEmail);
}
