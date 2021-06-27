package com.fcg.bookings.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class AppointmentDTO implements Serializable {
	private static final long serialVersionUID = -1169478826294010092L;
	private UUID id;
	private String currentState;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Long serviceProviderId;
	private Long clientId;
	private Long scheduleId;
}
