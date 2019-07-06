package com.qf.j1902.service;


import com.qf.j1902.pojo.AdminRole;

import java.util.List;

public interface AdminRoleService {
    List<AdminRole> findAll();  //查询所有角色
    AdminRole findAdminRolesByUserName(String username); //查询单个管理员拥有的角色

    void  deleteAdminRoleById(Integer id);  //根据id删除角色
    void  addAdminRoleById(AdminRole adminRole);  //添加角色信息
    void  updateDeletedById(Integer id, Integer deleted); //根据id修改状态（是否有效）
}
