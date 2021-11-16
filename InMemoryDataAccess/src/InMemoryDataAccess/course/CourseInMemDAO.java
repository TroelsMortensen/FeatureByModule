package InMemoryDataAccess.course;

import dataaccesscontracts.course.CourseDAO;
import models.Course;

import java.util.HashSet;
import java.util.Set;

public class CourseInMemDAO implements CourseDAO {

    private Set<Course> courses;

    public CourseInMemDAO() {
        seed();
    }

    @Override
    public Course add(Course course) {
        courses.add(course);
        return course;
    }

    @Override
    public Course getByCode(String code) {

        Course existing = courses.stream().
                filter(course -> course.getCode().equals(code)).    // I'm filtering the set by the courses which match the given code
                findFirst().                                        // I'm taking the first
                orElse(null);                                       // or returning null if nothing was found
        return existing;
    }

    private void seed() {
        courses = new HashSet<>();

        courses.add(
                new Course("IT-SDJ2Y-A21", "Software development with java 2", "A21")
        );
        courses.add(
                new Course("IT-SDJ2X-A21", "Software development with java 2", "A21")
        );
        courses.add(
                new Course("IT-DNP1Y-A21", ".NET programming 1", "A21")
        );
        courses.add(
                new Course("IT-DNP1-S22", ".NET programming 1", "S22")
        );
    }
}
