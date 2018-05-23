package org.codingworld.time.dto.base.request;


import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * BasePageRequest
 * @author xiaobotong
 * @version 1.00.00
 * 
 */
public class BasePageRequest implements Serializable{

	private static final long serialVersionUID = 2946171514847303726L;
	
	@Transient
	private String token;//用户TOKEN
	
	// 分页索引, 从1开始
	@Transient
	private Integer page = 1;
	
	/**
	 * 分页大小(支持不分页的查询，eg查询完整的表格树, 所以pageSize初始化为Null)
	 * 如因pageSize为null报异常，请先自行判断pageSize为什么会null
	 * 如果允许为null且数据量不大，则可不做分页查询只做排序PageHelper.orderby()
	 * 如果不允许为null且数据量很大，请问问为什么从前端请求时不传入分页参数pageSize?
	 */
	@Transient
	private Integer pageSize = 10; 
	
	/**
	 * 页面开始日期结束日期查询
	 */
	@Transient
	private String startDate;
	
	@Transient
	private String endDate;

	@Transient
	private String sortname;
	
	@Transient
	private String sortorder;
	
	/**
	 * 用于存放当前用户的所有信息
	 */
	@Transient
	private Map<String,Object> powerMap;
	

	/**
	 * 超级管理员用户ID
	 * @return
	 */
	@Transient
	private Integer superAdminUserId;
	
	@Transient
	private String  ldapAccount;//用户账号
	
	@Transient
	private String  userName;//用户名称
	
	@Transient
	private String allowSql;//许可权限sql
	
	@Transient
	private String exportHeadMap; //导出结果头部映射
	
	@Transient
	private String exportModule; /* 导出模块 */
	
	@Transient
	private String exportType; /* 导出类型 */


	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}
	
	public Map<String, Object> getPowerMap() {
		return powerMap;
	}

	public void setPowerMap(Map<String, Object> powerMap) {
		this.powerMap = powerMap;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOrderBy() {
		return sortname==null?"":sortname+" "+sortorder;
	}


	public Integer getSuperAdminUserId() {
		return superAdminUserId;
	}

	public void setSuperAdminUserId(Integer superAdminUserId) {
		this.superAdminUserId = superAdminUserId;
	}

	public String getLdapAccount() {
		return ldapAccount;
	}

	public void setLdapAccount(String ldapAccount) {
		this.ldapAccount = ldapAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAllowSql() {
		return allowSql;
	}

	public void setAllowSql(String allowSql) {
		this.allowSql = allowSql;
	}

	public String getExportHeadMap() {
		return exportHeadMap;
	}

	public void setExportHeadMap(String exportHeadMap) {
		this.exportHeadMap = exportHeadMap;
	}

	public String getExportModule() {
		return exportModule;
	}

	public void setExportModule(String exportModule) {
		this.exportModule = exportModule;
	}

	public String getExportType() {
		return exportType;
	}

	public void setExportType(String exportType) {
		this.exportType = exportType;
	}
	
}