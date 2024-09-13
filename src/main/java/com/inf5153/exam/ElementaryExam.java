package com.inf5153.exam;

/**
 * Represents an elementary exam, which is a type of Exam.
 */
public class ElementaryExam extends Exam {
    private static final ExamType EXAM_TYPE = ExamType.ELEMENTARY;

    /**
     * Constructs an ElementaryExam object.
     */
    public ElementaryExam() {
        super(EXAM_TYPE);
    }
}
