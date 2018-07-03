package com.atp.entity.member;

import com.atp.dto.base.request.BasePageRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 姓名 
     */
    private String name;
    /**
     * 性别(0:男；1女) 
     */
    private Short sex;
    /**
     * 年龄 
     */
    private Short age;
    /**
     * 出生日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;

    /**
     * 身份证号码
     */
    private String idCard;
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


    public AtpMember(){}

    public AtpMember(String name,Short sex,Short age,String phone,String address,String remark,String cardPwd){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.remark = remark;
        this.cardPwd = cardPwd;
    }

    public AtpMember(String name,Short sex,Short age,String phone,String address,String remark,String cardNo,String cardPwd){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.remark = remark;
        this.cardNo = cardNo;
        this.cardPwd = cardPwd;
    }

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

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}

