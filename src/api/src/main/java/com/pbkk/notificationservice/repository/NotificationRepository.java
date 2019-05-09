package com.pbkk.notificationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbkk.notificationservice.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{
	List<Notification> findByUserId(Integer userId);
}
