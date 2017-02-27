package com.gda.ws.service;

import java.util.Collection;

import com.gda.ws.web.api.dto.FoodCategoryDto;

public interface FoodService {

    Collection<FoodCategoryDto> foodCategories();
}
