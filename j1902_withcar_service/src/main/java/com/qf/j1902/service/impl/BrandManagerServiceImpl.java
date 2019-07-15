package com.qf.j1902.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.j1902.mapper.CarBrandMapper;
import com.qf.j1902.mapper.CarMapper;
import com.qf.j1902.pojo.Car;
import com.qf.j1902.pojo.CarBrand;
import com.qf.j1902.pojo.CarBrandExample;
import com.qf.j1902.pojo.CarExample;
import com.qf.j1902.service.BrandManagerService;
import com.qf.j1902.vo.PageRelstVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BrandManagerServiceImpl implements BrandManagerService {
    @Resource
    private CarBrandMapper  carBrandMapper;
    @Resource
    private CarMapper carMapper;


    @Override
    public PageRelstVo selectAll(Integer pageNum, Integer pageSize, Integer countryId, String name) {

        PageRelstVo relstVo = new PageRelstVo(); //

        PageHelper.startPage(pageNum,pageSize);
        CarBrandExample example = new CarBrandExample();
        if (countryId != 0){
            example.createCriteria().andCountryIdEqualTo(countryId);
        }
        if (!name.isEmpty()){
            example.createCriteria().andNameLike("%"+name+"%");
        }
        List<CarBrand> carBrands = carBrandMapper.selectByExample(example);
        PageInfo<CarBrand> pageInfo = new PageInfo<>(carBrands);
        relstVo.setTotal(pageInfo.getTotal()); //设置总数
        relstVo.setRows(carBrands);
        return relstVo;
    }


    @Override
    public boolean addCarBrand(String brandName, String logoUrl) {
        CarBrand brand = new CarBrand();
        Integer time = Integer.valueOf(String.valueOf(new Date().getTime()).substring(0, 10));
        brand.setName(brandName);
        brand.setLogoUrl(logoUrl);
        brand.setSaleStatus((byte)2);
        brand.setIsEnabled((byte)2);
        brand.setIsRemoved((byte)2);
        brand.setCreateTime(time);
        brand.setUpdateTime(time);
        brand.setDoTime(time);
        brand.setDoTime(time);
        brand.setSyncTime(time);
        int i = carBrandMapper.insertSelective(brand);
        return i == 0?false:true;
    }

    @Override
    public boolean deleteCarBrand(Integer id) {
        int i = carBrandMapper.deleteByPrimaryKey(id);
        return i==0?false:true;
    }

    @Override
    public boolean updateCarBrandById(String name, String logoUrl, Integer id) {
        CarBrand brand = new CarBrand();
        brand.setName(name);
        brand.setLogoUrl(logoUrl);
        brand.setUpdateTime(Integer.valueOf(String.valueOf(new Date().getTime()).substring(0,10)));
        CarBrandExample example = new CarBrandExample();
        example.createCriteria().andIdEqualTo(id);
        int i = carBrandMapper.updateByExampleSelective(brand, example);
        return i == 0?false:true;
    }
}
