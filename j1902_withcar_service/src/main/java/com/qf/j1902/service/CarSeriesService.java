package com.qf.j1902.service;

import com.qf.j1902.pojo.CarModel;
import com.qf.j1902.vo.PageRelstVo;

import java.util.List;

public interface CarSeriesService {
    PageRelstVo  getPageRelst(Integer pageNum, Integer pageSize, Integer countryId, Integer bodyForm, String name);

    List<CarModel> getCarModel();

    Boolean addCarModel(CarModel carModel);

    Boolean delCarSeries(Integer id);
}
