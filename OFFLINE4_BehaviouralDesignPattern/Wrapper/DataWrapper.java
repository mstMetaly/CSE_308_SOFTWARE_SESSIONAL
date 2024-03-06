package Wrapper;

import java.io.Serializable;

public class DataWrapper implements Serializable {
    public Object data;
    public Object subscriber;
    public String command;

    public DataWrapper(String command, Object data, Object subscriber) {
        this.command = command;
        this.data = data;
        this.subscriber = subscriber;
    }

    public DataWrapper(String command) {
        this.command = command;
        subscriber = null;
        data = null;
    }
}
