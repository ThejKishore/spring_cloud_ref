package com.kish.boot.learning.cloudconfigclient.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${info.foo}")
    private String propFromConfig;

    @GetMapping("/get")
    public String getDataFromConfig(){
        return propFromConfig;
    }

}
