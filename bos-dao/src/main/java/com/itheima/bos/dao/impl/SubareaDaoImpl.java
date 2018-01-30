package com.itheima.bos.dao.impl;

import org.springframework.stereotype.Repository;

import com.itheima.bos.dao.ISubareaDao;
import com.itheima.bos.dao.base.impl.BaseDaoImpl;
import com.itheima.bos.domain.Subarea;

import java.util.List;

@Repository
public class SubareaDaoImpl extends BaseDaoImpl<Subarea> implements ISubareaDao {

    @Override
    public List<Object> findHchartsSubarea() {
        String hql = "SELECT r.province,count(*) FROM Subarea s LEFT OUTER JOIN s.region r GROUP BY r.province";
        List<Object> objects = (List<Object>) this.getHibernateTemplate().find(hql);
        return objects;
    }
}
