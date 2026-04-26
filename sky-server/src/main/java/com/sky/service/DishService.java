package com.sky.service;

import com.sky.dto.DishDTO;
import org.springframework.stereotype.Service;


public interface DishService {

    /**
     * 新增菜品和對應的口味數據
     * @param dishDTO
     */
    public void savewithFlavor(DishDTO dishDTO);
}
