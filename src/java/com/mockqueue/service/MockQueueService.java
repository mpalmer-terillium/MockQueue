package com.mockqueue.service;

import com.mockqueue.dto.Message;
import com.mockqueue.dto.QueueResponse;
import com.mockqueue.listener.Listener;
import com.mockqueue.queue.MockQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class MockQueueService {
    
    private static final Logger logger = Logger.getLogger("MockQueue");
    private static final MockQueue queue = new MockQueue();
    private int ROUTER_INITIALIZED = 0;

    @WebMethod(operationName = "getNextMessage")
    public Message getNextMessage() {
        
        Message m = queue.readMessage();
        
        if(m.getId() != -1) {
            logger.log(Level.INFO, "Message {0} read", m.getId());
            return m;
        } else {
            return m;
        }
    }

    @WebMethod(operationName = "addNewMessage")
    public QueueResponse addNewMessage(@WebParam(name = "message") String m,
            @WebParam(name = "messageType") String t) {
        
        if(ROUTER_INITIALIZED == 0) {
            ROUTER_INITIALIZED = 1;
            Listener.initializeRouter();
        }
        
        int id = queue.addItem(new Message(m, t));
        
        String responseMessage = "Message ID: " + id + " created of type: " + t;
        
        logger.log(Level.INFO, responseMessage);
        
        return new QueueResponse(responseMessage, id);
    }
}
