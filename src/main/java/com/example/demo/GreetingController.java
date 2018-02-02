package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String homeTemplate = "Welcome to my, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")String name){
        return new Greeting(counter.incrementAndGet(),
                String.format(template,name));
    }

    @RequestMapping("/home")
    public Greeting homepage(@RequestParam(value = "home", defaultValue = "homepage")String home){
        return new Greeting(counter.incrementAndGet(),
                String.format(homeTemplate, home));

    }

    @RequestMapping("/Kimberly")
    public Greeting kimpage(@RequestParam(value = "first", defaultValue = "Kimberly") String first){
        return new Greeting(counter.incrementAndGet(),
                String.format(template, first));
    }

}
