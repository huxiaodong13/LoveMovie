package com.love.movie.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.love.movie.service.SakuraMovieService;

/**
 * @author sakura
 *
 */
@Controller
@RequestMapping("index")
public class SakuraMovieController {
	@Autowired
	private SakuraMovieService sakuraMovieServiceId;
	
	
	/**
	 * 选电影
	 * 
	 * @return
	 */
	@RequestMapping("selectMovie")
	public ModelAndView selectMovie() {
		ModelAndView mv = new ModelAndView("selectMovie");
		
		//获取热门电影
		int page = 1;
		int pageSize = 8;
		PageHelper.startPage(page, pageSize);
		
		List<Map<String, Object>> hotMovies = sakuraMovieServiceId.getHotMovies();
		PageInfo<Map<String, Object>> hotMoviesPage = new PageInfo<Map<String,Object>>(hotMovies);
		
		System.out.println("hot movies====" + hotMovies);
		
		mv.addObject("hotMoviesPage", hotMoviesPage);
		
		return mv;
	}
	
	
	/**
	 *电影排行榜 
	 * 
	 * @return
	 */
	@RequestMapping("movieRank")
	public ModelAndView	 movieRandk() {
		ModelAndView mv = new ModelAndView("movieRank");
		
		return mv;
	}
	
	
	/**
	 * 电影评论
	 * 
	 * @return
	 */
	@RequestMapping("review")
	public ModelAndView review() {
		ModelAndView mv = new ModelAndView("review");
		return mv;
	}
	
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
	public String writeReview() {
		return "writeReview";
	}
	
	
	/**
	 * 搜索
	 * 
	 * @return
	 */
	@RequestMapping("search")
	public String search() {
		return "search";
	}
	
	
	
}
