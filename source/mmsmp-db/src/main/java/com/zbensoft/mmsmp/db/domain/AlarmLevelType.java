package com.zbensoft.mmsmp.db.domain;

public class AlarmLevelType {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm_level_type.alarm_level_code
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    private String alarmLevelCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm_level_type.alarm_type_code
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    private String alarmTypeCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm_level_type.alarm_level_code
     *
     * @return the value of alarm_level_type.alarm_level_code
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    
    private String alarmLevelName;
    
    
    private String alarmTypeName;

	public String getAlarmLevelCode() {
        return alarmLevelCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm_level_type.alarm_level_code
     *
     * @param alarmLevelCode the value for alarm_level_type.alarm_level_code
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    public void setAlarmLevelCode(String alarmLevelCode) {
        this.alarmLevelCode = alarmLevelCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm_level_type.alarm_type_code
     *
     * @return the value of alarm_level_type.alarm_type_code
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    public String getAlarmTypeCode() {
        return alarmTypeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm_level_type.alarm_type_code
     *
     * @param alarmTypeCode the value for alarm_level_type.alarm_type_code
     *
     * @mbg.generated Fri Jun 09 15:47:28 CST 2017
     */
    public void setAlarmTypeCode(String alarmTypeCode) {
        this.alarmTypeCode = alarmTypeCode;
    }

	public String getAlarmLevelName() {
		return alarmLevelName;
	}

	public void setAlarmLevelName(String alarmLevelName) {
		this.alarmLevelName = alarmLevelName;
	}

	public String getAlarmTypeName() {
		return alarmTypeName;
	}

	public void setAlarmTypeName(String alarmTypeName) {
		this.alarmTypeName = alarmTypeName;
	}
}