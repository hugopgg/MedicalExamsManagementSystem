package com.inf5153.exam.elementary;

import com.inf5153.exam.ElementaryExam;

/**
 * Elementary exam representing an ultrasound.
 */
public class Ultrasound extends ElementaryExam {
    private String[] organs;

    /**
     * Constructs an Ultrasound exam with specified organs.
     *
     * @param organs the organs for ultrasound.
     */
    public Ultrasound(String... organs) {
        super();
        this.organs = organs;
    }

    /**
     * Gets the organs for ultrasound.
     *
     * @return the organs for ultrasound.
     */
    public String[] getOrgans() {
        return organs;
    }

    /**
     * Sets the organs for ultrasound.
     *
     * @param organs the new organs for ultrasound.
     */
    public void setOrgans(String[] organs) {
        this.organs = organs;
    }

    /**
     * Returns the name of the exam.
     *
     * @return the name of the exam ("Ultrasound").
     */
    @Override
    public String getName() {
        return "Ultrasound";
    }

    /**
     * Returns a string representation of the Ultrasound object.
     *
     * @return a string representation of the Ultrasound object.
     */
    @Override
    public String toString() {
        return "Ultrasound{" +
                "organs=" + java.util.Arrays.toString(organs) +
                '}';
    }
}
