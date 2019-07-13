package com.qf.j1902.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.j1902.mapper.ArticleMapper;
import com.qf.j1902.pojo.Article;
import com.qf.j1902.pojo.ArticleExample;
import com.qf.j1902.service.ArticleListService;
import com.qf.j1902.vo.EasyuiDataGridResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */
@Service
public class ArticleListServiceImpl implements ArticleListService {

    @Resource
    private ArticleMapper articleMapper;


    public List<Article> findAll() {
        ArticleExample example = new ArticleExample();
        List<Article> articles = articleMapper.selectByExample(example);
        return articles;
    }

    @Override
    public EasyuiDataGridResult findAll(Integer page, Integer pageSize) {
        EasyuiDataGridResult dataGridResult = new EasyuiDataGridResult();
        ArticleExample articleExample = new ArticleExample();
        PageHelper.startPage(page,pageSize);
        List<Article> articles = articleMapper.selectByExample(articleExample);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        dataGridResult.setRows(articles);
        long total = pageInfo.getTotal();
        dataGridResult.setTotal(total);
        return dataGridResult;
    }

    @Override
    public EasyuiDataGridResult findAll(Integer page, Integer pageSize, String title) {
        EasyuiDataGridResult dataGridResult = new EasyuiDataGridResult();
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        if (!title.isEmpty()){
            criteria.andAuthorLike("%" + title + "%");
        }


        PageHelper.startPage(page,pageSize);
        List<Article> articles = articleMapper.selectByExample(example);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        dataGridResult.setRows(articles);
        long total = pageInfo.getTotal();
        dataGridResult.setTotal(total);
        return dataGridResult;
    }
}
