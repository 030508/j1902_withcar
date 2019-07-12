package com.qf.j1902.controller.memberController;

import com.qf.j1902.pojo.MemberProfile;
import com.qf.j1902.pojo.MemberTagExample;
import com.qf.j1902.service.MemberProfileService;
import com.qf.j1902.vo.MemberVo;
import com.qf.j1902.vo.PageRelstVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Controller
public class MemberController {
    @Autowired
    private MemberProfileService memberProfileService;

    @RequestMapping("/{page}")
    public String showpage(@PathVariable("page") String page){
        return page;
    }

   @RequestMapping(value = "/members/list",method = RequestMethod.POST)
    @ResponseBody
    public Object memberList(@RequestParam(value = "page",defaultValue = "1")Integer pageNum, @RequestParam(value = "rows",defaultValue = "10")Integer pageSize,
                             @RequestParam(value = "title",defaultValue = "")String title, @RequestParam(value = "gender",defaultValue = "-1")Byte gender,
                             @RequestParam(value = "smallTime",defaultValue = "") String smallTime, @RequestParam(value = "bigTime",defaultValue = "") String bigTime){
        PageRelstVo pageAll = memberProfileService.selectAll(pageNum,pageSize,title,gender,smallTime,bigTime);
        return pageAll;
    }


    @RequestMapping(value = "/members/details",method = RequestMethod.GET)
    public String personal(@RequestParam("pid")Long id, Model model){
        MemberVo memberVo =memberProfileService.findPersonalById(id);
        model.addAttribute("memberVo",memberVo);
        System.out.println(memberVo);
        return "details";
    }

}
