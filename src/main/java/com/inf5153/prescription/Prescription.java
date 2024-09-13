package com.inf5153.prescription;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import com.inf5153.exam.Exam;

/**
 * Represents a prescription for an exam given to a patient.
 */
public class Prescription {
    private int id;
    private int patientId;
    private Exam exam;
    private Date prescriptionDate;

    private static final AtomicInteger setId = new AtomicInteger(0);

    /**
     * Constructs a Prescription object with the specified patient ID,
     * exam, and prescription date.
     *
     * @param patientId        The ID of the patient for whom the prescription is made
     * @param exam             The exam prescribed
     * @param prescriptionDate The date when the prescription was made
     */
    public Prescription(int patientId, Exam exam, Date prescriptionDate) {
        this.patientId = patientId;
        this.exam = exam;
        this.prescriptionDate = prescriptionDate;
        this.id = setId.incrementAndGet();
    }

    /**
     * Retrieves the ID of the patient associated with this prescription.
     *
     * @return The patient ID
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * Sets the patient ID associated with this prescription.
     *
     * @param patientId The patient ID to set
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * Retrieves the exam object associated with this prescription.
     *
     * @return The Exam object
     */
    public Exam getExam() {
        return exam;
    }

    /**
     * Sets the exam associated with this prescription.
     *
     * @param exam The Exam object to set
     */
    public void setExam(Exam exam) {
        this.exam = exam;
    }

    /**
     * Retrieves the date when the prescription was made.
     *
     * @return The prescription date
     */
    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    /**
     * Sets the date when the prescription was made.
     *
     * @param prescriptionDate The prescription date to set
     */
    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    /**
     * Retrieves the unique ID of this prescription.
     *
     * @return The prescription ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns a string representation of the Prescription object,
     * displaying its attributes.
     *
     * @return A string representation of the Prescription object
     */
    @Override
    public String toString() {
        return "Prescription{" +
                "patientId=" + patientId +
                ", exam=" + exam +
                ", prescriptionDate=" + prescriptionDate +
                ", prescriptionID=" + id +
                '}';
    }
}
