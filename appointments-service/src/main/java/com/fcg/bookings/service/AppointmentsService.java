package com.fcg.bookings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcg.bookings.repository.AppointmentsRepository;

@Service
public class AppointmentsService implements IAppointmentsService {

	private AppointmentsRepository appointmentsRepository;

	@Autowired
	public AppointmentsService(AppointmentsRepository appointmentsRepository) {
		this.appointmentsRepository = appointmentsRepository;
	}

}
