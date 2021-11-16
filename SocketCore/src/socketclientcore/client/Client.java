package socketclientcore.client;

public interface Client {

    void sendRequest(String requestType, Object arg, CallBack callBack) throws Exception;

}
