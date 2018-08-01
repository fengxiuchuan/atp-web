package com.atp.entity.sys;

import java.io.Serializable;

/**
 * @Description: SysUserRoleentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
public class SysUserRole  implements Serializable {

    /**
     * 主键 
     */
    private Long id;
    /**
     * 用户主键 
     */
    private Long userId;
    /**
     * 角色编码 
     */
    private String roleCode;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleCode() {
        return this.roleCode;
    }
}

