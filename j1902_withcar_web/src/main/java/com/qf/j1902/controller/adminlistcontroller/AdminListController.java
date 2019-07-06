package com.qf.j1902.controller.adminlistcontroller;

import com.qf.j1902.pojo.AdminUser;
import com.qf.j1902.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2019/7/6 0006.
 */
@Controller
@RequestMapping("/valid")
public class AdminListController {
    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("/adminlist")
    public String showAdminlist(){
        return "adminlist";
    }
    @RequestMapping(value = "/dealAdminList",method = RequestMethod.POST)
    @ResponseBody
    public Object dealAdminList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                @RequestParam(value = "rows",defaultValue = "10")Integer rows){

        List<AdminUser> adminUsers = adminUserService.findAllAdminUser(page,rows);
        return adminUsers;
    }
}
