package com.gda.ws.web.controller;

import com.gda.ws.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @Autowired
    FoodService foodService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getPublic(){
        return "main";
    }

    @RequestMapping(value = "/food", method = RequestMethod.GET)
    String getEdit(Model model){
        model.addAttribute("food", foodService.findAllfood());
        model.addAttribute("categories", foodService.foodCategories());
        return "food";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String getLogin(Model model) {
        return "login";
    }

}
