package com.inf5153.doctor;

import java.util.ArrayList;
import java.util.List;

import com.inf5153.service.Service;
import com.inf5153.services.DoctorService;

/**
 * Singleton class to manage doctors.
 */
public class DoctorManager implements DoctorService {

    private List<Doctor> doctors;

    private static volatile DoctorManager INSTANCE = null;

    /**
     * Private constructor to prevent instantiation.
     */
    private DoctorManager() {
        this.doctors = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of DoctorManager.
     *
     * @return the singleton instance.
     */
    public static DoctorManager getInstance() {
        DoctorManager i = INSTANCE;
        if (i == null) {
            synchronized (DoctorManager.class) {
                i = INSTANCE;
                if (i == null) {
                    INSTANCE = i = new DoctorManager();
                }
            }
        }
        return i;
    }

    /**
     * Returns the list of all doctors.
     *
     * @return a list of Doctor objects.
     */
    @Override
    public List<Doctor> getDoctors() {
        return doctors;
    }

    /**
     * Creates a new doctor and adds it to the list.
     *
     * @param licenseNumber the license number of the doctor.
     * @param service the service the doctor is associated with.
     * @param name the name of the doctor.
     * @param phone the phone number of the doctor.
     * @param email the email address of the doctor.
     * @return the created Doctor.
     */
    public Doctor createDoctor(String licenseNumber, Service service, String name, String phone,
                               String email) {
        Doctor doctor = new Doctor(licenseNumber, service, name, phone, email);
        doctors.add(doctor);
        return doctor;
    }

}
