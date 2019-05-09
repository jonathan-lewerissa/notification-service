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
import com.pbkk.notificationservice.repository.NotificationRepository;

@RestController
@RequestMapping("/api/notification-service")
public class NotificationController {
	@Autowired
	NotificationRepository notificationRepository;
	
	@GetMapping("/user/{id}")
	public List<Notification> getNotifications(@PathVariable Integer id) {
		return notificationRepository.findByUserId(id);
	}
	
	@PostMapping("/order/{orderId}/serve")
	public Notification serveNotification(@Valid @RequestBody Notification notification, @PathVariable Integer orderId) {
		//get user id associated with the order id
		notification.setEntityId(orderId);
		notification.setEntityType("order");
		notification.setUserId(100);
		notification.setNotificationType("serve");
		return notificationRepository.save(notification);
	}
	
	@PostMapping("/order/{orderId}/deliver")
	public Notification deliverNotification(@Valid @RequestBody Notification notification, @PathVariable Integer orderId) {
		notification.setEntityId(orderId);
		notification.setEntityType("order");
		notification.setUserId(100);
		notification.setNotificationType("delivery");
		return notificationRepository.save(notification);
	}
	
	@PostMapping("/order/{orderId}/arrival")
	public Notification arrivalNotification(@Valid @RequestBody Notification notification, @PathVariable Integer orderId) {
		notification.setEntityId(orderId);
		notification.setEntityType("order");
		notification.setUserId(100);
		notification.setNotificationType("finish");
		return notificationRepository.save(notification);
	}
	
	@PostMapping("/payment/{paymentId}/pending")
	public Notification paymentPendingNotification(@Valid @RequestBody Notification notification, @PathVariable Integer paymentId) {
		notification.setEntityId(paymentId);
		notification.setEntityType("payment");
		notification.setUserId(100);
		notification.setNotificationType("pending");
		return notificationRepository.save(notification);
	}
	
	@PostMapping("/payment/{paymentId}/failure")
	public Notification paymentFailureNotification(@Valid @RequestBody Notification notification, @PathVariable Integer paymentId) {
		notification.setEntityId(paymentId);
		notification.setEntityType("payment");
		notification.setUserId(100);
		notification.setNotificationType("failure");
		return notificationRepository.save(notification);
	}
	
	@PostMapping("/payment/{paymentId}/success")
	public Notification paymentSuccessNotification(@Valid @RequestBody Notification notification, @PathVariable Integer paymentId) {
		notification.setEntityId(paymentId);
		notification.setEntityType("payment");
		notification.setUserId(100);
		notification.setNotificationType("success");
		return notificationRepository.save(notification);
	}
}
