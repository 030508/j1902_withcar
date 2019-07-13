package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.AdminRoleMapper;
import com.qf.j1902.mapper.AdminRoleMenuMapper;
import com.qf.j1902.mapper.AdminUserMapper;
import com.qf.j1902.mapper.AdminUserRoleMapper;
import com.qf.j1902.pojo.*;

import com.qf.j1902.service.AdminRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    @Resource
    private AdminUserMapper adminUserMapper;
    @Resource
    private AdminUserRoleMapper adminUserRoleMapper;
    @Resource
    private AdminRoleMapper adminRoleMapper ;
    @Resource
    private AdminRoleMenuMapper adminRoleMenuMapper;

    @Override
    public List<AdminRole> findAll() {
        AdminRoleExample adminRoleExample = new AdminRoleExample();
        List<AdminRole> adminRoles = adminRoleMapper.selectByExample(adminRoleExample);
        return adminRoles;
    }

    @Override
    public AdminRole findAdminRolesByUserName(String username) {
        AdminUserExample adminUserExample = new AdminUserExample();
        adminUserExample.createCriteria().andUsernameEqualTo(username);
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);
        AdminUser adminUser = adminUsers.get(0);
        Integer adminUserId = adminUser.getId();
        AdminUserRoleExample adminUserRoleExample = new AdminUserRoleExample();
        adminUserRoleExample.createCriteria().andUserIdEqualTo(adminUserId);
        List<AdminUserRole> adminUserRoles = adminUserRoleMapper.selectByExample(adminUserRoleExample);
        AdminUserRole adminUserRole = adminUserRoles.get(0);
        Integer roleId = adminUserRole.getRoleId();
        AdminRole adminRole = adminRoleMapper.selectByPrimaryKey(roleId);
        return adminRole;
    }

    @Override
    public void deleteAdminRoleById(Integer id) {

    }

    @Override
    public void addAdminRoleById(AdminRole adminRole) {

    }

    @Override
    public void updateDeletedById(Integer id, Integer deleted) {

    }

    @Override
    public Integer findRoleIdByRoleName(String rolename) {
        AdminRoleExample adminRoleExample = new AdminRoleExample();
        adminRoleExample.createCriteria().andNameEqualTo(rolename);
        List<AdminRole> list = adminRoleMapper.selectByExample(adminRoleExample);
        AdminRole adminRole = list.get(0);
        Integer id = adminRole.getId();
        return id;

    }

    @Override
    public void addRole(AdminRole adminRole) {
        adminRoleMapper.insert(adminRole);
    }

    @Override
    public void deleteRoleByRoleName(String rolename) {
        if(true){
            AdminRoleExample adminRoleExample = new AdminRoleExample();
            adminRoleExample.createCriteria().andNameEqualTo(rolename);
            List<AdminRole> list = adminRoleMapper.selectByExample(adminRoleExample);
            AdminRole adminRole = list.get(0);
            Integer roleid = adminRole.getId();
            AdminRoleMenuExample adminRoleMenuExample = new AdminRoleMenuExample();
            adminRoleMenuExample.createCriteria().andRoleIdEqualTo(roleid);
            adminRoleMenuMapper.deleteByExample(adminRoleMenuExample);
        }
        AdminRoleExample adminRoleExample = new AdminRoleExample();
        adminRoleExample.createCriteria().andNameEqualTo(rolename);
        adminRoleMapper.deleteByExample(adminRoleExample);
    }
}
