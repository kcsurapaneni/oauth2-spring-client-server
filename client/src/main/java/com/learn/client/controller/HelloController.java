package com.learn.client.controller;

import org.springframework.web.bind.annotation.*;

import java.security.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    String hello(Principal principal) {
        return "Hello, " + principal.getName().toUpperCase();
    }

}
