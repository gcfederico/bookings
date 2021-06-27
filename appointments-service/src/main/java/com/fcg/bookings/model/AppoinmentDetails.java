package com.fcg.bookings.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "appointment_details")
@Data
@NoArgsConstructor
public class AppoinmentDetails {
	
	@Id
	@Column(name = "appointment_id")
	private UUID id;
	
	@NotNull
	@OneToOne
    @MapsId
    @JoinColumn(name = "appointment_id")
	private Appointment appointment;

	public AppoinmentDetails(@NotNull Appointment appointment) {
		super();
		this.id = appointment.getId();
		this.appointment = appointment;
	}
}
