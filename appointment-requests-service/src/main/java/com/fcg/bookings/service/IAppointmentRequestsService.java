package com.fcg.bookings.service;

import com.fcg.bookings.model.AppointmentRequest;

public interface IAppointmentRequestsService {

	AppointmentRequest create(AppointmentRequest appointmentRequest);

	AppointmentRequest accept(AppointmentRequest appointmentRequest);
	
	AppointmentRequest reschedule(AppointmentRequest appointmentRequest);
	
	AppointmentRequest cancel(AppointmentRequest appointmentRequest);
	
	AppointmentRequest reject(AppointmentRequest appointmentRequest);
}
