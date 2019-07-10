package com.qf.j1902.controller.adminlistcontroller;

import com.qf.j1902.pojo.AdminUser;
import com.qf.j1902.service.AdminUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/6 0006.
 */
@Controller
@RequestMapping("/valid")
public class AdminListController {
    @Autowired
    private AdminUserService adminUserService;
    //打开添加管理员视图
    @RequestMapping(value = "/addAdmin",method = RequestMethod.GET)
    public String addAdmin(){
        return "addAdmin";
    }
    //处理删除管理员业务
    @ResponseBody
    @RequestMapping(value = "/deleteadmin",method = RequestMethod.POST)
    public Integer deleteadmin(@RequestParam("id") int id){
        adminUserService.deleteAdminUser(id);
        return 1;
    }
    //处理添加管理员业务
    @ResponseBody
    @RequestMapping(value = "/dealaddAdmin",method = RequestMethod.POST)
    public Integer addAdmin(AdminUser adminUser, HttpSession session){
        String oldpassword = adminUser.getPassword();
        Md5Hash newpassword = new Md5Hash(oldpassword, null, 1024);
        adminUser.setPassword(newpassword.toString());
        Integer integer = Integer.valueOf(String.valueOf(new Date().getTime()).substring(0, 10));
        adminUser.setCreateTime(integer);
        String name = (String) session.getAttribute("name");
        adminUser.setConsumer(name);
        byte s=(byte)1;
        adminUser.setStatus(s);
        adminUserService.insertAdminUser(adminUser);

        return 1;
    }
    //打开修改管理员信息视图
    @RequestMapping(value = "/editAdminList",method = RequestMethod.GET)
    public String editList(@RequestParam("username")String username, Model model) throws Exception {
        AdminUser adminUser = adminUserService.findOneByName(username);
        model.addAttribute("username",username);
        Byte isSuper = adminUser.getIsSuper();
        model.addAttribute("isSuper",isSuper);
        String name = adminUser.getName();
        model.addAttribute("name",name);
        String dept = adminUser.getDept();
        model.addAttribute("dept",dept);
        String email = adminUser.getEmail();
        model.addAttribute("email",email);
        String phone = adminUser.getPhone();
        model.addAttribute("phone",phone);
        String remark = adminUser.getRemark();
        model.addAttribute("remark",remark);

        return "editAdminList";
    }
    //处理编辑管理员信息
    @RequestMapping(value = "/saveAdmin",method = RequestMethod.POST)
    @ResponseBody
    public Integer saveAdmin(AdminUser adminUser){
        adminUserService.updetaOneByName(adminUser);
        return 1;
    }
    //显示管理员列表视图
    @RequestMapping("/adminlist")
    public String showAdminlist(){
        return "adminlist";
    }
    //显示分页视图
    @RequestMapping(value = "/dealAdminList",method = RequestMethod.POST)
    @ResponseBody
    public Object dealAdminList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                @RequestParam(value = "rows",defaultValue = "10")Integer rows,
                                @RequestParam(value = "name",defaultValue = "")String name){

        List<AdminUser> adminUsers = adminUserService.findAllAdminUser(page,rows,name);
        return adminUsers;
    }
}
