package com.rl.ces.service;

import java.util.List;

import com.rl.ces.bean.CSUser;

public interface CSUserService {
	public void seveUser(CSUser user);

	public void updateUser(CSUser user);

	public CSUser getUserId(Integer userId);
	
	public void  deleteUser(Integer userId);
	
	public List<CSUser> listUser();
	
	public CSUser loginByNamePassword(String name,String password);

	
}
