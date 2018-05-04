package com.gerardoperrucci.gpredbee.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@CrossOrigin(origins = "*")
@Controller
public class StreamController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Object greeting(Object message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return message;
    }

}