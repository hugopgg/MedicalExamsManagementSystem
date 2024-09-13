package com.inf5153.labhub;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.inf5153.appointment.AppointmentRequest;
import com.inf5153.healthcarecenter.HealthCareCenterManager;
import com.inf5153.logger.ConsoleLogger;
import com.inf5153.logger.Logger;

/**
 * Represents a laboratory hub that handles appointment requests and manages laboratory operations.
 * Singleton class ensuring only one instance exists.
 */
public class LabHub {

    private List<Laboratory> laboratories;
    private final List<AppointmentRequest> appointmentRequestsInProcess;

    private static volatile LabHub INSTANCE = null;

    private Logger logger;

    /**
     * Private constructor initializes the list of laboratories and the logger.
     */
    private LabHub() {
        this.laboratories = LabUtils.initializeLaboratories();
        this.appointmentRequestsInProcess = new ArrayList<>();
        this.logger = new ConsoleLogger();
    }

    /**
     * Retrieves the singleton instance of LabHub.
     *
     * @return The singleton instance of LabHub
     */
    public static LabHub getInstance() {
        LabHub instance = INSTANCE;
        if (instance == null) {
            synchronized (LabHub.class) {
                instance = INSTANCE;
                if (instance == null) {
                    INSTANCE = instance = new LabHub();
                }
            }
        }
        return instance;
    }

    /**
     * Sends an appointment request to the lab hub.
     *
     * @param appointmentRequest The appointment request to be processed
     */
    public void sendAppointmentRequest(AppointmentRequest appointmentRequest) {
        appointmentRequestsInProcess.add(appointmentRequest);
        processAppointmentRequests();
    }

    /**
     * Processes appointment requests in the queue, assigns a laboratory, and sends an appointment response.
     */
    private void processAppointmentRequests() {
        while (!appointmentRequestsInProcess.isEmpty()) {
            AppointmentRequest request = appointmentRequestsInProcess.remove(0);

            Laboratory selectedLab = LabUtils.getRandomLabForExam(laboratories, request.getExam().getName());

            if (selectedLab != null) {
                sendAppointmentResponse(createAppointmentResponse(request, selectedLab.getName()));
            } else {
                logger.warn("LABHUB | No available laboratory for the exam: " + request.getExam().getName() +
                        " for request ID: " + request.getAppointmentId());
            }
        }
    }

    /**
     * Creates an appointment response for the given appointment request and selected laboratory.
     *
     * @param request The appointment request
     * @param lab     The name of the selected laboratory
     * @return The created appointment response
     */
    private AppointmentResponse createAppointmentResponse(AppointmentRequest request, String lab) {
        LocalDate date = LabUtils.getAppointmentDate();
        LocalTime time = LabUtils.getAppointmentTime();

        logger.info("LABHUB | ...Searching for availability...");
        logger.info("LABHUB | Availability found for request #" + request.getAppointmentId());

        return new AppointmentResponse(request.getPatientId(), request.getAppointmentId(), lab,
                date, time);
    }

    /**
     * Sends an appointment response to the health care center manager and initiates patient examination.
     *
     * @param appointmentResponse The appointment response to be sent
     */
    private void sendAppointmentResponse(AppointmentResponse appointmentResponse) {
        logger.info("LABHUB | Sending appointment response");
        HealthCareCenterManager.getInstance(this).receiveAppointmentResponse(appointmentResponse);
        patientDoExam(appointmentResponse);
    }

    /**
     * Simulates the patient undergoing the examination and creates a results response.
     *
     * @param appointmentResponse The appointment response indicating the examination
     */
    private void patientDoExam(AppointmentResponse appointmentResponse) {
        logger.info("LABHUB | ...Patient doing the exam...");
        ResultsResponse resultsResponse = createResultsResponse(appointmentResponse);
        HealthCareCenterManager.getInstance(this).receiveResultsResponse(resultsResponse);
    }

    /**
     * Creates a results response based on the appointment response received.
     *
     * @param appointmentResponse The appointment response
     * @return The created results response
     */
    private ResultsResponse createResultsResponse(AppointmentResponse appointmentResponse) {
        String uri = LabUtils.generateFilePath(appointmentResponse);
        int patientId = appointmentResponse.getPatientId();
        int appointmentId = appointmentResponse.getAppointmentId();
        LocalDate examDate = appointmentResponse.getDateRdv();

        return new ResultsResponse(uri, patientId, appointmentId, examDate);
    }
}
