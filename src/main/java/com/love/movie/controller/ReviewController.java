package com.love.movie.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.love.movie.model.Movie;
import com.love.movie.model.User;
import com.love.movie.service.CommentService;
import com.love.movie.service.MovieService;
import com.love.movie.service.UserService;
import com.love.movie.util.UserUtil;

/**
 * 影评Controller
 * 
 * 
 * @author sakura
 *
 */
@Controller
@RequestMapping("review")
public class ReviewController {
	@Autowired
	private CommentService commentService;

	@Autowired
	private UserService userService;

	@Autowired
	private MovieService movieService;

	/**
	 * 影评页 默认返回最受欢迎的评论
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("Review")
	public ModelAndView topReview(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("review");

		// 获取最受欢迎的评论
		int page = 1;
		int pageSize = 6;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> comments = commentService.getPopularComment();
		PageInfo<Map<String, Object>> commentPageInfo = new PageInfo<Map<String, Object>>(comments);

		// 找出每个评论的回复数
		List<Integer> commentReplyCount = new ArrayList<Integer>();
		for (Map<String, Object> item : comments) {
			int rcount = commentService.getCommentReplyCountByCid((int) item.get("cid"));
			System.out.println("rcount====" + rcount);
			commentReplyCount.add(rcount);
		}
		// 评论回复数
		mv.addObject("commentReplyCount", commentReplyCount);

		mv.addObject("commentPageInfo", commentPageInfo);

		if (UserUtil.isLogin(request)) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			mv.addObject("isLogin", true);
			mv.addObject("user", user);
		} else {
			mv.addObject("isLogin", false);
		}
		return mv;
	}

	/**
	 * 异步请求 最受欢迎评论
	 * 
	 * @return
	 */
	@RequestMapping(value = "showPopuplarComment", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showPopuplarComment(int page) {

		// 获取最受欢迎的评论
		int pageSize = 6;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> comments = commentService.getPopularComment();
		PageInfo<Map<String, Object>> commentPageInfo = new PageInfo<Map<String, Object>>(comments);

		// 找出每个评论的回复数
		List<Integer> commentReplyCount = new ArrayList<Integer>();
		for (Map<String, Object> item : comments) {
			int rcount = commentService.getCommentReplyCountByCid((int) item.get("cid"));
			System.out.println("rcount====" + rcount);
			commentReplyCount.add(rcount);
		}

		Map<String, Object> commentInfo = new HashMap<String, Object>();
		commentInfo.put("commentPageInfo", commentPageInfo);
		commentInfo.put("commentReplyCount", commentReplyCount);

		String jsonPageInfo = JSON.toJSONString(commentInfo);
		System.out.println("jsonPageInfo=====" + jsonPageInfo);

		return jsonPageInfo;
	}

	/**
	 * 异步请求热门影评
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showHotComment", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showHotComment(int page) {

		// 获取最受欢迎的评论
		int pageSize = 6;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> comments = commentService.getHotComment();
		PageInfo<Map<String, Object>> commentPageInfo = new PageInfo<Map<String, Object>>(comments);

		// 找出每个评论的发帖人信息 和所评论的电影信息
		List<Map<String, Object>> commentUser = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> commentMovie = new ArrayList<Map<String, Object>>();

		for (Map<String, Object> item : comments) {
			int uid = (int) item.get("comuid");
			int mid = (int) item.get("mid");
			System.out.println("uid:" + uid + " mid:" + mid);
			User user = userService.getUserByUid(uid);

			Map<String, Object> userInfo = new HashMap<String, Object>();
			userInfo.put("username", user.getUsername());
			userInfo.put("uid", user.getUid());
			userInfo.put("uimg", user.getUimg());

			Movie movie = movieService.getMovieById(mid);
			Map<String, Object> movieInfo = new HashMap<String, Object>();
			movieInfo.put("mname", movie.getMname());
			movieInfo.put("img", movie.getImg());
			movieInfo.put("mid", movie.getMid());

			commentUser.add(userInfo);
			commentMovie.add(movieInfo);
		}

		Map<String, Object> commentInfo = new HashMap<String, Object>();
		commentInfo.put("commentPageInfo", commentPageInfo);
		commentInfo.put("commentUser", commentUser);
		commentInfo.put("commentMovie", commentMovie);

		String jsonPageInfo = JSON.toJSONString(commentInfo);
		System.out.println("jsonPageInfo=====" + jsonPageInfo);

		return jsonPageInfo;
	}

	/**
	 * 异步请求新片影评
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showNewComment", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showNewComment(int page) {
		// 获取最受欢迎的评论
		int pageSize = 6;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> comments = commentService.getNewComment();
		PageInfo<Map<String, Object>> commentPageInfo = new PageInfo<Map<String, Object>>(comments);

		// 找出每个评论的回复数
		List<Integer> commentReplyCount = new ArrayList<Integer>();
		for (Map<String, Object> item : comments) {
			int rcount = commentService.getCommentReplyCountByCid((int) item.get("cid"));
			System.out.println("rcount====" + rcount);
			commentReplyCount.add(rcount);
		}

		Map<String, Object> commentInfo = new HashMap<String, Object>();
		commentInfo.put("commentPageInfo", commentPageInfo);
		commentInfo.put("commentReplyCount", commentReplyCount);

		String jsonPageInfo = JSON.toJSONString(commentInfo);
		System.out.println("jsonPageInfo=====" + jsonPageInfo);

		return jsonPageInfo;
	}

	/**
	 * 影评详情页
	 * 
	 * @param mname
	 * @param cid
	 * @return
	 */
	@RequestMapping("reviewDetail")
	public ModelAndView reviewDetail(int cid) {

		ModelAndView mv = new ModelAndView("reviewDetail"); // 影评详情
		Map<String, Object> comment = commentService.getCommentByCid(cid);
		System.out.println("影评详情页面之影评人" + comment);
		mv.addObject("comment", comment);

		return mv;
	}

}
