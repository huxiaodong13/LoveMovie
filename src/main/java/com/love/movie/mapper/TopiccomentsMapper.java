package com.love.movie.mapper;

import com.love.movie.model.Topiccoments;
import com.love.movie.model.TopiccomentsExample;
import com.love.movie.model.TopiccomentsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopiccomentsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    long countByExample(TopiccomentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int deleteByExample(TopiccomentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int deleteByPrimaryKey(TopiccomentsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int insert(Topiccoments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int insertSelective(Topiccoments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    List<Topiccoments> selectByExampleWithBLOBs(TopiccomentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    List<Topiccoments> selectByExample(TopiccomentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    Topiccoments selectByPrimaryKey(TopiccomentsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int updateByExampleSelective(@Param("record") Topiccoments record, @Param("example") TopiccomentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") Topiccoments record, @Param("example") TopiccomentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int updateByExample(@Param("record") Topiccoments record, @Param("example") TopiccomentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int updateByPrimaryKeySelective(Topiccoments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Topiccoments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topiccoments
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    int updateByPrimaryKey(Topiccoments record);
}