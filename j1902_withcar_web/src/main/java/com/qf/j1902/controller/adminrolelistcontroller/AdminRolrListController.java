package com.qf.j1902.controller.adminrolelistcontroller;

import com.qf.j1902.mapper.AdminRoleMapper;
import com.qf.j1902.pojo.AdminMenuAuth;
import com.qf.j1902.pojo.AdminRole;
import com.qf.j1902.pojo.AdminRoleMenuKey;
import com.qf.j1902.pojo.AdminUserRole;
import com.qf.j1902.service.AdminMenuService;
import com.qf.j1902.service.AdminRoleMenuService;
import com.qf.j1902.service.AdminRoleService;
import com.qf.j1902.service.AdminUserRoleService;
import com.qf.j1902.vo.AdminRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
@Controller
@RequestMapping("/valid")
public class AdminRolrListController {
    @Autowired
    private AdminRoleService adminRoleService;
    @Autowired
    private AdminUserRoleService adminUserRoleService;
    @Autowired 
    private AdminMenuService adminMenuService;
    @Autowired
    private AdminRoleMenuService adminRoleMenuService;
    //打开角色管理视图
    @RequestMapping("adminrolelist")
    public String adminrolelist(){
        return "adminrolelist";
    }
    //打开角色管理表格
    @ResponseBody
    @RequestMapping(value = "dealrolelist",method = RequestMethod.POST)
    public Object dealrolelist(){
        ArrayList<AdminRoleVo> adminRoleVos = new ArrayList<>();
        List<AdminRole> roles = adminRoleService.findAll();
        for (AdminRole adminrole:roles) {
            String adminroleName = adminrole.getName();
            Integer roleid = adminrole.getId();
            List<AdminUserRole> adminUserRoles = adminUserRoleService.getUserRolesByRoleId(roleid);
            Integer count = adminUserRoles.size();
            AdminRoleVo adminRoleVo = new AdminRoleVo(adminroleName, count);
            adminRoleVos.add(adminRoleVo);
        }
        return adminRoleVos;
    }
    //打开角色添加页面
    @RequestMapping("addAdminRole")
    public String addAdminRole(Model model){
        List<AdminMenuAuth> menuAuths = adminMenuService.findAll();
        //获得大去权限列表
        HashSet<String> actions = new HashSet<>();
        for (AdminMenuAuth adminMenuAuth:menuAuths) {
            actions.add(adminMenuAuth.getAction());
        }
        model.addAttribute("actions",actions);
        model.addAttribute("menuAuths",menuAuths);
        //根据大权限name获取小权限列表
        return "addAdminRole";
    }
    //处理添加角色并分配权限
    @RequestMapping(value = "dealaddRole",method = RequestMethod.POST)
    @ResponseBody
    public Integer dealaddRole(@RequestParam("rolename") String rolename, @RequestParam("menuid") int[] ids){
        AdminRole adminRole = new AdminRole(rolename);
        adminRoleService.addRole(adminRole);
        Integer roleId = adminRoleService.findRoleIdByRoleName(rolename);
        for (Integer menuid:ids) {
            AdminRoleMenuKey adminRoleMenuKey = new AdminRoleMenuKey(roleId, menuid);
            adminRoleMenuService.insertAdminRoleMenu(adminRoleMenuKey);
        }
        return 1;
    }
//打开编辑角色视图
    @RequestMapping("editAdminRole")
    public String editAdminRole(@RequestParam("rolename")String rolename,Model model){
        List<AdminMenuAuth> menuAuths = adminMenuService.findAll();
        //获得大去权限列表
        HashSet<String> actions = new HashSet<>();
        for (AdminMenuAuth adminMenuAuth:menuAuths) {
            actions.add(adminMenuAuth.getAction());
        }
        model.addAttribute("actions",actions);
        model.addAttribute("menuAuths",menuAuths);
        model.addAttribute("oldrolename",rolename);
        return "editAdminRole";
    }
    //刷新修改权限页面
    @RequestMapping(value = "/shuaxineditrole",method = RequestMethod.POST)
    @ResponseBody
    public List<Integer> xianshi(@RequestParam("rolename")String rolename, Model model){
        Integer roleid = adminRoleService.findRoleIdByRoleName(rolename);
        ArrayList<Integer> menuIds = new ArrayList<>();
        List<AdminRoleMenuKey> roleMenuKeys = adminRoleMenuService.selectAdminRoleMenuByRoleId(roleid);
        for (AdminRoleMenuKey adminRoleMenu:roleMenuKeys) {
            AdminMenuAuth adminMenuAuth= adminMenuService.findAdminMenuByMenuId(adminRoleMenu.getMenuId());
            menuIds.add(adminMenuAuth.getId().intValue());
        }
        model.addAttribute("oldrolename",rolename);
        model.addAttribute("menuNames",menuIds);
        return menuIds;
    }
    //处理角色权限修改
    @ResponseBody
    @RequestMapping(value = "dealeditrole",method = RequestMethod.POST)
    public Integer dealeditrole(@RequestParam("rolename") String rolename, @RequestParam("menuid") int[] ids){
        adminRoleMenuService.updateRoleMenuByRoleNameAndIds(rolename,ids);
        return 1;
    }
    //处理删除角色
    @ResponseBody
    @RequestMapping(value = "/deleteadminrole",method = RequestMethod.POST)
    public Integer deleteadminrole(@RequestParam("rolename")String rolename){
        adminRoleService.deleteRoleByRoleName(rolename);
        return 1;
    }

}
