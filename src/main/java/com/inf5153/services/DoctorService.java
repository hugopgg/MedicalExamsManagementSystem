package com.inf5153.services;

import java.util.List;

import com.inf5153.doctor.Doctor;
import com.inf5153.service.Service;

/**
 * Interface for managing doctors.
 */
public interface DoctorService {

    /**
     * Creates a new doctor with the specified details.
     *
     * @param licenseNumber The license number of the doctor
     * @param service       The service specialization of the doctor
     * @param name          The name of the doctor
     * @param phone         The phone number of the doctor
     * @param email         The email address of the doctor
     * @return The created Doctor object
     */
    Doctor createDoctor(String licenseNumber, Service service, String name, String phone, String email);

    /**
     * Retrieves a list of all doctors.
     *
     * @return The list of doctors
     */
    List<Doctor> getDoctors();
}
