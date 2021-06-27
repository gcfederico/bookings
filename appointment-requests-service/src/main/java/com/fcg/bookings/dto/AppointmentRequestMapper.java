package com.fcg.bookings.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcg.bookings.model.AppointmentRequest;

public class AppointmentRequestMapper extends ModelMapper {
	
	private static final ModelMapper mapper = new ModelMapper();
	
	public AppointmentRequestMapper() {
		super();
		// Mapper initialization
	}
	
	public static AppointmentRequestDTO mapToDTO(AppointmentRequest appointment) {
		return mapper.map(appointment, AppointmentRequestDTO.class);
	}

	public static AppointmentRequest mapFromDTO(AppointmentRequestDTO appointmentDTO) {
		return mapper.map(appointmentDTO, AppointmentRequest.class);
	}
}
