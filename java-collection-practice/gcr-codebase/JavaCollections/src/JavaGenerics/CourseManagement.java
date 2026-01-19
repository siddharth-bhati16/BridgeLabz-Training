package JavaGenerics;

import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    protected String evaluationMethod;

    public String getEvaluationMethod() {
        return evaluationMethod;
    }

    public abstract String getType();
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        evaluationMethod = "Written Examination";
    }

    @Override
    public String getType() {
        return "Exam-Based Course";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        evaluationMethod = "Assignments & Projects";
    }

    @Override
    public String getType() {
        return "Assignment-Based Course";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        evaluationMethod = "Research & Thesis";
    }

    @Override
    public String getType() {
        return "Research-Based Course";
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return courseName + " (" + department + ") | "
                + courseType.getType()
                + " | Evaluation: " + courseType.getEvaluationMethod();
    }
}

class CourseManager {

    public static void displayCourses(List<? extends CourseType> courseTypes) {
        for (CourseType type : courseTypes) {
            System.out.println(type.getType()
                    + " | Evaluation Method: " + type.getEvaluationMethod());
        }
    }
}

public class CourseManagement {
    public static void main(String[] args) {

        Course<ExamCourse> math =
                new Course<>("Mathematics", "Science", new ExamCourse());

        Course<AssignmentCourse> cs =
                new Course<>("Data Structures", "Computer Science", new AssignmentCourse());

        Course<ResearchCourse> phd =
                new Course<>("AI Research", "Computer Science", new ResearchCourse());

        List<CourseType> allCourseTypes = new ArrayList<>();
        allCourseTypes.add(math.getCourseType());
        allCourseTypes.add(cs.getCourseType());
        allCourseTypes.add(phd.getCourseType());

        System.out.println("=== UNIVERSITY COURSES ===");
        System.out.println(math);
        System.out.println(cs);
        System.out.println(phd);

        System.out.println("\n=== COURSE TYPES (USING WILDCARDS) ===");
        CourseManager.displayCourses(allCourseTypes);
    }
}

