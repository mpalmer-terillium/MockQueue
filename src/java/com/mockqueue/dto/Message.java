package com.mockqueue.dto;

import com.mockqueue.util.MockQueueUtil;
import java.util.Random;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

    public enum MessageType {
        PayTrace, SalesCloud, Other;
        
        public static MessageType parseString(String s) {
            if(s.equalsIgnoreCase("PayTrace")) {
                return PayTrace;
            } else if(s.equalsIgnoreCase("SalesCloud")) {
                return SalesCloud;
            } else {
                return Other;
            }
        }
    }

    private static int initId = Math.abs(new Random().nextInt() % 1000);

    private String message;
    private int id;
    private String timestamp;
    private MessageType type;

    public Message() {
        this.type = MessageType.Other;
    }

    public Message(String message, String type) {
        this.message = message;
        this.id = initId++;
        this.timestamp = MockQueueUtil.getTimestamp();
        this.type = MessageType.parseString(type);
    }

    public Message(String message, int id, String type) {
        this.message = message;
        this.id = id;
        this.timestamp = MockQueueUtil.getTimestamp();
        this.type = MessageType.parseString(type);
    }
    
    public Message(String message, int id, MessageType type) {
        this.message = message;
        this.id = id;
        this.timestamp = MockQueueUtil.getTimestamp();
        this.type = type;
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

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
