package com.zbensoft.mmsmp.db.domain;

public class SysLog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.sys_log_id
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    private String sysLogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.oper_time
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    private String operTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.oper_user
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    private String operUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.oper_model
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    private Integer operModel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.oper_type
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    private Integer operType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.oper_content
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    private String operContent;
    
    
    //查询条件
    
    private String operateTimeStart;
    
    
    private String operateTimeEnd;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.sys_log_id
     *
     * @return the value of sys_log.sys_log_id
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    public String getSysLogId() {
        return sysLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.sys_log_id
     *
     * @param sysLogId the value for sys_log.sys_log_id
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    public void setSysLogId(String sysLogId) {
        this.sysLogId = sysLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.oper_time
     *
     * @return the value of sys_log.oper_time
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    public String getOperTime() {
        return operTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.oper_time
     *
     * @param operTime the value for sys_log.oper_time
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    public void setOperTime(String operTime) {
        this.operTime = operTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.oper_user
     *
     * @return the value of sys_log.oper_user
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    public String getOperUser() {
        return operUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.oper_user
     *
     * @param operUser the value for sys_log.oper_user
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.oper_model
     *
     * @return the value of sys_log.oper_model
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    public Integer getOperModel() {
        return operModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.oper_model
     *
     * @param operModel the value for sys_log.oper_model
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    public void setOperModel(Integer operModel) {
        this.operModel = operModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.oper_type
     *
     * @return the value of sys_log.oper_type
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    public Integer getOperType() {
        return operType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.oper_type
     *
     * @param operType the value for sys_log.oper_type
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.oper_content
     *
     * @return the value of sys_log.oper_content
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    public String getOperContent() {
        return operContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.oper_content
     *
     * @param operContent the value for sys_log.oper_content
     *
     * @mbg.generated Thu Jun 29 11:16:44 CST 2017
     */
    public void setOperContent(String operContent) {
        this.operContent = operContent;
    }

	public String getOperateTimeStart() {
		return operateTimeStart;
	}

	public void setOperateTimeStart(String operateTimeStart) {
		this.operateTimeStart = operateTimeStart;
	}

	public String getOperateTimeEnd() {
		return operateTimeEnd;
	}

	public void setOperateTimeEnd(String operateTimeEnd) {
		this.operateTimeEnd = operateTimeEnd;
	}
}