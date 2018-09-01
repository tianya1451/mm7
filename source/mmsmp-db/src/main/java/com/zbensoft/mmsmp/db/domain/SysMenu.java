package com.zbensoft.mmsmp.db.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class SysMenu{
	@NotEmpty(message="{sysMenu.menuId.notEmpty.message}")
	@Length(max=13,message="{sysMenu.menuId.length}")
    private String menuId;
	@NotEmpty(message="{sysMenu.menuKeyWord.notEmpty.message}")
	@Length(max=10,message="{sysMenu.menuKeyWord.length}")
    private String menuKeyWord;
	@NotEmpty(message="{sysMenu.menuSortno.notEmpty.message}")
	@Length(max=10,message="{sysMenu.menuSortno.length}")
    private Integer menuSortno;

    private String menuPic;
	@NotEmpty(message="{sysMenu.menuType.notEmpty.message}")
	@Length(max=10,message="{sysMenu.menuType.length}")
    private String menuType;
	@NotEmpty(message="{sysMenu.preMenuId.notEmpty.message}")
	@Length(max=10,message="{sysMenu.preMenuId.length}")
    private String preMenuId;
    private String menuProces;
	@NotEmpty(message="{sysMenu.remark.notEmpty.message}")
	@Length(max=23,message="{sysMenu.remark.length}")
    private String remark;
    private String menuNameCn;


    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.menu_name_en
     *
     * @mbg.generated Tue Sep 19 10:07:01 CST 2017
     */
    private String menuNameEn;
    


    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.menu_name_es
     *
     * @mbg.generated Tue Sep 19 10:07:01 CST 2017
     */
    private String menuNameEs;

	//用于展示ztree时使用。切勿删除
	private String parentName;
	private String roleId;
	private String rescId;
	
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuKeyWord() {
		return menuKeyWord;
	}
	public void setMenuKeyWord(String menuKeyWord) {
		this.menuKeyWord = menuKeyWord;
	}
	public Integer getMenuSortno() {
		return menuSortno;
	}
	public void setMenuSortno(Integer menuSortno) {
		this.menuSortno = menuSortno;
	}

	public String getMenuPic() {
		return menuPic;
	}
	public void setMenuPic(String menuPic) {
		this.menuPic = menuPic;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getPreMenuId() {
		return preMenuId;
	}
	public void setPreMenuId(String preMenuId) {
		this.preMenuId = preMenuId;
	}
	public String getMenuProces() {
		return menuProces;
	}
	public void setMenuProces(String menuProces) {
		this.menuProces = menuProces;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRescId() {
		return rescId;
	}
	public void setRescId(String rescId) {
		this.rescId = rescId;
	}
	public String getMenuNameCn() {
		return menuNameCn;
	}
	public void setMenuNameCn(String menuNameCn) {
		this.menuNameCn = menuNameCn;
	}
	public String getMenuNameEn() {
		return menuNameEn;
	}
	public void setMenuNameEn(String menuNameEn) {
		this.menuNameEn = menuNameEn;
	}
	public String getMenuNameEs() {
		return menuNameEs;
	}
	public void setMenuNameEs(String menuNameEs) {
		this.menuNameEs = menuNameEs;
	}


  
}