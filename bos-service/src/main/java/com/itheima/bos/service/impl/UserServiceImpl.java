package com.itheima.bos.service.impl;

import com.itheima.bos.domain.Role;
import com.itheima.bos.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.domain.User;
import com.itheima.bos.service.IUserService;
import com.itheima.bos.utils.MD5Utils;
@Service
@Transactional
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	/***
	 * 用户登录
	 */
	public User login(User user) {
		//使用MD5加密密码
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(),password);
	}
	/**
	 * 根据用户id修改密码
	 */
	public void editPassword(String id, String password) {
		//使用MD5加密密码
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword", password,id);
	}

	@Override
	public void save(User model, String[] roleIds) {
		String password = model.getPassword();
		String md5Password = MD5Utils.md5(password);
		model.setPassword(md5Password);
		if(roleIds!=null&&roleIds.length>0){
            for(int i=0;i<roleIds.length;i++){
                Role role = new Role(roleIds[i]);
                model.getRoles().add(role);
            }
        }
		userDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
	}
}
