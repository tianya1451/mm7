package com.zbensoft.mmsmp.db.domain;

public class AlarmLevel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm_level.alarm_level_code
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    private String alarmLevelCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm_level.name
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm_level.remark
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm_level.alarm_level_code
     *
     * @return the value of alarm_level.alarm_level_code
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    public String getAlarmLevelCode() {
        return alarmLevelCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm_level.alarm_level_code
     *
     * @param alarmLevelCode the value for alarm_level.alarm_level_code
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    public void setAlarmLevelCode(String alarmLevelCode) {
        this.alarmLevelCode = alarmLevelCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm_level.name
     *
     * @return the value of alarm_level.name
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm_level.name
     *
     * @param name the value for alarm_level.name
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm_level.remark
     *
     * @return the value of alarm_level.remark
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm_level.remark
     *
     * @param remark the value for alarm_level.remark
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}