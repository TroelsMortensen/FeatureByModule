package InMemoryDataAccess;

import InMemoryDataAccess.course.CourseInMemDAO;
import dataaccesscontracts.DAOFactory;
import dataaccesscontracts.course.CourseDAO;

public class InMemDAOFactory implements DAOFactory {
    @Override
    public CourseDAO getCourseDAO() {
        return new CourseInMemDAO();
    }
}
