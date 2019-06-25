package com.love.movie.mapper;

import com.love.movie.model.Wseenmovie;
import com.love.movie.model.WseenmovieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WseenmovieMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wseenmovie
     *
     * @mbg.generated Mon Jun 24 19:35:52 CST 2019
     */
    long countByExample(WseenmovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wseenmovie
     *
     * @mbg.generated Mon Jun 24 19:35:52 CST 2019
     */
    int deleteByExample(WseenmovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wseenmovie
     *
     * @mbg.generated Mon Jun 24 19:35:52 CST 2019
     */
    int deleteByPrimaryKey(Integer wseenmid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wseenmovie
     *
     * @mbg.generated Mon Jun 24 19:35:52 CST 2019
     */
    int insert(Wseenmovie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wseenmovie
     *
     * @mbg.generated Mon Jun 24 19:35:52 CST 2019
     */
    int insertSelective(Wseenmovie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wseenmovie
     *
     * @mbg.generated Mon Jun 24 19:35:52 CST 2019
     */
    List<Wseenmovie> selectByExample(WseenmovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wseenmovie
     *
     * @mbg.generated Mon Jun 24 19:35:52 CST 2019
     */
    Wseenmovie selectByPrimaryKey(Integer wseenmid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wseenmovie
     *
     * @mbg.generated Mon Jun 24 19:35:52 CST 2019
     */
    int updateByExampleSelective(@Param("record") Wseenmovie record, @Param("example") WseenmovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wseenmovie
     *
     * @mbg.generated Mon Jun 24 19:35:52 CST 2019
     */
    int updateByExample(@Param("record") Wseenmovie record, @Param("example") WseenmovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wseenmovie
     *
     * @mbg.generated Mon Jun 24 19:35:52 CST 2019
     */
    int updateByPrimaryKeySelective(Wseenmovie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wseenmovie
     *
     * @mbg.generated Mon Jun 24 19:35:52 CST 2019
     */
    int updateByPrimaryKey(Wseenmovie record);
}