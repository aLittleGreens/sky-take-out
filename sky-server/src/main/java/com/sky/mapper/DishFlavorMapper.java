package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

   void insertBatch(List<DishFlavor> flavors);

   void updateBatch(List<DishFlavor> flavors);

   void deleteBatchByDishId(List<Long> ids);

   @Select("select * from dish_flavor where dish_id = #{dishId}")
   List<DishFlavor> getFlavorByDishId(Long dishId);
}
