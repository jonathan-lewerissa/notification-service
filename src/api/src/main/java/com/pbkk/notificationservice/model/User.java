package com.pbkk.notificationservice.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "users")
public class User extends AuditModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("user_id")
	private Long id;
	
	@JsonProperty("fcm_token")
	private String fcmToken;
}
