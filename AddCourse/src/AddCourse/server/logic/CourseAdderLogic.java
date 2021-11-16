package AddCourse.server.logic;

import dataaccesscontracts.DAOFactory;
import dataaccesscontracts.course.CourseDAO;
import models.Course;

public class CourseAdderLogic implements CourseAdder {

    private CourseDAO courseDAO;

    public CourseAdderLogic(DAOFactory factory) {
        this.courseDAO = factory.getCourseDAO();
    }

    @Override
    public Course addCourse(Course course) {
        Course existing = courseDAO.getByCode(course.getCode());
        if(existing != null){
            throw new RuntimeException("Course code already in use");
        }
        // not sure if necessary, but this course object is created by a socket stream.
        // Don't think the constructor is called
        course.validate();

        Course added = courseDAO.add(course);

        return added;
    }
}
