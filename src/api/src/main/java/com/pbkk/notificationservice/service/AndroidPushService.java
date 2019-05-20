package com.pbkk.notificationservice.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;

public interface AndroidPushService {
	public CompletableFuture<String> send(HttpEntity<String> entity);
	
	//https://grokonez.com/spring-framework/spring-boot/firebase-cloud-messaging-server-spring-to-push-notification-example-spring-boot
}
