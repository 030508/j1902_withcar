package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.AdminUserRoleMapper;
import com.qf.j1902.pojo.AdminUserRole;
import com.qf.j1902.pojo.AdminUserRoleExample;
import com.qf.j1902.service.AdminUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
@Service
public class AdminUserRoleServiceImpl implements AdminUserRoleService {
    @Resource
    private AdminUserRoleMapper adminUserRoleMapper;
    @Override
    public void updateByUserId(AdminUserRole adminUserRole) {
        Integer userId = adminUserRole.getUserId();
        AdminUserRoleExample adminUserRoleExample = new AdminUserRoleExample();
        adminUserRoleExample.createCriteria().andUserIdEqualTo(userId);
        adminUserRoleMapper.updateByExampleSelective(adminUserRole,adminUserRoleExample);

    }

    @Override
    public void addAdminUserRole(AdminUserRole adminUserRole) {
        adminUserRoleMapper.insert(adminUserRole);
    }

    @Override
    public List<AdminUserRole> getUserRolesByRoleId(Integer roleid) {
        AdminUserRoleExample adminUserRoleExample = new AdminUserRoleExample();
        adminUserRoleExample.createCriteria().andRoleIdEqualTo(roleid);
        List<AdminUserRole> adminUserRoles = adminUserRoleMapper.selectByExample(adminUserRoleExample);
        return adminUserRoles;
    }

    @Override
    public void deleteUserRoleByUserId(int id) {
        AdminUserRoleExample adminUserRoleExample = new AdminUserRoleExample();
        adminUserRoleExample.createCriteria().andUserIdEqualTo(id);
        adminUserRoleMapper.deleteByExample(adminUserRoleExample);
    }
}
