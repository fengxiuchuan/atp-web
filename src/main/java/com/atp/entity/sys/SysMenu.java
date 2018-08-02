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
    private Integer id;
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
    private Integer parentId;
    /**
     * enabled 
     */
    private Boolean enabled;
    /**
     * 资源类型(menu:菜单;btn:按钮) 
     */
    private String menuType;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
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
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return this.parentId;
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

    private SysMenu sysMenu;

    public void setSysMenu(SysMenu sysMenu){
        this.sysMenu = sysMenu;
    }

    public SysMenu getSysMenu() {
        return sysMenu;
    }
}

