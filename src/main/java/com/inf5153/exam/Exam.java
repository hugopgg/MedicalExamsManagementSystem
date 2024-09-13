package com.inf5153.exam;

/**
 * Represents an abstract exam.
 */
public abstract class Exam {
    private ExamType type;
    private String name;

    /**
     * Constructs an Exam object with the specified type.
     *
     * @param type the type of the exam.
     */
    public Exam(ExamType type) {
        this.type = type;
        this.name = this.getName();
    }

    /**
     * Gets the type of the exam.
     *
     * @return the type of the exam.
     */
    public ExamType getType() {
        return type;
    }

    /**
     * Gets the name of the exam.
     *
     * @return the name of the exam.
     */
    public String getName() {
        return name;
    }
}
