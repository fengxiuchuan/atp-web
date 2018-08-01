package com.atp.entity.sys;

import java.io.Serializable;

/**
 * @Description: SysRoleentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:46
 */
public class SysRole  implements Serializable {

    /**
     * 主键 
     */
    private Long id;
    /**
     * 角色编码 
     */
    private String roleCode;
    /**
     * 角色名称 
     */
    private String roleName;
    /**
     * 描述 
     */
    private String roleDesc;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleCode() {
        return this.roleCode;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return this.roleName;
    }
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleDesc() {
        return this.roleDesc;
    }
}

