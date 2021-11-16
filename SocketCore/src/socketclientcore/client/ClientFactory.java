package socketclientcore.client;

public class ClientFactory {
    public static Client getClient(){
        return new SocketClient();
    }
}
