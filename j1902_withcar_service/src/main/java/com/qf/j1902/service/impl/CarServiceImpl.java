package com.qf.j1902.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.j1902.mapper.CarMapper;
import com.qf.j1902.pojo.Car;
import com.qf.j1902.pojo.CarExample;
import com.qf.j1902.service.CarService;
import com.qf.j1902.vo.PageRelstVo;
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

    @Override
    public PageRelstVo findAll(Integer pageNum, Integer pageSize) {
        PageRelstVo pageRelstVo = new PageRelstVo();
        CarExample carExample = new CarExample();
         PageHelper.startPage(pageNum, pageSize);
        List<Car> cars = carMapper.selectByExample(carExample);
        PageInfo<Car> pageInfo = new PageInfo<>(cars);
        pageRelstVo.setTotal(pageInfo.getTotal());
        pageRelstVo.setRows(cars);
        return pageRelstVo;
    }
}
