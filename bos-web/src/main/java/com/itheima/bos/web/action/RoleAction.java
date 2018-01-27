package com.itheima.bos.web.action;

import com.itheima.bos.domain.Function;
import com.itheima.bos.domain.Role;
import com.itheima.bos.service.IRoleService;
import com.itheima.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
    private String functionIds;

    public void setFunctionIds(String functionIds) {
        this.functionIds = functionIds;
    }

    @Autowired
    private IRoleService irs;
    public String save(){
        irs.save(model,functionIds);
        return LIST;
    }

    public String pageQuery(){
        irs.pageQuery(pageBean);
        this.java2Json(pageBean,new String[]{"functions","users"});
        return NONE;
    }
}
