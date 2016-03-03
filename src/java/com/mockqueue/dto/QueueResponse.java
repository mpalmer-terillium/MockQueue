package com.mockqueue.dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class QueueResponse {
    
    private String response;
    private int id;
    
    public QueueResponse() {}
    
    public QueueResponse(String response, int id) {
        this.response = response;
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
