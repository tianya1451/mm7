package com.zbensoft.mmsmp.api.service.api;

import java.util.List;

import com.zbensoft.mmsmp.db.domain.AlarmManger;

public interface AlarmMangerService {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table reconciliation_bath
	 *
	 * @mbg.generated Thu May 25 16:26:59 CST 2017
	 */
	int deleteByPrimaryKey(String alarmKey);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table reconciliation_bath
	 *
	 * @mbg.generated Thu May 25 16:26:59 CST 2017
	 */
	int insert(AlarmManger record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table reconciliation_bath
	 *
	 * @mbg.generated Thu May 25 16:26:59 CST 2017
	 */
	int insertSelective(AlarmManger record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table reconciliation_bath
	 *
	 * @mbg.generated Thu May 25 16:26:59 CST 2017
	 */
	AlarmManger selectByPrimaryKey(String alarmKey);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table reconciliation_bath
	 *
	 * @mbg.generated Thu May 25 16:26:59 CST 2017
	 */
	int updateByPrimaryKeySelective(AlarmManger record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table reconciliation_bath
	 *
	 * @mbg.generated Thu May 25 16:26:59 CST 2017
	 */
	int updateByPrimaryKey(AlarmManger record);

	List<AlarmManger> selectPage(AlarmManger record);

	void deleteAll();

	int count(AlarmManger alarmManger);

	List<AlarmManger> selectAll();
}