package com.pbkk.notificationservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "notifications")
public class Notification extends AuditModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@JsonProperty("sender")
	private String sender;
	
	@NotBlank
	@JsonProperty("type")
	private String type;
	
	@NotBlank
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("callback_url")
	private String callbackUrl;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore	
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", sender=" + sender + ", type=" + type + ", message=" + message
				+ ", callbackUrl=" + callbackUrl + ", user=" + user + "]";
	}
	
	
}
