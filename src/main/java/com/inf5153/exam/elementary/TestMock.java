package com.inf5153.exam.elementary;

import com.inf5153.exam.ElementaryExam;

public class TestMock extends ElementaryExam {

    public TestMock() {
        super();
    }

    @Override
    public String getName() {
        return "Test exam";
    }

    @Override
    public String toString() {
        return "TestExam";
    }

}
