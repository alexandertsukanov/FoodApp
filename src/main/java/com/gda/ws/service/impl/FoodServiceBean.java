package com.gda.ws.service.impl;

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
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceBean implements FoodService {

    private static final Logger LOG = LoggerFactory.getLogger(FoodServiceBean.class);

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Autowired
    private OrderFoodRepository orderFoodRepository;

    @Autowired
    private MapperUtils mapperUtils;

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
        return mapperUtils.convertToFoodDto(foodRepository.findOne(id));
    }

    @Override
    public FoodCategoryDto findOneCategory(Long id) {
        return mapperUtils.convertToFoodCategoryDto(foodCategoryRepository.findOne(id));
    }

    @Override
    public Collection<FoodDto> findAllfood() {
        LOG.info("> findAllFood");
        Collection<Food> found = foodRepository.findAll();
        Collection<FoodDto> result = found.stream().map(e -> mapperUtils.convertToFoodDto(e)).collect(Collectors.toList());
        LOG.info("< findAllFood");
        return result;
    }

    @Override
    public Collection<FoodCategoryDto> findAllFoodCategories() {
        LOG.info("> findAll");
        Collection<FoodCategory> found = foodCategoryRepository.findAll();
        Collection<FoodCategoryDto> result = found.stream()
                .map(e -> mapperUtils.convertToFoodCategoryDto(e)).collect(Collectors.toList());
        LOG.info("< findAll");
        return result;
    }

    @Override
    public Collection<FoodDto> findFoodByCategory(Long id) {
        LOG.info("> findFoodByCategory");
        Collection<Food> found = foodRepository.findFoodByCategoryId(id);
        Collection<FoodDto> result = found.stream().map(e -> mapperUtils.convertToFoodDto(e)).collect(Collectors.toList());
        LOG.info("< findFoodByCategory");
        return result;
    }

    @Override
    public Cart saveCart(Cart cart) {
        OrderInfo info = cart.getEntityOrderInfo();
        Order order = new Order();
        order.setOrderInfo(info);
        order.setStatusId(1L);
        order.setUserId(1L);
        order = orderRepository.save(order);
        List<Food> entityFoodList = cart.getEntityFoodList();
        for (int i = 0; i < entityFoodList.size(); i++) {
            Food food = entityFoodList.get(i);
            OrderFood orderFood = new OrderFood();
            orderFood.setFood(food);
            orderFood.setOrder(order);
            orderFood.setQuantity(Long.valueOf(cart.getIntegerListCount().get(i)));
            orderFoodRepository.save(orderFood);
        }
        cart.setEntityOrderInfo(order.getOrderInfo());
        return cart;
    }
}