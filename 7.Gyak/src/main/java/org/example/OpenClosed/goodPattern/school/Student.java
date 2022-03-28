package org.example.OpenClosed.goodPattern.school;

public class Student extends User{
    @Override
    public String getDachBorad() {
        return "courseSubscriber, takeExam, " + super.getDachBorad();
    }
}
