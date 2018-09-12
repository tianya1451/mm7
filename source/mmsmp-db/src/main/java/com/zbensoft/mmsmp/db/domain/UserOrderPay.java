package com.zbensoft.mmsmp.db.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserOrderPay {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.user_order_pay_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private String userOrderPayId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.phone_number
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private String phoneNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.sp_info_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private String spInfoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.product_info_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private String productInfoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.charge_phone_number
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private String chargePhoneNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.order_time
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.order_route
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private Integer orderRoute;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.order_type
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private Integer orderType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.fee
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private Double fee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.feature_str
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private String featureStr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.status
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.version
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private String version;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.not_disturb_time
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private String notDisturbTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.transaction_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private String transactionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.eff_time
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date effTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.area
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private String area;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.priority
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private Integer priority;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.last_batch_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private String lastBatchId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_order_pay.is_package
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    private Integer isPackage;
    private String provinceCityName;
    private String parentProvinceCityId;
    private String parentProvinceCityName;
    private String productName;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.user_order_pay_id
     *
     * @return the value of user_order_pay.user_order_pay_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public String getUserOrderPayId() {
        return userOrderPayId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.user_order_pay_id
     *
     * @param userOrderPayId the value for user_order_pay.user_order_pay_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setUserOrderPayId(String userOrderPayId) {
        this.userOrderPayId = userOrderPayId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.phone_number
     *
     * @return the value of user_order_pay.phone_number
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.phone_number
     *
     * @param phoneNumber the value for user_order_pay.phone_number
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.sp_info_id
     *
     * @return the value of user_order_pay.sp_info_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public String getSpInfoId() {
        return spInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.sp_info_id
     *
     * @param spInfoId the value for user_order_pay.sp_info_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setSpInfoId(String spInfoId) {
        this.spInfoId = spInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.product_info_id
     *
     * @return the value of user_order_pay.product_info_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public String getProductInfoId() {
        return productInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.product_info_id
     *
     * @param productInfoId the value for user_order_pay.product_info_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setProductInfoId(String productInfoId) {
        this.productInfoId = productInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.charge_phone_number
     *
     * @return the value of user_order_pay.charge_phone_number
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public String getChargePhoneNumber() {
        return chargePhoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.charge_phone_number
     *
     * @param chargePhoneNumber the value for user_order_pay.charge_phone_number
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setChargePhoneNumber(String chargePhoneNumber) {
        this.chargePhoneNumber = chargePhoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.order_time
     *
     * @return the value of user_order_pay.order_time
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.order_time
     *
     * @param orderTime the value for user_order_pay.order_time
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.order_route
     *
     * @return the value of user_order_pay.order_route
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public Integer getOrderRoute() {
        return orderRoute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.order_route
     *
     * @param orderRoute the value for user_order_pay.order_route
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setOrderRoute(Integer orderRoute) {
        this.orderRoute = orderRoute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.order_type
     *
     * @return the value of user_order_pay.order_type
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.order_type
     *
     * @param orderType the value for user_order_pay.order_type
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.fee
     *
     * @return the value of user_order_pay.fee
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public Double getFee() {
        return fee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.fee
     *
     * @param fee the value for user_order_pay.fee
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setFee(Double fee) {
        this.fee = fee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.feature_str
     *
     * @return the value of user_order_pay.feature_str
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public String getFeatureStr() {
        return featureStr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.feature_str
     *
     * @param featureStr the value for user_order_pay.feature_str
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setFeatureStr(String featureStr) {
        this.featureStr = featureStr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.status
     *
     * @return the value of user_order_pay.status
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.status
     *
     * @param status the value for user_order_pay.status
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.version
     *
     * @return the value of user_order_pay.version
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public String getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.version
     *
     * @param version the value for user_order_pay.version
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.not_disturb_time
     *
     * @return the value of user_order_pay.not_disturb_time
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public String getNotDisturbTime() {
        return notDisturbTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.not_disturb_time
     *
     * @param notDisturbTime the value for user_order_pay.not_disturb_time
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setNotDisturbTime(String notDisturbTime) {
        this.notDisturbTime = notDisturbTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.transaction_id
     *
     * @return the value of user_order_pay.transaction_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.transaction_id
     *
     * @param transactionId the value for user_order_pay.transaction_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.eff_time
     *
     * @return the value of user_order_pay.eff_time
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public Date getEffTime() {
        return effTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.eff_time
     *
     * @param effTime the value for user_order_pay.eff_time
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setEffTime(Date effTime) {
        this.effTime = effTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.area
     *
     * @return the value of user_order_pay.area
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.area
     *
     * @param area the value for user_order_pay.area
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.priority
     *
     * @return the value of user_order_pay.priority
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.priority
     *
     * @param priority the value for user_order_pay.priority
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.last_batch_id
     *
     * @return the value of user_order_pay.last_batch_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public String getLastBatchId() {
        return lastBatchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.last_batch_id
     *
     * @param lastBatchId the value for user_order_pay.last_batch_id
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setLastBatchId(String lastBatchId) {
        this.lastBatchId = lastBatchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_order_pay.is_package
     *
     * @return the value of user_order_pay.is_package
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public Integer getIsPackage() {
        return isPackage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_order_pay.is_package
     *
     * @param isPackage the value for user_order_pay.is_package
     *
     * @mbg.generated Mon Aug 27 14:33:07 CST 2018
     */
    public void setIsPackage(Integer isPackage) {
        this.isPackage = isPackage;
    }

	public String getProvinceCityName() {
		return provinceCityName;
	}

	public void setProvinceCityName(String provinceCityName) {
		this.provinceCityName = provinceCityName;
	}

	public String getParentProvinceCityId() {
		return parentProvinceCityId;
	}

	public void setParentProvinceCityId(String parentProvinceCityId) {
		this.parentProvinceCityId = parentProvinceCityId;
	}

	public String getParentProvinceCityName() {
		return parentProvinceCityName;
	}

	public void setParentProvinceCityName(String parentProvinceCityName) {
		this.parentProvinceCityName = parentProvinceCityName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
    
}