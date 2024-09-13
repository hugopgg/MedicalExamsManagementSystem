package com.inf5153.exam;

/**
 * Enum representing types of exams.
 */
public enum ExamType {
    ELEMENTARY("Elementary"),
    COMPOSITE("Composite");

    private final String displayName;

    /**
     * Constructs an ExamType enum with the specified display name.
     *
     * @param displayName the display name of the exam type.
     */
    ExamType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the display name of the exam type.
     *
     * @return the display name of the exam type.
     */
    public String getDisplayName() {
        return displayName;
    }
}
