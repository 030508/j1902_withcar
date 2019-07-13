package com.qf.j1902.service;

import com.qf.j1902.pojo.AdminUserRole;

import java.util.List;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
public interface AdminUserRoleService {
    void updateByUserId(AdminUserRole adminUserRole);

    void addAdminUserRole(AdminUserRole adminUserRole);

    List<AdminUserRole> getUserRolesByRoleId(Integer roleid);

    void deleteUserRoleByUserId(int id);
}
