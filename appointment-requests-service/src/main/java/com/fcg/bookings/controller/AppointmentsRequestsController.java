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

	@Autowired
	public AppointmentsRequestsController(AppointmentRequestsService appointmentsService) {
		this.appointmentRequestsService = appointmentsService;
	}

	@ResponseBody
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public AppointmentRequestDTO create(@RequestBody AppointmentRequestDTO appointmentRequest) {
		var appointment = appointmentRequestsService.create(AppointmentRequestMapper.mapFromDTO(appointmentRequest));
		return AppointmentRequestMapper.mapToDTO(appointment);
	}

}
