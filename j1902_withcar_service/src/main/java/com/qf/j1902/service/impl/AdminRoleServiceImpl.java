package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.AdminRoleMapper;
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

    @Override
    public List<AdminRole> findAll() {
        AdminRoleExample adminRoleExample = new AdminRoleExample();
        List<AdminRole> adminRoles = adminRoleMapper.selectByExample(adminRoleExample);
        return adminRoles;
    }

    @Override
    public AdminRole findAdminRolesByUserName(String username) {
        AdminUserExample adminUserExample = new AdminUserExample();
        AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);
        List<Integer> list = new ArrayList<>();
        for (AdminUser a: adminUsers) {
            Integer id = a.getId();
            list.add(id);
        }
        for (Integer integer:list) {
            AdminUserRoleExample adminUserRoleExample = new AdminUserRoleExample();
            AdminUserRoleExample.Criteria criteria1 = adminUserRoleExample.createCriteria();
            criteria1.andUserIdEqualTo(integer);
            List<AdminUserRole> adminUserRoles = adminUserRoleMapper.selectByExample(adminUserRoleExample);
            for (AdminUserRole adminUserRole: adminUserRoles) {
                Integer roleId = adminUserRole.getRoleId();
            }
        }

        return null;
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
}
