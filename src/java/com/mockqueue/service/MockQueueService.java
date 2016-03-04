package com.mockqueue.service;

import com.mockqueue.dto.Message;
import com.mockqueue.dto.Message.MessageType;
import com.mockqueue.dto.QueueResponse;
import com.mockqueue.queue.MockQueue;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class MockQueueService {

    private static final MockQueue queue = new MockQueue();

    @WebMethod(operationName = "getNextMessage")
    public Message getNextMessage() {
        return queue.readMessage();
    }

    @WebMethod(operationName = "addNewMessage")
    public QueueResponse addNewMessage(@WebParam(name = "message") String m,
            @WebParam(name = "messageType") String t) {
        return new QueueResponse("New message created", queue.addItem(new Message(m, t)));
    }
}
