package com.itheima.bos.service;

import com.itheima.bos.domain.User;
import com.itheima.bos.utils.PageBean;

public interface IUserService {

	public User login(User model);

	public void editPassword(String id, String password);

    void save(User model, String[] roleIds);

	void pageQuery(PageBean pageBean);
}
