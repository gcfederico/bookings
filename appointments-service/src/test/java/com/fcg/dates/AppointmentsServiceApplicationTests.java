package com.fcg.dates;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fcg.bookings.AppointmentsServiceApplication;
import com.fcg.bookings.service.AppointmentsService;

@SpringBootTest(classes = AppointmentsServiceApplication.class)
class AppointmentsServiceApplicationTests {

	@Autowired
	private AppointmentsService appointmentsService;

	@Test
	void contextLoads() {
		assertNotNull(appointmentsService);
	}
}
