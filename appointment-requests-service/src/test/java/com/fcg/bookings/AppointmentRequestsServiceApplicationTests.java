package com.fcg.bookings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fcg.bookings.model.AppointmentRequest;
import com.fcg.bookings.model.AppointmentRequestState;
import com.fcg.bookings.service.AppointmentRequestsService;

@SpringBootTest
class AppointmentRequestsServiceApplicationTests {

	@Autowired
	private AppointmentRequestsService appointmentRequestsService;

	@Test
	void contextLoads() {
		assertNotNull(appointmentRequestsService);
	}

	@Test
	void createAppointmentRequest() {
		var newAppointmentRequest = appointmentRequestsService.create(dummyAppointmentRequest());
		assertNotNull(newAppointmentRequest, "Null Element");
		assertNotNull(newAppointmentRequest.getId(), "Null UUID");
	}

	@Test
	void acceptAppointment() {
		var appointmentRequest = appointmentRequestsService.create(dummyAppointmentRequest());
		appointmentRequest = appointmentRequestsService.accept(appointmentRequest);
		assertNotNull(appointmentRequest, "Null Element");
		assertEquals(appointmentRequest.getCurrentState(), AppointmentRequestState.ACCEPTED);
	}
	
	@Test
	void rescheduleAppointment() {
		var appointmentRequest = appointmentRequestsService.create(dummyAppointmentRequest());
		appointmentRequest.setStartDate(appointmentRequest.getStartDate().plusHours(1));
		appointmentRequest = appointmentRequestsService.reschedule(appointmentRequest);
		assertNotNull(appointmentRequest, "Null Element");
		assertEquals(appointmentRequest.getCurrentState(), AppointmentRequestState.RESCHEDULED);
	}
	
	@Test
	void cancelAppointment() {
		var appointmentRequest = appointmentRequestsService.create(dummyAppointmentRequest());
		appointmentRequest = appointmentRequestsService.cancel(appointmentRequest);
		assertNotNull(appointmentRequest, "Null Element");
		assertEquals(appointmentRequest.getCurrentState(), AppointmentRequestState.CANCELED);
	}
	
	@Test
	void rejectAppointment() {
		var appointmentRequest = appointmentRequestsService.create(dummyAppointmentRequest());
		appointmentRequest = appointmentRequestsService.reject(appointmentRequest);
		assertNotNull(appointmentRequest, "Null Element");
		assertEquals(appointmentRequest.getCurrentState(), AppointmentRequestState.REJECTED);
	}
	
	private AppointmentRequest dummyAppointmentRequest() {
		return new AppointmentRequest(LocalDateTime.now(), 1l, 1l, 1l);
	}

}
