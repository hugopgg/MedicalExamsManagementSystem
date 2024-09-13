package com.inf5153.services;

import java.util.List;
import com.inf5153.patient.Patient;

/**
 * Interface for managing patient-related operations.
 */
public interface PatientService {

    /**
     * Creates a new patient with the specified details.
     *
     * @param name  The name of the patient
     * @param phone The phone number of the patient
     * @param email The email address of the patient
     * @return The created Patient object
     */
    Patient createPatient(String name, String phone, String email);

    /**
     * Retrieves a list of all patients.
     *
     * @return The list of patients
     */
    List<Patient> getPatients();

}
