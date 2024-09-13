package com.inf5153.healthcarecenter;

import java.util.ArrayList;
import java.util.List;

import com.inf5153.appointment.AppointmentRequest;
import com.inf5153.doctor.Doctor;
import com.inf5153.labhub.AppointmentResponse;
import com.inf5153.labhub.LabHub;
import com.inf5153.labhub.ResultsResponse;
import com.inf5153.logger.ConsoleLogger;
import com.inf5153.logger.Logger;
import com.inf5153.patient.Patient;
import com.inf5153.service.Service;
import com.inf5153.services.HealthCareCenterService;

/**
 * Manages the operations of the HealthCareCenter and interactions with LabHub.
 */
public class HealthCareCenterManager implements HealthCareCenterService {

    private HealthCareCenter healthCareCenter;
    private LabHub labHub;
    private Logger logger;

    private static volatile HealthCareCenterManager INSTANCE = null;

    private List<AppointmentResponse> receivedAppointmentResponses = new ArrayList<>();
    private List<ResultsResponse> receivedResultsResponses = new ArrayList<>();

    /**
     * Private constructor to initialize with LabHub instance and logger.
     *
     * @param labHub the LabHub instance to interact with.
     */
    private HealthCareCenterManager(LabHub labHub) {
        this.healthCareCenter = HealthCareCenter.getInstance();
        this.labHub = labHub;
        this.logger = new ConsoleLogger();
    }

    /**
     * Returns the singleton instance of HealthCareCenterManager.
     *
     * @param labHub the LabHub instance to use.
     * @return the singleton instance of HealthCareCenterManager.
     */
    public static HealthCareCenterManager getInstance(LabHub labHub) {
        if (INSTANCE == null) {
            synchronized (HealthCareCenterManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HealthCareCenterManager(labHub);
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Sends an appointment request to LabHub and logs the action.
     *
     * @param appointmentRequest the appointment request to send.
     */
    public void sendAppointmentRequest(AppointmentRequest appointmentRequest) {
        logger.info("HCC | sending appointment request : " + appointmentRequest);
        labHub.sendAppointmentRequest(appointmentRequest);
    }

    /**
     * Receives and processes an appointment response from LabHub.
     *
     * @param appointmentResponse the appointment response received.
     */
    public void receiveAppointmentResponse(AppointmentResponse appointmentResponse) {
        receivedAppointmentResponses.add(appointmentResponse);
        appointmentResponse.sendNotification();
    }

    /**
     * Receives and processes a results response from LabHub.
     *
     * @param resultsResponse the results response received.
     */
    public void receiveResultsResponse(ResultsResponse resultsResponse) {
        receivedResultsResponses.add(resultsResponse);
        resultsResponse.sendNotification();
    }

    /**
     * Returns the list of received appointment responses.
     *
     * @return the list of received appointment responses.
     */
    public List<AppointmentResponse> getReceivedAppointmentResponses() {
        return receivedAppointmentResponses;
    }

    /**
     * Returns the list of received results responses.
     *
     * @return the list of received results responses.
     */
    public List<ResultsResponse> getReceivedResultsResponses() {
        return receivedResultsResponses;
    }

    // Methods delegated to HealthCareCenter instance

    @Override
    public void addDoctor(Doctor doctor) {
        this.healthCareCenter.addDoctor(doctor);
    }

    @Override
    public void addService(Service service) {
        this.healthCareCenter.addService(service);
    }

    @Override
    public void addPatient(Patient patient) {
        this.healthCareCenter.addPatient(patient);
    }

    @Override
    public ArrayList<Doctor> getDoctors() {
        return healthCareCenter.getDoctors();
    }

    @Override
    public ArrayList<Service> getServices() {
        return healthCareCenter.getServices();
    }

    @Override
    public ArrayList<Patient> getPatients() {
        return healthCareCenter.getPatients();
    }

    @Override
    public String toString() {
        return healthCareCenter.toString();
    }

}
