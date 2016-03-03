package com.mockqueue.util;

import java.time.Instant;


public class MockQueueUtil {
    
    public static String getTimestamp() {
        return Instant.now().toString();
    }
}
