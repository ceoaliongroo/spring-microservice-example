package com.mantilla.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: carlosmantilla
 * @since:
 */
@RestController
public class SecureDemo {

    @RequestMapping("/plus")
    public @ResponseBody String root() {
        return "{\"value\": \"Secure Demo\"}";
    }

}
