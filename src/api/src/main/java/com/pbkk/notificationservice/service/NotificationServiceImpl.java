package com.pbkk.notificationservice.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import com.pbkk.notificationservice.model.Notification;
import com.pbkk.notificationservice.model.User;
import com.pbkk.notificationservice.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	NotificationRepository notificationRepository;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	AndroidPushService androidPushService;
	
	@Override
	public List<Notification> getUserNotifications(Long userId) {
		return notificationRepository.findByUserId(userId);
	}

	@Override
	public Notification createNotification(User user, Notification notification, Boolean isEmail) {
		Notification savedNotification = notificationRepository.save(notification);
		
	    JSONObject body = new JSONObject();
	    
	    JSONObject bodyNotification = new JSONObject();
	    bodyNotification.put("title", notification.getTitle());
	    bodyNotification.put("body", notification.getMessage());
	    
	    body.put("notification", bodyNotification);
	    body.put("to", user.getFcmToken());
	    
	    androidPushService.send(new HttpEntity<>(body.toString()));
	    
	    if (isEmail) {
	    	emailService.sendEmail(user.getEmail(), notification.getTitle(), notification.getMessage());
	    }
	    
		return savedNotification;
	}

}
