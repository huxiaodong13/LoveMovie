package com.love.movie.mapper;

import com.love.movie.model.Storeup;
import com.love.movie.model.StoreupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreupMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table storeup
	 * @mbg.generated  Wed Jun 26 10:52:09 CST 2019
	 */
	long countByExample(StoreupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table storeup
	 * @mbg.generated  Wed Jun 26 10:52:09 CST 2019
	 */
	int deleteByExample(StoreupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table storeup
	 * @mbg.generated  Wed Jun 26 10:52:09 CST 2019
	 */
	int deleteByPrimaryKey(Integer sid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table storeup
	 * @mbg.generated  Wed Jun 26 10:52:09 CST 2019
	 */
	int insert(Storeup record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table storeup
	 * @mbg.generated  Wed Jun 26 10:52:09 CST 2019
	 */
	int insertSelective(Storeup record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table storeup
	 * @mbg.generated  Wed Jun 26 10:52:09 CST 2019
	 */
	List<Storeup> selectByExample(StoreupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table storeup
	 * @mbg.generated  Wed Jun 26 10:52:09 CST 2019
	 */
	Storeup selectByPrimaryKey(Integer sid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table storeup
	 * @mbg.generated  Wed Jun 26 10:52:09 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Storeup record, @Param("example") StoreupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table storeup
	 * @mbg.generated  Wed Jun 26 10:52:09 CST 2019
	 */
	int updateByExample(@Param("record") Storeup record, @Param("example") StoreupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table storeup
	 * @mbg.generated  Wed Jun 26 10:52:09 CST 2019
	 */
	int updateByPrimaryKeySelective(Storeup record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table storeup
	 * @mbg.generated  Wed Jun 26 10:52:09 CST 2019
	 */
	int updateByPrimaryKey(Storeup record);
}