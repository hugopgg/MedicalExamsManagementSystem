package com.inf5153.patient;

import java.util.ArrayList;
import java.util.List;

import com.inf5153.services.PatientService;

/**
 * Manages the collection of patients and provides operations to create and
 * retrieve patients.
 * Implements PatientService interface.
 */
public class PatientManager implements PatientService {

    private List<Patient> patients;
    private static volatile PatientManager INSTANCE = null;

    /**
     * Private constructor to initialize the patient list.
     */
    private PatientManager() {
        this.patients = new ArrayList<>();
    }

    /**
     * Singleton instance retrieval method.
     *
     * @return The singleton instance of PatientManager
     */
    public static PatientManager getInstance() {
        PatientManager i = INSTANCE;
        if (i == null) {
            synchronized (PatientManager.class) {
                i = INSTANCE;
                if (i == null) {
                    INSTANCE = i = new PatientManager();
                }
            }
        }
        return i;
    }

    /**
     * Retrieves the list of patients.
     *
     * @return The list of patients
     */
    @Override
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Creates a new patient with the specified name, phone, and email,
     * adds it to the patient list, and returns the created patient object.
     *
     * @param name  The name of the patient
     * @param phone The phone number of the patient
     * @param email The email address of the patient
     * @return The created Patient object
     */
    public Patient createPatient(String name, String phone, String email) {
        Patient patient = new Patient(name, phone, email);
        patients.add(patient);
        return patient;
    }

}
