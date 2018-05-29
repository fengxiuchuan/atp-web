package com.atp.entity.base;

import com.atp.dto.base.request.BasePageRequest;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: AtpGymentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:10
 */
public class AtpGym extends BasePageRequest implements Serializable {

    /**
     * 主键ID 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 场馆名称 
     */
    private String gymName;
    /**
     * 负责人名称 
     */
    private String manager;
    /**
     * 联系方式 
     */
    private String phone;
    /**
     * 联系地址 
     */
    private String address;
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

    public AtpGym(){}

    public AtpGym(String gymName,String phone,String manager,String address){
        this.gymName = gymName;
        this.phone = phone;
        this.manager = manager;
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getGymName() {
        return this.gymName;
    }
    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManager() {
        return this.manager;
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

