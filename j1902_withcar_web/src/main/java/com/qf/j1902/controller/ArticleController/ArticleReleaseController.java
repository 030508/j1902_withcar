package com.qf.j1902.controller.ArticleController;

import com.qf.j1902.pojo.Article;
import com.qf.j1902.service.ArticleListService;
import com.qf.j1902.vo.EasyuiDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */
@Controller
public class ArticleReleaseController {
    @Autowired
    private ArticleListService articleListService;
    @RequestMapping(value = "/valid/article-release",method = RequestMethod.GET)
    public String release(){
        return "article-release";
    }

    @RequestMapping(value = "/valid/articlerelease",method = RequestMethod.POST)
    @ResponseBody
    public Object showList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                           @RequestParam(value = "rows",defaultValue = "10")Integer pageSize,
                           @RequestParam(value = "title",defaultValue = "")String title){
        EasyuiDataGridResult all = articleListService.findAll(page, pageSize, title);
        return all;
    }
}

