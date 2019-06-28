package com.love.movie.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.alibaba.fastjson.JSONObject;
import com.love.movie.model.Movie;
import com.love.movie.service.CommentService;
import com.love.movie.service.MovieService;

/**
 * 主页控制器
 * 
 * @author 
 *
 */
@Controller
@RequestMapping("index")
public class IndexController {
	@Autowired
	private MovieService movieService;
	@Autowired 
	private CommentService commentService;
	
	/**
	 * 首页
	 *
	 */
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		
		List<Map<String, Object>> moviesNewDate = movieService.getTopNewDateMovie();
		
		ArrayList<Object> tagsList = new ArrayList<>();
		ArrayList<Object> directList = new ArrayList<>();
		for(Map<String, Object> m : moviesNewDate) {
			System.out.println("新电影======================");
			System.out.println(m);
			String tagString = m.get("mtag").toString();
			tagString = tagString.replace(" ", "");
			String[] tags = tagString.split("/");
			List<Map<String, Object>> set = new ArrayList(Arrays.asList(tags));
			//System.out.println("json数据为"+JSONObject.toJSON(set));
			System.out.println("新电影tags"+set);
			tagsList.add(JSONObject.toJSON(set));
			
			String mdirectString = m.get("mdirect").toString();
			mdirectString = mdirectString.replace(" ", "");
			String[] mdirects = mdirectString.split("/");
			List<Map<String, Object>> mdirectSet = new ArrayList(Arrays.asList(mdirectString));
			//System.out.println("json数据为"+JSONObject.toJSON(mdirectSet));
			System.out.println("导演为"+mdirectSet);
			directList.add(JSONObject.toJSON(mdirectSet));
		}
		mv.addObject("moviesNewDate", moviesNewDate);
		mv.addObject("tagsList", tagsList);
		mv.addObject("directList", directList);
		
		List<Map<String, Object>> moviesHot = movieService.getHotMovie();
		
		ArrayList<Object> tagsListHot = new ArrayList<>();
		ArrayList<Object> directListHot = new ArrayList<>();
		for(Map<String, Object> m : moviesHot) {
			System.out.println("热门电影======================");
			System.out.println(m);
			String tagString = m.get("mtag").toString();
			tagString = tagString.replace(" ", "");
			String[] tags = tagString.split("/");
			List<Map<String, Object>> set = new ArrayList(Arrays.asList(tags));
			System.out.println("json数据为"+JSONObject.toJSON(set));
			System.out.println("热门tags"+set);
			tagsListHot.add(JSONObject.toJSON(set));
			
			String mdirectString = m.get("mdirect").toString();
			mdirectString = mdirectString.replace(" ", "");
			String[] mdirects = mdirectString.split("/");
			List<Map<String, Object>> mdirectSet = new ArrayList(Arrays.asList(mdirectString));
			//System.out.println("json数据为"+JSONObject.toJSON(mdirectSet));
			System.out.println("热门导演"+mdirectSet);
			directListHot.add(JSONObject.toJSON(mdirectSet));
		}
		mv.addObject("tagsListHot", tagsListHot);
		mv.addObject("directListHot", directListHot);
		mv.addObject("moviesHot", moviesHot);
		
		List<Map<String, Object>> commentLikes = commentService.getLikeComment();
		mv.addObject("commentLikes", commentLikes);

		
		return mv;
	}
	
//	/**
//	 * 电影详情
//	 * 
//	 * @param mid
//	 * @return
//	 */
//	@RequestMapping("movieDetail")
//	public ModelAndView movieDetail(int mid) {
//		ModelAndView mv = null;
//		Movie movie = movieService.getMovieById(mid);
//		if(movie != null) {
//			mv = new ModelAndView("moviedetails");
//			mv.addObject(movie);
//		}else {
//			mv = new ModelAndView("failError");
//		}
//		return mv;
//	}
	

	/**
	 * 异步请求热门的电影
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showHotMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showHotMovies() {
		List<Map<String, Object>> moviesHot = movieService.getHotMovie();
		
		String jsonSMPageInfo = JSON.toJSONString(moviesHot);
		//String jsonSMPageInfo = JSONObject.toJSON(moviesHot).toString();
		System.out.println("热门jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

	/**
	 * 异步请求最新的电影
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showDateMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showDateMovies() {
		List<Map<String, Object>> moviesHot = movieService.getTopNewDateMovie();
		
		String jsonSMPageInfo = JSON.toJSONString(moviesHot);
		//String jsonSMPageInfo = JSONObject.toJSON(moviesHot).toString();
		System.out.println("最新jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

	/**
	 * 异步请求高分的电影
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showScoreMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showScoreMovies() {
		List<Map<String, Object>> moviesHot = movieService.getScoreMovie();
		
		String jsonSMPageInfo = JSON.toJSONString(moviesHot);
		//String jsonSMPageInfo = JSONObject.toJSON(moviesHot).toString();
		System.out.println("高分jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

	/**
	 * 异步请求冷门的电影
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showColdMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showColdMovies() {
		List<Map<String, Object>> moviesHot = movieService.getColdMovie();
		
		String jsonSMPageInfo = JSON.toJSONString(moviesHot);
		//String jsonSMPageInfo = JSONObject.toJSON(moviesHot).toString();
		System.out.println("冷门jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
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
	public String showHotComment() {
		List<Map<String, Object>> comments = commentService.getHotComment();
		
		String jsonSMPageInfo = JSON.toJSONString(comments);
		System.out.println("热门影评jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

	/**
	 * 异步请求最新的影评
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showDateComment", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showDateComment() {
		List<Map<String, Object>> comments = commentService.getNewComment();
		
		String jsonSMPageInfo = JSON.toJSONString(comments);
		//String jsonSMPageInfo = JSONObject.toJSON(moviesHot).toString();
		System.out.println("新片jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

}
