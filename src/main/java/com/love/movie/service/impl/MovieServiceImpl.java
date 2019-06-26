package com.love.movie.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.movie.mapper.CustomedMovieMapper;
import com.love.movie.mapper.MovieMapper;
import com.love.movie.model.Movie;
import com.love.movie.service.MovieService;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	public MovieMapper movieMapper;
	@Autowired
	private CustomedMovieMapper customedMovieMapper;
	
	@Override
	public List<Map<String, Object>> getAllMovie() {
		List<Map<String, Object>> movies = customedMovieMapper.getAllMovie();
		return movies;
	}

	@Override
	public Movie getMovieById(int mid) {
		Movie movie = movieMapper.selectByPrimaryKey(mid);
		return movie;
	}

	@Override
	public List<Map<String, Object>> getTopNewDateMovie() {
		List<Map<String, Object>> movies = customedMovieMapper.getNewDateMovie();
		//List<Map<String, Object>> moviesNewDate = movies.subList(0, 9);
		return movies;
	}

	@Override
	public List<Map<String, Object>> getTopClassicsMovie() {
		List<Map<String, Object>> movies = customedMovieMapper.getClassicsMovie();
		return movies;
	}

	@Override
	public List<Map<String, Object>> getColdMovie() {
		List<Map<String, Object>> movies = customedMovieMapper.getColdMovie();
		return movies;
	}

	@Override
	public List<Map<String, Object>> getScoreMovie() {
		List<Map<String, Object>> movies = customedMovieMapper.getScoreMovie();
		return movies;
	}

	@Override
	public List<Map<String, Object>> getHotMovie() {
		List<Map<String, Object>> movies = customedMovieMapper.getHotMovie();
		return movies;
	}

	@Override
	public List<Map<String, Object>> getMAllMovie() {
		List<Map<String, Object>> movies = customedMovieMapper.getMAllMovie();
		return movies;
	}

	@Override
	public boolean updateMovie(Movie movie) {
		int n = movieMapper.updateByPrimaryKeySelective(movie);
		if(n>=1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delMovieByMid(int mid) {
		int n = movieMapper.deleteByPrimaryKey(mid);
		
		//与该电影有关的影评信息也得删除
		if(n>=1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insertMovie(Movie movie) {
		// TODO Auto-generated method stub
		int n = movieMapper.insert(movie);
		if(n == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getAllNewDateMovie() {
		List<Map<String, Object>> movies = customedMovieMapper.getAllNewDateMovie();
		return movies;
	}

	
}
