package com.love.movie.mapper;

import com.love.movie.model.Level;
import com.love.movie.model.LevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LevelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table level
	 * @mbg.generated  Mon Jun 24 11:18:24 CST 2019
	 */
	long countByExample(LevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table level
	 * @mbg.generated  Mon Jun 24 11:18:24 CST 2019
	 */
	int deleteByExample(LevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table level
	 * @mbg.generated  Mon Jun 24 11:18:24 CST 2019
	 */
	int deleteByPrimaryKey(Integer lid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table level
	 * @mbg.generated  Mon Jun 24 11:18:24 CST 2019
	 */
	int insert(Level record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table level
	 * @mbg.generated  Mon Jun 24 11:18:24 CST 2019
	 */
	int insertSelective(Level record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table level
	 * @mbg.generated  Mon Jun 24 11:18:24 CST 2019
	 */
	List<Level> selectByExample(LevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table level
	 * @mbg.generated  Mon Jun 24 11:18:24 CST 2019
	 */
	Level selectByPrimaryKey(Integer lid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table level
	 * @mbg.generated  Mon Jun 24 11:18:24 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Level record, @Param("example") LevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table level
	 * @mbg.generated  Mon Jun 24 11:18:24 CST 2019
	 */
	int updateByExample(@Param("record") Level record, @Param("example") LevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table level
	 * @mbg.generated  Mon Jun 24 11:18:24 CST 2019
	 */
	int updateByPrimaryKeySelective(Level record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table level
	 * @mbg.generated  Mon Jun 24 11:18:24 CST 2019
	 */
	int updateByPrimaryKey(Level record);
}