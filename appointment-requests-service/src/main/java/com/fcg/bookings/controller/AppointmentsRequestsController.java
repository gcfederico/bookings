package com.fcg.bookings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fcg.bookings.dto.AppointmentRequestDTO;
import com.fcg.bookings.dto.AppointmentRequestMapper;
import com.fcg.bookings.model.AppointmentRequest;
import com.fcg.bookings.service.AppointmentRequestsService;

@RestController
@RequestMapping(value = "/appointment-requests")
public class AppointmentsRequestsController {

	final private AppointmentRequestsService appointmentRequestsService;
	final private AppointmentRequestMapper modelMapper;

	@Autowired
	public AppointmentsRequestsController(AppointmentRequestsService appointmentsService, AppointmentRequestMapper modelMapper) {
		this.appointmentRequestsService = appointmentsService;
		this.modelMapper = modelMapper;
	}

	@ResponseBody
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public AppointmentRequestDTO create(@RequestBody AppointmentRequestDTO appointmentRequest) {
		var appointment = appointmentRequestsService.create(mapFromDTO(appointmentRequest));
		return mapToDTO(appointment);
	}

	private AppointmentRequestDTO mapToDTO(AppointmentRequest appointment) {
		return modelMapper.map(appointment, AppointmentRequestDTO.class);
	}

	private AppointmentRequest mapFromDTO(AppointmentRequestDTO appointmentDTO) {
		return modelMapper.map(appointmentDTO, AppointmentRequest.class);
	}
}
