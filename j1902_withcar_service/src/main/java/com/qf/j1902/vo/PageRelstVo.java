package com.qf.j1902.vo;


import java.util.List;

public class PageRelstVo {
    private  Long total; //返回总记录数
    List<?> rows; //返回当前页结果集




    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
