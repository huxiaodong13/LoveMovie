package com.love.movie.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.movie.model.User;
import com.love.movie.service.UserService;
import com.love.movie.util.UserUtil;

@Controller
@RequestMapping("index")
public class UserController {
	
	@Autowired
	private UserService userServiceId;
	
	
	/**
	 * 用户个人信息主页
	 * 
	 * @return
	 */
	@RequestMapping("userInfo")
	public ModelAndView userInfo(HttpServletRequest request) {
		
		if(!UserUtil.isLogin(request)) {
			return new ModelAndView("error");
		}
		
		HttpSession session = request.getSession();		
		User userLogin = (User)session.getAttribute("user");	//获取登录用户信息
		
		
		ModelAndView mv = new ModelAndView("userPage");
		mv.addObject("userInfo", userLogin);
		System.out.println("我是用户主页~~ 我的信息不为空");
		
		
		System.out.println("userInfo*********" + userLogin);
		
		
		return mv;
	}
	
	/**
	 * 用户信息更新
	 *
	 * @return
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("updateUserInfo")
	public String updateUserInfo( HttpServletRequest request) throws Exception  {
		request.setCharacterEncoding("utf-8");
		
//		//获取当前用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
//		
		System.out.println("user info ===== " + user);
		
		/*----------------------------上传文件处理------------------------------------*/
		
		//解析和检查请求，是否为post方式，是否为二进制流方式
		Boolean isMultipart=ServletFileUpload.isMultipartContent(request);
		
		
		//若含图片，则为其生成UUID并转存图片，然后，让用户的头像地址更新为图片存在的地址
		if(isMultipart) {
			System.out.println("上传图片文件");
			String avatarUUID = null;
			
			//创建文件对象工厂
			FileItemFactory factory=new DiskFileItemFactory();
			//创建文件上传处理器
			ServletFileUpload upload=new ServletFileUpload(factory);
			
			//解析请求
			List<FileItem> items=upload.parseRequest(request);
			
			//迭代出每一个FileItem，并判断是普通是表单控件还是文件上传控件
			for(FileItem item : items) {
				String fileName = item.getFieldName();
				
				//普通的文件控件
				if(item.isFormField()) {
					String value = item.getString("utf-8");
					 System.out.println(fileName + "->" + value);
					 
					 if(fileName.equals("email")) {
						 user.setEmail(value);
					 }else if(fileName.equals("brief")) {
						user.setBrief(value);
					 }else if(fileName.equals("birth")){
						 if(value.equals("")) {
							 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							 try {
								 Date ubirth = format.parse(value);
								 System.out.println("ubirth == "+ubirth);
								 user.setBirth(ubirth);
							 } catch (Exception e) {
								 e.printStackTrace();	
							 }
						 }
					 }else if(fileName.equals("gender")) {
						 int  gender = Integer.parseInt(value);
						 user.setGender(gender);
					 }
				}else{
					//上传文件的控件
					//为图片文件生成UUID
					avatarUUID = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(item.getName());
					System.out.println(fileName + "->" + FilenameUtils.getName(item.getName())); //一个的标签的name，一个是文件的name
					
					//生成文件的存储路径
					String path = request.getServletContext().getRealPath("img");
					System.out.println("path=========" + path);
					
					//存图片
					item.write(new File(path, avatarUUID));
					user.setUimg("../img/"+avatarUUID);
				}
			}
		}else {
			System.out.println("没有文件上传");
		}
		System.out.println("now user=========" + user);
//		//调用服务更新用户信息
		userServiceId.updateUserInfo(user);
		
		return "forward:userInfo";
	}
	
	
	
	
}
