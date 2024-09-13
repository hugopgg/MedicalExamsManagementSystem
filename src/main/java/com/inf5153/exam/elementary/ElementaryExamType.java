package com.inf5153.exam.elementary;

/**
 * Enum representing different types of elementary exams.
 */
public enum ElementaryExamType {
    BLOOD("Blood Analysis"),
    ENDOSCOPY("Endoscopy"),
    MRI("MRI Radiography"),
    MYELO("Myelogram"),
    ULTRASOUND("Ultrasound"),
    URINE("Urine Analysis"),
    XRAY("Xray Radiography"),
    TESTNOAV("Test fake exam");

    private final String displayName;

    /**
     * Constructs an ElementaryExamType with a display name.
     *
     * @param displayName the display name of the elementary exam type.
     */
    ElementaryExamType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the display name of the elementary exam type.
     *
     * @return the display name.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Gets an array of all display names of elementary exam types.
     *
     * @return an array of display names.
     */
    public static String[] getAllTypes() {
        ElementaryExamType[] values = ElementaryExamType.values();
        String[] types = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            types[i] = values[i].getDisplayName();
        }
        return types;
    }

    /**
     * Retrieves the ElementaryExamType enum from its display name.
     *
     * @param displayName the display name of the elementary exam type.
     * @return the corresponding ElementaryExamType enum.
     * @throws IllegalArgumentException if no enum constant matches the display
     *                                  name.
     */
    public static ElementaryExamType fromDisplayName(String displayName) {
        for (ElementaryExamType type : ElementaryExamType.values()) {
            if (type.getDisplayName().equalsIgnoreCase(displayName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with displayName " + displayName);
    }
}
