package socketservercore.server;

import socketservercore.tos.Request;
import socketservercore.tos.Response;

public interface SocketController {
    Response handle(Request request);
}
