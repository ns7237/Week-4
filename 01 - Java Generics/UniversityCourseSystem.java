import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getEvaluationMethod();
}

class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }

    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based";
    }
}

class Course<T extends CourseType> {
    private T courseType;
    private String department;
    private int credits;

    public Course(String department, int credits, T courseType) {
        this.department = department;
        this.credits = credits;
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public String getDepartment() {
        return department;
    }

    public int getCredits() {
        return credits;
    }

    public void displayInfo() {
        System.out.println("Department: " + department + ", Course: " + courseType.getName() + ", Evaluation: " + courseType.getEvaluationMethod() + ", Credits: " + credits);
    }
}

class UniversityUtils {
    public static void displayAllCourses(List<? extends CourseType> courseTypes) {
        for (CourseType ct : courseTypes) {
            System.out.println("Course: " + ct.getName() + ", Evaluation Method: " + ct.getEvaluationMethod());
        }
    }
}

public class UniversityCourseSystem {
    public static void main(String[] args) {
        Course<ExamCourse> math101 = new Course<>("Mathematics", 4, new ExamCourse("Calculus I"));
        Course<AssignmentCourse> cs102 = new Course<>("Computer Science", 3, new AssignmentCourse("Intro to Programming"));
        Course<ResearchCourse> bio201 = new Course<>("Biology", 5, new ResearchCourse("Genetic Research"));

        List<Course<? extends CourseType>> allCourses = new ArrayList<>();
        allCourses.add(math101);
        allCourses.add(cs102);
        allCourses.add(bio201);

        for (Course<? extends CourseType> c : allCourses) {
            c.displayInfo();
        }

        System.out.println("\nDisplaying Evaluation Methods:");
        List<CourseType> types = new ArrayList<>();
        types.add(math101.getCourseType());
        types.add(cs102.getCourseType());
        types.add(bio201.getCourseType());
        UniversityUtils.displayAllCourses(types);
    }
}
