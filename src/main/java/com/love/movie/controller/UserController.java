package com.love.movie.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
		// 分页
		int page = 1;
		int pageSize = 4;

		// 若用户没有登录
		if (!UserUtil.isLogin(request)) {

			int uid = Integer.parseInt(request.getParameter("uid"));
			User others = userServiceId.getUserByUid(uid);
			// 若是没有找到指定用户
			if (others == null) {
				return new ModelAndView("error");
			}
			ModelAndView mv = new ModelAndView("userDisplay");
			mv.addObject("userInfo", others);
			
			// 看过的电影 想看的电影 参与的评论
			PageHelper.startPage(page, pageSize);
			List<Map<String, Object>> seenMovies = userServiceId.getSeenMovies(uid);
			PageInfo<Map<String, Object>> smPageInfo = new PageInfo<Map<String, Object>>(seenMovies);

			PageHelper.startPage(page, pageSize);
			List<Map<String, Object>> wSeenMovies = userServiceId.getWantSeeMovie(uid);
			PageInfo<Map<String, Object>> wmPageInfo = new PageInfo<Map<String, Object>>(wSeenMovies);

			PageHelper.startPage(page, pageSize);
			List<Map<String, Object>> userComments = userServiceId.getCommentByUserId(uid);
			PageInfo<Map<String, Object>> cPageInfo = new PageInfo<Map<String, Object>>(userComments);

			mv.addObject("smPageInfo", smPageInfo);
			mv.addObject("wmPageInfo", wmPageInfo);
			mv.addObject("cPageInfo", cPageInfo);
			
			mv.addObject("isLogin", false);
			return mv;
		}
		
		int userId = Integer.parseInt(request.getParameter("uid"));
		

		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("user"); // 获取登录用户信息
		
		//访问别人的页面
		if(userLogin.getUid() != userId) {
			
			int uid = Integer.parseInt(request.getParameter("uid"));
			User others = userServiceId.getUserByUid(uid);
			// 若是没有找到指定用户
			if (others == null) {
				return new ModelAndView("error");
			}
			ModelAndView mv = new ModelAndView("userDisplay");
			mv.addObject("userInfo", others);
			
			//登录的用户
			mv.addObject("userLogin", userLogin);
			mv.addObject("isLogin", true);
			
			// 看过的电影 想看的电影 参与的评论
			PageHelper.startPage(page, pageSize);
			List<Map<String, Object>> seenMovies = userServiceId.getSeenMovies(uid);
			PageInfo<Map<String, Object>> smPageInfo = new PageInfo<Map<String, Object>>(seenMovies);

			PageHelper.startPage(page, pageSize);
			List<Map<String, Object>> wSeenMovies = userServiceId.getWantSeeMovie(uid);
			PageInfo<Map<String, Object>> wmPageInfo = new PageInfo<Map<String, Object>>(wSeenMovies);

			PageHelper.startPage(page, pageSize);
			List<Map<String, Object>> userComments = userServiceId.getCommentByUserId(uid);
			PageInfo<Map<String, Object>> cPageInfo = new PageInfo<Map<String, Object>>(userComments);

			mv.addObject("smPageInfo", smPageInfo);
			mv.addObject("wmPageInfo", wmPageInfo);
			mv.addObject("cPageInfo", cPageInfo);
			return mv;
			
		}else {
			
			ModelAndView mv = new ModelAndView("userPage");
			// 个人资料
			mv.addObject("userInfo", userLogin);

			int uid = userLogin.getUid();

			// 看过的电影 想看的电影 参与的评论
			PageHelper.startPage(page, pageSize);
			List<Map<String, Object>> seenMovies = userServiceId.getSeenMovies(uid);
			PageInfo<Map<String, Object>> smPageInfo = new PageInfo<Map<String, Object>>(seenMovies);

			PageHelper.startPage(page, pageSize);
			List<Map<String, Object>> wSeenMovies = userServiceId.getWantSeeMovie(uid);
			PageInfo<Map<String, Object>> wmPageInfo = new PageInfo<Map<String, Object>>(wSeenMovies);

			PageHelper.startPage(page, pageSize);
			List<Map<String, Object>> userComments = userServiceId.getCommentByUserId(uid);
			PageInfo<Map<String, Object>> cPageInfo = new PageInfo<Map<String, Object>>(userComments);

			mv.addObject("smPageInfo", smPageInfo);
			mv.addObject("wmPageInfo", wmPageInfo);
			mv.addObject("cPageInfo", cPageInfo);

			System.out.println(smPageInfo);

			return mv;
		}
	}

	/**
	 * 异步请求看过的电影
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showSeenMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showSeenMovies(int page, HttpServletRequest request) {

		System.out.println("seen movies page===" + page);

		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("user"); // 获取登录用户信息
		int uid = userLogin.getUid();

		// 获取看过的电影
		int pageSize = 4;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> seenMovies = userServiceId.getSeenMovies(uid);
		PageInfo<Map<String, Object>> smPageInfo = new PageInfo<Map<String, Object>>(seenMovies);

		String jsonSMPageInfo = JSON.toJSONString(smPageInfo);
		System.out.println("jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

	/**
	 * 异步请求 返回想看的电影
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showWSeenMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showWSeenMovies(int page, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("user"); // 获取登录用户信息
		int uid = userLogin.getUid();

		// 获取想看的电影
		int pageSize = 4;
		System.out.println("ws page====" + page);

		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> wSeenMovies = userServiceId.getWantSeeMovie(uid);
		PageInfo<Map<String, Object>> wsPageInfo = new PageInfo<Map<String, Object>>(wSeenMovies);

		String jsonWSPageInfo = JSON.toJSONString(wsPageInfo);
		System.out.println("jsonWSPageInfo====" + jsonWSPageInfo);
		return jsonWSPageInfo;

	}

	/**
	 * 异步请求 参与的评论
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showReviews", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showReviews(int page, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("user"); // 获取登录用户信息
		int uid = userLogin.getUid();

		// 获取看过的电影
		int pageSize = 4;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> reviews = userServiceId.getCommentByUserId(uid);
		PageInfo<Map<String, Object>> reviewsPageInfo = new PageInfo<Map<String, Object>>(reviews);

//		String jsonreviewsPageInfo = JSON.toJSONString(reviewsPageInfo);
//		System.out.println("jsonreviewsPageInfo====" + jsonreviewsPageInfo);

		Map<String, Object> cInfo = new HashMap<String, Object>();
		cInfo.put("username", userLogin.getUsername());
		cInfo.put("cPageInfo", reviewsPageInfo);

		String jsonreviewsPageInfo = JSON.toJSONString(cInfo);

		return jsonreviewsPageInfo;

	}

	/**
	 * ------- 测试-------
	 * 
	 * 异步接收数据 同时返回json数据
	 * 
	 * @return
	 */
	@RequestMapping("/showPerson")
	@ResponseBody
	public String showPerson(String data) {
		System.out.println("data=====" + data);
		Map<String, Object> map = new HashMap<String, Object>();
		User user = new User();
		user.setUsername("sakurameme");
		map.put("user", user);

		String jsonStr = JSON.toJSONString(map);
		System.out.println("jsonStr=========" + jsonStr);
		return jsonStr;
	}

	@RequestMapping("show")
	public String show() {
		return "show";
	}

	/**
	 * 用户信息更新
	 *
	 * @return
	 * @throws Exception
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("updateUserInfo")
	public String updateUserInfo(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

//		//获取当前用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int uid = user.getUid();
//		
		System.out.println("user info ===== " + user);

		/*----------------------------上传文件处理------------------------------------*/

		// 解析和检查请求，是否为post方式，是否为二进制流方式
		Boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// 若含图片，则为其生成UUID并转存图片，然后，让用户的头像地址更新为图片存在的地址
		if (isMultipart) {
			System.out.println("上传图片文件");
			String avatarUUID = null;

			// 创建文件对象工厂
			FileItemFactory factory = new DiskFileItemFactory();
			// 创建文件上传处理器
			ServletFileUpload upload = new ServletFileUpload(factory);

			// 解析请求
			List<FileItem> items = upload.parseRequest(request);

			// 迭代出每一个FileItem，并判断是普通是表单控件还是文件上传控件
			for (FileItem item : items) {
				String fileName = item.getFieldName();

				// 普通的文件控件
				if (item.isFormField()) {
					String value = item.getString("utf-8");
					System.out.println(fileName + "->" + value);

					if (fileName.equals("email")) {
						user.setEmail(value);
					} else if (fileName.equals("brief")) {
						user.setBrief(value);
					} else if (fileName.equals("birth")) {
//						if (value.equals("") != false) {
						System.out.println("改生日");

						try {
							SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", java.util.Locale.US);
							Date ubirth = sdf.parse(value);
							System.out.println("ubirth == " + ubirth);
							user.setBirth(ubirth);
						} catch (Exception e) {
//								e.printStackTrace();
							System.out.println("没有修改生日");
						}
//						}
					} else if (fileName.equals("gender")) {
						int gender = Integer.parseInt(value);
						user.setGender(gender);
					}
				} else {
					// 上传文件的控件
					if (FilenameUtils.getExtension(item.getName()).equals("") == false) {
						// 为图片文件生成UUID
						avatarUUID = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(item.getName());
						System.out.println(fileName + "->" + FilenameUtils.getName(item.getName())); // 一个的标签的name，一个是文件的name

						// 生成文件的存储路径
						String path = request.getServletContext().getRealPath("img");
						System.out.println("path=========" + path);

						// 存图片
						item.write(new File(path, avatarUUID));
						user.setUimg("../img/" + avatarUUID);
					}
				}
			}
		} else {
			System.out.println("没有文件上传");
		}
		System.out.println("now user=========" + user);
//		//调用服务更新用户信息
		userServiceId.updateUserInfo(user);

		return "forward:userInfo?uid="+ uid;
	}

}
