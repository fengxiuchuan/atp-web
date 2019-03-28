package com.atp.dto.sys;

import java.io.Serializable;
import java.util.List;

import  com.atp.entity.sys.SysRole;

/**
 * @Description: SysRoleentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:46
 */
public class SysRoleDTO extends SysRole implements Serializable {

    private String key;

    private String value;

    private String label;
    /**
     *  选中的菜单
     */
    private List<Long> menuIdList;



    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }

    public String getKey() {
        return this.getRoleCode();
    }


    public String getValue() {
        return this.getRoleCode();
    }

    public String getLabel() {
        return this.getRoleName();
    }
}

