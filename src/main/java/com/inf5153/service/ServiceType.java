package com.inf5153.service;

/**
 * Enum representing different types of services.
 */
public enum ServiceType {
    CARDIO("Cardiology"),
    NEPHRO("Nephrology"),
    GASTRO("Gastroenterology");

    private final String displayName;

    /**
     * Constructor for ServiceType enum.
     *
     * @param displayName The display name of the service type
     */
    ServiceType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the display name of the service type.
     *
     * @return The display name
     */
    public String getDisplayName() {
        return displayName;
    }
}
