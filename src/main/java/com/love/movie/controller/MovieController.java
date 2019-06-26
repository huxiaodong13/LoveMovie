package com.love.movie.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.movie.model.Movie;
import com.love.movie.service.CommentService;
import com.love.movie.service.MovieService;

@Controller
@RequestMapping("movie")
public class MovieController {
	@Autowired
	private MovieService movieService;
	@Autowired 
	private CommentService commentService;
		
	@RequestMapping("movieDetail")
	public ModelAndView movieDetail(int mid) {
		ModelAndView mv = null;
		Movie movie = movieService.getMovieById(mid);
		if(movie != null) {
			mv = new ModelAndView("moviedetails");
			mv.addObject("movie",movie);

			List<Map<String, Object>>  commentsList = commentService.getCommentByMid(mid);
			if(commentsList != null) {
				for(Map<String, Object> c : commentsList) {
					System.out.println(" mid的影评======================");
					System.out.println(c);
					System.out.println("======================");
				}
				mv.addObject("commentsList",commentsList);
			}else {
				System.out.println("还未有用户评论");
				mv.addObject("commentsList","还未有用户评论");
			}
			
		}else {
			mv = new ModelAndView("findError");
		}
		
		mv.addObject("isLogin", false);
		
		return mv;
	}

	
}
