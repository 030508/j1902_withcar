package com.qf.j1902.service;

import com.qf.j1902.pojo.Car;
import com.qf.j1902.vo.PageRelstVo;

import java.util.List;

public interface CarService {
    List<Car> cars();

    PageRelstVo findAll(Integer pageNum, Integer pageSize);
}
