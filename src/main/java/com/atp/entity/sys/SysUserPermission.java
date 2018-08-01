package com.atp.entity.sys;

import java.io.Serializable;

/**
 * @Description: SysUserPermissionentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
public class SysUserPermission  implements Serializable {

    /**
     * 主键 
     */
    private Long id;
    /**
     * 用户主键 
     */
    private Long userId;
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
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getMenuId() {
        return this.menuId;
    }
}

