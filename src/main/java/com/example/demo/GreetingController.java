package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    // private static final String template = "Hello %s";

    @GetMapping
    public Greeting greeting(
            @RequestParam(value = "nombre", defaultValue = "Mundo") String nombre,
            @RequestParam(value = "saludo", defaultValue = "Hola") String saludo) {
        return new Greeting(counter.incrementAndGet(), (saludo.trim() + " " + nombre.trim()));
    }

}
