package com.rl.ces.dao.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.rl.ces.DBUtil;
import com.rl.ces.bean.CSUser;
import com.rl.ces.dao.CSUserDao;

public class CSUserDaoImpl implements CSUserDao {

	@Override
	public void seveUser(CSUser user) {
		String sql="insert into cs_user(user_id,username,password,gender,brithday,address,sal,pic) values(sequserid.nextval,?,?,?,?,?,?,?)";
		  //设置传入的值
		  PreparedStatement prate = null;
		  try{
			  prate=DBUtil.getsStatement(sql);
			  prate.setString(1,user.getUsername());
			  prate.setString(2,user.getPassword());
			  prate.setInt(3, user.getGender());
			  //sql.date的构造器是long型  用util.gettime()的方法可以获得 数据库用to_date("?","yyyy-mm-dd")
			  prate.setDate(4, new java.sql.Date(user.getBrithday().getTime()));
			  prate.setString(5, user.getAddress());
			  prate.setBigDecimal(6, user.getSal());
			  prate.setString(7, user.getPic());
			  prate.executeUpdate();
			 
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		 finally{
			 DBUtil.closeUpdate(prate);
			 
		 }
		

	}

	@Override
	public void updateUser(CSUser user) {
		String sql="update cs_user  set username=? , password=?,gender=?,brithday=?,address=?,sal=?,pic=? where user_id=?";
		  //设置传入的值
		  PreparedStatement prate = null;
		  try{
			  prate=	DBUtil.getsStatement(sql);
			  prate.setString(1,user.getUsername());
			  prate.setString(2,user.getPassword());
			  prate.setInt(3, user.getGender());
			  //sql.date的构造器是long型  用util.gettime()的方法可以获得 数据库用to_date("?","yyyy-mm-dd")
			  prate.setDate(4, new java.sql.Date(user.getBrithday().getTime()));
			  prate.setString(5, user.getAddress());
			  prate.setBigDecimal(6, user.getSal());
			  prate.setString(7, user.getPic());
			  prate.setInt(8, user.getUserId());
			  
			  prate.executeUpdate();
			 
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		 finally{
			 DBUtil.closeUpdate(prate);
			 
		 }
	}
	@Override
	public void  deleteUser(Integer userId)
	{
		  String sql="delete  cs_user where user_id=?";
		 PreparedStatement prate=null;
		  try {
			prate=DBUtil.getsStatement(sql);
			prate.setInt(1,userId);
			prate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  DBUtil.closeUpdate(prate);
	}

	@Override
	public CSUser getUserId(Integer userId) {
		String sql = "select * from cs_user where user_id=?";
		PreparedStatement state = null;
		ResultSet rst = null;
		CSUser user = new CSUser();
		try {
			state = DBUtil.getsStatement(sql);
			state.setInt(1, userId);
			rst = state.executeQuery();
			// 游标向下一行
			rst.next();
			// 获取表中数据
			String username = rst.getString("username");
			String password = rst.getString("password");
			Integer gender = rst.getInt("gender");
			Date brithday = rst.getDate("brithday");
			String address = rst.getString("address");
			BigDecimal sal = rst.getBigDecimal("sal");
			String pic = rst.getString("pic");
			// 设置为对象
			user.setAddress(address);
			user.setBrithday(brithday);
			user.setGender(gender);
			user.setPassword(password);
			user.setSal(sal);
			user.setUsername(username);
			user.setPic(pic);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeQuery(rst);
		}
		return user;
	}

	@Override
	public List<CSUser> listUser() {
		String sql="select * from cs_user";
		PreparedStatement  state=null;
		List<CSUser> list=new LinkedList<CSUser>();
		ResultSet rst=null;
		try {
			state=DBUtil.getsStatement(sql);
			rst=state.executeQuery();
			//获取表
			while(rst.next())
			{
				//获取表中数据
				Integer userId=rst.getInt("user_id");
				String username=rst.getString("username");
				String password=rst.getString("password");
				Integer gender=rst.getInt("gender");
				Date brithday=rst.getDate("brithday");
				String address=rst.getString("address");
				String pic=rst.getString("pic");
				BigDecimal sal=rst.getBigDecimal("sal");
				CSUser cu=new CSUser();
				cu.setAddress(address);
				cu.setBrithday(brithday);
				cu.setGender(gender);
				cu.setUserId(userId);
				cu.setPassword(password);
				cu.setSal(sal);
				cu.setUsername(username);
				cu.setPic(pic);
				list.add(cu);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			DBUtil.closeQuery(rst);
		}
		return list;
	}

	@Override
	public CSUser loginByNamePassword(String name, String password) {
		String sql="select * from cs_user where username=? and password=?";
		//获取查询窗口
		PreparedStatement state=DBUtil.getsStatement(sql);
		ResultSet rst=null;
		CSUser cu=null;
		try {
			state.setString(1, name);
			state.setString(2, password);
			rst=state.executeQuery();
			if(rst.next())
			{
				Integer userId=rst.getInt("user_id");
				Integer gender=rst.getInt("gender");
				Date brithday=rst.getDate("brithday");
				String address=rst.getString("address");
				String pic=rst.getString("pic");
				BigDecimal sal=rst.getBigDecimal("sal");
				cu=new CSUser();
				cu.setAddress(address);
				cu.setBrithday(brithday);
				cu.setGender(gender);
				cu.setUserId(userId);
				cu.setPassword(password);
				cu.setSal(sal);
				cu.setUsername(name);
				cu.setPic(pic);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cu;
	}
}
