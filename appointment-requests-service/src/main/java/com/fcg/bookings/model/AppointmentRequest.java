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
@Table(name = "appointment_requests")
public class AppointmentRequest {

	@Id
	@GeneratedValue
	private UUID id;

	@NotNull
	@Column
	@Enumerated(EnumType.STRING)
	private AppointmentRequestState currentState;

	@NotNull
	@Column
	private LocalDateTime startDate;

	@NotNull
	@Column
	private LocalDateTime estimatedEndDate;

	@NotNull
	@Column
	private Long clientId;

	@NotNull
	@Column
	private Long serviceProviderId;

	@NotNull
	@Column
	private Long scheduleId;

	public AppointmentRequest(
			@NotNull LocalDateTime startDate, 
			@NotNull Long clientId, 
			@NotNull Long serviceProviderId,
			@NotNull Long scheduleId) {
		
		this.currentState = AppointmentRequestState.CREATED;
		this.startDate = startDate;
		this.clientId = clientId;
		this.serviceProviderId = serviceProviderId;
		this.scheduleId = scheduleId;
		this.estimatedEndDate = startDate.plusMinutes(15);
	}
}
