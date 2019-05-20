package com.pbkk.notificationservice.service;

import java.util.List;
import java.util.Optional;

import com.pbkk.notificationservice.model.Notification;

public interface NotificationService {
	List<Notification> getUserNotifications(Long userId);
	Notification createNotification(Notification notification, Optional<Boolean> isEmail);
}
