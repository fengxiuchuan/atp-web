package com.atp.entity.sys;

import com.atp.dto.base.request.BasePageRequest;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description: SysMenuentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:45
 */
public class SysMenu extends BasePageRequest implements Serializable {

    /**
     * 主键 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * url 
     */
    private String url;
    /**
     * router path 
     */
    private String path;
    /**
     * 组件名称（用于加载） 
     */
    private String component;
    /**
     * 组件中文名 
     */
    private String name;
    /**
     * icon类名 
     */
    private String iconCls;
    /**
     * keepAlive 
     */
    private Boolean keepAlive;
    /**
     * requireAuth 
     */
    private Boolean requireAuth;
    /**
     * 父级ID 
     */
    private Long parentId;
    /**
     * enabled 
     */
    private Boolean enabled;
    /**
     * 资源类型(menu:菜单;btn:按钮) 
     */
    private String menuType;
    /**
     * 资源树级别
     */
    private Integer level;
    /**
     * 资源全路径
     */
    private String menuPath;
    /**
     * 排序
     */
    private Integer sort;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
    public void setComponent(String component) {
        this.component = component;
    }

    public String getComponent() {
        return this.component;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getIconCls() {
        return this.iconCls;
    }
    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getKeepAlive() {
        return this.keepAlive;
    }
    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }

    public Boolean getRequireAuth() {
        return this.requireAuth;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }
    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuType() {
        return this.menuType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}

