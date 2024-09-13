package com.inf5153.exam.elementary;

import com.inf5153.exam.ElementaryExam;

/**
 * Elementary exam representing an X-ray radiography.
 */
public class XRayRadiography extends ElementaryExam {
    private String[] bodyParts;

    /**
     * Constructs an XRayRadiography exam with specified body parts.
     *
     * @param bodyParts the body parts for X-ray radiography.
     */
    public XRayRadiography(String... bodyParts) {
        super();
        this.bodyParts = bodyParts;
    }

    /**
     * Gets the body parts for X-ray radiography.
     *
     * @return the body parts for X-ray radiography.
     */
    public String[] getBodyParts() {
        return bodyParts;
    }

    /**
     * Sets the body parts for X-ray radiography.
     *
     * @param bodyParts the new body parts for X-ray radiography.
     */
    public void setBodyParts(String[] bodyParts) {
        this.bodyParts = bodyParts;
    }

    /**
     * Returns the name of the exam.
     *
     * @return the name of the exam ("Xray").
     */
    @Override
    public String getName() {
        return "Xray";
    }

    /**
     * Returns a string representation of the XRayRadiography object.
     *
     * @return a string representation of the XRayRadiography object.
     */
    @Override
    public String toString() {
        return "XRayRadiography{" +
                "bodyParts=" + java.util.Arrays.toString(bodyParts) +
                '}';
    }
}
