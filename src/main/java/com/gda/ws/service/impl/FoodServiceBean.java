package com.gda.ws.service.impl;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import com.gda.ws.entity.Food;
import com.gda.ws.repository.FoodRepository;
import com.gda.ws.service.FoodService;
import com.gda.ws.dto.FoodDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gda.ws.entity.FoodCategory;
import com.gda.ws.repository.FoodCategoryRepository;
import com.gda.ws.dto.FoodCategoryDto;

@Service
public class FoodServiceBean implements FoodService {

    private static final Logger LOG = LoggerFactory.getLogger(FoodServiceBean.class);

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

	@Autowired
	private FoodRepository foodRepository;
    
	@Override
	@HystrixCommand
	public Collection<FoodCategoryDto> foodCategories() {
		LOG.info("> findAll");
        Collection<FoodCategory> found = foodCategoryRepository.findAll();
        Collection<FoodCategoryDto> result = found.stream()
        		.map(e -> from(e)).collect(Collectors.toList());
        LOG.info("< findAll");
        return result;
	}

	@Override
	public Collection<FoodDto> findFoodByCategory(Long id) {
		LOG.info("> findFoodByCategory");
		Collection<Food> found = foodRepository.findFoodByCategoryId(id);
		Collection<FoodDto> result = found.stream().map(e -> from(e)).collect(Collectors.toList());
		LOG.info("< findFoodByCategory");
		return result;
	}
	
	private static FoodCategoryDto from(FoodCategory entity){
		if(Objects.isNull(entity)){
    		return null;
    	}
		FoodCategoryDto dto = new FoodCategoryDto();
    	dto.setId(entity.getId());
    	dto.setName(entity.getName());
    	dto.setLink(entity.getLink());
    	return dto;
    }


	private static FoodDto from(Food entity){
		if(Objects.isNull(entity)){
			return null;
		}
		FoodDto dto = new FoodDto();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setCategoryId(entity.getCategoryId());
		dto.setDescription(entity.getDescription());
		dto.setImageLink(entity.getImageLink());
		dto.setWeight(entity.getWeight());
		dto.setPrice(entity.getPrice());
		dto.setIngredients(entity.getIngredients());
		dto.setCalories(entity.getCalories());
		return dto;
	}


}