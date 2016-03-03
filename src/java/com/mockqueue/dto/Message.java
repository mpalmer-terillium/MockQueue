package com.mockqueue.dto;


import com.mockqueue.util.MockQueueUtil;
import java.util.Random;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
    
    private static int initId = Math.abs(new Random().nextInt() % 1000);
    
    private String message;
    private int id;
    private String timestamp;
    
    public Message() {}
    
    public Message(String message) {
        this.message = message;
        this.id = initId++;
        this.timestamp = MockQueueUtil.getTimestamp();
    }
    
    public Message(String message, int id) {
        this.message = message;
        this.id = id;
        this.timestamp = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getInitId() {
        return initId;
    }

    public static void setInitId(int initId) {
        Message.initId = initId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
