package com.love.movie.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.movie.mapper.CustomedSakuraMovieMapper;
import com.love.movie.mapper.MovieMapper;
import com.love.movie.model.Movie;
import com.love.movie.service.SakuraMovieService;


@Service("sakuraMovieServiceId")
public class SakuraMovieServiceImpl implements SakuraMovieService {

	@Autowired 
	private MovieMapper movieMapper;
	
	@Autowired
	private CustomedSakuraMovieMapper csMovieMapper;
	

	/**
	 * 根据mid获取电影信息
	 * 
	 * @param mid
	 * @return
	 */
	@Override
	public Movie getMovieByMid(int mid) {
		return movieMapper.selectByPrimaryKey(mid);
	}
	
	
	@Override
	public List<Map<String, Object>> getHotMovies() {
		return csMovieMapper.getHotMovies();
	}


	@Override
	public List<Map<String, Object>> getNewMovies() {
		return csMovieMapper.getNewMovies();
	}


	@Override
	public List<Map<String, Object>> getClassicMovies() {
		return csMovieMapper.getClassicMovies();
	}


	@Override
	public List<Map<String, Object>> getPalyableMovies() {
		return csMovieMapper.getPalyableMovies();
	}


	@Override
	public List<Map<String, Object>> getHighScoreMovies() {
		return csMovieMapper.getHighScoreMovies();
	}


	@Override
	public List<Map<String, Object>> getDarkHorseMovies() {
		return csMovieMapper.getDarkHorseMovies();
	}


	@Override
	public List<Map<String, Object>> getChineseMovies() {
		return csMovieMapper.getChineseMovies();
	}


	@Override
	public List<Map<String, Object>> getKoreanMovies() {
		return csMovieMapper.getKoreanMovies();
	}


	@Override
	public List<Map<String, Object>> getEuropeanAndAmericanMovies() {
		return csMovieMapper.getEuropeanAndAmericanMovies();
	}


	@Override
	public List<Map<String, Object>> getJapaneseMovies() {
		return csMovieMapper.getJapaneseMovies();
	}


	@Override
	public List<Map<String, Object>> getActionMovies() {
		return csMovieMapper.getActionMovies();
	}

	@Override
	public List<Map<String, Object>> getComedyMovies() {
		return csMovieMapper.getComedyMovies();
	}


	@Override
	public List<Map<String, Object>> getLoveMovies() {
		return csMovieMapper.getLoveMovies();
	}


	@Override
	public List<Map<String, Object>> getScienceFictionMovies() {
		return csMovieMapper.getScienceFictionMovies();
	}


	@Override
	public List<Map<String, Object>> getCartoonMovies() {
		return csMovieMapper.getCartoonMovies();
	}


	@Override
	public List<Map<String, Object>> getSuspenseMovies() {
		return csMovieMapper.getSuspenseMovies();
	}


	@Override
	public List<Map<String, Object>> getHorribleMovies() {
		return csMovieMapper.getHorribleMovies();
	}
	
	
}
