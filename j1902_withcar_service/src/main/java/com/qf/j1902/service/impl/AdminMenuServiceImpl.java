package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.AdminMenuAuthMapper;
import com.qf.j1902.pojo.AdminMenuAuth;
import com.qf.j1902.pojo.AdminMenuAuthExample;
import com.qf.j1902.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class AdminMenuServiceImpl implements AdminMenuService {
    @Resource
    private AdminMenuAuthMapper adminMenuMapper;


    @Override
    public List<AdminMenuAuth> findAll() {
        AdminMenuAuthExample authExample = new AdminMenuAuthExample();
        List<AdminMenuAuth> menuAuths = adminMenuMapper.selectByExample(authExample);
        return menuAuths;
    }

    @Override
    public Set<AdminMenuAuth> findAdminMenusByUserName(String username) {
        AdminMenuAuthExample adminMenuAuthExample = new AdminMenuAuthExample();
        AdminMenuAuthExample.Criteria criteria = adminMenuAuthExample.createCriteria();
        criteria.andNameEqualTo(username);
        List<AdminMenuAuth> adminMenuAuths = adminMenuMapper.selectByExample(adminMenuAuthExample);
        HashSet<AdminMenuAuth> adminMenus = new HashSet<>();
        for (AdminMenuAuth a:adminMenuAuths) {
            adminMenus.add(a);
        }
        return adminMenus;
    }

    @Override
    public void addAdminMenu(AdminMenuAuth adminMenu) {
        adminMenuMapper.insert(adminMenu);

    }

    @Override
    public void updateStatusById(Byte status, Short id) {
        AdminMenuAuthExample authExample = new AdminMenuAuthExample();
        AdminMenuAuthExample.Criteria criteria = authExample.createCriteria();
        criteria.andIdEqualTo(id);
        AdminMenuAuth menuAuth = new AdminMenuAuth();
        menuAuth.setStatus(status);
        adminMenuMapper.updateByExampleSelective(menuAuth,authExample);

//        adminMenuMapper.updateStatusById(status,id);
    }
}
