package com.zbensoft.mmsmp.db.domain;

/**
 * 
 * @author xieqiang
 *
 */
public class UserRsetPassword {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consumer_user.user_id
     *
     * @mbg.generated Wed Jun 07 15:37:39 CST 2017
     */
    private String userId;

    private String password;

	private String newPassword;
	
	private String confirmPassword;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}