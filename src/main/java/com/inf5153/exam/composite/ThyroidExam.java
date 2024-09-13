package com.inf5153.exam.composite;

import java.util.Arrays;
import java.util.List;

import com.inf5153.exam.*;
import com.inf5153.exam.elementary.BloodAnalysis;
import com.inf5153.exam.elementary.Ultrasound;

/**
 * Composite exam representing a thyroid exam composed of multiple elementary exams.
 */
public class ThyroidExam extends CompositeExam {
    private static final List<Exam> COMPONENT_EXAMS = Arrays.asList(
            new Ultrasound("Thyroïde"),
            new AnemiaExam(),
            new BloodAnalysis("TSH"));

    /**
     * Constructs a ThyroidExam with predefined component exams.
     */
    public ThyroidExam() {
        super(COMPONENT_EXAMS);
    }

    /**
     * Returns the name of the exam.
     *
     * @return the name of the exam.
     */
    @Override
    public String getName() {
        return "Thyroid Exam";
    }

    /**
     * Returns a string representation of the ThyroidExam object.
     *
     * @return a string representation of the ThyroidExam object.
     */
    @Override
    public String toString() {
        return "ThyroidExam{" +
                "components=" + COMPONENT_EXAMS +
                '}';
    }
}
