package com.inf5153.services;

import java.util.List;
import com.inf5153.service.Service;
import com.inf5153.service.ServiceType;

/**
 * Interface for managing services offered by the application.
 */
public interface ServiceService {

    /**
     * Creates a new service with the specified service type, phone number, and email.
     *
     * @param serviceType The type of service to create
     * @param phone       The phone number associated with the service
     * @param email       The email address associated with the service
     * @return The created Service object
     */
    Service createService(ServiceType serviceType, String phone, String email);

    /**
     * Retrieves a list of all services available.
     *
     * @return The list of services
     */
    List<Service> getServices();

    /**
     * Retrieves a list of names of all services available.
     *
     * @return The list of service names
     */
    List<String> getServicesNames();

}
