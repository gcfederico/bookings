package com.fcg.bookings.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fcg.bookings.model.AppointmentRequest;

public interface AppointmentRequestsRepository extends JpaRepository<AppointmentRequest, UUID> {

}
