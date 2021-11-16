package AddCourse.client.clientcontroller;

import models.Course;
import socketclientcore.client.Client;
import socketclientcore.client.SocketClient;

public class TestClient {

    public static void main(String[] args)  {
        Course c = new Course("IT-SDJ1-A21", "Software development with Java 1", "A21");
        Client client = new SocketClient();
        try {
            client.sendRequest("AddCourse", c, response ->
                    myCallbackMethod((Course) response)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void myCallbackMethod(Course course) {
        int stopher = 0;
    }
}
