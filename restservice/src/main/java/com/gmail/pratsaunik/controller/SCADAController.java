package com.gmail.pratsaunik.controller;


import com.gmail.pratsaunik.service.ControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SCADAController {

    @Autowired
    ControllerService controllerService;

/*
    @PostMapping("/IED")
    public void createNewIED(@RequestBody CreateCmd createCmd){
        controllerService.create(createCmd);
    }
*/

    @PostMapping("/value")
    public void createNewIED(@RequestBody ValueCmd valueCmd){
        controllerService.value(valueCmd);
    }
}
