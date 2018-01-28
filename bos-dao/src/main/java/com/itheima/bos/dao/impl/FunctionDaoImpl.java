package com.itheima.bos.dao.impl;

import com.itheima.bos.dao.IFunctionDao;
import com.itheima.bos.dao.base.impl.BaseDaoImpl;
import com.itheima.bos.domain.Function;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao {
    public List<Function> findAll() {
        String hql = "FROM Function f WHERE f.parentFunction IS NULL";
        List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
        return list;
    }

    //根据用户id查询对应的权限
    @Override
    public List<Function> findFunctionsByUserId(String uid) {
        String hql = "SELECT DISTINCT f FROM Function f INNER JOIN f.roles r" +
                " INNER JOIN r.users u WHERE u.id = ?";
        List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql,uid);
        return list;
    }

    @Override
    public List<Function> findMenuFunctionsByUserId(String uid) {
        String hql = "SELECT DISTINCT f FROM Function f INNER JOIN f.roles r" +
                " INNER JOIN r.users u WHERE u.id = ? AND f.generatemenu = '1' ORDER BY f.zindex";
        List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql,uid);
        return list;
    }
}
