package com.gda.ws.web.api;

import com.gda.ws.dto.FoodCategoryDto;
import com.gda.ws.dto.FoodDto;
import com.gda.ws.entity.Food;
import com.gda.ws.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;

@RestController
public class FoodController {

    private static final Logger LOG = LoggerFactory.getLogger(FoodController.class);

    @Autowired
    private FoodService service;
    /**
     * Web service endpoint to fetch all entities. The service returns the collection of entities as
     * JSON.
     *
     * @return A ResponseEntity containing a Collection of objects.
     */

    @RequestMapping(value = "/api/card-save", method = RequestMethod.POST)
    public void saveOrder(@RequestBody HashMap<Food, Integer> hashMap) {
    }

    @RequestMapping(value = "/api/food-categories",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<FoodCategoryDto>> foodCategories() {
        LOG.info("> foodCategories");
        Collection<FoodCategoryDto> entities = service.foodCategories();
        LOG.info("< foodCategories");
        return new ResponseEntity<Collection<FoodCategoryDto>>(entities, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/food-categories/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<FoodDto>> findFoodByCategory(@PathVariable("id") Long id) {
        LOG.info("> foodByCategory");
        Collection<FoodDto> entities = service.findFoodByCategory(id);
        LOG.info("< foodBCategory");
        return new ResponseEntity<Collection<FoodDto>>(entities, HttpStatus.OK);
    }
}
