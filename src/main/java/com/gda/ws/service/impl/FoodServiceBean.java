package com.gda.ws.service.impl;

import com.gda.ws.dto.FoodCategoryDto;
import com.gda.ws.dto.FoodDto;
import com.gda.ws.entity.Cart;
import com.gda.ws.entity.Food;
import com.gda.ws.entity.FoodCategory;
import com.gda.ws.forms.CategoryForm;
import com.gda.ws.forms.FoodForm;
import com.gda.ws.repository.FoodCategoryRepository;
import com.gda.ws.repository.FoodRepository;
import com.gda.ws.repository.OrderInfoRepository;
import com.gda.ws.repository.OrderRepository;
import com.gda.ws.service.FoodService;
import com.gda.ws.utils.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    private MapperUtils mapperUtils;

    @Override
    public FoodDto findOneFood(Long id) {
        return mapperUtils.convertToFoodDto(foodRepository.findOne(id));
    }

    @Override
    public FoodCategoryDto findOneCategory(Long id) {
        return mapperUtils.converToFoodCategoryDto(foodCategoryRepository.findOne(id));
    }

    @Override
    public void deleteOneFood(Long id) {
        foodRepository.delete(id);
    }

    @Override
    public void deleteOneCategory(Long id) {
        foodCategoryRepository.delete(id);
    }

    //TODO Save object refactoring

    @Override
    public void saveOne(FoodForm form) {
        if (form.getId() != null) {
            Food food = new Food();
            food.setId(form.getId());
            food.setCategoryId(form.getCategoryId());
            food.setTitle(form.getTitle());
            food.setDescription(form.getDescription());
            food.setCalories(form.getCalories());
            food.setIngredients(form.getIngredients());
            food.setWeight(form.getWeight());
            food.setPrice(form.getPrice());
            food.setImageLink(form.getImageLink());
            foodRepository.save(food);
        } else {
            Food food = new Food(form);
//            food.setCategoryId(form.getCategoryId());
//            food.setTitle(form.getTitle());
//            food.setDescription(form.getDescription());
//            food.setCalories(form.getCalories());
//            food.setIngredients(form.getIngredients());
//            food.setWeight(form.getWeight());
//            food.setPrice(form.getPrice());
//            food.setImageLink(form.getImageLink());
            foodRepository.save(food);
        }
    }

    @Override
    public void saveOne(CategoryForm form) {
        if (form.getId() != null) {
            FoodCategory foodCategory = foodCategoryRepository.findOne(form.getId());
            foodCategory.setName(form.getName());
            foodCategory.setLink(form.getLink());
            foodCategory.setLinkBig(form.getLinkBig());
            foodCategoryRepository.save(foodCategory);
        } else {
            FoodCategory foodCategory = new FoodCategory();
            foodCategory.setName(form.getName());
            foodCategory.setLink(form.getLink());
            foodCategory.setLinkBig(form.getLinkBig());
            foodCategoryRepository.save(foodCategory);
        }
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
    public Collection<FoodCategoryDto> foodCategories() {
        LOG.info("> findAll");
        Collection<FoodCategory> found = foodCategoryRepository.findAll();
        Collection<FoodCategoryDto> result = found.stream()
                .map(e -> mapperUtils.converToFoodCategoryDto(e)).collect(Collectors.toList());
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
//        int counter = 0;
//        for (Food food : cart.getEntityFoodList()) {
//            Order order = new Order();
//            order.setOrderId(1L);
//            order.setFoodId(food.getCategoryId());
//            order.setStatusId(2L);
//            order.setUserId(1L);
//            order.setQuantity(Long.valueOf(cart.getIntegerListCount().get(counter++)));
//            orderRepository.save(order);
//        }
//        orderInfoRepository.save(cart.getEntityOrderInfo());
        return cart;
    }
}