package com.qf.j1902.controller.ArticleController;

import com.qf.j1902.service.ArticleListService;
import com.qf.j1902.vo.EasyuiDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2019/7/10.
 */
@Controller
public class ArticleListController {
    @Autowired
    private ArticleListService articleListService;


    /*@RequestMapping(value = "/valid/{aa}",method = RequestMethod.GET)
    public String aa(@PathVariable("aa") String aa){
        return aa;
    }*/
    @RequestMapping(value = "/valid/article-list",method = RequestMethod.GET)
    public String list(){
        return "article-list";
    }

    @RequestMapping(value = "/valid/articlelist",method = RequestMethod.POST)
    @ResponseBody
    public Object showList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                           @RequestParam(value = "rows",defaultValue = "10")Integer pageSize,
                           @RequestParam(value = "title",defaultValue = "")String title){
        EasyuiDataGridResult all = articleListService.findAll(page, pageSize, title);
        return all;
    }
}
