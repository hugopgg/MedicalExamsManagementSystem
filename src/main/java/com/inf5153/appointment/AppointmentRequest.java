package com.inf5153.appointment;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import com.inf5153.exam.Exam;

/**
 * Represents an appointment request.
 */
public class AppointmentRequest {
    private int appointmentId;
    private int patientId;
    private Exam exam;
    private Date requestDate;

    private static final AtomicInteger setId = new AtomicInteger(0);

    /**
     * Constructs an AppointmentRequest with the specified patient ID and exam.
     * Sets the request date to the current date and time.
     * 
     * @param patientId the ID of the patient.
     * @param exam the exam to be scheduled.
     */
    public AppointmentRequest(int patientId, Exam exam) {
        this.patientId = patientId;
        this.exam = exam;
        this.requestDate = new Date(); 
        this.appointmentId = setId.incrementAndGet();
    }

    /**
     * Gets the appointment ID.
     * 
     * @return the appointment ID.
     */
    public int getAppointmentId() {
        return appointmentId;
    }

    /**
     * Sets the appointment ID.
     * 
     * @param appointmentId the new appointment ID.
     */
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * Gets the patient ID.
     * 
     * @return the patient ID.
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * Sets the patient ID.
     * 
     * @param patientId the new patient ID.
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * Gets the exam.
     * 
     * @return the exam.
     */
    public Exam getExam() {
        return exam;
    }

    /**
     * Sets the exam.
     * 
     * @param exam the new exam.
     */
    public void setExam(Exam exam) {
        this.exam = exam;
    }

    /**
     * Gets the request date.
     * 
     * @return the request date.
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the request date.
     * 
     * @param requestDate the new request date.
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * Returns a string representation of the appointment request.
     * 
     * @return a string representation of the appointment request.
     */
    @Override
    public String toString() {
        return "AppointmentRequest{" +
                "appointmentId=" + appointmentId +
                ", patientId=" + patientId +
                ", exam=" + exam +
                ", requestDate=" + requestDate +
                '}';
    }
}
