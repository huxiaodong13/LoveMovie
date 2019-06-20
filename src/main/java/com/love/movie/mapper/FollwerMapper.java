package com.love.movie.mapper;

import com.love.movie.model.FollwerExample;
import com.love.movie.model.FollwerKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FollwerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follwer
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    long countByExample(FollwerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follwer
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int deleteByExample(FollwerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follwer
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int deleteByPrimaryKey(FollwerKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follwer
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int insert(FollwerKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follwer
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int insertSelective(FollwerKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follwer
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    List<FollwerKey> selectByExample(FollwerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follwer
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int updateByExampleSelective(@Param("record") FollwerKey record, @Param("example") FollwerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follwer
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int updateByExample(@Param("record") FollwerKey record, @Param("example") FollwerExample example);
}