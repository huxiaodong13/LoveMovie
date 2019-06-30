package com.love.movie.mapper;

import com.love.movie.model.Reply;
import com.love.movie.model.ReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	long countByExample(ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	int deleteByExample(ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	int deleteByPrimaryKey(Integer rid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	int insert(Reply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	int insertSelective(Reply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	List<Reply> selectByExampleWithBLOBs(ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	List<Reply> selectByExample(ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	Reply selectByPrimaryKey(Integer rid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Reply record, @Param("example") ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	int updateByExampleWithBLOBs(@Param("record") Reply record, @Param("example") ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	int updateByExample(@Param("record") Reply record, @Param("example") ReplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	int updateByPrimaryKeySelective(Reply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	int updateByPrimaryKeyWithBLOBs(Reply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table reply
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	int updateByPrimaryKey(Reply record);
}