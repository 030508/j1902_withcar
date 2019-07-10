package com.qf.j1902.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.j1902.mapper.AdminUserMapper;
import com.qf.j1902.pojo.AdminUser;
import com.qf.j1902.pojo.AdminUserExample;
import com.qf.j1902.service.AdminUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public List<AdminUser> findAllAdminUser(Integer page, Integer rows, String name) {
        AdminUserExample adminUserExample = new AdminUserExample();
        if (!StringUtils.isEmpty(name)){
        AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
        criteria.andNameLike("%"+name+"%");
        }
        PageHelper.startPage(page,rows);
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);
        return adminUsers;
    }

    //分页查询
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

    @Override
    public void updetaOneByName(AdminUser adminUser) {
        String username = adminUser.getUsername();
        AdminUserExample adminUserExample = new AdminUserExample();
        adminUserExample.createCriteria().andUsernameEqualTo(username);
        adminUserMapper.updateByExampleSelective(adminUser,adminUserExample);
    }

    @Override
    public void insertAdminUser(AdminUser adminUser) {
        adminUserMapper.insert(adminUser);
    }

    @Override
    public void deleteAdminUser(int id) {
        adminUserMapper.deleteByPrimaryKey(id);
    }


}

