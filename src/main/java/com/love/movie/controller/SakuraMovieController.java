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
import com.love.movie.model.Movie;
import com.love.movie.model.User;
import com.love.movie.service.SakuraMovieService;
import com.love.movie.util.UserUtil;

/**
 * @author sakura
 *
 */
@Controller
@RequestMapping("smovie")	
public class SakuraMovieController {
	@Autowired
	private SakuraMovieService sakuraMovieServiceId;
	

	/**
	 * 选电影
	 * 
	 * @return
	 */
	@RequestMapping("selectMovie")
	public ModelAndView selectMovie(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("selectMovie");
		
		boolean isLogin = false;
		if(UserUtil.isLogin(request)) {
			isLogin = true;
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			mv.addObject("user", user);
		}
		
		mv.addObject("isLogin", isLogin);
		
		// 获取热门电影
		int page = 1;
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);

		List<Map<String, Object>> hotMovies = sakuraMovieServiceId.getHotMovies();
		PageInfo<Map<String, Object>> hotMoviesPage = new PageInfo<Map<String, Object>>(hotMovies);
		System.out.println("hot movies====" + hotMoviesPage);
		
		mv.addObject("infoPage", hotMoviesPage);
		
		//为登录用户查询电影是否看过
		if(isLogin) {
//			List<Integer> movieMark = sakuraMovieServiceId
		}

		return mv;
	}

	/**
	 * 异步请求 热门电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showHotMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showHotMovies(int page) {

		System.out.println("hot movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> hotMovies = sakuraMovieServiceId.getHotMovies();
		PageInfo<Map<String, Object>> hotMoviePageInfo = new PageInfo<Map<String, Object>>(hotMovies);

		String jsonHMPageInfo = JSON.toJSONString(hotMoviePageInfo);
		System.out.println("infoPage=====" + jsonHMPageInfo);

		return jsonHMPageInfo;
	}

	/**
	 * 异步请求 最新电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showNewMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showNewMovies(int page) {

		System.out.println("New movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getNewMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 经典电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showClassicMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showClassicMovies(int page) {

		System.out.println("classic movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getClassicMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 可播放电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showPlayableMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showPlayableMovies(int page) {

		System.out.println("palyable movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getPalyableMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 高分系列电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showHighScoreMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showHighScoreMovies(int page) {

		System.out.println("high score movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getHighScoreMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 冷门佳片电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showDarkHouseMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showDarkHouseMovies(int page) {

		System.out.println("dark house movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getDarkHorseMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 华语电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showChineseMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showChineseMovies(int page) {

		System.out.println("chinese movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getChineseMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 韩国电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showKoreanMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showKoreaneMovies(int page) {

		System.out.println("Korean movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getKoreanMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 欧美电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showEAMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showEAMovies(int page) {

		System.out.println("EA movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getEuropeanAndAmericanMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 日本电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showJapaneseMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showJapaneseMovies(int page) {

		System.out.println("Japanese movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getJapaneseMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 动作电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showActionMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showActionMovies(int page) {

		System.out.println("Action movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getActionMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 喜剧电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showComedyMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showComedyMovies(int page) {

		System.out.println("Comedy movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getComedyMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 爱情电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showLoveMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showLoveMovies(int page) {

		System.out.println("Love movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getLoveMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 科幻电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showSFMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showSFMovies(int page) {

		System.out.println("SF movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getScienceFictionMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 动画电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showCartoonMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showCartoonMovies(int page) {

		System.out.println("cure movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getCartoonMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 悬疑电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showSuspenseMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showSuspenseMovies(int page) {

		System.out.println("Suspense movies page===" + page);

		// 获取看过的电影
		int pageSize = 12;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getSuspenseMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}

	/**
	 * 异步请求 恐怖电影分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showHorribleMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showHorribleMovies(int page) {

		System.out.println("Horrible movies page===" + page);

		// 获取看过的电影
		int pageSize = 4;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies = sakuraMovieServiceId.getHorribleMovies();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonMoviesPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonMoviesPageInfo=====" + jsonMoviesPageInfo);

		return jsonMoviesPageInfo;
	}


}
