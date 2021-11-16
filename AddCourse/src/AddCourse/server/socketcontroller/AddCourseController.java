package AddCourse.server.socketcontroller;

import AddCourse.server.logic.CourseAdder;
import models.Course;
import socketservercore.tos.Request;
import socketservercore.tos.Response;
import socketservercore.server.SocketController;

public class AddCourseController implements SocketController {

    private CourseAdder logic;

    public AddCourseController(CourseAdder logic) {
        this.logic = logic;
    }

    @Override
    public Response handle(Request request) {
        Course course = (Course) request.arg;
        Course added = logic.addCourse(course);
        return new Response("OK", added);
    }
}
