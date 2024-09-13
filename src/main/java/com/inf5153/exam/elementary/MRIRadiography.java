package com.inf5153.exam.elementary;

import com.inf5153.exam.ElementaryExam;

/**
 * Elementary exam representing an MRI radiography.
 */
public class MRIRadiography extends ElementaryExam {
    private String[] bodyParts;

    /**
     * Constructs an MRIRadiography with specified body parts.
     *
     * @param bodyParts the body parts for MRI radiography.
     */
    public MRIRadiography(String... bodyParts) {
        super();
        this.bodyParts = bodyParts;
    }

    /**
     * Gets the body parts for MRI radiography.
     *
     * @return the body parts.
     */
    public String[] getBodyParts() {
        return bodyParts;
    }

    /**
     * Sets the body parts for MRI radiography.
     *
     * @param bodyParts the new body parts.
     */
    public void setBodyParts(String[] bodyParts) {
        this.bodyParts = bodyParts;
    }

    /**
     * Returns the name of the exam.
     *
     * @return the name of the exam ("MRI").
     */
    @Override
    public String getName() {
        return "MRI";
    }

    /**
     * Returns a string representation of the MRIRadiography object.
     *
     * @return a string representation of the MRIRadiography object.
     */
    @Override
    public String toString() {
        return "MRIRadiography{" +
                "bodyParts=" + java.util.Arrays.toString(bodyParts) +
                '}';
    }
}