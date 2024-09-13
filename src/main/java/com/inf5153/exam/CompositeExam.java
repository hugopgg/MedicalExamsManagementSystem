package com.inf5153.exam;

import java.util.List;

/**
 * Represents a composite exam, which is composed of multiple sub-exams.
 */
public class CompositeExam extends Exam {
    private static final ExamType EXAM_TYPE = ExamType.COMPOSITE;
    private List<Exam> components;

    /**
     * Constructs a CompositeExam with the specified components.
     *
     * @param components the list of sub-exams that compose the composite exam.
     */
    public CompositeExam(List<Exam> components) {
        super(EXAM_TYPE);
        this.components = components;
    }

    /**
     * Gets the components of the composite exam.
     *
     * @return the list of sub-exams that compose the composite exam.
     */
    public List<Exam> getComponents() {
        return components;
    }

    /**
     * Sets the components of the composite exam.
     *
     * @param components the new list of sub-exams that compose the composite exam.
     */
    public void setComponents(List<Exam> components) {
        this.components = components;
    }

    /**
     * Returns a string representation of the CompositeExam object.
     *
     * @return a string representation of the CompositeExam object.
     */
    @Override
    public String toString() {
        return "CompositeExam{" +
                "components=" + components +
                '}';
    }

}
