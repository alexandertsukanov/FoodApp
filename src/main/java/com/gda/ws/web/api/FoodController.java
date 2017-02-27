package com.gda.ws.web.api;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gda.ws.service.FoodService;
import com.gda.ws.web.api.dto.FoodCategoryDto;

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
    @RequestMapping(value = "/api/food-categories",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<FoodCategoryDto>> foodCategories() {
        LOG.info("> foodCategories");
        Collection<FoodCategoryDto> entities = service.foodCategories();
        LOG.info("< foodCategories");
        return new ResponseEntity<Collection<FoodCategoryDto>>(entities, HttpStatus.OK);
    }
}
