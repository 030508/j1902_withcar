package com.qf.j1902.vo;

import lombok.Data;

import java.util.List;

/**
 * 封装datagrid组件需要的数据定义
 * Created by jeffrey on 2019/7/3.
 */
@Data
public class EasyuiDataGridResult {
    private long  total;//总记录数
    private List<?> rows;//返回当前页结果集

}
