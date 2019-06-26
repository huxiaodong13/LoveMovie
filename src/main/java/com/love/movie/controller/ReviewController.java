package com.love.movie.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.love.movie.model.Comment;
import com.love.movie.service.CommentService;

@Controller
@RequestMapping("review")
public class ReviewController {
	@Autowired 
	CommentService commentService;
	@RequestMapping("Review")
	public ModelAndView topReview() {
		ModelAndView mv = new ModelAndView("review");
		List<Map<String, Object>> commentLikes = commentService.getTopLikeComment();
		for(Map<String, Object> c : commentLikes) {
			System.out.println("最受欢迎的======================");
			System.out.println(c);
			System.out.println("======================");
		}
		mv.addObject("comments", commentLikes);

		return mv;
	}


	 @RequestMapping("reviewDetail") public ModelAndView reviewDetail(String
	  mname,int cid) { ModelAndView mv = new ModelAndView("reviewdetail"); //影评详情
	  Map<String, Object> comment = commentService.getCommentByCid(cid);
	  System.out.println("影评详情页面之影评人"+comment); mv.addObject("comment", comment);
	  mv.addObject("mname",mname); return mv; }
	 
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

		//System.out.println("seen movies page===" + page);

		int pageSize = 6;
		PageHelper.startPage(1, pageSize);
		List<Map<String, Object>> comments = commentService.getAllHotComment();
		//PageInfo<Map<String, Object>> smPageInfo = new PageInfo<Map<String, Object>>(comments);

		String jsonSMPageInfo = JSON.toJSONString(comments);
		//System.out.println("热门影评jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
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
	public String showNewComment() {

		//System.out.println("seen movies page===" + page);

		int pageSize = 6;
		PageHelper.startPage(1, pageSize);
		List<Map<String, Object>> comments = commentService.getAllNewComment();
		//PageInfo<Map<String, Object>> smPageInfo = new PageInfo<Map<String, Object>>(comments);

		String jsonSMPageInfo = JSON.toJSONString(comments);
		System.out.println("新片影评jsonSMPageInfo====" + jsonSMPageInfo);
		return jsonSMPageInfo;
	}

}
