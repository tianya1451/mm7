package com.zbensoft.mmsmp.db.mapper;

import java.util.List;

import com.zbensoft.mmsmp.db.domain.ContentSensitiveWord;

public interface ContentSensitiveWordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_sensitive_word
     *
     * @mbg.generated Fri Aug 24 15:18:19 CST 2018
     */
    int deleteByPrimaryKey(String contentSensitiveWordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_sensitive_word
     *
     * @mbg.generated Fri Aug 24 15:18:19 CST 2018
     */
    int insert(ContentSensitiveWord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_sensitive_word
     *
     * @mbg.generated Fri Aug 24 15:18:19 CST 2018
     */
    int insertSelective(ContentSensitiveWord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_sensitive_word
     *
     * @mbg.generated Fri Aug 24 15:18:19 CST 2018
     */
    ContentSensitiveWord selectByPrimaryKey(String contentSensitiveWordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_sensitive_word
     *
     * @mbg.generated Fri Aug 24 15:18:19 CST 2018
     */
    int updateByPrimaryKeySelective(ContentSensitiveWord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_sensitive_word
     *
     * @mbg.generated Fri Aug 24 15:18:19 CST 2018
     */
    int updateByPrimaryKey(ContentSensitiveWord record);

	List<ContentSensitiveWord> selectPage(ContentSensitiveWord record);

	int count(ContentSensitiveWord record);
}