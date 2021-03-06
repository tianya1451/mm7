package com.zbensoft.mmsmp.db.mapper;

import java.util.List;

import com.zbensoft.mmsmp.db.domain.ContentInfo;
import com.zbensoft.mmsmp.db.domain.SysLog;

public interface ContentInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table content_info
	 * @mbg.generated  Fri Aug 24 15:18:19 CST 2018
	 */
	int deleteByPrimaryKey(String contentInfoId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table content_info
	 * @mbg.generated  Fri Aug 24 15:18:19 CST 2018
	 */
	int insert(ContentInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table content_info
	 * @mbg.generated  Fri Aug 24 15:18:19 CST 2018
	 */
	int insertSelective(ContentInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table content_info
	 * @mbg.generated  Fri Aug 24 15:18:19 CST 2018
	 */
	ContentInfo selectByPrimaryKey(String contentInfoId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table content_info
	 * @mbg.generated  Fri Aug 24 15:18:19 CST 2018
	 */
	int updateByPrimaryKeySelective(ContentInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table content_info
	 * @mbg.generated  Fri Aug 24 15:18:19 CST 2018
	 */
	int updateByPrimaryKey(ContentInfo record);

	List<ContentInfo> selectPage(ContentInfo record);

	int count(ContentInfo record);
}