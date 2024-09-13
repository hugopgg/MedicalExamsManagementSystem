package com.inf5153.service;

import java.util.ArrayList;
import java.util.List;

import com.inf5153.services.ServiceService;

/**
 * Manages services offered by the system.
 * Implements ServiceService to provide service management functionality.
 */
public class ServiceManager implements ServiceService {

    private List<Service> services;

    private static volatile ServiceManager INSTANCE = null;

    /**
     * Private constructor to initialize the services list.
     */
    private ServiceManager() {
        this.services = new ArrayList<>();
    }

    /**
     * Singleton pattern: gets the instance of ServiceManager.
     *
     * @return The singleton instance of ServiceManager
     */
    public static ServiceManager getInstance() {
        ServiceManager i = INSTANCE;
        if (i == null) {
            synchronized (ServiceManager.class) {
                i = INSTANCE;
                if (i == null) {
                    INSTANCE = i = new ServiceManager();
                }
            }
        }
        return i;
    }

    /**
     * Retrieves the list of all services managed by this ServiceManager.
     *
     * @return The list of services
     */
    @Override
    public List<Service> getServices() {
        return services;
    }

    /**
     * Retrieves the names of all services managed by this ServiceManager.
     *
     * @return The list of service names
     */
    @Override
    public List<String> getServicesNames() {
        List<String> serviceNames = new ArrayList<>();
        for (Service service : services) {
            serviceNames.add(service.getName());
        }
        return serviceNames;
    }

    /**
     * Creates a new service with the specified type, phone, and email,
     * and adds it to the list of services managed by this ServiceManager.
     *
     * @param serviceType The type of the service to create
     * @param phone       The phone number of the service
     * @param email       The email address of the service
     * @return The created Service object
     */
    @Override
    public Service createService(ServiceType serviceType, String phone, String email) {
        Service service = new Service(serviceType, phone, email);
        services.add(service);
        return service;
    }
}
