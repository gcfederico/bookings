package com.fcg.bookings.service;

import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcg.bookings.model.AppointmentRequest;
import com.fcg.bookings.model.AppointmentRequestState;
import com.fcg.bookings.repository.AppointmentRequestsRepository;

@Service
public class AppointmentRequestsService implements IAppointmentRequestsService {

	private AppointmentRequestsRepository appointmentsRepository;

	@Autowired
	public AppointmentRequestsService(AppointmentRequestsRepository appointmentsRepository) {
		this.appointmentsRepository = appointmentsRepository;
	}

	@Override
	public AppointmentRequest create(AppointmentRequest appointment) {
		var newAppointment = new AppointmentRequest(
								appointment.getStartDate(), 
								appointment.getClientId(),
								appointment.getServiceProviderId(), 
								appointment.getScheduleId());
						
		if (!isNull(appointment.getEstimatedEndDate())) {
			newAppointment.setEstimatedEndDate(appointment.getEstimatedEndDate());
		}

		return appointmentsRepository.save(newAppointment);
	}

	@Override
	public AppointmentRequest accept(AppointmentRequest appointment) {
		var appointmentRequest = appointmentsRepository.findById(appointment.getId())
				.orElseThrow();		
		appointmentRequest.setCurrentState(AppointmentRequestState.ACCEPTED);
		return appointmentsRepository.save(appointmentRequest);
	}

	@Override
	public AppointmentRequest reschedule(AppointmentRequest appointment) {
		var appointmentRequest = appointmentsRepository.findById(appointment.getId())
				.orElseThrow();
		
		var startDate = appointment.getStartDate();
		if (!appointmentRequest.getStartDate().equals(startDate)) {
			appointmentRequest.setCurrentState(AppointmentRequestState.RESCHEDULED);
			appointmentRequest.setStartDate(startDate);
			appointmentRequest.setEstimatedEndDate(appointment.getEstimatedEndDate());
		}
		
		return appointmentsRepository.save(appointmentRequest);
	}

	@Override
	public AppointmentRequest cancel(AppointmentRequest appointment) {
		var appointmentRequest = appointmentsRepository.findById(appointment.getId())
				.orElseThrow();		
		appointmentRequest.setCurrentState(AppointmentRequestState.CANCELED);
		return appointmentsRepository.save(appointmentRequest);
	}

	@Override
	public AppointmentRequest reject(AppointmentRequest appointment) {
		var appointmentRequest = appointmentsRepository.findById(appointment.getId())
				.orElseThrow();		
		appointmentRequest.setCurrentState(AppointmentRequestState.REJECTED);
		return appointmentsRepository.save(appointmentRequest);
	}
}
