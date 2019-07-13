package com.qf.j1902.service.impl;
import com.qf.j1902.mapper.AdminRoleMapper;
import com.qf.j1902.mapper.AdminRoleMenuMapper;
import com.qf.j1902.pojo.AdminRole;
import com.qf.j1902.pojo.AdminRoleExample;
import com.qf.j1902.pojo.AdminRoleMenuExample;
import com.qf.j1902.pojo.AdminRoleMenuKey;
import com.qf.j1902.service.AdminRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/7/12 0012.
 */
@Service
public class AdminRoleMenuServiceImpl implements AdminRoleMenuService {
    @Resource
    private AdminRoleMenuMapper adminRoleMenuMapper;
    @Resource
    private AdminRoleMapper adminRoleMapper;
    @Override
    public void insertAdminRoleMenu(AdminRoleMenuKey adminRoleMenuKey) {
        adminRoleMenuMapper.insert(adminRoleMenuKey);
    }

    @Override
    public List<AdminRoleMenuKey> selectAdminRoleMenuByRoleId(Integer roleid) {
        AdminRoleMenuExample adminRoleMenuExample = new AdminRoleMenuExample();
        adminRoleMenuExample.createCriteria().andRoleIdEqualTo(roleid);
        List<AdminRoleMenuKey> roleMenuKeys = adminRoleMenuMapper.selectByExample(adminRoleMenuExample);
        return roleMenuKeys;

    }

    @Override
    public void updateRoleMenuByRoleNameAndIds(String rolename, int[] ids) {
        AdminRoleExample adminRoleExample = new AdminRoleExample();
        adminRoleExample.createCriteria().andNameEqualTo(rolename);
        List<AdminRole> list = adminRoleMapper.selectByExample(adminRoleExample);
        AdminRole adminRole = list.get(0);
        Integer roleid = adminRole.getId();
        AdminRoleMenuExample adminRoleMenuExample = new AdminRoleMenuExample();
        if (true){
        adminRoleMenuExample.createCriteria().andRoleIdEqualTo(roleid);
        adminRoleMenuMapper.deleteByExample(adminRoleMenuExample);
        }
        for (Integer menuid:ids){
            AdminRoleMenuKey roleMenuKey = new AdminRoleMenuKey(roleid, menuid);
            adminRoleMenuMapper.insert(roleMenuKey);
        }
    }
}
