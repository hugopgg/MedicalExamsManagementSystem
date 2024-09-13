package com.inf5153.doctor;

import java.util.ArrayList;

import com.inf5153.notification.Listener;
import com.inf5153.patient.Patient;
import com.inf5153.service.Service;

/**
 * Represents a doctor with a license number, service, contact information, and a list of patients.
 */
public class Doctor extends Listener {
    private String licenseNumber;
    private Service service;
    private String name;
    private String phone;
    private String email;
    private ArrayList<Patient> patients;

    /**
     * Constructs a Doctor with the specified details.
     *
     * @param licenseNumber the license number of the doctor.
     * @param service the service the doctor is associated with.
     * @param name the name of the doctor.
     * @param phone the phone number of the doctor.
     * @param email the email address of the doctor.
     */
    public Doctor(String licenseNumber, Service service, String name, String phone, String email) {
        this.licenseNumber = licenseNumber;
        this.service = service;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.patients = new ArrayList<>();
    }

    /**
     * Gets the license number of the doctor.
     *
     * @return the license number.
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * Sets the license number of the doctor.
     *
     * @param licenseNumber the new license number.
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * Gets the service the doctor is associated with.
     *
     * @return the service.
     */
    public Service getService() {
        return service;
    }

    /**
     * Sets the service the doctor is associated with.
     *
     * @param service the new service.
     */
    public void setService(Service service) {
        this.service = service;
    }

    /**
     * Gets the name of the doctor.
     *
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the doctor.
     *
     * @param name the new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the phone number of the doctor.
     *
     * @return the phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the doctor.
     *
     * @param phone the new phone number.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the email address of the doctor.
     *
     * @return the email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the doctor.
     *
     * @param email the new email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the list of patients assigned to the doctor.
     *
     * @return the list of patients.
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     * Sets the list of patients assigned to the doctor.
     *
     * @param patients the new list of patients.
     */
    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    /**
     * Adds a patient to the doctor's list of patients.
     *
     * @param patient the patient to add.
     */
    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    /**
     * Returns a string representation of the doctor.
     *
     * @return a string representation of the doctor.
     */
    @Override
    public String toString() {
        return "Doctor{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", service=" + service.getName() +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", patients=" + patients +
                '}';
    }
}
