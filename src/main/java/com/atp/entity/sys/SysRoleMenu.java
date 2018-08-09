package com.atp.entity.sys;

import java.io.Serializable;

/**
 * @Description: SysRoleMenuentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-08-09 17:04:19
 */
public class SysRoleMenu  implements Serializable {

    /**
     * 主键 
     */
    private Long id;
    /**
     * 角色编码 
     */
    private String roleCode;
    /**
     * 资源主键 
     */
    private Long menuId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getMenuId() {
        return this.menuId;
    }
}

