package com.zbensoft.mmsmp.db.domain;

public class TaskInstance {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_instance.task_instance_id
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    private String taskInstanceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_instance.task_id
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    private String taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_instance.status
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_instance.progress
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    private Integer progress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_instance.message
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    private String message;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_instance.remark
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    private String remark;
    private String name;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_instance.task_instance_id
     *
     * @return the value of task_instance.task_instance_id
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    public String getTaskInstanceId() {
        return taskInstanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_instance.task_instance_id
     *
     * @param taskInstanceId the value for task_instance.task_instance_id
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    public void setTaskInstanceId(String taskInstanceId) {
        this.taskInstanceId = taskInstanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_instance.task_id
     *
     * @return the value of task_instance.task_id
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_instance.task_id
     *
     * @param taskId the value for task_instance.task_id
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_instance.status
     *
     * @return the value of task_instance.status
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_instance.status
     *
     * @param status the value for task_instance.status
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_instance.progress
     *
     * @return the value of task_instance.progress
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    public Integer getProgress() {
        return progress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_instance.progress
     *
     * @param progress the value for task_instance.progress
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_instance.message
     *
     * @return the value of task_instance.message
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_instance.message
     *
     * @param message the value for task_instance.message
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_instance.remark
     *
     * @return the value of task_instance.remark
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_instance.remark
     *
     * @param remark the value for task_instance.remark
     *
     * @mbg.generated Mon Jun 19 16:16:12 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}