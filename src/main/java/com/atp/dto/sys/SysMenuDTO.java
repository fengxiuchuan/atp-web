package com.atp.dto.sys;

import java.io.Serializable;
import java.util.List;

import com.atp.dto.DataTree;
import  com.atp.entity.sys.SysMenu;

/**
 * @Description: SysMenuentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:45
 */
public class SysMenuDTO extends SysMenu implements Serializable,DataTree<SysMenuDTO> {

    /**
     * 下级节点
     */
    private Boolean inEdit;

    /**
     * 下级节点
     */
    private List<SysMenuDTO> children;


    private String label;

    private String parentName;

    public List<SysMenuDTO> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenuDTO> children) {
        this.children = children;
    }

    @Override
    public void setChildList(List<SysMenuDTO> childList) {
        this.children = childList;
    }

    @Override
    public List<SysMenuDTO> getChildList() {
        return this.children;
    }

    public String getLabel() {
        return this.getName();
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}

