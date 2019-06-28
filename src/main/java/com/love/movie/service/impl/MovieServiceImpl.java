package com.love.movie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.movie.mapper.CustomedMovieMapper;
import com.love.movie.mapper.MovieMapper;
import com.love.movie.mapper.ScoreMapper;
import com.love.movie.model.Movie;
import com.love.movie.model.Score;
import com.love.movie.service.MovieService;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	public MovieMapper movieMapper;

	@Autowired
	private ScoreMapper scoreMapper;

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
		// List<Map<String, Object>> moviesNewDate = movies.subList(0, 9);
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
		if (n >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delMovieByMid(int mid) {
		int n = movieMapper.deleteByPrimaryKey(mid);

		// 与该电影有关的影评信息也得删除
		if (n >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insertMovie(Movie movie) {
		// TODO Auto-generated method stub
		int n = movieMapper.insert(movie);
		if (n == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getAllNewDateMovie() {
		List<Map<String, Object>> movies = customedMovieMapper.getAllNewDateMovie();
		return movies;
	}

	@Override
	public List<Integer> getMovieScoreLevel(int mid) {
		
		List<Integer> countLevel = new ArrayList<Integer>();
		int level1 = customedMovieMapper.getMovieScoreLevel1Count(mid);
		int level2 = customedMovieMapper.getMovieScoreLevel2Count(mid);
		int level3 = customedMovieMapper.getMovieScoreLevel3Count(mid);
		int level4 = customedMovieMapper.getMovieScoreLevel4Count(mid);
		int level5 = customedMovieMapper.getMovieScoreLevel5Count(mid);
		
		
		Movie movie = movieMapper.selectByPrimaryKey(mid);
		int totalCount = movie.getMcount();
		
		System.out.println(level1+" "+level2+" "+totalCount);
		
		
		countLevel.add((int)Math.ceil( ( (double)level1/totalCount)*100 ) );
		countLevel.add((int)Math.ceil( ( (double)level2/totalCount)*100 ) );
		countLevel.add((int)Math.ceil( ( (double)level3/totalCount)*100 ) );
		countLevel.add((int)Math.ceil( ( (double)level4/totalCount)*100 ) );
		countLevel.add((int)Math.ceil( ( (double)level5/totalCount)*100 ) );
		
		
		return countLevel;
	}
	

	@Override
	public boolean modifyUserMovieScore(Score score) {
		
		Score findScore = customedMovieMapper.getScoreByMidAndUid(score);
		if(findScore == null) {
			System.out.println("用户未对该电影进行评分，现在进行评分");
			
			//更新movie表中评分人数和其得分数
			customedMovieMapper.addMovieCount(score.getMid());
			scoreMapper.insert(score);
			customedMovieMapper.modifyMovieScore(score.getMid());
		
		}else {
			//更新评分
			System.out.println("score++++====" + score);
			customedMovieMapper.modifyScoreByMidAndUid(score);
		}
		return true;
	}
}
