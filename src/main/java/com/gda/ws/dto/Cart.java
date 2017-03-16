package com.gda.ws.dto;

import com.gda.ws.entity.Food;
import com.gda.ws.entity.OrderInfo;
import com.gda.ws.entity.User;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private User user;

    private List<Food> entityFoodList;

    private List<Integer> integerListCount;

    private OrderInfo entityOrderInfo;

    public Cart() {
        entityFoodList = new ArrayList<>();
        integerListCount = new ArrayList<>();
        entityOrderInfo = new OrderInfo(-1L, "", "");
    }

    public void addFood(Food entityFood) {
        if (entityFoodList.contains(entityFood)) {
            int index = entityFoodList.indexOf(entityFood);
            Integer value = integerListCount.get(index);
            value += 1;
            integerListCount.set(index, value);
        } else {
            entityFoodList.add(entityFood);
            integerListCount.add(1);
        }
    }

    public void deleteOneFood(Food entityFood) {
        if (entityFoodList.contains(entityFood)) {
            int index = entityFoodList.indexOf(entityFood);
            Integer value = integerListCount.get(index);
            if (value > 1) {
                value -= 1;
                integerListCount.set(index, value);
            } else {
                entityFoodList.remove(index);
                integerListCount.remove(index);
            }
        }
    }

    public void deleteFood(Food entityFood) {
        if (entityFoodList.contains(entityFood)) {
            int index = entityFoodList.indexOf(entityFood);
            entityFoodList.remove(index);
            integerListCount.remove(index);
        }
    }

    public List<Food> getEntityFoodList() {
        return entityFoodList;
    }

    public List<Integer> getIntegerListCount() {
        return integerListCount;
    }

    public void clearCart() {
        entityFoodList.clear();
        integerListCount.clear();
    }

    public BigDecimal getTotalPrice() {

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);

        BigDecimal totalPrice = new BigDecimal("0.0");
        totalPrice.setScale(0, BigDecimal.ROUND_CEILING);

        try {
            for (int i = 0; entityFoodList.size() > i; i++) {
                BigDecimal eachPrice = (BigDecimal) decimalFormat.parse(entityFoodList.get(i).getPrice());
                BigDecimal eachPriceMultiply = eachPrice.multiply(new BigDecimal(integerListCount.get(i)));
                totalPrice = totalPrice.add(eachPriceMultiply);
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return totalPrice;
    }
    public OrderInfo getEntityOrderInfo() {
        return entityOrderInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEntityOrderInfo(OrderInfo entityOrderInfo) {
        this.entityOrderInfo = entityOrderInfo;
    }
}
