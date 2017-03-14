package com.gda.ws.web.api;

import com.gda.ws.dto.FoodCategoryDto;
import com.gda.ws.dto.FoodDto;
import com.gda.ws.dto.HistoryDto;
import com.gda.ws.entity.Cart;
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

    @RequestMapping(value = "/api/cart-test", method = RequestMethod.GET)
    public void saveTestOrder() {
        LOG.info("Saving cart...");
//        OrderInfo info = new OrderInfo();
//        info.setAddress("My address");
//        info.setPhone("+34820984320");
//        Order order = new Order();
//        order.setOrderInfo(info);
//        Food food = foodRepository.findOne(2L);
//        OrderFood orderFood = new OrderFood();
//        orderFood.setFood(food);
//        orderFood.setOrder(order);
//        orderFood.setQuantity(1L);
//        orderFoodRepository.save(orderFood);
    }

    @RequestMapping(value = "/api/cart-save", method = RequestMethod.POST)
    public Cart saveOrder(@RequestBody Cart cart) {
        LOG.info("Saving cart...");
        return service.saveCart(cart);
    }

    @RequestMapping(value = "/api/food-categories",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<FoodCategoryDto>> foodCategories() {
        LOG.info("> foodCategories");
        Collection<FoodCategoryDto> entities = service.findAllFoodCategories();
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

    @RequestMapping(value = "/api/history",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<HistoryDto>> findHistory() {
        LOG.info("> foodByCategory");
        Collection<HistoryDto> entities = service.findAllHistory();
        LOG.info("< foodBCategory");
        return new ResponseEntity<Collection<HistoryDto>>(entities, HttpStatus.OK);
    }

}
