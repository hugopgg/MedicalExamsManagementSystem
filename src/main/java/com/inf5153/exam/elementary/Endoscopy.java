package com.inf5153.exam.elementary;

import com.inf5153.exam.ElementaryExam;

/**
 * Elementary exam representing an endoscopy.
 */
public class Endoscopy extends ElementaryExam {
    private String[] endoType;

    /**
     * Constructs an Endoscopy with specified types.
     *
     * @param type the types of endoscopy.
     */
    public Endoscopy(String... type) {
        super();
        this.endoType = type;
    }

    /**
     * Gets the types of endoscopy.
     *
     * @return the types of endoscopy.
     */
    public String[] getEndoType() {
        return endoType;
    }

    /**
     * Sets the types of endoscopy.
     *
     * @param type the new types of endoscopy.
     */
    public void setEndoType(String... type) {
        this.endoType = type;
    }

    /**
     * Returns the name of the exam.
     *
     * @return the name of the exam.
     */
    @Override
    public String getName() {
        return "Endoscopy";
    }

    /**
     * Returns a string representation of the Endoscopy object.
     *
     * @return a string representation of the Endoscopy object.
     */
    @Override
    public String toString() {
        return "Endoscopy{" +
                "type='" + java.util.Arrays.toString(endoType) + '\'' +
                '}';
    }
}
