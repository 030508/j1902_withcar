package com.qf.j1902.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.j1902.mapper.CarMakeMapper;
import com.qf.j1902.mapper.CarModelMapper;
import com.qf.j1902.mapper.DictCountryMapper;
import com.qf.j1902.pojo.CarMake;
import com.qf.j1902.pojo.CarModel;
import com.qf.j1902.pojo.CarModelExample;
import com.qf.j1902.pojo.DictCountry;
import com.qf.j1902.service.CarSeriesService;
import com.qf.j1902.vo.PageRelstVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CarSeriesServiceImpl implements CarSeriesService {
    @Resource
    private CarModelMapper carModelMapper;
    @Resource
    private CarMakeMapper carMakeMapper;
    @Resource
    private DictCountryMapper dictCountryMapper;
    @Override
    public PageRelstVo getPageRelst(Integer pageNum, Integer pageSize, Integer countryId, Integer bodyForm, String name) {
        PageRelstVo pageRelstVo = new PageRelstVo();
        PageHelper.startPage(pageNum,pageSize);
        CarModelExample example = new CarModelExample();
        if (countryId != 0){
            example.createCriteria().andCountryIdEqualTo(countryId);
        }
        if (bodyForm != 0){
            example.createCriteria().andBodyFormEqualTo(bodyForm);
        }
        if ( !name.isEmpty()){
            example.createCriteria().andNameEqualTo(name);
        }
        List<CarModel> models = carModelMapper.selectByExample(example);
        PageInfo<CarModel> pageInfo = new PageInfo<>(models);
        pageRelstVo.setRows(models);
        pageRelstVo.setTotal(pageInfo.getTotal());
        return pageRelstVo;
    }

    @Override
    public List<CarModel> getCarModel() {
        CarModelExample example = new CarModelExample();
        List<CarModel> models = carModelMapper.selectByExample(example);
        return models;
    }

    @Override
    public Boolean addCarModel(CarModel carModel) {
        System.out.println(carModel.toString());
        System.out.println(carModel.getMakeId());
        CarMake carMake = null;
        try {
            carMake = getCarMake(carModel.getMakeId());
        } catch (Exception e) { }
        if (carMake != null){
            carModel.setBrandName(carMake.getBrandName());
            carModel.setMakeName(carMake.getName());
            carModel.setCountryId(carMake.getCountryId());
            DictCountry dictCountry = getDictCountry(carMake.getCountryId());
            if (dictCountry != null){
                carModel.setCountryClass(dictCountry.getId());
                carModel.setCountryName(dictCountry.getName());
                carModel.setCountryClassName(dictCountry.getEnName());
            }
        }
        Integer time = Integer.valueOf(String.valueOf(new Date().getTime()).substring(0, 10));
        carModel.setCreateTime(time);
        carModel.setUpdateTime(time);
        carModel.setSyncTime(time);

        int i = carModelMapper.insertSelective(carModel);
        return i==0?false:true;
    }

    @Override
    public Boolean delCarSeries(Integer id) {
        int i = carModelMapper.deleteByPrimaryKey(id);
        return i == 0 ? false:true;
    }

    public CarMake getCarMake( Integer makeId ){
        CarMake carMake = carMakeMapper.selectByPrimaryKey(makeId);
        return carMake;
    }

    public DictCountry getDictCountry(Integer id ){
        DictCountry dictCountry = dictCountryMapper.selectByPrimaryKey(id);
        return dictCountry;
    }
}
