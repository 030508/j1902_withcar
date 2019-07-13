package com.qf.j1902.service;

import com.qf.j1902.vo.PageRelstVo;

public interface BrandManagerService {

    PageRelstVo selectAll(Integer pageNum, Integer pageSize,Integer countryId,String name);

    boolean addCarBrand(String brandName, String logoUrl);

    boolean deleteCarBrand(Integer id);

    boolean updateCarBrandById(String name, String logoUrl, Integer id);
}
