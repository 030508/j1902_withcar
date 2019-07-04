package com.qf.j1902.mapper;

import com.qf.j1902.pojo.CarModelImage;
import com.qf.j1902.pojo.CarModelImageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CarModelImageMapper {
    int countByExample(CarModelImageExample example);

    int deleteByExample(CarModelImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarModelImage record);

    int insertSelective(CarModelImage record);

    List<CarModelImage> selectByExample(CarModelImageExample example);

    CarModelImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarModelImage record, @Param("example") CarModelImageExample example);

    int updateByExample(@Param("record") CarModelImage record, @Param("example") CarModelImageExample example);

    int updateByPrimaryKeySelective(CarModelImage record);

    int updateByPrimaryKey(CarModelImage record);
}