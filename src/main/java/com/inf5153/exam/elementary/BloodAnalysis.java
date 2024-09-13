package com.inf5153.exam.elementary;

import com.inf5153.exam.ElementaryExam;

/**
 * Elementary exam representing a blood analysis.
 */
public class BloodAnalysis extends ElementaryExam {
    private String[] parameters;

    /**
     * Constructs a BloodAnalysis with specified parameters.
     *
     * @param parameters the parameters of the blood analysis.
     */
    public BloodAnalysis(String... parameters) {
        super();
        this.parameters = parameters;
    }

    /**
     * Gets the parameters of the blood analysis.
     *
     * @return the parameters.
     */
    public String[] getParameters() {
        return parameters;
    }

    /**
     * Sets the parameters of the blood analysis.
     *
     * @param parameters the new parameters.
     */
    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    /**
     * Returns the name of the exam.
     *
     * @return the name of the exam.
     */
    @Override
    public String getName() {
        return "Blood Analysis";
    }

    /**
     * Returns a string representation of the BloodAnalysis object.
     *
     * @return a string representation of the BloodAnalysis object.
     */
    @Override
    public String toString() {
        return "BloodAnalysis{" +
                "parameters=" + java.util.Arrays.toString(parameters) +
                '}';
    }
}
