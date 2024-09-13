package com.inf5153.exam;

import com.inf5153.exam.composite.*;
import com.inf5153.exam.elementary.*;

/**
 * Concrete implementation of ExamAbstractFactory that creates exams.
 */
public class ExamFactory implements ExamAbstractFactory {

    @Override
    public Exam createElementaryExam(ElementaryExamType examType, String... parameters) {
        switch (examType) {
            case BLOOD:
                return new BloodAnalysis(parameters);
            case ENDOSCOPY:
                return new Endoscopy(parameters);
            case MRI:
                return new MRIRadiography(parameters);
            case MYELO:
                return new Myelogram();
            case ULTRASOUND:
                return new Ultrasound(parameters);
            case URINE:
                return new UrineAnalysis(parameters);
            case XRAY:
                return new XRayRadiography(parameters);
            case TESTNOAV:
                return new TestMock();
            default:
                throw new IllegalArgumentException("Unknown elementary exam type: " + examType);
        }
    }

    @Override
    public Exam createCompositeExam(CompositeExamType examType) {
        switch (examType) {
            case ANEMIA:
                return new AnemiaExam();
            case THYROID:
                return new ThyroidExam();
            default:
                throw new IllegalArgumentException("Unknown composite exam type: " + examType);
        }
    }

}
