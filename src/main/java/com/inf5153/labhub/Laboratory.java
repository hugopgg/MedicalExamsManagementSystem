package com.inf5153.labhub;

import java.util.List;

/**
 * Represents a laboratory entity with details such as code, name, address, contact information,
 * and available exams.
 */
public class Laboratory {
    private String code;
    private String name;
    private String address;
    private String phone;
    private String email;
    private List<String> availableExams;

    /**
     * Constructs a laboratory object with the specified attributes.
     *
     * @param code          The code of the laboratory
     * @param name          The name of the laboratory
     * @param address       The address of the laboratory
     * @param phone         The phone number of the laboratory
     * @param email         The email address of the laboratory
     * @param availableExams The list of available exams offered by the laboratory
     */
    public Laboratory(String code, String name, String address, String phone, String email, List<String> availableExams) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.availableExams = availableExams;
    }

    /**
     * Retrieves the code of the laboratory.
     *
     * @return The code of the laboratory
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code of the laboratory.
     *
     * @param code The code of the laboratory
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Retrieves the name of the laboratory.
     *
     * @return The name of the laboratory
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the laboratory.
     *
     * @param name The name of the laboratory
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the address of the laboratory.
     *
     * @return The address of the laboratory
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the laboratory.
     *
     * @param address The address of the laboratory
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieves the phone number of the laboratory.
     *
     * @return The phone number of the laboratory
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the laboratory.
     *
     * @param phone The phone number of the laboratory
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retrieves the email address of the laboratory.
     *
     * @return The email address of the laboratory
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the laboratory.
     *
     * @param email The email address of the laboratory
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the list of available exams offered by the laboratory.
     *
     * @return The list of available exams
     */
    public List<String> getAvailableExams() {
        return availableExams;
    }

    /**
     * Sets the list of available exams offered by the laboratory.
     *
     * @param availableExams The list of available exams
     */
    public void setAvailableExams(List<String> availableExams) {
        this.availableExams = availableExams;
    }

    /**
     * Returns a string representation of the laboratory object.
     *
     * @return The string representation of the laboratory
     */
    @Override
    public String toString() {
        return "Laboratory{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", availableExams=" + availableExams +
                '}';
    }
}
