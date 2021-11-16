package socketservercore.tos;

import java.io.Serializable;

public class Request implements Serializable {
    public String requestType;
    public Object arg;

    public Request(String requestType, Object arg) {
        this.requestType = requestType;
        this.arg = arg;
    }
}
