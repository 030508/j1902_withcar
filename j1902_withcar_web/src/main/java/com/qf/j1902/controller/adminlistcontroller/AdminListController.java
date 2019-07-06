package com.qf.j1902.controller.adminlistcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/7/6 0006.
 */
@Controller
@RequestMapping("/valid")
public class AdminListController {

    @RequestMapping("/adminlist")
    public String showAdminlist(){
        return "adminlist";
    }
}
