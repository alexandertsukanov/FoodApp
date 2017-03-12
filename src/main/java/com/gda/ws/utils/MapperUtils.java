package com.gda.ws.utils;

import com.gda.ws.dto.FoodCategoryDto;
import com.gda.ws.dto.FoodDto;
import com.gda.ws.entity.Food;
import com.gda.ws.entity.FoodCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MapperUtils {

    @Autowired
    private ModelMapper modelMapper;

    public FoodCategoryDto converToFoodCategoryDto(FoodCategory entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        return modelMapper.map(entity, FoodCategoryDto.class);
    }

    public FoodDto convertToFoodDto(Food entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        return modelMapper.map(entity, FoodDto.class);
    }

}
