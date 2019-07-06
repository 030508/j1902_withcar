package com.qf.j1902.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.j1902.mapper.AdminUserMapper;
import com.qf.j1902.pojo.AdminUser;
import com.qf.j1902.pojo.AdminUserExample;
import com.qf.j1902.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public List<AdminUser> findAllAdminUser() {
        AdminUserExample adminUserExample = new AdminUserExample();
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);
        return adminUsers;
    }

    @Override
    public List<AdminUser> findAllAdminUser(Integer page, Integer rows) {
        AdminUserExample adminUserExample = new AdminUserExample();
        PageHelper.startPage(page,rows);
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);
        return adminUsers;
    }

    @Override
    public AdminUser findOneByName(String username)throws Exception {
        AdminUserExample adminUserExample = new AdminUserExample();
        AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);
        AdminUser adminUser=(AdminUser) adminUsers.get(0);
        return adminUser;
    }

    @Override
    public void deleteOneByName(String username) {

    }

    @Override
    public void addByAdminUser(AdminUser adminUser) {

    }

    @Override
    public void updetaOneByName(String phone, String email, String username) {

    }


    //分页查询











}

