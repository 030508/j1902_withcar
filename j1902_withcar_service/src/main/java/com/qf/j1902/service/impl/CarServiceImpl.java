package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.CarMapper;
import com.qf.j1902.pojo.Car;
import com.qf.j1902.pojo.CarExample;
import com.qf.j1902.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Resource
    private CarMapper carMapper;

    @Override
    public List<Car> cars() {
        CarExample carExample = new CarExample();
        List<Car> cars = carMapper.selectByExample(carExample);
        return cars;
    }
}
