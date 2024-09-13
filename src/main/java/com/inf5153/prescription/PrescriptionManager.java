package com.inf5153.prescription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inf5153.exam.Exam;
import com.inf5153.services.PrescriptionService;

/**
 * Manages prescriptions of exams for patients.
 * Implements the PrescriptionService interface.
 */
public class PrescriptionManager implements PrescriptionService {

    private List<Prescription> prescriptions;

    private static volatile PrescriptionManager INSTANCE = null;

    /**
     * Private constructor to initialize the prescriptions list.
     */
    private PrescriptionManager() {
        this.prescriptions = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of PrescriptionManager.
     *
     * @return The singleton instance of PrescriptionManager
     */
    public static PrescriptionManager getInstance() {
        PrescriptionManager instance = INSTANCE;
        if (instance == null) {
            synchronized (PrescriptionManager.class) {
                instance = INSTANCE;
                if (instance == null) {
                    INSTANCE = instance = new PrescriptionManager();
                }
            }
        }
        return instance;
    }

    /**
     * Retrieves all prescriptions currently managed by this PrescriptionManager.
     *
     * @return List of all prescriptions
     */
    @Override
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /**
     * Creates a new prescription for a patient with the given patient ID and exam.
     * Adds the prescription to the list of managed prescriptions.
     *
     * @param patientId The ID of the patient for whom the prescription is made
     * @param exam      The exam that is prescribed
     * @return The created Prescription object
     */
    @Override
    public Prescription createPrescription(int patientId, Exam exam) {
        Prescription prescription = new Prescription(patientId, exam, new Date());
        prescriptions.add(prescription);
        return prescription;
    }

    /**
     * Retrieves all prescriptions associated with a specific patient ID.
     *
     * @param patientId The ID of the patient for whom prescriptions are to be retrieved
     * @return List of prescriptions associated with the patient ID
     */
    @Override
    public List<Prescription> getPrescriptionsByPatientId(int patientId) {
        List<Prescription> patientPrescriptions = new ArrayList<>();
        for (Prescription prescription : prescriptions) {
            if (prescription.getPatientId() == patientId) {
                patientPrescriptions.add(prescription);
            }
        }
        return patientPrescriptions;
    }
}
