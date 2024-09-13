package com.inf5153.labhub;

import com.inf5153.notification.Notifier;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Represents an appointment response created from the lab hub.
 * Extends Notifier to handle notifications to listeners.
 */
public class AppointmentResponse extends Notifier {

    private int patientId;
    private int appointmentId;
    private LocalDate dateRdv;
    private LocalTime heureRdv;
    private String lab;

    /**
     * Constructs an AppointmentResponse object with specified patient ID,
     * appointment ID, lab name,
     * appointment date, and appointment time.
     *
     * @param patientId     The ID of the patient requesting the appointment
     * @param appointmentId The unique ID assigned to the appointment
     * @param lab           The name of the lab where the appointment is scheduled
     * @param dateRdv       The date of the appointment
     * @param heureRdv      The time of the appointment
     */
    public AppointmentResponse(int patientId, int appointmentId, String lab, LocalDate dateRdv, LocalTime heureRdv) {
        this.patientId = patientId;
        this.appointmentId = appointmentId;
        this.lab = lab;
        this.dateRdv = dateRdv;
        this.heureRdv = heureRdv;

        this.listeners = new ArrayList<>();
        this.listeners.add("Patient");
        this.listeners.add("Service");
    }

    /**
     * Retrieves the patient ID associated with this appointment response.
     *
     * @return The patient ID
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * Sets the patient ID associated with this appointment response.
     *
     * @param patientId The patient ID to set
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * Retrieves the unique ID of the appointment.
     *
     * @return The appointment ID
     */
    public int getAppointmentId() {
        return appointmentId;
    }

    /**
     * Sets the unique ID of the appointment.
     *
     * @param appointmentId The appointment ID to set
     */
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * Retrieves the date of the appointment.
     *
     * @return The appointment date
     */
    public LocalDate getDateRdv() {
        return dateRdv;
    }

    /**
     * Sets the date of the appointment.
     *
     * @param dateRdv The appointment date to set
     */
    public void setDateRdv(LocalDate dateRdv) {
        this.dateRdv = dateRdv;
    }

    /**
     * Retrieves the time of the appointment.
     *
     * @return The appointment time
     */
    public LocalTime getHeureRdv() {
        return heureRdv;
    }

    /**
     * Sets the time of the appointment.
     *
     * @param heureRdv The appointment time to set
     */
    public void setHeureRdv(LocalTime heureRdv) {
        this.heureRdv = heureRdv;
    }

    /**
     * Retrieves the name of the lab where the appointment is scheduled.
     *
     * @return The name of the lab
     */
    public String getLab() {
        return lab;
    }

    /**
     * Sets the name of the lab where the appointment is scheduled.
     *
     * @param lab The name of the lab to set
     */
    public void setLab(String lab) {
        this.lab = lab;
    }

    /**
     * Sends a notification to the listeners about receiving this appointment
     * response.
     * Overrides the sendNotification method from Notifier.
     */
    @Override
    public void sendNotification() {
        // sendMail();
        // sendSMS();
        System.out.println("APPOINTMENT RESPONSE RECEIVED : appointmentId = " + appointmentId +
                ", patientId = " + patientId +
                ", agents notified = " + listeners);
    }

    /**
     * Returns a string representation of the appointment response, displaying its
     * attributes.
     *
     * @return A string representation of the appointment response
     */
    @Override
    public String toString() {
        return "AppointmentResponse{" +
                "codePatient=" + patientId +
                ", appointmentId=" + appointmentId +
                ", dateRdv=" + dateRdv +
                ", heureRdv=" + heureRdv +
                ", lab='" + lab + '\'' +
                '}';
    }
}
