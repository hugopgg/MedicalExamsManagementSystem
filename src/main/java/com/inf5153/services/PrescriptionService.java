package com.inf5153.services;

import java.util.List;
import com.inf5153.exam.Exam;
import com.inf5153.prescription.Prescription;

/**
 * Interface for managing prescription-related operations.
 */
public interface PrescriptionService {

    /**
     * Retrieves a list of all prescriptions.
     *
     * @return The list of prescriptions
     */
    List<Prescription> getPrescriptions();

    /**
     * Creates a new prescription for a patient with the specified exam.
     *
     * @param patientId The ID of the patient associated with the prescription
     * @param exam      The exam associated with the prescription
     * @return The created Prescription object
     */
    Prescription createPrescription(int patientId, Exam exam);

    /**
     * Retrieves a list of prescriptions for a specific patient identified by patient ID.
     *
     * @param patientId The ID of the patient to retrieve prescriptions for
     * @return The list of prescriptions for the specified patient
     */
    List<Prescription> getPrescriptionsByPatientId(int patientId);

}
