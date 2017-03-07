package com.gda.ws.web.controller;

import com.gda.ws.forms.FoodForm;
import com.gda.ws.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    String getMain() {
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    String getLogin() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/food", method = RequestMethod.GET)
    String getFood(Model model) {
        model.addAttribute("food", foodService.findAllfood());
        model.addAttribute("categories", foodService.foodCategories());
        return "food";
    }

    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
    String getFoodById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("categories", foodService.foodCategories());
        model.addAttribute("food", foodService.findFoodByCategory(id));
        return "food";
    }

    @RequestMapping(value = "/edit/food/", method = RequestMethod.GET)
    String createNewFood(Model model) {
        model.addAttribute("categories", foodService.foodCategories());
        model.addAttribute("FoodForm", new FoodForm());
        return "edit/food";
    }

    @RequestMapping(value = "/edit/food/{id}", method = RequestMethod.GET)
    String editFoodById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("categories", foodService.foodCategories());
        model.addAttribute("FoodForm", foodService.findOne(id));
        return "edit/food";
    }

    @RequestMapping(value = "/edit/food/", method = RequestMethod.POST)
    String saveNewFood(Model model, @ModelAttribute FoodForm foodForm) {
        foodService.saveOne(foodForm);
        return "redirect:/food";
    }

    @RequestMapping(value = "/delete/food/{id}", method = RequestMethod.GET)
    String deleteFood(@PathVariable("id") Long id) {
        foodService.deleteOne(id);
        return "redirect:/food";
    }

}
