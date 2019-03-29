package com.rl.ces.service.impl;

import java.util.List;

import com.rl.ces.bean.CSUser;
import com.rl.ces.dao.CSUserDao;
import com.rl.ces.dao.impl.CSUserDaoImpl;
import com.rl.ces.service.CSUserService;

public class CSUserServiceImpl implements CSUserService {
	private CSUserDao userDao=new CSUserDaoImpl();
	@Override
	public void seveUser(CSUser user) {
		userDao.seveUser(user);
	}

	@Override
	public void updateUser(CSUser user) {
		userDao.updateUser(user);
	}

	@Override
	public CSUser getUserId(Integer userId) {
		
		
		return userDao.getUserId(userId);
	}

	public void  deleteUser(Integer userId)
	{
		userDao.deleteUser(userId);
	}
	
	@Override
	public List<CSUser> listUser() {
		return userDao.listUser();
	}

	@Override
	public CSUser loginByNamePassword(String name,String password) {
		// TODO Auto-generated method stub
		return userDao.loginByNamePassword(name, password);
	}

}
