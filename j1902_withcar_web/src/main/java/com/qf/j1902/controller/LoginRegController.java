package com.qf.j1902.controller;

import com.qf.j1902.pojo.AdminMenuAuth;
import com.qf.j1902.pojo.AdminRole;
import com.qf.j1902.pojo.AdminUser;
import com.qf.j1902.service.AdminMenuService;
import com.qf.j1902.service.AdminRoleService;
import com.qf.j1902.service.AdminUserService;

import com.qf.j1902.shiro.utils.ImgCode;
import com.qf.j1902.shiro.utils.SessionKey;
import com.qf.j1902.vo.LoginVo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2019/6/28 0028.
 */
@Controller
public class LoginRegController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AdminMenuService adminMenuService;
    @Autowired
    private AdminRoleService adminRoleService;
    //显示登录视图
    @RequestMapping("/")
    public String loginView(){
        return "login";
    }
    //登录处理
    @RequestMapping(value = "deallogin",method = RequestMethod.POST)
    public String dealLogin(LoginVo loginVo, HttpSession session){
        if (loginVo.getVerrifyCode().isEmpty()){return "redirect:/";}
        String verify =(String) session.getAttribute(ImgCode.RANDOMCODEKEY);
        boolean b = StringUtils.startsWithIgnoreCase(verify,loginVo.getVerrifyCode());
        System.out.println(b);
        if (StringUtils.startsWithIgnoreCase(verify,loginVo.getVerrifyCode())){
            System.out.println(verify+"——————————"+loginVo.getVerrifyCode());
              try {
                        //从安全管理器获取主体对象
                 Subject subject = SecurityUtils.getSubject();
                 //构建令牌
                        UsernamePasswordToken token = new UsernamePasswordToken(loginVo.getLoginName(), loginVo.getPassword());
                        //登录
                        subject.login(token);
                        if (subject.isAuthenticated()) {
                            AdminUser adminUser = adminUserService.findOneByName(loginVo.getLoginName());
                            String name = adminUser.getName();
                            session.setAttribute("name",name);
                            Byte isSuper = adminUser.getIsSuper();
                            session.setAttribute("isSuper",isSuper);
                            session.setAttribute(SessionKey.ADMINUSERNAME,loginVo.getLoginName());
                            Set<AdminMenuAuth> menus = adminMenuService.findAdminMenusByUserName(loginVo.getLoginName());
                            HashSet<String> adminMemuNames = new HashSet<>();
                            for (AdminMenuAuth adminMenu:menus) {
                                adminMemuNames.add(adminMenu.getName());
                            }
                            session.setAttribute(SessionKey.ADMINUSERMENUS,adminMemuNames);
                            AdminRole adminRole = adminRoleService.findAdminRolesByUserName(loginVo.getLoginName());
                            String rolename = adminRole.getName();
                            session.setAttribute(SessionKey.ADMINROLE,rolename);
                            return "redirect:/valid/main";//如果登录成功返回的页面
                        }
                    }catch (AuthenticationException e){
                  System.out.println("用户名密码错误");
                  return "redirect:/";
                    } catch (Exception e) {
                  e.printStackTrace();
              }
        }else {
            System.out.println("验证码比对失败");
            return "redirect:/";//验证码无效
        }
        System.out.println("失败");
        return "redirect:/";//未登录成功返回的页面
    }
    @RequestMapping("/valid/main")
    public String showMain(){return "main";}



    //验证码换图
    @RequestMapping(value ="/getimage",method = RequestMethod.GET)
    public void getVerifyImg(HttpServletRequest request, HttpServletResponse response){
        ImgCode imgCode = new ImgCode();
        imgCode.getRandcode(request,response);
    }



    //    显示unauth视图
    @RequestMapping(value = "/unauth",method = RequestMethod.POST)
    public String showUnauthView(){
        return "unauth";
    }
    //注销用户
    @RequestMapping("/valid/logout")
    public String logOut(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();//退出操作（清除用户缓存数据）

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
