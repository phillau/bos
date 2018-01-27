package com.itheima.bos.service;

import com.itheima.bos.domain.Role;
import com.itheima.bos.utils.PageBean;

import java.util.List;

public interface IRoleService {
    void save(Role model, String functionIds);

    void pageQuery(PageBean pageBean);

    List<Role> findRoles();
}
