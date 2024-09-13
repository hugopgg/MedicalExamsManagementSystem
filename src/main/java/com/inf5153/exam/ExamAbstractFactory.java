package com.inf5153.exam;

import com.inf5153.exam.composite.CompositeExamType;
import com.inf5153.exam.elementary.ElementaryExamType;

/**
 * Interface for creating exams using abstract factory pattern.
 */
public interface ExamAbstractFactory {

    /**
     * Creates an elementary exam based on the specified type and parameters.
     *
     * @param examType   the type of elementary exam to create.
     * @param parameters optional parameters for creating the elementary exam.
     * @return the created elementary exam.
     */
    Exam createElementaryExam(ElementaryExamType examType, String... parameters);

    /**
     * Creates a composite exam based on the specified type.
     *
     * @param examType the type of composite exam to create.
     * @return the created composite exam.
     */
    Exam createCompositeExam(CompositeExamType examType);
}
