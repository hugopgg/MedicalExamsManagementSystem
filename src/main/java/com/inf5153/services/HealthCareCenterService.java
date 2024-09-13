package com.inf5153.services;

import java.util.ArrayList;

import com.inf5153.doctor.Doctor;
import com.inf5153.patient.Patient;
import com.inf5153.service.Service;

/**
 * Interface for managing a healthcare center.
 */
public interface HealthCareCenterService {

    /**
     * Adds a doctor to the healthcare center.
     *
     * @param doctor The doctor to add
     */
    void addDoctor(Doctor doctor);

    /**
     * Adds a service to the healthcare center.
     *
     * @param service The service to add
     */
    void addService(Service service);

    /**
     * Adds a patient to the healthcare center.
     *
     * @param patient The patient to add
     */
    void addPatient(Patient patient);

    /**
     * Retrieves a list of all doctors in the healthcare center.
     *
     * @return The list of doctors
     */
    ArrayList<Doctor> getDoctors();

    /**
     * Retrieves a list of all services offered by the healthcare center.
     *
     * @return The list of services
     */
    ArrayList<Service> getServices();

    /**
     * Retrieves a list of all patients registered at the healthcare center.
     *
     * @return The list of patients
     */
    ArrayList<Patient> getPatients();
}
