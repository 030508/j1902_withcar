package com.qf.j1902.service;

import com.qf.j1902.pojo.AdminRoleMenuKey;

import java.util.List;

/**
 * Created by Administrator on 2019/7/12 0012.
 */
public interface AdminRoleMenuService {
    void insertAdminRoleMenu(AdminRoleMenuKey adminRoleMenuKey);

    List<AdminRoleMenuKey> selectAdminRoleMenuByRoleId(Integer roleid);

    void updateRoleMenuByRoleNameAndIds(String rolename, int[] ids);
}
