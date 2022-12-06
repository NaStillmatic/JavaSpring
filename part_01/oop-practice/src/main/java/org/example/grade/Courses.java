package org.example.grade;

import java.util.List;

public class Courses {
    private final List<Course> courses;
    public Courses(List<Course> courses) {
        this.courses = courses;
    }
    public double multiplyCreditAndCcourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }
    public int calculateTotoalCompletedGrade() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
