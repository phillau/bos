package com.itheima.bos.service.impl;

import com.itheima.bos.dao.IWorkOrderDao;
import com.itheima.bos.domain.Workordermanage;
import com.itheima.bos.service.IWorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WorkOrderServiceImpl implements IWorkOrderService{
    @Autowired
    private IWorkOrderDao workOrderDao;

    @Override
    public void save(Workordermanage model) {
        workOrderDao.save(model);
    }
}
