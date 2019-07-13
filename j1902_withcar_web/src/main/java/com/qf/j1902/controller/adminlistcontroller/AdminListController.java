package com.qf.j1902.controller.adminlistcontroller;

import com.qf.j1902.mapper.AdminUserRoleMapper;
import com.qf.j1902.pojo.AdminRole;
import com.qf.j1902.pojo.AdminUser;
import com.qf.j1902.pojo.AdminUserRole;
import com.qf.j1902.service.AdminRoleService;
import com.qf.j1902.service.AdminUserRoleService;
import com.qf.j1902.service.AdminUserService;
import com.qf.j1902.vo.AdminListVo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
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
    @Autowired
    private AdminRoleService adminRoleService;
    @Autowired
    private AdminUserRoleService adminUserRoleService;
    //打开添加管理员视图
    @RequestMapping(value = "/addAdmin",method = RequestMethod.GET)
    public String addAdmin(Model model){
        List<AdminRole> list = adminRoleService.findAll();
        model.addAttribute("adminRoles",list);
        return "addAdmin";
    }
    //处理删除管理员业务
    @ResponseBody
    @RequestMapping(value = "/deleteadmin",method = RequestMethod.POST)
    public Integer deleteadmin(@RequestParam("id") int id){
        adminUserService.deleteAdminUser(id);
        adminUserRoleService.deleteUserRoleByUserId(id);
        return 1;
    }
    //处理添加管理员业务
    @ResponseBody
    @RequestMapping(value = "/dealaddAdmin",method = RequestMethod.POST)
    public Integer addAdmin(AdminUser adminUser, HttpSession session,@RequestParam("roleid")Integer roleid) throws Exception {
        String oldpassword = adminUser.getPassword();
        Md5Hash newpassword = new Md5Hash(oldpassword, null, 1024);
        String nowpassword = newpassword.toString();
        session.setAttribute("nowpassword",nowpassword);
        adminUser.setPassword(nowpassword);
        Integer integer = Integer.valueOf(String.valueOf(new Date().getTime()).substring(0, 10));
        adminUser.setCreateTime(integer);
        String name = (String) session.getAttribute("name");
        adminUser.setConsumer(name);
        byte s=(byte)1;
        adminUser.setStatus(s);
        adminUserService.insertAdminUser(adminUser);
        String username = adminUser.getUsername();
        AdminUser oneByName = adminUserService.findOneByName(username);
        Integer userid = oneByName.getId();
        AdminUserRole adminUserRole = new AdminUserRole(userid, roleid);
        adminUserRoleService.addAdminUserRole(adminUserRole);

        return 1;
    }
    //打开修改管理员信息视图
    @RequestMapping(value = "/editAdminList",method = RequestMethod.GET)
    public String editList(@RequestParam("username")String username, Model model) throws Exception {
        List<AdminRole> lists = adminRoleService.findAll();
        model.addAttribute("adminRoles",lists);
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
    public Integer saveAdmin(AdminUser adminUser,@RequestParam("roleid")Integer roleid) throws Exception {
        String username = adminUser.getUsername();
        AdminUser oneByName = adminUserService.findOneByName(username);
        Integer userid = oneByName.getId();
        AdminUserRole adminUserRole = new AdminUserRole(userid, roleid);
        adminUserRoleService.updateByUserId(adminUserRole);
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
        List<AdminListVo> list = new ArrayList<>();
        for (AdminUser adminUser:adminUsers) {
            Integer id = adminUser.getId();
            String name1 = adminUser.getName();
            String username = adminUser.getUsername();
            AdminRole adminRole = adminRoleService.findAdminRolesByUserName(username);
            String rolename = adminRole.getName();
            AdminListVo adminListVo = new AdminListVo(id, name1, username, rolename);
            list.add(adminListVo);
        }
        return list;
    }
}
