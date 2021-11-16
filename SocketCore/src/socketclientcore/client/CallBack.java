package socketclientcore.client;

public interface CallBack {
    void handle(Object response) throws Exception; // TODO: 16/11/2021 make generic return type at some point
}
