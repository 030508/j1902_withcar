package com.qf.j1902.service;

import com.qf.j1902.pojo.MemberProfile;
import com.qf.j1902.vo.MemberVo;
import com.qf.j1902.vo.PageRelstVo;

import javax.xml.crypto.Data;

public interface MemberProfileService {
    public PageRelstVo findAll(Byte gender, Integer pageNum, Integer title, String pageSize, Data smallTime, Data bigTime); //查询所有会员个人角色信息(分页查询)

    MemberProfile findOneById(Long  id);

    MemberVo findPersonalById(Long id);

    PageRelstVo selectAll(Integer pageNum, Integer pageSize, String title, Byte gender, String smallTime, String bigTime);//查询所有会员个人角色信息(分页查询)
}
