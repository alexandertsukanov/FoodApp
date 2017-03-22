package com.gda.ws.utils;

import com.gda.ws.dto.*;
import com.gda.ws.entity.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class MapperUtils {


    public HistoryDto toHistoryDto(History entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        HistoryDto historyDto = new HistoryDto();
        historyDto.setId(entity.getId());
        historyDto.setOrderUser(toUserDto(entity.getUser()));
        historyDto.setOrder(toOrderDto(entity.getOrder()));
        return historyDto;
    }

    public History toHistory(HistoryDto dto){
        if (Objects.isNull(dto)) {
            return null;
        }
        History entity = new History();
        entity.setId(dto.getId());
        entity.setOrder(toOrder(dto.getOrder()));
        entity.setUser(toUser(dto.getOrderUser()));
        return entity;
    }

    public FoodCategoryDto toFoodCategoryDto(FoodCategory entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        FoodCategoryDto foodCategoryDto = new FoodCategoryDto();
        foodCategoryDto.setId(entity.getId());
        foodCategoryDto.setName(entity.getName());
        foodCategoryDto.setLink(entity.getLink());
        foodCategoryDto.setLinkBig(entity.getLinkBig());
        return foodCategoryDto;
    }

    public FoodCategory toFoodCategory(FoodCategoryDto dto){
        if (Objects.isNull(dto)) {
            return null;
        }
        FoodCategory entity = new FoodCategory();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLink(dto.getLink());
        entity.setLinkBig(dto.getLinkBig());
        return entity;
    }


    public FoodDto toFoodDto(Food entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        FoodDto dto = new FoodDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setCalories(entity.getCalories());
        dto.setDescription(entity.getDescription());
        dto.setIngredients(entity.getIngredients());
        dto.setPrice(entity.getPrice());
        dto.setWeight(entity.getWeight());
        dto.setCategory(toFoodCategoryDto(entity.getCategory()));
        dto.setImageLink(entity.getImageLink());
        return dto;
    }

    public Food toFood(FoodDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        Food entity = new Food();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setCalories(dto.getCalories());
        entity.setDescription(dto.getDescription());
        entity.setIngredients(dto.getIngredients());
        entity.setPrice(dto.getPrice());
        entity.setWeight(dto.getWeight());
        entity.setCategory(toFoodCategory(dto.getCategory()));
        entity.setImageLink(dto.getImageLink());
        return entity;
    }

    public OrderDto toOrderDto(Order entity){
        if (Objects.isNull(entity)) {
            return null;
        }
        OrderDto orderDto = new OrderDto();
        orderDto.setId(entity.getId());
        orderDto.setStatus(toOrderStatusDto(entity.getStatus()));
        orderDto.setUser(toUserDto(entity.getUser()));
        orderDto.setOrderInfo(toOrderInfoDto(entity.getOrderInfo()));
        orderDto.setHistories(entity.getHistories().stream().map(e -> toHistoryDto(e)).collect(Collectors.toList()));
        orderDto.setOrderFoods(entity.getOrderFoods().stream().map(e -> toOrderFoodDto(e)).collect(Collectors.toList()));
        return orderDto;
    }

    public Order toOrder(OrderDto dto){
        if (Objects.isNull(dto)) {
            return null;
        }
        Order entity = new Order();
        entity.setId(dto.getId());
        entity.setStatus(toOrderStatus(dto.getStatus()));
        entity.setUser(toUser(dto.getUser()));
        entity.setOrderInfo(toOrderInfo(dto.getOrderInfo()));
        entity.setHistories(dto.getHistories().stream().map(e -> toHistory(e)).collect(Collectors.toList()));
        entity.setOrderFoods(dto.getOrderFoods().stream().map(e -> toOrderFood(e)).collect(Collectors.toList()));
        return entity;
    }

    public OrderFoodDto toOrderFoodDto(OrderFood entity){
        if (Objects.isNull(entity)) {
            return null;
        }
        OrderFoodDto dto = new OrderFoodDto();
        dto.setId(entity.getId());
        dto.setFood(entity.getFood());
        dto.setOrder(toOrderDto(entity.getOrder()));
        dto.setQuantity(entity.getQuantity());
        return dto;
    }

    public OrderFood toOrderFood(OrderFoodDto dto){
        if (Objects.isNull(dto)) {
            return null;
        }
        OrderFood entity = new OrderFood();
        entity.setId(dto.getId());
        entity.setFood(dto.getFood());
        entity.setOrder(toOrder(dto.getOrder()));
        entity.setQuantity(dto.getQuantity());
        return entity;
    }
    
    public OrderStatusDto toOrderStatusDto(OrderStatus entity){
        if (Objects.isNull(entity)) {
            return null;
        }
        OrderStatusDto dto = new OrderStatusDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setOrders(entity.getOrders().stream().map(e -> toOrderDto(e)).collect(Collectors.toList()));
        return dto;
    }

    public OrderStatus toOrderStatus(OrderStatusDto dto){
        if (Objects.isNull(dto)) {
            return null;
        }
        OrderStatus entity = new OrderStatus();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setOrders(dto.getOrders().stream().map(e -> toOrder(e)).collect(Collectors.toList()));
        return entity;
    }

    public OrderInfoDto toOrderInfoDto(OrderInfo entity){
        if (Objects.isNull(entity)) {
            return null;
        }
        OrderInfoDto dto = new OrderInfoDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setStatus(entity.getStatus());
        dto.setDate(entity.getDate());
        dto.setOrders(entity.getOrders().stream().map(e -> toOrderDto(e)).collect(Collectors.toList()));
        return dto;
    }

    public OrderInfo toOrderInfo(OrderInfoDto dto){
        if (Objects.isNull(dto)) {
            return null;
        }
        OrderInfo entity = new OrderInfo();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setStatus(dto.getStatus());
        entity.setDate(dto.getDate());
        entity.setOrders(dto.getOrders().stream().map(e -> toOrder(e)).collect(Collectors.toList()));
        return entity;
    }

    public UserDto toUserDto(User entity){
        if(Objects.isNull(entity)){
            return null;
        }
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setDeviceId(entity.getDeviceId());
        return dto;
    }

    public User toUser(UserDto dto){
        if(Objects.isNull(dto)){
            return null;
        }
        User entity = new User();
        entity.setId(dto.getId());
        entity.setDeviceId(dto.getDeviceId());
        return entity;
    }

}
