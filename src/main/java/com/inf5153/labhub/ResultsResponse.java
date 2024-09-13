package com.inf5153.labhub;

import java.time.LocalDate;
import java.util.ArrayList;

import com.inf5153.notification.Notifier;

/**
 * Represents the response generated after processing an appointment for exam
 * results.
 * Extends Notifier to handle notifications to listeners.
 */
public class ResultsResponse extends Notifier {
    private String uri; 
    private int patientId; 
    private int appointmentId; 
    private LocalDate examDate; 

    /**
     * Constructs a new ResultsResponse object with the specified parameters.
     *
     * @param uri           URI to the exam results
     * @param patientId     ID of the patient
     * @param appointmentId ID of the appointment
     * @param examDate      Date of the exam
     */
    public ResultsResponse(String uri, int patientId, int appointmentId, LocalDate examDate) {
        this.uri = uri;
        this.patientId = patientId;
        this.appointmentId = appointmentId;
        this.examDate = examDate;

        // Initialize listeners
        this.listeners = new ArrayList<>();
        this.listeners.add("Medecin");
        this.listeners.add("Service");
    }

    /**
     * Retrieves the URI to the exam results.
     *
     * @return URI to the exam results
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the URI to the exam results.
     *
     * @param uri URI to set
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * Retrieves the ID of the patient.
     *
     * @return ID of the patient
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * Sets the ID of the patient.
     *
     * @param patientId ID of the patient to set
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * Retrieves the ID of the appointment.
     *
     * @return ID of the appointment
     */
    public int getAppointmentId() {
        return appointmentId;
    }

    /**
     * Sets the ID of the appointment.
     *
     * @param appointmentId ID of the appointment to set
     */
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * Retrieves the date of the exam.
     *
     * @return Date of the exam
     */
    public LocalDate getExamDate() {
        return examDate;
    }

    /**
     * Sets the date of the exam.
     *
     * @param examDate Date of the exam to set
     */
    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    /**
     * Returns a string representation of the ResultsResponse object.
     *
     * @return String representation of the ResultsResponse
     */
    @Override
    public String toString() {
        return "ResultsResponse [uri=" + uri +
                ", patientId=" + patientId +
                ", appointmentId=" + appointmentId +
                ", examDate=" + examDate + "]";
    }

    /**
     * Sends notification about the results response.
     * Prints a message to the console indicating the exam date, patient ID,
     * and the agents notified.
     */
    @Override
    public void sendNotification() {
        // sendMail();
        // sendSMS();
        System.out.println("RESULTS RESPONSE RECEIVED : exam date = " + examDate +
                ", patientId = " + patientId +
                ", agents notified = " + listeners);
    }
}
