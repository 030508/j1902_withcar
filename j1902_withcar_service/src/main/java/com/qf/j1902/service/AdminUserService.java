package com.qf.j1902.service;


import com.qf.j1902.pojo.AdminUser;


import java.util.List;

public interface AdminUserService {

   //通过用户名查询
   AdminUser findOneByName(String username) throws Exception;


   //通过用户名进行删除
   void deleteOneByName(String username);

   //添加新管理员用户
   void addByAdminUser(AdminUser adminUser);

   //修改管理员信息
   void updetaOneByName(String phone, String email, String username);
}
