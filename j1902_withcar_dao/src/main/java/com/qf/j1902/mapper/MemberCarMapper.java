package com.qf.j1902.mapper;

import com.qf.j1902.pojo.MemberCar;
import com.qf.j1902.pojo.MemberCarExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MemberCarMapper {
    int countByExample(MemberCarExample example);

    int deleteByExample(MemberCarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberCar record);

    int insertSelective(MemberCar record);

    List<MemberCar> selectByExample(MemberCarExample example);

    MemberCar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberCar record, @Param("example") MemberCarExample example);

    int updateByExample(@Param("record") MemberCar record, @Param("example") MemberCarExample example);

    int updateByPrimaryKeySelective(MemberCar record);

    int updateByPrimaryKey(MemberCar record);
}