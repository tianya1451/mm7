package com.zbensoft.mmsmp.api.service.api;

import java.util.List;

import com.zbensoft.mmsmp.db.domain.SysRole;
import com.zbensoft.mmsmp.db.domain.SysRoleMenu;
import com.zbensoft.mmsmp.db.domain.SysRoleMenuKey;

public interface SysRoleMenuService {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_role_menu
	 * 
	 * @mbg.generated Thu May 25 15:26:15 CST 2017
	 */
	int deleteByPrimaryKey(SysRoleMenuKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_role_menu
	 * 
	 * @mbg.generated Thu May 25 15:26:15 CST 2017
	 */
	int insert(SysRoleMenu record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_role_menu
	 * 
	 * @mbg.generated Thu May 25 15:26:15 CST 2017
	 */
	int insertSelective(SysRoleMenu record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_role_menu
	 * 
	 * @mbg.generated Thu May 25 15:26:15 CST 2017
	 */
	SysRoleMenu selectByPrimaryKey(SysRoleMenuKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_role_menu
	 * 
	 * @mbg.generated Thu May 25 15:26:15 CST 2017
	 */
	int updateByPrimaryKeySelective(SysRoleMenu record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_role_menu
	 * 
	 * @mbg.generated Thu May 25 15:26:15 CST 2017
	 */
	int updateByPrimaryKey(SysRoleMenu record);

	List<SysRoleMenu> selectPage(SysRoleMenu record);

boolean isRoleExist(SysRoleMenu roleMenu);
	void deleteAll();
	int count(SysRoleMenu roleMenu);
}