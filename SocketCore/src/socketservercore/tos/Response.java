package socketservercore.tos;

import java.io.Serializable;

public class Response implements Serializable {
    public String responseType;
    public Object arg;

    public Response(String responseType, Object arg) {
        this.responseType = responseType;
        this.arg = arg;
    }
}
