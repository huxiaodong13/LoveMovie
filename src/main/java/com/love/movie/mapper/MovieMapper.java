package com.love.movie.mapper;

import com.love.movie.model.Movie;
import com.love.movie.model.MovieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	long countByExample(MovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int deleteByExample(MovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int deleteByPrimaryKey(Integer mid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int insert(Movie record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int insertSelective(Movie record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	List<Movie> selectByExampleWithBLOBs(MovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	List<Movie> selectByExample(MovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	Movie selectByPrimaryKey(Integer mid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int updateByExampleWithBLOBs(@Param("record") Movie record, @Param("example") MovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int updateByPrimaryKeySelective(Movie record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int updateByPrimaryKeyWithBLOBs(Movie record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int updateByPrimaryKey(Movie record);
}