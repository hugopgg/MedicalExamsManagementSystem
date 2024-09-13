package com.inf5153.service;

import java.util.ArrayList;
import java.util.List;

import com.inf5153.doctor.Doctor;
import com.inf5153.notification.Listener;

/**
 * Represents a service offered by the system.
 * Extends Listener to handle notifications.
 */
public class Service extends Listener {
    private String name;
    private String phone;
    private String email;
    private List<Doctor> doctors;

    /**
     * Constructs a Service object with specified service type, phone, and email.
     *
     * @param service The service type
     * @param phone   The phone number of the service
     * @param email   The email address of the service
     */
    public Service(ServiceType service, String phone, String email) {
        this.name = service.getDisplayName();
        this.phone = phone;
        this.email = email;
        this.doctors = new ArrayList<>();
    }

    /**
     * Retrieves the name of the service.
     *
     * @return The name of the service
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the service.
     *
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the phone number of the service.
     *
     * @return The phone number of the service
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the service.
     *
     * @param phone The phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retrieves the email address of the service.
     *
     * @return The email address of the service
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the service.
     *
     * @param email The email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the list of doctors associated with this service.
     *
     * @return The list of doctors
     */
    public List<Doctor> getDoctors() {
        return doctors;
    }

    /**
     * Sets the list of doctors associated with this service.
     *
     * @param doctors The list of doctors to set
     */
    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    /**
     * Adds a doctor to the list of doctors associated with this service.
     *
     * @param doctor The doctor to add
     */
    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    /**
     * Returns a string representation of the Service object.
     *
     * @return A string representation of the Service object
     */
    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", doctors=" + doctors +
                '}';
    }

    /**
     * Implements the receiveNotification method from the Listener interface.
     * Subclasses should override this method to define their specific notification
     * handling behavior.
     *
     * @throws UnsupportedOperationException if the method is called
     */
    @Override
    public void receiveNotification() {
        System.out.println("Service received a notification.");
        // Implement notification handling specific to Service
    }
}
