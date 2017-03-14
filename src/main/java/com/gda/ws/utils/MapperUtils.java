package com.gda.ws.utils;

import com.gda.ws.dto.FoodCategoryDto;
import com.gda.ws.dto.FoodDto;
import com.gda.ws.dto.HistoryDto;
import com.gda.ws.entity.Food;
import com.gda.ws.entity.FoodCategory;
import com.gda.ws.entity.History;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MapperUtils {


    public HistoryDto convertToHistoryDto(History entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        HistoryDto historyDto = new HistoryDto();
        historyDto.setId(entity.getId());
        historyDto.setOrderUser(entity.getUser());
        historyDto.setOrder(entity.getOrder());
        historyDto.setOrderStatus(entity.getOrderStatus());
        return historyDto;
    }

    public FoodCategoryDto convertToFoodCategoryDto(FoodCategory entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        FoodCategoryDto foodCategoryDto = new FoodCategoryDto();
        foodCategoryDto.setFoods(entity.getFoods());
        foodCategoryDto.setName(entity.getName());
        foodCategoryDto.setId(entity.getId());
        foodCategoryDto.setLink(entity.getLink());
        foodCategoryDto.setLinkBig(entity.getLinkBig());
        return foodCategoryDto;
    }

    public FoodDto convertToFoodDto(Food entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        FoodDto foodDto = new FoodDto();
        foodDto.setId(entity.getId());
        foodDto.setTitle(entity.getTitle());
        foodDto.setCalories(entity.getCalories());
        foodDto.setDescription(entity.getDescription());
        foodDto.setIngredients(entity.getIngredients());
        foodDto.setPrice(entity.getPrice());
        foodDto.setWeight(entity.getWeight());
        foodDto.setCategory(entity.getCategory());
        foodDto.setImageLink(entity.getImageLink());
        return foodDto;
    }

}
