package com.inf5153.exam.elementary;

import com.inf5153.exam.ElementaryExam;

/**
 * Elementary exam representing a urine analysis.
 */
public class UrineAnalysis extends ElementaryExam {
    private String[] parameters;

    /**
     * Constructs a UrineAnalysis exam with specified parameters.
     *
     * @param parameters the parameters for urine analysis.
     */
    public UrineAnalysis(String... parameters) {
        super();
        this.parameters = parameters;
    }

    /**
     * Gets the parameters for urine analysis.
     *
     * @return the parameters for urine analysis.
     */
    public String[] getParameters() {
        return parameters;
    }

    /**
     * Sets the parameters for urine analysis.
     *
     * @param parameters the new parameters for urine analysis.
     */
    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    /**
     * Returns the name of the exam.
     *
     * @return the name of the exam ("Urine Analysis").
     */
    @Override
    public String getName() {
        return "Urine Analysis";
    }

    /**
     * Returns a string representation of the UrineAnalysis object.
     *
     * @return a string representation of the UrineAnalysis object.
     */
    @Override
    public String toString() {
        return "UrineAnalysis{" +
                "parameters=" + java.util.Arrays.toString(parameters) +
                '}';
    }
}
