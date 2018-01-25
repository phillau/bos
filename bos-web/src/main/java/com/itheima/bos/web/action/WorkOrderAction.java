package com.itheima.bos.web.action;

import com.itheima.bos.domain.Workordermanage;
import com.itheima.bos.service.IWorkOrderService;
import com.itheima.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class WorkOrderAction extends BaseAction<Workordermanage>{

    @Autowired
    private IWorkOrderService workOrderService;

    public String add(){
        workOrderService.save(model);

        return NONE;
    }
}
