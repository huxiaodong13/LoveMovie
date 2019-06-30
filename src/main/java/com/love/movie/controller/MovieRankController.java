package com.love.movie.controller;

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
import com.love.movie.model.User;
import com.love.movie.service.CommentService;
import com.love.movie.service.MovieService;
import com.love.movie.util.UserUtil;

@Controller
@RequestMapping("Rank")
public class MovieRankController {

	@Autowired
	private MovieService movieService;
	@Autowired
	CommentService commentService;

	/**
	 * 最新电影排行榜
	 * 
	 * @return
	 */
	@RequestMapping("NewRank")
	public ModelAndView movieRank(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("movieRank");

		int page = 1;
		int pageSize = 10;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> moviesNewDate = movieService.getAllNewDateMovie();
		PageInfo<Map<String, Object>> moveiRankPageInfo = new PageInfo<Map<String, Object>>(moviesNewDate);

		mv.addObject("moviesRankPageInfo", moveiRankPageInfo);

		// 用户是否登录
		if (UserUtil.isLogin(request)) {
			mv.addObject("isLogin", true);

			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			mv.addObject("user", user);

		} else {
			mv.addObject("isLogin", false);
		}

		return mv;
	}

	/**
	 * 经典电排行榜
	 * 
	 * @return
	 */
	@RequestMapping("classicsRank")
	public ModelAndView movieClassicsRank(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("movieRank");
		List<Map<String, Object>> moviesClassic = movieService.getTopClassicsMovie();
		mv.addObject("moviesRank", moviesClassic);

		// 用户是否登录
		if (UserUtil.isLogin(request)) {
			mv.addObject("isLogin", true);

			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			mv.addObject("user", user);

		} else {
			mv.addObject("isLogin", false);
		}

		return mv;
	}

	/**
	 * 异步请求经典的电影
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getClassicMovieRankData", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String classicsRankMovies() {
		List<Map<String, Object>> moviesClassic = movieService.getTopClassicsMovie();
		String jsonSMPageInfo = JSON.toJSONString(moviesClassic);
		System.out.println("jsonMRPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

	/**
	 * 异步请求新片的电影
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getNewMovieRankData", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String newRankMovies(int page) {
		
		int pageSize = 10;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> moviesNewDate = movieService.getAllNewDateMovie();
		PageInfo<Map<String, Object>> moveiRankPageInfo = new PageInfo<Map<String, Object>>(moviesNewDate);
		
		String jsonSMPageInfo = JSON.toJSONString(moveiRankPageInfo);
		System.out.println("jsonMRPageInfo====" + jsonSMPageInfo);
		
		return jsonSMPageInfo;
	}

}
