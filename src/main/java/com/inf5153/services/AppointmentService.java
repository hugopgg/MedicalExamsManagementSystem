package com.inf5153.services;

import com.inf5153.appointment.AppointmentRequest;
import com.inf5153.prescription.Prescription;

import java.util.List;

/**
 * Interface for managing appointment requests.
 */
public interface AppointmentService {

    /**
     * Retrieves a list of all appointment requests.
     *
     * @return The list of appointment requests
     */
    List<AppointmentRequest> getAppointmentRequests();

    /**
     * Creates a new appointment request based on a prescription.
     *
     * @param prescription The prescription associated with the appointment request
     * @return The created appointment request
     */
    AppointmentRequest createAppointmentRequest(Prescription prescription);

    /**
     * Retrieves a list of appointment requests for a specific patient.
     *
     * @param patientId The ID of the patient
     * @return The list of appointment requests for the specified patient
     */
    List<AppointmentRequest> getAppointmentRequestsByPatientId(int patientId);
}
