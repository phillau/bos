package com.itheima.bos.web.action;

import com.itheima.bos.domain.Noticebill;
import com.itheima.bos.service.INoticebillService;
import com.itheima.bos.web.action.base.BaseAction;
import com.itheima.crm.Customer;
import com.itheima.crm.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill>{
    //注入crm代理对象
    @Autowired
    private ICustomerService proxy;

    @Autowired
    private INoticebillService noticebillService;

    public String findCustomerByTelephone(){
        Customer customer = proxy.findCustomerByTelephone(model.getTelephone());
        this.java2Json(customer,new String[]{});
        return NONE;
    }

    public String add(){
        noticebillService.save(model);
        return "list";
    }
}
