package org.example.OpenClosed.goodPattern.school;

public class Teacher extends User {
    @Override
    public String getDachBorad() {
        return "coursePublisher, createExam, " + super.getDachBorad();
    }
}
