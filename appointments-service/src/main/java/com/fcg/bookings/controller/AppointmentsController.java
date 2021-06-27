package com.fcg.bookings.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcg.bookings.service.AppointmentsService;

@RestController
@RequestMapping(value = "/appointments")
public class AppointmentsController {

	final private AppointmentsService appointmentsService;
	final private ModelMapper modelMapper;
	
	@Autowired
	public AppointmentsController(AppointmentsService appointmentsService, ModelMapper modelMapper) {
		super();
		this.appointmentsService = appointmentsService;
		this.modelMapper = modelMapper;
	}

}
