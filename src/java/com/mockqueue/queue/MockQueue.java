package com.mockqueue.queue;

import com.mockqueue.dto.Message;
import java.util.LinkedList;


public class MockQueue {
    
    private final Message DEFAULT_MESSAGE = new Message("No more messages", -1);
    
    private final LinkedList<Message> queue = new LinkedList<>();
    
    public MockQueue() {}

    public int addItem(Message m) {
        this.queue.add(m);
        return m.getId();
    }
    
    public Message readMessage() {
        if(queue.isEmpty()) {
            return DEFAULT_MESSAGE;
        } else {
            return this.queue.removeFirst();
        }
    }
}
