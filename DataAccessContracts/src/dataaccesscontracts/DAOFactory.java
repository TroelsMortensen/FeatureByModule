package dataaccesscontracts;

import dataaccesscontracts.course.CourseDAO;

public interface DAOFactory {
    CourseDAO getCourseDAO();
}
