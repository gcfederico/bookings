package com.fcg.bookings.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {

	@Id
	@GeneratedValue
	private UUID id;
	
	@NotNull
	@Column
	@Enumerated(EnumType.STRING)
	private AppointmentState currentState;
	
	@NotNull
	@Column
	private LocalDateTime startDate;
	
	@Column
	private LocalDateTime endDate;
	
	public Appointment( 
			@NotNull LocalDateTime startDate,
			@NotNull Long clientId, 
			@NotNull Long serviceProviderId,
			@NotNull Long scheduleId) {
		this.currentState = AppointmentState.CREATED;
		this.startDate = startDate;
	}
	
	
}
