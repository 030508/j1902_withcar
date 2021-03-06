package com.qf.j1902.mapper;

import com.qf.j1902.pojo.MemberToken;
import com.qf.j1902.pojo.MemberTokenExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MemberTokenMapper {
    int countByExample(MemberTokenExample example);

    int deleteByExample(MemberTokenExample example);

    int deleteByPrimaryKey(Long memberId);

    int insert(MemberToken record);

    int insertSelective(MemberToken record);

    List<MemberToken> selectByExample(MemberTokenExample example);

    MemberToken selectByPrimaryKey(Long memberId);

    int updateByExampleSelective(@Param("record") MemberToken record, @Param("example") MemberTokenExample example);

    int updateByExample(@Param("record") MemberToken record, @Param("example") MemberTokenExample example);

    int updateByPrimaryKeySelective(MemberToken record);

    int updateByPrimaryKey(MemberToken record);
}