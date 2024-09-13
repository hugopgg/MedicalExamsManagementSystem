package com.inf5153.exam.elementary;

import com.inf5153.exam.ElementaryExam;

/**
 * Elementary exam representing a myelogram.
 */
public class Myelogram extends ElementaryExam {

    /**
     * Constructs a Myelogram exam.
     */
    public Myelogram() {
        super();
    }

    /**
     * Returns the name of the exam.
     *
     * @return the name of the exam ("Myelogram").
     */
    @Override
    public String getName() {
        return "Myelogram";
    }

    /**
     * Returns a string representation of the Myelogram exam.
     *
     * @return a string representation of the Myelogram exam.
     */
    @Override
    public String toString() {
        return "Myelogram Exam";
    }
}
