package com.fcg.bookings.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class AppointmentRequestDTO implements Serializable {
	private static final long serialVersionUID = -1169478826294010092L;
	private UUID id;
	private String currentState;
	private LocalDateTime startDate;
	private LocalDateTime estimatedEndDate;
	private Long clientId;
	private Long serviceProviderId;
	private Long scheduleId;
}
