package com.atp.dto.sys;

import java.io.Serializable;
import java.util.List;

import  com.atp.entity.sys.SysUser;
import com.atp.entity.sys.SysUserRole;

import javax.persistence.Transient;

/**
 * @Description: SysUserentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
public class SysUserDTO extends SysUser implements Serializable {

    /**
     * 用户角色列表
     */
    private String [] userRoleArr;

    @Transient
    private List<SysUserRole> userRoleList;

    public String[] getUserRoleArr() {
        return userRoleArr;
    }

    public void setUserRoleArr(String[] userRoleArr) {
        this.userRoleArr = userRoleArr;
    }

    public List<SysUserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<SysUserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
}

