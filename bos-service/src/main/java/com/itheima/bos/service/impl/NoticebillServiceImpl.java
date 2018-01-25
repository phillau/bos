package com.itheima.bos.service.impl;

import com.itheima.bos.dao.IDecidedzoneDao;
import com.itheima.bos.dao.INoticebillDao;
import com.itheima.bos.dao.IWorkbillDao;
import com.itheima.bos.domain.*;
import com.itheima.bos.service.INoticebillService;
import com.itheima.bos.utils.BOSUtils;
import com.itheima.crm.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@Transactional
public class NoticebillServiceImpl implements INoticebillService {

    @Autowired
    private INoticebillDao noticebillDao;
    @Autowired
    private ICustomerService proxy;
    @Autowired
    private IDecidedzoneDao decidedzoneDao;
    @Autowired
    private IWorkbillDao workbillDao;

    /**
     * 保存一个业务通知单，并尝试自动分单
     */
    @Override
    public void save(Noticebill noticebill) {
        User user = BOSUtils.getLoginUser();
        noticebill.setUser(user);
        noticebillDao.save(noticebill);
        //获取用户的取件地址
        String pickaddress = noticebill.getPickaddress();
        //远程调用crm服务，根据取件地址查询定区id
        String decidedzoneId = proxy.findDecidedzoneIdByAddress(pickaddress);
        if(decidedzoneId!=null){
            //查询到了定区id，可以完成自动分单
            Decidedzone decidedzone = decidedzoneDao.findById(decidedzoneId);
            Staff staff = decidedzone.getStaff();
            noticebill.setStaff(staff);
            noticebill.setOrdertype(Noticebill.ORDERTYPE_AUTO);
            Workbill workbill = new Workbill();
            workbill.setAttachbilltimes(0);
            workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));
            workbill.setNoticebill(noticebill);
            workbill.setPickstate(Workbill.PICKSTATE_NO);
            workbill.setRemark(noticebill.getRemark());
            workbill.setStaff(staff);
            workbill.setType(Workbill.TYPE_1);
            workbillDao.save(workbill);
            //调用短信平台，发送短信
        }else{
            //没有查询到定区id，不能完成自动分单
            noticebill.setOrdertype(Noticebill.ORDERTYPE_MAN);
        }
    }
}
