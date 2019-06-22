package com.love.movie.mapper;

import com.love.movie.model.Topic;
import com.love.movie.model.TopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	long countByExample(TopicExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	int deleteByExample(TopicExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	int deleteByPrimaryKey(Integer tid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	int insert(Topic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	int insertSelective(Topic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	List<Topic> selectByExampleWithBLOBs(TopicExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	List<Topic> selectByExample(TopicExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	Topic selectByPrimaryKey(Integer tid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Topic record, @Param("example") TopicExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	int updateByExampleWithBLOBs(@Param("record") Topic record, @Param("example") TopicExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	int updateByExample(@Param("record") Topic record, @Param("example") TopicExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	int updateByPrimaryKeySelective(Topic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	int updateByPrimaryKeyWithBLOBs(Topic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topic
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	int updateByPrimaryKey(Topic record);
}