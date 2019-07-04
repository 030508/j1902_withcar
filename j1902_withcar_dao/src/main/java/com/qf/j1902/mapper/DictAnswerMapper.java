package com.qf.j1902.mapper;

import com.qf.j1902.pojo.DictAnswer;
import com.qf.j1902.pojo.DictAnswerExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DictAnswerMapper {
    int countByExample(DictAnswerExample example);

    int deleteByExample(DictAnswerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictAnswer record);

    int insertSelective(DictAnswer record);

    List<DictAnswer> selectByExample(DictAnswerExample example);

    DictAnswer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictAnswer record, @Param("example") DictAnswerExample example);

    int updateByExample(@Param("record") DictAnswer record, @Param("example") DictAnswerExample example);

    int updateByPrimaryKeySelective(DictAnswer record);

    int updateByPrimaryKey(DictAnswer record);
}