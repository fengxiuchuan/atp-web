package com.atp.dto.sys;

import java.io.Serializable;
import  com.atp.entity.sys.SysUserRole;

/**
 * @Description: SysUserRoleentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
public class SysUserRoleDTO extends SysUserRole implements Serializable {

    private String roleCodes;

    public String getRoleCodes() {
        return roleCodes;
    }

    public void setRoleCodes(String roleCodes) {
        this.roleCodes = roleCodes;
    }
}

