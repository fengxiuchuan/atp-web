package org.codingworld.time.entity.member;

import java.io.Serializable;

import org.codingworld.time.dto.base.request.BasePageRequest;

import java.util.Date;

/**
 * @Description: AtpMemberentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:29
 */
public class AtpMember extends BasePageRequest implements Serializable {

    /**
     * 主键 
     */
    private Long id;
    /**
     * 姓名 
     */
    private String name;
    /**
     * 性别(0:男；1女) 
     */
    private Boolean sex;
    /**
     * 年龄 
     */
    private Boolean age;
    /**
     * 联系方式 
     */
    private String phone;
    /**
     * 联系地址 
     */
    private String address;
    /**
     * 备注 
     */
    private String remark;
    /**
     * 会员编号 
     */
    private String cardNo;
    /**
     * 会员密码 
     */
    private String cardPwd;
    /**
     * 创建人 
     */
    private Long createdBy;
    /**
     * 创建人名称 
     */
    private String createdName;
    /**
     * 创建时间 
     */
    private Date createdTime;
    /**
     * 更新人 
     */
    private Long lastUpdatedBy;
    /**
     * 更新人名称 
     */
    private String lastUpdatedName;
    /**
     * 最后更新时间 
     */
    private Date lastUpdatedTime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getSex() {
        return this.sex;
    }
    public void setAge(Boolean age) {
        this.age = age;
    }

    public Boolean getAge() {
        return this.age;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return this.cardNo;
    }
    public void setCardPwd(String cardPwd) {
        this.cardPwd = cardPwd;
    }

    public String getCardPwd() {
        return this.cardPwd;
    }
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }
    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public String getCreatedName() {
        return this.createdName;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }
    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Long getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }
    public void setLastUpdatedName(String lastUpdatedName) {
        this.lastUpdatedName = lastUpdatedName;
    }

    public String getLastUpdatedName() {
        return this.lastUpdatedName;
    }
    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public Date getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }
}

