package com.itheima.bos.service.impl;

import com.itheima.bos.dao.IRoleDao;
import com.itheima.bos.domain.Function;
import com.itheima.bos.domain.Role;
import com.itheima.bos.service.IRoleService;
import com.itheima.bos.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao ird;
    @Override
    public void save(Role model, String functionIds) {
        String[] split = functionIds.split(",");
        Set<Function> set = new HashSet<Function>();
        for(String id:split){
            Function function = new Function(id);
            model.getFunctions().add(function);
        }
        ird.save(model);
    }

    @Override
    public void pageQuery(PageBean pageBean) {
        ird.pageQuery(pageBean);
    }
}
