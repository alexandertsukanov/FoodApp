package com.gda.ws.web.controller;

import com.gda.ws.forms.CategoryForm;
import com.gda.ws.forms.FoodForm;
import com.gda.ws.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FoodViewController {

    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    String getMain() {
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String getLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    String getreLogin() {
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
        model.addAttribute("cat", "?cat=" + id);
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
        model.addAttribute("FoodForm", foodService.findOneFood(id));
        return "edit/food";
    }

    @RequestMapping(value = "/edit/food/", method = RequestMethod.POST)
    String saveNewFood(@ModelAttribute FoodForm foodForm) {
        foodService.saveOne(foodForm);
        return "redirect:/food";
    }

    @RequestMapping(value = "/delete/food/{id}", method = RequestMethod.GET)
    String deleteFood(@PathVariable("id") Long id, @RequestParam("cat") Long cat) {
        foodService.deleteOneFood(id);
        if (cat == null) {
            return "redirect:/food";
        } else {
            return "redirect:/food/" + cat;
        }
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    String getCategories(Model model) {
        model.addAttribute("categories", foodService.foodCategories());
        return "categories";
    }

    @RequestMapping(value = "/edit/category/", method = RequestMethod.GET)
    String createNewCategory(Model model) {
        model.addAttribute("CategoryForm", new CategoryForm());
        return "edit/category";
    }

    @RequestMapping(value = "/edit/category/{id}", method = RequestMethod.GET)
    String editCategoryById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("CategoryForm", foodService.findOneCategory(id));
        return "edit/category";
    }

    @RequestMapping(value = "/edit/category/", method = RequestMethod.POST)
    String saveNewFoodCategory(@ModelAttribute CategoryForm categoryForm) {
        foodService.saveOne(categoryForm);
        return "redirect:/category";
    }

    @RequestMapping(value = "/delete/category/{id}", method = RequestMethod.GET)
    String deleteFood(@PathVariable("id") Long id) {
        foodService.deleteOneCategory(id);
        return "redirect:/category";
    }
}
