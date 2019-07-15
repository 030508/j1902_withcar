package com.qf.j1902.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.j1902.mapper.*;
import com.qf.j1902.pojo.*;
import com.qf.j1902.service.MemberProfileService;
import com.qf.j1902.vo.MemberVo;
import com.qf.j1902.vo.PageRelstVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.List;

@Service
public class MemberProfileServiceIMpl implements MemberProfileService {
    @Resource
    private MemberProfileMapper memberProfileMapper;  //个人信息表
    @Resource
    private MemberTagMapper memberTagMapper;     //个人标签表
    @Resource
    private MemberCarMapper memberCarMapper;  //个人私有车辆表
    @Resource
    private MemberFavMapper memberFavMapper; //会员收藏表
    @Resource
    private MemberPointMapper memberPointMapper; //会员积分表

    @Override
    public PageRelstVo findAll(Byte gender, Integer pageNum, Integer title, String pageSize, Data smallTime, Data bigTime) {
        return null;
    }

    @Override
    public MemberProfile findOneById(Long id) {
        MemberProfile profile = memberProfileMapper.selectByPrimaryKey(id);
        List<String> memberTags = memberTagMapper.findTagNamesByMemberId(id);


        return profile;
    }

    @Override
    public MemberVo findPersonalById(Long id) {

        MemberProfile profile = memberProfileMapper.selectByPrimaryKey(id);
        List<String> memberTags = memberTagMapper.findTagNamesByMemberId(id);


        MemberFavExample favExample = new MemberFavExample();
        favExample.createCriteria().andMemberIdEqualTo(id);
        List<MemberFav> memberFavs = memberFavMapper.selectByExample(favExample);

        MemberCarExample carExample = new MemberCarExample();
        carExample.createCriteria().andMemberIdEqualTo(id);
        List<MemberCar> memberCars = memberCarMapper.selectByExample(carExample);


        MemberPointExample pointExample = new MemberPointExample();
        pointExample.createCriteria().andMemberIdEqualTo(id);
        List<MemberPoint> memberPoints = memberPointMapper.selectByExample(pointExample);
        MemberVo memberVo = new MemberVo(profile,memberTags);

        return memberVo;
    }

    public  void getMemberCar(Long id){
      /* */
       /* List<Car>  cars = memberCarMapper.selectMyCarByMemberId( id);*/
    }
    @Override
    public PageRelstVo selectAll(Integer pageNum, Integer pageSize, String title, Byte gender, String smallTime, String bigTime) {
        PageRelstVo relstVo = new PageRelstVo();  //用来存储总条数 和显示的内容(集合)
        PageHelper.startPage(pageNum, pageSize);   //添加分页功能
        MemberProfileExample example = new MemberProfileExample();
        if (gender != -1){
            example.createCriteria().andGenderEqualTo(gender);
        }
        if (!title.isEmpty()){
            example.createCriteria().andNameLike("%"+title+"%");
        }
        /*if (!smallTime.equals("")){
            Integer stime = Integer.valueOf(String.valueOf(smallTime).substring(0, 10));
            if (!smallTime.equals("")){
                Integer btime = Integer.valueOf(String.valueOf(bigTime).substring(0, 10));
                example.createCriteria().andRegisterTimeBetween(stime ,btime);
            }else {
                example.createCriteria().andRegisterTimeBetween(stime ,Integer.valueOf(String.valueOf(new Date().getTime()).substring(0, 10)));
            }
        }*/
        List<MemberProfile> profiles = memberProfileMapper.selectByExample(example);
        PageInfo<MemberProfile> pageInfo = new PageInfo<>(profiles);
        relstVo.setRows(profiles);  //设置当前页结果集
        relstVo.setTotal(pageInfo.getTotal());//设置总条数
        return relstVo;
    }
}
