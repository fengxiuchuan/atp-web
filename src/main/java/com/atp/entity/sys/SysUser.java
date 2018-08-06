package com.atp.entity.sys;

import com.atp.dto.base.request.BasePageRequest;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description: SysUserentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
public class SysUser  extends BasePageRequest implements Serializable {

    /**
     * 主键 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 用户名 
     */
    private String userName;
    /**
     * 密码(加密) 
     */
    private String userPwd;
    /**
     * 是否有效(1:是，0:否) 
     */
    private Boolean enabled;
    /**
     * 联系方式 
     */
    private String phone;
    /**
     * 用户头像 
     */
    private String faceImg;
    /**
     * 备注 
     */
    private String remark;
    /**
     * 用户姓名
     */
    private String displayName;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPwd() {
        return this.userPwd;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getFaceImg() {
        return this.faceImg;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}

