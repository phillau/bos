package com.itheima.bos.realm;

import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class BOSRealm extends AuthorizingRealm {
    @Autowired
    private IUserDao userDao;
    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("realm中的认证方法执行了。。。。");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        //根据用户名查询数据库中的密码
        User user = userDao.findUserByUsername(username);
        if(user==null){
            //用户不存在
            return null;
        }
        //如果能查询到，再由框架比对数据库中查询到的密码和页面提交的密码是否一致
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        return info;
    }

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("staff-list");
        //TODO 后期修改为根据当前用户查询数据库，并获取实际对应的权限
        return info;
    }
}
