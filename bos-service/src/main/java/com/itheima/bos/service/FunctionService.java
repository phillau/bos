package com.itheima.bos.service;

import com.itheima.bos.domain.Function;
import com.itheima.bos.utils.PageBean;

import java.util.List;

public interface FunctionService {
    List<Function> findParentFuntions();

    void save(Function model);

    void pageQuery(PageBean pageBean);
}
