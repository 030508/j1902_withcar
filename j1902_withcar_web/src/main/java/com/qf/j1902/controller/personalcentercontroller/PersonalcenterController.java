package com.qf.j1902.controller.personalcentercontroller;

import com.qf.j1902.pojo.AdminUser;
import com.qf.j1902.service.AdminUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2019/7/10 0010.
 */
@Controller
@RequestMapping("/valid")
public class PersonalcenterController {
    @Autowired
    private AdminUserService adminUserService;
    //打开个人中心选项卡
    @RequestMapping("/personalcenter")
    public String personalcenter(HttpSession session, Model model) throws Exception {
        String adminUserName = (String) session.getAttribute("adminUserName");
        AdminUser adminUser = adminUserService.findOneByName(adminUserName);
        model.addAttribute("adminUser",adminUser);
        return "personalcenter";
    }
    //处理保存修改个人信息
    @RequestMapping(value = "/savePersonal",method = RequestMethod.POST)
    @ResponseBody
    public Integer savePersonal(AdminUser adminUser){
        String username = adminUser.getUsername();
        adminUserService.updetaOneByName(adminUser);
        return 1;
    }
    //处理修改个人密码
    @ResponseBody
    @RequestMapping(value = "/saveUpdatePassword",method = RequestMethod.POST)
    public Integer saveUpdatePassword(@RequestParam("oldpassword1") String oldpassword,@RequestParam("password1") String password, @RequestParam("querenpassword1") String querenpassword, HttpSession session) throws Exception {
        System.out.println("oldpassword---------"+oldpassword);
        System.out.println("password-----------"+password);
        System.out.println("querenpassword---------"+querenpassword);
        String username = (String)session.getAttribute("adminUserName");
        String oldpassword1 = new Md5Hash(oldpassword,null,1024).toString();
        AdminUser adminUser = adminUserService.findOneByName(username);
        String nowpassword = adminUser.getPassword();
        System.out.println("nowpassword-------------"+nowpassword);
        if (!oldpassword1.equals(nowpassword)){//旧密码不正确时
            return 2;
        }
        if (!password.equals(querenpassword)){//确认密码时
            return 3;
        }
        String string = new Md5Hash(password,null,1024).toString();

        adminUserService.updatePasswordByUserName(string,username);
        return 1;
    }
}
