package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: carlosmantilla
 * @since:
 */
@RestController
public class Basic {
    @RequestMapping("/plus")
    public @ResponseBody
    String root() {
        return "{\"value\": \"Secure Demo Microplus Boot, Security and Data REST!!!\"}";
    }

}


