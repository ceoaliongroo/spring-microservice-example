package com.mantilla.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: carlosmantilla
 * @since:
 */
@RestController
@EnableAutoConfiguration
public class SecureDemo {

    @RequestMapping("/")
    public @ResponseBody String root() {
        return "{\"value\": \"Secure Demo\"}";
    }

}
