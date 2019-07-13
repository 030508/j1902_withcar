package com.qf.j1902.service;

import com.qf.j1902.pojo.Article;
import com.qf.j1902.vo.EasyuiDataGridResult;

import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */
public interface ArticleListService {
    public List<Article> findAll();
    public EasyuiDataGridResult findAll(Integer page, Integer pageSize);
    public EasyuiDataGridResult findAll(Integer page,Integer pageSize,String title);
}
