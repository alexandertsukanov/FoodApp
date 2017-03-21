package com.gda.ws.service.impl;

import com.gda.ws.dto.Cart;
import com.gda.ws.dto.FoodCategoryDto;
import com.gda.ws.dto.FoodDto;
import com.gda.ws.entity.*;
import com.gda.ws.forms.FoodCategoryForm;
import com.gda.ws.forms.FoodForm;
import com.gda.ws.repository.*;
import com.gda.ws.service.FoodService;
import com.gda.ws.utils.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    private static final Logger LOG = LoggerFactory.getLogger(FoodServiceImpl.class);

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderFoodRepository orderFoodRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private MapperUtils mapperUtils;

    @Autowired
    private HistoryRepository historyRepository;


    @Override
    public void deleteOneFood(Long id) {
        foodRepository.delete(id);
    }

    @Override
    public void deleteOneCategory(Long id) {
        foodCategoryRepository.delete(id);
    }

    @Override
    public void saveOne(FoodForm form) {
        foodRepository.save(new Food(form));
    }

    @Override
    public void saveOne(FoodCategoryForm form) {
        foodCategoryRepository.save(new FoodCategory(form));
    }

    @Override
    public FoodDto findOneFood(Long id) {
        return mapperUtils.toFoodDto(foodRepository.findOne(id));
    }

    @Override
    public FoodCategoryDto findOneCategory(Long id) {
        return mapperUtils.toFoodCategoryDto(foodCategoryRepository.findOne(id));
    }

    @Override
    public Collection<FoodDto> findAllfood() {
        LOG.info("> findAllFood");
        Collection<Food> found = foodRepository.findAll();
        Collection<FoodDto> result = found.stream().map(e -> mapperUtils.toFoodDto(e)).collect(Collectors.toList());
        LOG.info("< findAllFood");
        return result;
    }

    @Override
    public Collection<FoodCategoryDto> findAllFoodCategories() {
        LOG.info("> findAll");
        Collection<FoodCategory> found = foodCategoryRepository.findAll();
        Collection<FoodCategoryDto> result = found.stream()
                .map(e -> mapperUtils.toFoodCategoryDto(e)).collect(Collectors.toList());
        LOG.info("< findAll");
        return result;
    }

    @Override
    public Collection<FoodDto> findFoodByCategory(Long id) {
        LOG.info("> findFoodByCategory");
        Collection<Food> found = foodRepository.findFoodByCategoryId(id);
        Collection<FoodDto> result = found.stream().map(e -> mapperUtils.toFoodDto(e)).collect(Collectors.toList());
        LOG.info("< findFoodByCategory");
        return result;
    }

    @Override
    public Collection<Cart> findAllHistory(String deviceId) {
        LOG.info("> findAllHistory of User by DeviceId " + deviceId);
        User user = userRepository.findByDeviceId(deviceId);
        List<History> found = historyRepository.findHistoryByOrderUserId(user.getId());
        List<Cart> toSend = new ArrayList<>();
        for (History history : found) {
            Cart cart = new Cart();
            cart.setUser(history.getUser());
            cart.setEntityOrderInfo(history.getOrder().getOrderInfo());
            Collection<OrderFood> orderFoodCollection = history.getOrder().getOrderFoods();
            for (OrderFood orderFood : orderFoodCollection) {
                if (orderFood.getQuantity() > 0) {
                    for (int i = 0; i < orderFood.getQuantity(); i++) {
                        cart.addFood(orderFood.getFood());
                    }
                } else {
                    cart.addFood(orderFood.getFood());
                }
            }
            toSend.add(cart);
        }
        LOG.info("< findAllHistory of User by DeviceId " + deviceId);
        return toSend;
    }

    @Override
    public Cart saveCart(Cart cart) {
        OrderInfo receivedOrderInfo = cart.getEntityOrderInfo();
        receivedOrderInfo.setId(null);
        receivedOrderInfo.setDate(new Date(System.currentTimeMillis()));
        Order order = new Order();
        User user = userRepository.findOne(cart.getUser().getId());
        order.setOrderInfo(receivedOrderInfo);
        order.setStatus(orderStatusRepository.findOne(1L));
        order.setUser(user);
        List<Food> entityFoodList = cart.getEntityFoodList();
        for (int i = 0; i < entityFoodList.size(); i++) {
            Food food = foodRepository.findOne(entityFoodList.get(i).getId());
            Long rating = food.getRating();
            food.setRating(++rating);
            OrderFood orderFood = new OrderFood();
            orderFood.setFood(food);
            orderFood.setOrder(order);
            orderFood.setQuantity(Long.valueOf(cart.getIntegerListCount().get(i)));
            orderFoodRepository.save(orderFood);
        }
        History history = new History();
        history.setOrder(order);
        history.setUser(user);
        historyRepository.save(history);
        cart.setEntityOrderInfo(order.getOrderInfo());
        LOG.info("Card saved.");
        return cart;
    }
}