package com.atp.entity.coach;

import com.atp.dto.base.request.BasePageRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: AtpCoachentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:34:16
 */
public class AtpCoach extends BasePageRequest implements Serializable {

    /**
     * 主键 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 教练编号 
     */
    private String coachNo;
    /**
     * 教练名称 
     */
    private String coachName;
    /**
     * 出生日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;
    /**
     * 性别（0：男；1：女） 
     */
    private Short sex;
    /**
     * 年龄 
     */
    private Short age;
    /**
     * 联系方式:
     */
    private String phone;
    /**
     * 所在健身场馆 
     */
    private Long gymId;
    /**
     * 是否在职(Y:是；N：否） 
     */
    private String jobState;
    /**
     * 用户名 
     */
    private String userAccount;
    /**
     * 用户密码 
     */
    private String userPasswd;
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

    public AtpCoach(){}

    public AtpCoach(String coachNo,String coachName,Short sex,Short age,Long gymId,String jobState,String userAccount,String userPasswd){
        this.coachNo = coachNo;
        this.coachName = coachName;
        this.sex = sex;
        this.age = age;
        this.gymId = gymId;
        this.jobState = jobState;
        this.userAccount = userAccount;
        this.userPasswd = userPasswd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setCoachNo(String coachNo) {
        this.coachNo = coachNo;
    }

    public String getCoachNo() {
        return this.coachNo;
    }
    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getCoachName() {
        return this.coachName;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Short getAge() {
        return this.age;
    }
    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    public Long getGymId() {
        return this.gymId;
    }
    public void setJobState(String jobState) {
        this.jobState = jobState;
    }

    public String getJobState() {
        return this.jobState;
    }
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserAccount() {
        return this.userAccount;
    }
    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getUserPasswd() {
        return this.userPasswd;
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

    public Short getSex() {
        return sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

