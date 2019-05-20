package com.pbkk.notificationservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NotificationBridge {
	
	@JsonProperty("sender")
	private String sender;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("callback_url")
	private String callbackUrl;
	
	@JsonProperty("user_id")
	private Long userId;
	
	@JsonProperty("isEmail")
	private Boolean isEmail;
	
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Boolean getIsEmail() {
		return isEmail;
	}
	public void setIsEmail(Boolean isEmail) {
		this.isEmail = isEmail;
	}
	
}
