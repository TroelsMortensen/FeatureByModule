package sockets;

import AddCourse.server.logic.CourseAdderLogic;
import AddCourse.server.socketcontroller.AddCourseController;
import InMemoryDataAccess.InMemDAOFactory;
import dataaccesscontracts.DAOFactory;
import socketservercore.server.SocketServer;

import java.io.IOException;

public class RunServer {

    public static void main(String[] args) throws IOException {
        SocketServer socketServer = new SocketServer();
        DAOFactory factory = new InMemDAOFactory();

        addControllers(socketServer, factory);

        socketServer.start();
    }

    private static void addControllers(SocketServer socketServer, DAOFactory factory) {
        // TODO at some point I'll try to add controller by type, and use generics to instantiate it in the SocketServer.
        socketServer.addController(
                "AddCourse", () ->
                        new AddCourseController(
                                new CourseAdderLogic(factory)
                        )
        );
    }
}
