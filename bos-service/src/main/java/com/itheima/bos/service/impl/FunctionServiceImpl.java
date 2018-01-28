package com.itheima.bos.service.impl;

import com.itheima.bos.dao.IFunctionDao;
import com.itheima.bos.domain.Function;
import com.itheima.bos.service.FunctionService;
import com.itheima.bos.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FunctionServiceImpl implements FunctionService {
    @Autowired
    private IFunctionDao fd;

    @Override
    public List<Function> findParentFuntions() {
        return fd.findAll();
    }

    @Override
    public void save(Function model) {
        fd.save(model);
    }

    @Override
    public void pageQuery(PageBean pageBean) {
        fd.pageQuery(pageBean);
    }

    @Override
    public List<Function> listMenuByUserId(String uid) {
        List<Function> list = fd.findMenuFunctionsByUserId(uid);
        return list;
    }
}
