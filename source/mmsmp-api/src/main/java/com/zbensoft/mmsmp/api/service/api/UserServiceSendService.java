package com.zbensoft.mmsmp.api.service.api;

import java.util.List;

import com.zbensoft.mmsmp.db.domain.UserServiceSend;

public interface UserServiceSendService {
	/**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_service_send
     *
     * @mbg.generated Mon Aug 27 11:26:29 CST 2018
     */
    int deleteByPrimaryKey(String userServiceSendId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_service_send
     *
     * @mbg.generated Mon Aug 27 11:26:29 CST 2018
     */
    int insert(UserServiceSend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_service_send
     *
     * @mbg.generated Mon Aug 27 11:26:29 CST 2018
     */
    int insertSelective(UserServiceSend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_service_send
     *
     * @mbg.generated Mon Aug 27 11:26:29 CST 2018
     */
    UserServiceSend selectByPrimaryKey(String userServiceSendId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_service_send
     *
     * @mbg.generated Mon Aug 27 11:26:29 CST 2018
     */
    int updateByPrimaryKeySelective(UserServiceSend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_service_send
     *
     * @mbg.generated Mon Aug 27 11:26:29 CST 2018
     */
    int updateByPrimaryKey(UserServiceSend record);
    
    List<UserServiceSend> selectPage(UserServiceSend record);
    
    int count(UserServiceSend record);
}
