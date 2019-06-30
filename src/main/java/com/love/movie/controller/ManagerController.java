package com.love.movie.controller;

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
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.love.movie.mapper.XCustomedUserMapper;
import com.love.movie.model.Movie;
import com.love.movie.model.User;
import com.love.movie.service.CommentService;
import com.love.movie.service.MovieService;
import com.love.movie.service.XReplyService;
import com.love.movie.service.XUserService;
import com.love.movie.util.UserUtil;

@Controller
@RequestMapping("manager")
public class ManagerController {
	@Autowired
	private MovieService movieService;
	
	@Autowired 
	private CommentService commentService;
	
	@Autowired
	private XUserService xuserService;
	
	@Autowired
	private XReplyService xReplyService;
	/**
	 * *管理员展示
	 *
	 */
	@RequestMapping("manager")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("manage");
		
		if(!UserUtil.isLogin(request)) {
			return new ModelAndView("login");
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user.getLevel() != 1) {
			return new ModelAndView("login");
		}
		
		//管理员用户信息
		mv.addObject("user", user);
		
		// 分页
		int page = 1;
		int pageSize = 6;
		
		//电影管理
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies= movieService.getMAllMovie();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		//影评管理
		PageHelper.startPage(page, 4);
		List<Map<String, Object>> comments= commentService.getMAllComment();
		PageInfo<Map<String, Object>> commentsPageInfo = new PageInfo<Map<String, Object>>(comments);

		//用户管理
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> users= xuserService.getMAllUser();
		PageInfo<Map<String, Object>> usersPageInfo = new PageInfo<Map<String, Object>>(users);

		//评论管理
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> xReply= xReplyService.getMAllReply();
		PageInfo<Map<String, Object>> xReplyPageInfo = new PageInfo<Map<String, Object>>(xReply);
		
		//恶意影评管理
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> badComments= commentService.getMBadAllComment();
		PageInfo<Map<String, Object>> badCommentsPageInfo = new PageInfo<Map<String, Object>>(badComments);
		
		//恶意回复管理
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> badReplys = xReplyService.getMBadAllReply();
		PageInfo<Map<String, Object>> badReplysPageInfo = new PageInfo<Map<String, Object>>(badReplys);

		
		mv.addObject("moviesPageInfo", moviesPageInfo);
		mv.addObject("commentsPageInfo", commentsPageInfo);
		mv.addObject("usersPageInfo", usersPageInfo);
		mv.addObject("xReplyPageInfo", xReplyPageInfo);
		
		mv.addObject("badCommentsPageInfo", badCommentsPageInfo);
		mv.addObject("badReplysPageInfo", badReplysPageInfo);
		System.out.println(xReplyPageInfo);

		return mv;
	}
	
	/**
	 * 异步请求电影
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showMovies", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showMovies(int page) {

		System.out.println("movies page===" + page);

		int pageSize = 6;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> movies= movieService.getMAllMovie();
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(movies);

		String jsonSMPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

	
	/**
	 * *异步请求影评
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showComments", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showComments(int page) {

		int pageSize = 4;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> comments= commentService.getMAllComment();;
		PageInfo<Map<String, Object>> moviesPageInfo = new PageInfo<Map<String, Object>>(comments);

		String jsonSMPageInfo = JSON.toJSONString(moviesPageInfo);
		System.out.println("jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

	/**
	 * *异步请求用户
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showUsers", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showUsers(int page) {

		int pageSize = 6;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> users= xuserService.getMAllUser();
		PageInfo<Map<String, Object>> usersPageInfo = new PageInfo<Map<String, Object>>(users);

		String jsonSMPageInfo = JSON.toJSONString(usersPageInfo);
		return jsonSMPageInfo;
	}

	/**
	 * *异步请求用户
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showReplys", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showReplys(int page) {

		System.out.println("回复 page===" + page);

		int pageSize = 6;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> replys= xReplyService.getMAllReply();
		PageInfo<Map<String, Object>> replysPageInfo = new PageInfo<Map<String, Object>>(replys);

		String jsonSMPageInfo = JSON.toJSONString(replysPageInfo);
		System.out.println("jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

	
	/**
	 * *异步请求 恶意影评
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showBadComments", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showBadComments(int page) {

		int pageSize = 6;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> badComments= commentService.getMBadAllComment();
		PageInfo<Map<String, Object>> badCommentPageInfo = new PageInfo<Map<String, Object>>(badComments);

		String jsonSMPageInfo = JSON.toJSONString(badCommentPageInfo);
		return jsonSMPageInfo;
	}

	/**
	 * *异步请求 恶意回复
	 * 
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showBadReply", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String showBadReply(int page) {

		System.out.println("恶意回复 page===" + page);

		int pageSize = 6;
		PageHelper.startPage(page, pageSize);
		List<Map<String, Object>> badReplys= xReplyService.getMBadAllReply();
		PageInfo<Map<String, Object>> badReplysPageInfo = new PageInfo<Map<String, Object>>(badReplys);

		String jsonSMPageInfo = JSON.toJSONString(badReplysPageInfo);
		System.out.println("jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

	
	
	/**
	 * *异步请求 刪除用户
	 * 
	 * @param uid
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "delUser", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String delUser(int uid) {

		//System.out.println("删除用户 uid===" + uid);
		Boolean isOk = xuserService.delUserById(uid);
		if(isOk) {
			return "success";
		}
		return "fail";
	}

	/**
	 * *异步请求 刪除影评
	 * 
	 * @param cid
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "delComment", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String delComment(int cid) {

		System.out.println("删除影评 uid===" + cid);
		Boolean isOk = commentService.delCommentByCid(cid);
		if(isOk) {
			return "success";
		}
		return "fail";
	}
	

	/**
	 * *异步请求 刪除影评
	 * 
	 * @param mid
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "delMovie", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String delMovie(int mid) {

		System.out.println("删除电影 mid===" + mid);
		Boolean isOk = movieService.delMovieByMid(mid);
		if(isOk) {
//			List<Map<String, Object>> commentsList = commentService.getCommentByMid(mid);
//			for(Map<String, Object> comment : commentsList) {
//				System.out.println("影评cid==");
//				System.out.println(comment.get("cid").toString());
//				boolean r = xReplyService.delReplyByCid(Integer.parseInt(comment.get("cid").toString()));
//			}
//			boolean c = commentService.delCommentByMid(mid);
			return "success";
		}
		return "fail";
	}

	/**
	 * *异步请求 刪除恶意影评
	 * 
	 * @param cid
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "delBadComment", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String delBadComment(int cid) {

		System.out.println("删除恶意影评电影 cid===" + cid);
		Boolean isOk = commentService.delCommentByCid(cid);
		if(isOk) {
			boolean r = xReplyService.delReplyByCid(cid);
			if(r) {
				System.out.println("通过cid删除评论成功");
			}
			return "success";
		}
		return "fail";
	}

	/**
	 * *异步请求 刪除(恶意)评论
	 * 
	 * @param rid
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "delBadReply", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String delBadReply(int rid) {

		System.out.println("删除恶意评论 rid===" + rid);
		Boolean isOk = xReplyService.delReply(rid);
		if(isOk) {
			return "success";
		}
		return "fail";
	}

	/**
	 * *异步请求 更新电影信息
	 * 
	 * @param movie
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "updateMovie", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String updateMovie(Movie movie, HttpServletRequest request) {
		
		System.out.println("更新电影 ===" + movie);
		
//		System.out.println("电影id ===" + mid);
		Boolean isOk = movieService.updateMovie(movie);
		if(isOk) {
			return "success";
		}
		return "fail";
	}

	/**
	 * *异步请求 添加电影
	 * 
	 * @param movie
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "insertMovie", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String insertMovie(Movie movie) {

		System.out.println("添加电影 ===" + movie);
		Boolean isOk = movieService.insertMovie(movie);
		if(isOk) {
			return "success";
		}
		return "fail";
	}

	/**
	 * *异步请求 查找电影
	 * 
	 * @param mid
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "selectMovie", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String selectMovie(int mid) {

		System.out.println("电影 ===" + mid);
		Movie movie = movieService.getMovieById(mid);
		String jsonSM = JSON.toJSONString(movie);
		System.out.println("电影jsonSM====" + jsonSM);
		return jsonSM;
	}

	

}