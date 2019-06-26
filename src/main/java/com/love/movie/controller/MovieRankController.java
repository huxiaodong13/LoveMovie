package com.love.movie.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.love.movie.service.CommentService;
import com.love.movie.service.MovieService;

@Controller
@RequestMapping("Rank")
public class MovieRankController {

	@Autowired
	private MovieService movieService;
	@Autowired
	CommentService commentService;
	
	/**
	 * * 最新电影排行榜
	 *
	 */
	@RequestMapping("NewRank")
	public ModelAndView movieRank() {
		ModelAndView mv = new ModelAndView("movie-rank");
		List<Map<String, Object>> moviesNewDate = movieService.getAllNewDateMovie();
		for(Map<String, Object> m : moviesNewDate) {
			System.out.println("======================");
			System.out.println(m);
			System.out.println("======================");
		}
		mv.addObject("moviesRank", moviesNewDate);
		return mv;
	}

	
	/**
	 * * 经典电影排行榜
	 *
	 */
	@RequestMapping("classicsRank")
	public ModelAndView movieClassicsRank() {
		ModelAndView mv = new ModelAndView("movie-rank");
		List<Map<String, Object>> moviesNewDate = movieService.getTopClassicsMovie();
		for(Map<String, Object> m : moviesNewDate) {
			System.out.println("======================");
			System.out.println(m);
			System.out.println("======================");
		}
		mv.addObject("moviesRank", moviesNewDate);
		return mv;
	}
	
	/**
	 * 异步请求经典的电影
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "classicsRankMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String classicsRankMovies() {

		//System.out.println("seen movies page===" + page);

		int pageSize = 3;
		PageHelper.startPage(1, pageSize);
		List<Map<String, Object>> moviesClassics = movieService.getTopClassicsMovie();
		//PageInfo<Map<String, Object>> smPageInfo = new PageInfo<Map<String, Object>>(moviesClassics);

		String jsonSMPageInfo = JSON.toJSONString(moviesClassics);
		System.out.println("jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

	/**
	 * 异步请求新片的电影
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "newRankMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String newRankMovies() {

		//System.out.println("seen movies page===" + page);

		int pageSize = 3;
		PageHelper.startPage(1, pageSize);
		List<Map<String, Object>> moviesNewDate = movieService.getAllNewDateMovie();
		//PageInfo<Map<String, Object>> smPageInfo = new PageInfo<Map<String, Object>>(moviesNewDate);

		String jsonSMPageInfo = JSON.toJSONString(moviesNewDate);
		System.out.println("jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

}
