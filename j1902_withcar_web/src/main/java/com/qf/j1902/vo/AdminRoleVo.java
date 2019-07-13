package com.qf.j1902.vo;

import lombok.Data;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
@Data
public class AdminRoleVo {
    private String rolename;
    private Integer rolecount;

    public AdminRoleVo(String rolename, Integer rolecount) {
        this.rolename = rolename;
        this.rolecount = rolecount;
    }
}
