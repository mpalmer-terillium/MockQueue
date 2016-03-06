package com.mockqueue.listener;

import com.mockedwards.service.MockRouter;
import com.mockedwards.service.MockRouterRequest;
import com.mockedwards.service.MockRouterService;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Listener {
    
    private static final MockRouter router = new MockRouterService().getMockRouterPort();
    private static final Logger logger = Logger.getLogger("Listener");

    public static void initializeRouter() {
       
        try {
            MockRouterRequest request = new MockRouterRequest();
            request.setPasscode(1234);

            logger.log(Level.INFO, router.initializeRouter(request).getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception in contextInitialized: " + e.toString());
        }
    }
    
}
