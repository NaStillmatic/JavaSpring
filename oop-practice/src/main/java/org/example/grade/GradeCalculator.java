package org.example.grade;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }
    public double calculateGrade() {
        // (학점수 * 교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCcourseGrade();
        // 수강신청 총 학점수
        int totalCompletedCredit = courses.calculateTotoalCompletedGrade();
        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
