package com.itheima.bos.web.action;

import com.itheima.bos.domain.Function;
import com.itheima.bos.service.FunctionService;
import com.itheima.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function>{
    @Autowired
    private FunctionService fs;
    public String listajax(){
        List<Function> list = fs.findParentFuntions();
        this.java2Json(list,new String[]{"parentFunction","roles","children"});
        return null;
    }

    public String add(){
        Function parentFunction = model.getParentFunction();
        if(parentFunction.getId()!=null && "".equals(parentFunction.getId())){
            model.setParentFunction(null);
        }
        fs.save(model);
        return LIST;
    }

    public String pageQuery(){
        String page = model.getPage();
        pageBean.setCurrentPage(Integer.parseInt(page));
        fs.pageQuery(pageBean);
        this.java2Json(pageBean,new String[]{"parentFunction","roles","children"});
        return null;
    }
}
