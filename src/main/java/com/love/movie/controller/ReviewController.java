package com.love.movie.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.love.movie.model.Attitude;
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
	public ModelAndView reviewDetail(int cid, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("reviewDetail"); // 影评详情

		// 影评
		Map<String, Object> comment = commentService.getCommentByCid(cid);
		mv.addObject("comment", comment);

		// 获取发帖人
		User user = userService.getUserByUid((int) comment.get("uid"));
		mv.addObject("userPost", user);

		// 获取该影评所评价的电影信息
		Movie movie = movieService.getMovieById((int) comment.get("mid"));
		mv.addObject("movie", movie);

		// 获取该影评的收藏数
		Integer storeCount = commentService.getCommentStroeCount(cid);
		if (storeCount != null) {
			mv.addObject("storeCount", storeCount);
		} else {
			mv.addObject("storeCount", 0);
		}
		
		//获取该影评的回帖
		List<Map<String, Object>> replyToComment = commentService.getReplyToCommentByCid(cid);
		mv.addObject("replyToComment", replyToComment);
		System.out.println("replyToComment==="+ replyToComment);
		
		// 标记是否登录
		if (UserUtil.isLogin(request)) {
			HttpSession session = request.getSession();
			User userLogin = (User) session.getAttribute("user");
			mv.addObject("isLogin", true);
			mv.addObject("userLogin", userLogin);

			int uid = userLogin.getUid();

			// 该用户是否收点赞或者踩该帖子
			Attitude attitude = new Attitude();
			attitude.setUid(uid);
			attitude.setCid(cid);
			Integer attiInteger = commentService.getUserAttitudeToComment(attitude);
			if (attiInteger == null) {
				mv.addObject("isLike", -1); // 既没有点赞也没有踩
			} else {
				mv.addObject("isLike", attiInteger);
			}

			// 该用户是否收藏过该帖子
			boolean isStoreup = commentService.isStoreComment(cid, uid);
			mv.addObject("isStoreup", isStoreup);

		} else {
			mv.addObject("isLogin", false);
			mv.addObject("isStoreup", false);
		}

		return mv;
	}

	/**
	 * 处理收藏
	 * 
	 * @param cid
	 * @param status
	 * @param request
	 * @return
	 */
	@RequestMapping("doStoreUpComment")
	@ResponseBody
	public String doStoreUp(int cid, int status, HttpServletRequest request) {
		System.out.println("store comment cid " + cid + " status " + status);

		User user = null;

		// 未登录不能收藏
		if (UserUtil.isLogin(request) == false) {
			return "-1";
		}

		HttpSession session = request.getSession();
		user = (User) session.getAttribute("user");
		int uid = user.getUid();

		// 取消收藏
		if (status == 1) {
			if (commentService.cancelStoreComment(cid, uid)) {
				System.out.println("取消收藏成功");
				return "0";
			}
			System.out.println("取消收藏失败");
			return "2";
		} else if (status == 0) {
			// 收藏
			if (commentService.storeComment(cid, uid)) {
				System.out.println("收藏成功");
				return "1";
			}
			System.out.println("收藏失败");
			return "2";
		}
		return "2";
	}

	/**
	 * 处理点赞或者踩
	 * 
	 * @param thumbSatus
	 * @param cid
	 * @param request
	 * @return
	 */
	@RequestMapping("doThumb")
	@ResponseBody
	public String doThumb(String thumbStatus, int cid, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int uid = user.getUid();

		System.out.println("thumbStatus:" + thumbStatus);

		if (thumbStatus.equals("00")) {
			System.out.println("取消踩");
			commentService.cancelThumDownComment(cid, uid);
			return "1";

		} else if (thumbStatus.equals("01")) {
			System.out.println("踩");
			commentService.doThumDownComment(cid, uid);
			return "1";

		} else if (thumbStatus.equals("10")) {
			System.out.println("取消赞");
			commentService.cancelThumbUpComment(cid, uid);
			return "1";

		} else if (thumbStatus.equals("11")) {
			System.out.println("赞");
			commentService.doThumbUpComment(cid, uid);
			return "1";
		}
		return "2";
	}

	/**
	 * 异步处理 举报
	 * 
	 * @param reason
	 * @param cid
	 * @param request
	 * @return
	 */
	@RequestMapping("doReport")
	@ResponseBody
	public String doReport(String reason, int cid, HttpServletRequest request) {
		// 未登录不能举报
		if (!UserUtil.isLogin(request)) {
			return "0";
		}

		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("user");
		int uid = userLogin.getUid();

		if (commentService.doReport(reason, cid, uid)) {
			return "1";
		}
		return "2";
	}

	/**
	 * 异步处理 回复
	 * 
	 * @param content
	 * @param cid
	 * @param request
	 * @return
	 */
	@RequestMapping("doAddReplyToComment")
	@ResponseBody
	public String doAddReplyToComment(String content, int cid, int touid, HttpServletRequest request) {
		// 未登录不能回复
		if (!UserUtil.isLogin(request)) {
			return "0";
		}
		
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("user");
		int uid = userLogin.getUid();
		
		if(commentService.doAddReplyToComment(content, cid, uid, touid)) {
			return "1";
		}
		
		return "2";
	}

}
