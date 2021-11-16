package socketclientcore.client;

import socketservercore.tos.Request;
import socketservercore.tos.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient implements Client{

    public void sendRequest(String requestType, Object arg, CallBack callBack) throws Exception {
        Request request = new Request(requestType, arg);
        try {
            Socket socket = new Socket("localhost", 2710);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(request);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Response response = (Response) ois.readObject();
            if("ERROR".equals(response.responseType)){
                throw new Exception(response.arg.toString());
            }
            callBack.handle(response.arg);
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }

    }
}
