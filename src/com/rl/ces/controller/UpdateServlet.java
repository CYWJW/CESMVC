package com.rl.ces.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.rl.ces.bean.CSUser;
import com.rl.ces.service.CSUserService;
import com.rl.ces.service.impl.CSUserServiceImpl;

public class UpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CSUserService service = new CSUserServiceImpl();
		// 定义上传格式
		List<String> lString = new ArrayList<String>();
		lString.add(".img");
		lString.add(".jpg");
		lString.add(".gif");
		lString.add(".png");
		String userId=null;
		String username = null;
		String password = null;
		String gender = null;
		String brithday = null;
		String address = null;
		String sal = null;
		String pic = null;
		// 把参数数据类型转换
		Integer genderInt = null;
		Date brithdayDate = null;
		BigDecimal salDecimal = null;
		// 创建特殊表单上传的对象和条件
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		try {
			List<FileItem> list = fileUpload.parseRequest(request);
			// 对接收到的文件进行循环
			for (FileItem fItem : list) {

				// 判断是否为普通文本
				if (fItem.isFormField()) {
					// 获取域名
					String nameId = fItem.getFieldName();
					// 获取文本内容
					String text = fItem.getString();
					// 转换格式
					text = new String(text.getBytes("ISO-8859-1"), "UTF-8");
					if ("userId".equals(nameId)) {
						userId = text;
					}
					else if ("username".equals(nameId)) {
						username = text;
					} else if ("password".equals(nameId)) {
						password = text;
					} else if ("gender".equals(nameId)) {
						gender = text;
					} else if ("brithday".equals(nameId)) {
						brithday = text;
					} else if ("address".equals(nameId)) {
						address = text;
					} else {
						sal = text;
					}
				}
				// 如果为特殊文本
				else {
					// 将后半部分路径保存到数据库 将文件保存到图片里
					// 获取文本名
					String picName = fItem.getName();
					String count = null;
					if (picName != null && !"".equals(picName)) {
						// 获取后缀名
						count = picName.substring(picName.lastIndexOf("."));
					}

					// 判断是否为图像
					if (lString.contains(count)) {
						// 存入对象
						pic = "/userImages/" + picName;
						// 获取保存图片路径
						String rpath = request.getServletContext().getRealPath(
								"/userImages/");
						// 保存图片
						File file = new File(rpath, picName);
						fItem.write(file);
					} else {
						response.getWriter().write("请传正确的,img,jpg,gif,png格式");
						return;
					}

				}

			}
			// 将获取到的表单内容存入对象
			if (gender != null) {
				genderInt = new Integer(gender);
			}
			if (brithday != null) {
				brithdayDate = new SimpleDateFormat("yyyy-mm-dd")
						.parse(brithday);
			}
			if (sal != null) {
				salDecimal = new BigDecimal(sal);
			}
			CSUser user = new CSUser();
			user.setUserId(new Integer(userId));
			user.setUsername(username);
			user.setGender(genderInt);
			user.setBrithday(brithdayDate);
			user.setSal(salDecimal);
			user.setAddress(address);
			user.setPassword(password);
			user.setPic(pic);
			// 保存
			service.updateUser(user);
			request.getRequestDispatcher("/QueryServlet").forward(request,
					response);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	} 

}
