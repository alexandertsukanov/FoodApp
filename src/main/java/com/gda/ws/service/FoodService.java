package com.gda.ws.service;

import com.gda.ws.dto.FoodCategoryDto;
import com.gda.ws.dto.FoodDto;
import com.gda.ws.entity.Cart;
import com.gda.ws.forms.CategoryForm;
import com.gda.ws.forms.FoodForm;

import java.util.Collection;

public interface FoodService {

    Cart saveCart(Cart cart);

    FoodDto findOneFood(Long id);

    FoodCategoryDto findOneCategory(Long id);

    void saveOne(FoodForm form);

    void saveOne(CategoryForm form);

    void deleteOneFood(Long id);

    void deleteOneCategory(Long id);

    Collection<FoodCategoryDto> foodCategories();

    Collection<FoodDto> findAllfood();

    Collection<FoodDto> findFoodByCategory(Long id);
}
