package com.inf5153.healthcarecenter;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.inf5153.doctor.Doctor;
import com.inf5153.patient.Patient;
import com.inf5153.service.Service;

/**
 * Singleton class representing a healthcare center.
 */
public class HealthCareCenter {

    private ArrayList<Service> services;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    private static volatile HealthCareCenter INSTANCE = null;

    /**
     * Private constructor to initialize the lists of services, doctors, and patients.
     */
    private HealthCareCenter() {
        this.services = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of HealthCareCenter.
     *
     * @return the singleton instance of HealthCareCenter.
     */
    public static HealthCareCenter getInstance() {
        HealthCareCenter i = INSTANCE;
        if (i == null) {
            synchronized (HealthCareCenter.class) {
                i = INSTANCE;
                if (i == null) {
                    INSTANCE = i = new HealthCareCenter();
                }
            }
        }
        return i;
    }

    /**
     * Returns the list of services in the health care center.
     *
     * @return the list of services.
     */
    public ArrayList<Service> getServices() {
        return services;
    }

    /**
     * Returns the list of doctors in the health care center.
     *
     * @return the list of doctors.
     */
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    /**
     * Returns the list of patients in the health care center.
     *
     * @return the list of patients.
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     * Adds a service to the health care center.
     *
     * @param service the service to add.
     */
    public void addService(Service service) {
        this.services.add(service);
    }

    /**
     * Adds a doctor to the health care center.
     *
     * @param doctor the doctor to add.
     */
    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    /**
     * Adds a patient to the health care center.
     *
     * @param patient the patient to add.
     */
    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    /**
     * Returns a string representation of the health care center, including its services, doctors, and patients.
     *
     * @return a string representation of the health care center.
     */
    @Override
    public String toString() {
        String serviceNames = services.stream()
                .map(Service::getName)
                .collect(Collectors.joining(", "));

        String doctorNames = doctors.stream()
                .map(Doctor::getName)
                .collect(Collectors.joining(", "));

        String patientIds = patients.stream()
                .map(Patient::getId)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return "HealthCareCenter{" +
                "services=[" + serviceNames + ']' +
                ", doctors=[" + doctorNames + ']' +
                ", patients=[" + patientIds + ']' +
                '}';
    }

}
