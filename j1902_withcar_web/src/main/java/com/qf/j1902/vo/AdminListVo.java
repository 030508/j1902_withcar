package com.qf.j1902.vo;

import lombok.Data;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
@Data
public class AdminListVo {
    private Integer id;
    private String name;
    private String username;
    private String rolename;

    public AdminListVo(Integer id, String name, String username, String rolename) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.rolename = rolename;
    }
}
