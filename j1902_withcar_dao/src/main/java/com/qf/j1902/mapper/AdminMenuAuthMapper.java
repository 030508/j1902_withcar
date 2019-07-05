package com.qf.j1902.mapper;

import com.qf.j1902.pojo.AdminMenuAuth;
import com.qf.j1902.pojo.AdminMenuAuthExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AdminMenuAuthMapper {
    int countByExample(AdminMenuAuthExample example);

    int deleteByExample(AdminMenuAuthExample example);

    int deleteByPrimaryKey(Short id);

    int insert(AdminMenuAuth record);

    int insertSelective(AdminMenuAuth record);

    List<AdminMenuAuth> selectByExample(AdminMenuAuthExample example);

    AdminMenuAuth selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") AdminMenuAuth record, @Param("example") AdminMenuAuthExample example);

    int updateByExample(@Param("record") AdminMenuAuth record, @Param("example") AdminMenuAuthExample example);

    int updateByPrimaryKeySelective(AdminMenuAuth record);

    int updateByPrimaryKey(AdminMenuAuth record);
    List<AdminMenuAuth> findAdminMenusByUserName(String username);//查询用户所拥有的权限
}