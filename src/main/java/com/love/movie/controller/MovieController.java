package com.love.movie.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.love.movie.model.Comment;
import com.love.movie.model.Movie;
import com.love.movie.model.Score;
import com.love.movie.model.User;
import com.love.movie.service.CommentService;
import com.love.movie.service.MovieService;
import com.love.movie.service.UserService;
import com.love.movie.util.UserUtil;

@Controller
@RequestMapping("movie")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@Autowired 
	private CommentService commentService;
	
	@Autowired
	private 
	UserService userService;
	
	/**
	 * 电影详情
	 * 
	 * @param mid
	 * @param request
	 * @return
	 */
	@RequestMapping("movieDetail")
	public ModelAndView movieDetail(int mid, HttpServletRequest request) {
		ModelAndView mv = null;
		Movie movie = movieService.getMovieById(mid);
		if(movie == null) {
			mv = new ModelAndView("findError");
		}else {
			mv = new ModelAndView("movieDetail");
			mv.addObject("movie",movie);
			
			//找到相应电影的影评
			int page = 1;
			int pageSize = 6;
			PageHelper.startPage(page, pageSize);
			
			List<Map<String, Object>>  commentsList = commentService.getPopularCommentByMid(mid);
			PageInfo<Map<String, Object>> commentPageInfo = new PageInfo<Map<String,Object>>(commentsList);
			
			//找出每个评论的回复数
			List<Integer> commentReplyCount = new ArrayList<Integer>();
			for(Map<String, Object> item : commentsList) {
				int rcount = commentService.getCommentReplyCountByCid((int)item.get("cid"));
				System.out.println("rcount====" + rcount);
				commentReplyCount.add(rcount);
			}
			mv.addObject("commentReplyCount", commentReplyCount);
			
			
			if(commentsList.isEmpty() == false) {
				mv.addObject("commentPageInfo",commentPageInfo);
				mv.addObject("hasComments",true);
			}else {
				System.out.println("还未有用户评论");
				mv.addObject("hasComments",false);
			}
			
			//各阶段的评分数据
			List<Integer> movieScoreLevel = movieService.getMovieScoreLevel(mid);
			System.out.println("movieScoreLevel" + movieScoreLevel);
			mv.addObject("movieScoreLevel", movieScoreLevel);
			
			//用户是否登录
			if(UserUtil.isLogin(request)) {
				mv.addObject("isLogin", true);
				
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute("user");
				mv.addObject("user", user);
				
			}else {
				mv.addObject("isLogin", false);
			}
			
		}
		return mv;
	}
	
	/**
	 * 更新对电影的评分
	 * 
	 * @param mid
	 * @param score
	 * @param request
	 * @return
	 */
	@RequestMapping("modifyMovieScore")
	@ResponseBody
	public String modifyMovieScore(Score score, HttpServletRequest request) {
		
		//未登录
		if(!UserUtil.isLogin(request)) {
			return "0";
		}
		
		System.out.println("modifyMovieScore score " + score);
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		score.setUid(user.getUid());
		
		//更新评分
		movieService.modifyUserMovieScore(score);
		
		System.out.println("score===" + score);
		return "1";
	}
	
	/**
	 *  异步请求 电影详情页的最受欢迎评论分页数据
	 * 
	 * @param mid
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showMovieDetailPopuplarComment", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showMovieDetailPopuplarComment(int mid, int page) {
		System.out.println("showMovieDetailPopuplarComment page===" + page);

		int pageSize = 6;
		PageHelper.startPage(page, pageSize);
		
		List<Map<String, Object>>  commentsList = commentService.getPopularCommentByMid(mid);
		PageInfo<Map<String, Object>> commentPageInfo = new PageInfo<Map<String,Object>>(commentsList);
		
		Map<String, Object> commentInfo = new HashMap<String, Object>();
		
		if(commentPageInfo.getTotal() == 0) {
			commentInfo.put("hasComments", false);
		}else {
			commentInfo.put("hasComments", true);
			
			//分页数据
			commentInfo.put("commentPageInfo", commentPageInfo);
			
			//找出每个评论的回复数
			List<Integer> commentReplyCount = new ArrayList<Integer>();
			for(Map<String, Object> item : commentsList) {
				int rcount = commentService.getCommentReplyCountByCid((int)item.get("cid"));
				System.out.println("rcount====" + rcount);
				commentReplyCount.add(rcount);
			}
			//评论回复数
			commentInfo.put("commentReplyCount", commentReplyCount);
		}
		
		String jsonPageInfo = JSON.toJSONString(commentInfo);
		System.out.println("commentPageInfo=====" + jsonPageInfo);
		
		return jsonPageInfo;
	}
	
	/**
	 *  异步请求 电影详情页的热门欢迎评论分页数据
	 * 
	 * @param mid
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showMovieDetailHotComment", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showMovieDetailHotComment(int mid, int page) {
		System.out.println("showMovieDetailHotComment page===" + page);

		int pageSize = 1;
		PageHelper.startPage(page, pageSize);
		
		List<Map<String, Object>>  commentsList = commentService.getHotCommentByMid(mid);
		PageInfo<Map<String, Object>> commentPageInfo = new PageInfo<Map<String,Object>>(commentsList);
		
		Map<String, Object> commentInfo = new HashMap<String, Object>();
		
		if(commentPageInfo.getTotal() == 0) {
			commentInfo.put("hasComments", false);
		}else {
			commentInfo.put("hasComments", true);
			
			//分页数据
			commentInfo.put("commentPageInfo", commentPageInfo);
			
			List<Map<String, Object>> commentUser = new ArrayList<Map<String, Object>>();
			for(Map<String, Object> item : commentsList) {
				System.out.println("item==" + item);
				
				int uid2 = (int) item.get("uid");
				System.out.println("uid:" + uid2);
				User user2 = userService.getUserByUid(uid2);

				Map<String, Object> userInfo = new HashMap<String, Object>();
				userInfo.put("username", user2.getUsername());
				userInfo.put("uid", user2.getUid());
				userInfo.put("uimg", user2.getUimg());
				commentUser.add(userInfo);
			}
			
			commentInfo.put("commentUser", commentUser);
		}
		
		String jsonPageInfo = JSON.toJSONString(commentInfo);
		System.out.println("commentPageInfo=====" + jsonPageInfo);
		
		return jsonPageInfo;
	}
	
	/**
	 *  异步请求 电影详情页的最新评论分页数据
	 * 
	 * @param mid
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showMovieDetailNewComment", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showMovieDetailNewComment(int mid, int page) {
		System.out.println("showMovieDetailNewComment page===" + page);

		int pageSize = 6;
		PageHelper.startPage(page, pageSize);
		
		List<Map<String, Object>>  commentsList = commentService.getNewCommentByMid(mid);
		PageInfo<Map<String, Object>> commentPageInfo = new PageInfo<Map<String,Object>>(commentsList);
		
		Map<String, Object> commentInfo = new HashMap<String, Object>();
		
		if(commentPageInfo.getTotal() == 0) {
			commentInfo.put("hasComments", false);
		}else {
			commentInfo.put("hasComments", true);
			
			//分页数据
			commentInfo.put("commentPageInfo", commentPageInfo);
			//找出每个评论的回复数
			List<Integer> commentReplyCount = new ArrayList<Integer>();
			for(Map<String, Object> item : commentsList) {
				int rcount = commentService.getCommentReplyCountByCid((int)item.get("cid"));
				System.out.println("rcount====" + rcount);
				commentReplyCount.add(rcount);
			}
			//回复回复数
			commentInfo.put("commentReplyCount", commentReplyCount);
		}
		
		String jsonPageInfo = JSON.toJSONString(commentInfo);
		System.out.println("commentPageInfo=====" + jsonPageInfo);
		
		return jsonPageInfo;
	}
	
	/**
	 *  异步请求 电影详情页的好友评论分页数据
	 * 
	 * @param mid
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "showMovieDetailFriendComment", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showMovieDetailFriendComment(int mid, int page, HttpServletRequest request) {
		System.out.println("showMovieDetailFriendComment page===" + page);

		if(!UserUtil.isLogin(request)) {
			return "没有登录，请登录后获取好友数据";
		}else {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			
			Comment comment = new Comment();
			comment.setMid(mid);
			comment.setUid(user.getUid());
			
			int pageSize = 6;
			PageHelper.startPage(page, pageSize);
			List<Map<String, Object>>  commentsList = commentService.getFriendCommentByMid(comment);
			PageInfo<Map<String, Object>> commentPageInfo = new PageInfo<Map<String,Object>>(commentsList);
			
			Map<String, Object> commentInfo = new HashMap<String, Object>();
			
			if(commentPageInfo.getTotal() == 0) {
				commentInfo.put("hasComments", false);
			}else {
				commentInfo.put("hasComments", true);
				
				//分页数据
				commentInfo.put("commentPageInfo", commentPageInfo);
				
				//找出每个评论的回复数
				List<Integer> commentReplyCount = new ArrayList<Integer>();
				for(Map<String, Object> item : commentsList) {
					int rcount = commentService.getCommentReplyCountByCid((int)item.get("cid"));
					System.out.println("rcount====" + rcount);
					commentReplyCount.add(rcount);
				}
				//回复回复数
				commentInfo.put("commentReplyCount", commentReplyCount);
				
				// 找出每个评论的发帖人信息 和所评论的电影信息
				List<Map<String, Object>> commentUser = new ArrayList<Map<String, Object>>();
				List<Map<String, Object>> commentMovie = new ArrayList<Map<String, Object>>();
				
				for (Map<String, Object> item : commentsList) {
					System.out.println("item==" + item);
					
					int uid2 = (int) item.get("uid");
					int mid2 = (int) item.get("mid");
					System.out.println("uid:" + uid2 + " mid:" + mid2);
					User user2 = userService.getUserByUid(uid2);

					Map<String, Object> userInfo = new HashMap<String, Object>();
					userInfo.put("username", user2.getUsername());
					userInfo.put("uid", user2.getUid());
					userInfo.put("uimg", user2.getUimg());

					Movie movie = movieService.getMovieById(mid2);
					Map<String, Object> movieInfo = new HashMap<String, Object>();
					movieInfo.put("mname", movie.getMname());
					movieInfo.put("img", movie.getImg());
					movieInfo.put("mid", movie.getMid());

					commentUser.add(userInfo);
					commentMovie.add(movieInfo);
				}
				
				commentInfo.put("commentUser", commentUser);
				commentInfo.put("commentMovie", commentMovie);
			}
			
			String jsonPageInfo = JSON.toJSONString(commentInfo);
			System.out.println("commentPageInfo=====" + jsonPageInfo);
			
			return jsonPageInfo;
		}
	}
	
}
