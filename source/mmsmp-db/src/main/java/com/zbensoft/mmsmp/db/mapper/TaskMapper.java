package com.zbensoft.mmsmp.db.mapper;

import java.util.List;

import com.zbensoft.mmsmp.db.domain.Task;

public interface TaskMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated Mon Jun 19 14:47:04 CST 2017
     */
    int deleteByPrimaryKey(String taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated Mon Jun 19 14:47:04 CST 2017
     */
    int insert(Task record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated Mon Jun 19 14:47:04 CST 2017
     */
    int insertSelective(Task record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated Mon Jun 19 14:47:04 CST 2017
     */
    Task selectByPrimaryKey(String taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated Mon Jun 19 14:47:04 CST 2017
     */
    int updateByPrimaryKeySelective(Task record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated Mon Jun 19 14:47:04 CST 2017
     */
    int updateByPrimaryKey(Task record);
    int deleteAll();
	int count(Task task);
	Task selectByTaskName(String name);
	List<Task> selectPage(Task record);
	boolean isExist(Task task);
}