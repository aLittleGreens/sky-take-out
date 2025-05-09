package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {

    PageResult pageQuery(DishPageQueryDTO categoryPageQueryDTO);

    void update(DishDTO dishDTO);

    DishVO getDishById(Long id);

    void save(DishDTO dishDTO);

    List<Dish> getDishByCategoryId(Integer categoryId);

    void startOrStop(Integer status, Long id);

    void deleteDish(List<Long> ids);
}
