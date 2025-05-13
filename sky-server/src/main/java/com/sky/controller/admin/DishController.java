package com.sky.controller.admin;

import com.sky.dto.CategoryPageQueryDTO;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.Employee;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜单相关接口")
@Slf4j
public class DishController {
    @Autowired
    DishService dishService;

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("菜品分类分页查询")
    public Result<PageResult> page(DishPageQueryDTO categoryPageQueryDTO) {
        log.info("分页查询：{}", categoryPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    @PutMapping
    @ApiOperation("菜品修改")
    public Result updateDish(@RequestBody DishDTO dishDTO) {
        log.info("菜品修改：{}", dishDTO);
        dishService.update(dishDTO);
        return Result.success();
    }

    @GetMapping("{id}")
    @ApiOperation("根据id查询菜品")
    public Result<DishVO> getDishById(@PathVariable Long id) {
        log.info("根据id查询菜品：{}", id);
        DishVO dishVO = dishService.getDishById(id);
        return Result.success(dishVO);
    }

    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    public Result<List<Dish>> getDishByCategoryId(Long categoryId) {
        log.info("根据分类id查询菜品：{}", categoryId);
        List<Dish> dishList = dishService.getDishByCategoryId(categoryId);
        return Result.success(dishList);
    }


    @PostMapping
    @ApiOperation("新增菜品")
    public Result<?> addDish(@RequestBody DishDTO dishDTO) {
        log.info("新增菜品：{}", dishDTO);
        dishService.save(dishDTO);
        return Result.success();
    }

    /**
     * 启用、禁用分类
     *
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用菜品")
    public Result startOrStop(@PathVariable("status") Integer status, Long id) {
        log.info("启用禁用菜品：{} {}", status, id);
        dishService.startOrStop(status, id);
        return Result.success();
    }

    /**
     * 前端用的“1，2，3”，加入RequestParam，转为list
     *
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("删除菜品")
    public Result deleteDish(@RequestParam List<Long> ids) {
        log.info("删除菜品：{}", ids);
        dishService.deleteDish(ids);
        return Result.success();
    }

}
