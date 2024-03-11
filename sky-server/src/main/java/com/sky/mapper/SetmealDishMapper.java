package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据ids批量删除菜品
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 根据菜品id查询对应的套餐
     * @param dishIds
     * @return
     */
      List<Long> getSetmealIdsByDishIds(List<Long> dishIds);


    /**
     * 批量插入菜品
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐id查询对应的菜品
     * @param setmealId
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id=#{setmealId}")
    List<SetmealDish> getSetmealIdsByDishId(Long setmealId);

    /**
     * 根据套餐id删除菜品
     * @param id
     */
    @Delete("delete from setmeal_dish where setmeal_id=#{id}")
    void deleteById(Long id);
}
