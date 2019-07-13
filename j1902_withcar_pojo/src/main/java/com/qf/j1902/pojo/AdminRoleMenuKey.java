package com.qf.j1902.pojo;

public class AdminRoleMenuKey {
    private Integer roleId;

    private Integer menuId;

    public AdminRoleMenuKey(Integer roleId, Integer menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }

    public AdminRoleMenuKey() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}