package com.gda.ws.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gda.ws.dto.Cart;
import com.gda.ws.dto.FoodCategoryDto;
import com.gda.ws.dto.FoodDto;
import com.gda.ws.repository.FoodRepository;
import com.gda.ws.repository.OrderFoodRepository;
import com.gda.ws.repository.OrderInfoRepository;
import com.gda.ws.repository.OrderRepository;
import com.gda.ws.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class FoodController {

    private static final Logger LOG = LoggerFactory.getLogger(FoodController.class);

    @Autowired
    private FoodService service;

    @Autowired
    private OrderRepository orderRepository;
    //
    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Autowired
    private OrderFoodRepository orderFoodRepository;

    @Autowired
    FoodRepository foodRepository;

    /**
     * Web service endpoint to fetch all entities. The service returns the collection of entities as
     * JSON.
     *
     * @return A ResponseEntity containing a Collection of objects.
     */

    @RequestMapping(value = "/api/cart-save", method = RequestMethod.POST)
    public Cart saveOrder(@RequestBody Cart cart) throws JsonProcessingException {
        LOG.info("Saving cart...");
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(cart);
        LOG.info(jsonInString);
        return service.saveCart(cart);
    }

    @RequestMapping(value = "/api/food-categories",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<FoodCategoryDto>> foodCategories() {
        LOG.info("> foodCategories");
        Collection<FoodCategoryDto> entities = service.findAllFoodCategories();
        LOG.info("< foodCategories");
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/food-categories/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<FoodDto>> findFoodByCategory(@PathVariable("id") Long id) {
        LOG.info("> foodByCategory");
        Collection<FoodDto> entities = service.findFoodByCategory(id);
        LOG.info("< foodBCategory");
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/history",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cart>> findHistory() {
        LOG.info("> foodAllHistory");
        Collection<Cart> entities = service.findAllHistory();
        LOG.info("< foodAllHistory");
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

}
