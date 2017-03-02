package com.gda.ws.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getPublic(){
        return "index";
    }

}
