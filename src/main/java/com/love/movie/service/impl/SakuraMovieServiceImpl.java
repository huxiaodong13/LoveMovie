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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getClassicMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getPalyableMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getHighScoreMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getDarkHorseMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getChineseMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getKoreanMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getEuropeanAndAmericanMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getJapaneseMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getActionMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getComedyMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getLoveMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getScienceFictionMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getCureMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getSuspenseMovies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> getHorribleMovies() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
