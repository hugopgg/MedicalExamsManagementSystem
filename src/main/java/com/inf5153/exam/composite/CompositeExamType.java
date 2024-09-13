package com.inf5153.exam.composite;

/**
 * Enum representing different types of composite exams.
 */
public enum CompositeExamType {
    ANEMIA("Anemia Exam"),
    THYROID("Thyroid Exam");

    private final String displayName;

    /**
     * Constructs a CompositeExamType with a display name.
     *
     * @param displayName the display name of the composite exam type.
     */
    CompositeExamType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the display name of the composite exam type.
     *
     * @return the display name.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Gets an array of all display names of composite exam types.
     *
     * @return an array of display names.
     */
    public static String[] getAllTypes() {
        CompositeExamType[] values = CompositeExamType.values();
        String[] types = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            types[i] = values[i].getDisplayName();
        }
        return types;
    }

    /**
     * Retrieves the CompositeExamType enum from its display name.
     *
     * @param displayName the display name of the composite exam type.
     * @return the corresponding CompositeExamType enum.
     * @throws IllegalArgumentException if no enum constant matches the display name.
     */
    public static CompositeExamType fromDisplayName(String displayName) {
        for (CompositeExamType type : CompositeExamType.values()) {
            if (type.getDisplayName().equalsIgnoreCase(displayName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with displayName " + displayName);
    }
}
