package com.love.movie.mapper;

import com.love.movie.model.UlevelExample;
import com.love.movie.model.UlevelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UlevelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ulevel
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	long countByExample(UlevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ulevel
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int deleteByExample(UlevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ulevel
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int deleteByPrimaryKey(UlevelKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ulevel
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int insert(UlevelKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ulevel
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int insertSelective(UlevelKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ulevel
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	List<UlevelKey> selectByExample(UlevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ulevel
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int updateByExampleSelective(@Param("record") UlevelKey record, @Param("example") UlevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ulevel
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	int updateByExample(@Param("record") UlevelKey record, @Param("example") UlevelExample example);
}