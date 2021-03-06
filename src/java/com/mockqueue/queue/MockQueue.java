package com.mockqueue.queue;

import com.mockqueue.dto.Message;
import com.mockqueue.dto.Message.MessageType;
import java.util.LinkedList;

public class MockQueue {

    private final Message DEFAULT_MESSAGE = new Message("No more messages", -1, MessageType.Other);

    private final LinkedList<Message> queue = new LinkedList<>();

    public MockQueue() {
    }

    public int addItem(Message m) {
        this.queue.add(m);
        return m.getId();
    }

    public Message readMessage() {
        return this.queue.isEmpty() ? DEFAULT_MESSAGE : this.queue.removeFirst();
    }

    public int size() {
        return queue.size();
    }
}
