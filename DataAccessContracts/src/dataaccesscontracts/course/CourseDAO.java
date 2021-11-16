package dataaccesscontracts.course;

import models.Course;

public interface CourseDAO {
    Course add(Course course);

    Course getByCode(String code);
}
