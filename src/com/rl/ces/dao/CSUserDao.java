package com.rl.ces.dao;

import java.util.List;

import com.rl.ces.bean.CSUser;

public interface CSUserDao {
	//对数据库进行操作的类  增删改查
	//增加
	public void seveUser(CSUser user);
	//改动
	public void updateUser(CSUser user);
	//删除
	public void deleteUser(Integer userId);
	//查询
	public CSUser getUserId(Integer userId);
	//用户登录
	public CSUser loginByNamePassword(String name,String password);
	//全面查询
	public List<CSUser> listUser();
}
