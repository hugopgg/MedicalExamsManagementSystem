package com.inf5153.appointment;

import com.inf5153.prescription.Prescription;
import com.inf5153.services.AppointmentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class to manage appointment requests.
 */
public class AppointmentManager implements AppointmentService {

    private List<AppointmentRequest> appointmentRequests;

    private static volatile AppointmentManager INSTANCE = null;

    /**
     * Private constructor to prevent instantiation.
     */
    private AppointmentManager() {
        this.appointmentRequests = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of AppointmentManager.
     *
     * @return the singleton instance.
     */
    public static AppointmentManager getInstance() {
        AppointmentManager i = INSTANCE;
        if (i == null) {
            synchronized (AppointmentManager.class) {
                i = INSTANCE;
                if (i == null) {
                    INSTANCE = i = new AppointmentManager();
                }
            }
        }
        return i;
    }

    /**
     * Returns the list of all appointment requests.
     *
     * @return a list of AppointmentRequest objects.
     */
    @Override
    public List<AppointmentRequest> getAppointmentRequests() {
        return appointmentRequests;
    }

    /**
     * Creates a new appointment request based on a prescription and adds it to the list.
     *
     * @param prescription the Prescription object.
     * @return the created AppointmentRequest.
     */
    @Override
    public AppointmentRequest createAppointmentRequest(Prescription prescription) {
        AppointmentRequest appointmentRequest = new AppointmentRequest(prescription.getPatientId(),
                prescription.getExam());
        appointmentRequests.add(appointmentRequest);
        return appointmentRequest;
    }

    /**
     * Returns a list of appointment requests for a specific patient ID.
     *
     * @param patientId the patient ID.
     * @return a list of AppointmentRequest objects for the specified patient ID.
     */
    @Override
    public List<AppointmentRequest> getAppointmentRequestsByPatientId(int patientId) {
        List<AppointmentRequest> patientAppointmentRequests = new ArrayList<>();
        for (AppointmentRequest request : appointmentRequests) {
            if (request.getPatientId() == patientId) {
                patientAppointmentRequests.add(request);
            }
        }
        return patientAppointmentRequests;
    }
}
