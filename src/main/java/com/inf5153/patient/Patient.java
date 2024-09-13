package com.inf5153.patient;

import java.util.concurrent.atomic.AtomicInteger;

import com.inf5153.notification.Listener;

/**
 * Represents a patient in the healthcare system.
 * Extends Listener to handle notifications.
 */
public class Patient extends Listener {
    private int id;
    private String name;
    private String phone;
    private String email;

    private static final AtomicInteger setId = new AtomicInteger(0);

    /**
     * Default constructor for Patient.
     */
    public Patient() {
    }

    /**
     * Constructs a Patient object with specified name, phone, and email.
     * Assigns a unique ID using an atomic integer.
     *
     * @param name  The name of the patient
     * @param phone The phone number of the patient
     * @param email The email address of the patient
     */
    public Patient(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.id = setId.incrementAndGet();
    }

    /**
     * Retrieves the ID of the patient.
     *
     * @return The ID of the patient
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the patient.
     *
     * @param id The ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the patient.
     *
     * @return The name of the patient
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the patient.
     *
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the phone number of the patient.
     *
     * @return The phone number of the patient
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the patient.
     *
     * @param phone The phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retrieves the email address of the patient.
     *
     * @return The email address of the patient
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the patient.
     *
     * @param email The email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of the patient, displaying its attributes.
     *
     * @return A string representation of the patient
     */
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
