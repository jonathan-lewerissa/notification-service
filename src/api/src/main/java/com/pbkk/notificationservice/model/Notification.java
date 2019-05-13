package com.pbkk.notificationservice.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "notifications")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"id","created_at","updated_at"}, allowGetters = true)
public class Notification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@JsonProperty("user_id")
	private Integer userId;
	
	@NotBlank
	@JsonProperty("type")
	private String type;
	
	@NotBlank
	@JsonProperty("entity")
	private String entity;
	
	@NotBlank
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("callback_url")
	private String callbackUrl;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@JsonProperty("created_at")
	private Date createdAt;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@JsonProperty("updated_at")
	private Date updatedAt;
}
