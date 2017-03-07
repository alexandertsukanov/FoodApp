package com.gda.ws.service.impl;

import com.gda.ws.dto.FoodCategoryDto;
import com.gda.ws.dto.FoodDto;
import com.gda.ws.entity.Food;
import com.gda.ws.entity.FoodCategory;
import com.gda.ws.forms.FoodForm;
import com.gda.ws.repository.FoodCategoryRepository;
import com.gda.ws.repository.FoodRepository;
import com.gda.ws.service.FoodService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FoodServiceBean implements FoodService {

    private static final Logger LOG = LoggerFactory.getLogger(FoodServiceBean.class);

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

	@Autowired
	private FoodRepository foodRepository;

	@Override
	public FoodDto findOne(Long id) {
		FoodDto result = from(foodRepository.findOne(id));
		return result;
	}

	@Override
	public void deleteOne(Long id) {
		foodRepository.delete(id);
	}

	@Override
	public void saveOne(FoodForm form) {
		if (form.getId() != null) {
			Food food = foodRepository.findOne(form.getId());
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
			Food food = new Food();
			food.setCategoryId(form.getCategoryId());
			food.setTitle(form.getTitle());
			food.setDescription(form.getDescription());
			food.setCalories(form.getCalories());
			food.setIngredients(form.getIngredients());
			food.setWeight(form.getWeight());
			food.setPrice(form.getPrice());
			food.setImageLink(form.getImageLink());
			foodRepository.save(food);
		}
	}

	@Override
	public Collection<FoodDto> findAllfood() {
		LOG.info("> findAllFood");
		Collection<Food> found = foodRepository.findAll();
		Collection<FoodDto> result = found.stream().map(e -> from(e)).collect(Collectors.toList());
		LOG.info("< findAllFood");
		return result;
	}

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