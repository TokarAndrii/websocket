package com.example.controllers;

import com.example.Greeting;
import com.example.HelloMessage;
import org.jboss.logging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage helloMessage) throws InterruptedException {

        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, "+ helloMessage.getName()+ " !!!");

    }

}
