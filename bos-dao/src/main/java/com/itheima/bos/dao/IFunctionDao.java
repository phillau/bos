package com.itheima.bos.dao;

import com.itheima.bos.dao.base.IBaseDao;
import com.itheima.bos.domain.Function;

import java.util.List;

public interface IFunctionDao extends IBaseDao<Function>{
    List<Function> findFunctionsByUserId(String id);

    List<Function> findMenuFunctionsByUserId(String uid);
}
