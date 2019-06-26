package com.love.movie.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.love.movie.model.Comment;
import com.love.movie.model.Movie;
import com.love.movie.model.User;
import com.love.movie.service.SakuraMovieService;
import com.love.movie.service.SakuraReviewService;
import com.love.movie.util.UserUtil;

@Controller
@RequestMapping("sreview")
public class SakuraReviewController {
	@Autowired
	private SakuraMovieService sakuraMovieServiceId;
	
	@Autowired
	private SakuraReviewService SakuraReviewServiceId;

	/**
	 * 评论详情
	 * 
	 * @return
	 */
	@RequestMapping("reviewDetail")
	public ModelAndView reviewDetail() {
		ModelAndView mv = new ModelAndView("reviewDetails");
		return mv;
	}

	/**
	 * 写影评
	 * 
	 * @return
	 */
	@RequestMapping("writeReview")
	public ModelAndView writeReview(int mid, HttpServletRequest request) {

		// 登录验证
		if (!UserUtil.isLogin(request)) {
			return new ModelAndView("error");
		}

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		ModelAndView mv = new ModelAndView("writeReview");
		Movie movie = sakuraMovieServiceId.getMovieByMid(mid);

		mv.addObject("movie", movie);
		mv.addObject("user", user);
		
		return mv;
	}

	/**
	 * 处理提交的影评 0为未提交成功 1为提交成功
	 * 
	 * 
	 * @return
	 */
	@RequestMapping("submitReview")
	@ResponseBody
	public String submitReview(Comment comment, HttpServletRequest request) {
		
		// 登录验证
		if (!UserUtil.isLogin(request)) {
			return "0";
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int uid = user.getUid();
		
		comment.setUid(uid);
		comment.setCdate(new Date());
		comment.setClike(0);
		comment.setReport(0);
		
		boolean addOK = SakuraReviewServiceId.addComment(comment);
		System.out.println(comment);
		
		if(addOK) {
			return "1";
		}
		return "0";
	}
}
