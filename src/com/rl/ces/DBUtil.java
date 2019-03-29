package com.rl.ces;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	// 获取连接过程
	public static Connection getConnection() {
		// 加载文件流
		InputStream in = DBUtil.class.getClassLoader().getResourceAsStream(
				"db.properties");
		// 获取文件属性
		Properties pro = new Properties();
		Connection conn=null;
		// 加载文件
		try {
			pro.load(in);

			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String user = pro.getProperty("user");
			String password = pro.getProperty("password");
			// 启动驱动
			Class.forName(driver);
			// 获得链接
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 获得预处理处理命令窗口
	public static PreparedStatement getsStatement(String sql)  {
		Connection conn = DBUtil.getConnection();
		PreparedStatement state =null;
		try{
			state = conn.prepareStatement(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		// 创建预处理接口
	
		return state;
	}

	public static void closeUpdate(PreparedStatement state) {
		if (state != null) {
			// 关闭连接
			try {
				Connection conn = state.getConnection();
				state.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void closeQuery(ResultSet resut) {
		if (resut != null) {
			Statement state = null;
			try {
				state = resut.getStatement();

				Connection conn = state.getConnection();
				resut.close();
				state.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
