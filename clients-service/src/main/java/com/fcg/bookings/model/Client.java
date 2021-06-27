package com.fcg.bookings.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter @Setter @NoArgsConstructor
public class Client {

	@Id
	@GeneratedValue
	private UUID id;
	
	@Column
	private String email;
	
	@Column
	private String username;
	
	@Column
	private String instagram;
	
	@Column
	private String whatsapp;
	
	public Client(String username, String email) {
		this.email = email;
		this.username = username;
	}
}
