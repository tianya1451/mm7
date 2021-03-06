package com.zbensoft.mmsmp.db.domain;

public class StSuccRatio extends StSuccRatioKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column st_succ_ratio.recv_sms_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    private Double recvSmsNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column st_succ_ratio.send_sms_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    private Double sendSmsNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column st_succ_ratio.sms_gateway_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    private Double smsGatewayNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column st_succ_ratio.sms_user_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    private Double smsUserNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column st_succ_ratio.send_mms_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    private Double sendMmsNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column st_succ_ratio.mms_gateway_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    private Double mmsGatewayNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column st_succ_ratio.mms_user_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    private Double mmsUserNum;
    
    private Double userNum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column st_succ_ratio.recv_sms_num
     *
     * @return the value of st_succ_ratio.recv_sms_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    private String productName;
    private String provinceName;
    private Double userSuccRate;
    private String stTimeStart;
    private String stTimeEnd;
    public Double getRecvSmsNum() {
        return recvSmsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column st_succ_ratio.recv_sms_num
     *
     * @param recvSmsNum the value for st_succ_ratio.recv_sms_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public void setRecvSmsNum(Double recvSmsNum) {
        this.recvSmsNum = recvSmsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column st_succ_ratio.send_sms_num
     *
     * @return the value of st_succ_ratio.send_sms_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public Double getSendSmsNum() {
        return sendSmsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column st_succ_ratio.send_sms_num
     *
     * @param sendSmsNum the value for st_succ_ratio.send_sms_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public void setSendSmsNum(Double sendSmsNum) {
        this.sendSmsNum = sendSmsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column st_succ_ratio.sms_gateway_num
     *
     * @return the value of st_succ_ratio.sms_gateway_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public Double getSmsGatewayNum() {
        return smsGatewayNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column st_succ_ratio.sms_gateway_num
     *
     * @param smsGatewayNum the value for st_succ_ratio.sms_gateway_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public void setSmsGatewayNum(Double smsGatewayNum) {
        this.smsGatewayNum = smsGatewayNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column st_succ_ratio.sms_user_num
     *
     * @return the value of st_succ_ratio.sms_user_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public Double getSmsUserNum() {
        return smsUserNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column st_succ_ratio.sms_user_num
     *
     * @param smsUserNum the value for st_succ_ratio.sms_user_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public void setSmsUserNum(Double smsUserNum) {
        this.smsUserNum = smsUserNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column st_succ_ratio.send_mms_num
     *
     * @return the value of st_succ_ratio.send_mms_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public Double getSendMmsNum() {
        return sendMmsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column st_succ_ratio.send_mms_num
     *
     * @param sendMmsNum the value for st_succ_ratio.send_mms_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public void setSendMmsNum(Double sendMmsNum) {
        this.sendMmsNum = sendMmsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column st_succ_ratio.mms_gateway_num
     *
     * @return the value of st_succ_ratio.mms_gateway_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public Double getMmsGatewayNum() {
        return mmsGatewayNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column st_succ_ratio.mms_gateway_num
     *
     * @param mmsGatewayNum the value for st_succ_ratio.mms_gateway_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public void setMmsGatewayNum(Double mmsGatewayNum) {
        this.mmsGatewayNum = mmsGatewayNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column st_succ_ratio.mms_user_num
     *
     * @return the value of st_succ_ratio.mms_user_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public Double getMmsUserNum() {
        return mmsUserNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column st_succ_ratio.mms_user_num
     *
     * @param mmsUserNum the value for st_succ_ratio.mms_user_num
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    public void setMmsUserNum(Double mmsUserNum) {
        this.mmsUserNum = mmsUserNum;
    }

	public Double getUserNum() {
		return userNum;
	}

	public void setUserNum(Double userNum) {
		this.userNum = userNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Double getUserSuccRate() {
		return userSuccRate;
	}

	public void setUserSuccRate(Double userSuccRate) {
		this.userSuccRate = userSuccRate;
	}

	public String getStTimeStart() {
		return stTimeStart;
	}

	public void setStTimeStart(String stTimeStart) {
		this.stTimeStart = stTimeStart;
	}

	public String getStTimeEnd() {
		return stTimeEnd;
	}

	public void setStTimeEnd(String stTimeEnd) {
		this.stTimeEnd = stTimeEnd;
	}
}