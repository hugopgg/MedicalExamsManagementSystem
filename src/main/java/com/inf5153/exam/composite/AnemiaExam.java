package com.inf5153.exam.composite;

import java.util.Arrays;
import java.util.List;

import com.inf5153.exam.*;
import com.inf5153.exam.elementary.BloodAnalysis;
import com.inf5153.exam.elementary.Myelogram;
import com.inf5153.exam.elementary.UrineAnalysis;

/**
 * Composite exam representing an anemia exam composed of multiple elementary exams.
 */
public class AnemiaExam extends CompositeExam {
    private static final List<Exam> COMPONENT_EXAMS = Arrays.asList(
            new BloodAnalysis("FSC"),
            new Myelogram(),
            new UrineAnalysis("protéinurie", "glycosurie"));

    /**
     * Constructs an AnemiaExam with predefined component exams.
     */
    public AnemiaExam() {
        super(COMPONENT_EXAMS);
    }

    /**
     * Returns the name of the exam.
     *
     * @return the name of the exam.
     */
    @Override
    public String getName() {
        return "Anemia Exam";
    }

    /**
     * Returns a string representation of the AnemiaExam object.
     *
     * @return a string representation of the AnemiaExam object.
     */
    @Override
    public String toString() {
        return "AnemiaExam{" +
                "components=" + COMPONENT_EXAMS +
                '}';
    }
}
