package com.qf.j1902.vo;

import com.qf.j1902.pojo.*;

import java.util.List;


public class MemberVo {
   private MemberProfile member;  //会员个人信息
 /*  private List<MemberCar> memberCars;  //会员座驾
   private List<MemberFav> memberFavs; //会员收藏
   private List<MemberPoint> memberPoints; //会员积分*/
   private List<String> memberTags;//会员拥标签

   public MemberVo() {
   }

   public MemberVo(MemberProfile member, List<String> memberTags) {
      this.member = member;
      this.memberTags = memberTags;
   }

   public MemberProfile getMember() {
      return member;
   }

   public void setMember(MemberProfile member) {
      this.member = member;
   }

   public List<String> getMemberTags() {
      return memberTags;
   }

   public void setMemberTags(List<String> memberTags) {
      this.memberTags = memberTags;
   }
}
