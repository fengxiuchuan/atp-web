package com.atp.entity.member;

import com.atp.dto.base.request.BasePageRequest;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: AtpMemCourseConsumeentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:28
 */
public class AtpMemCourseConsume extends BasePageRequest implements Serializable {

    /**
     * 主键 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 会员课程主键
     */
    private Long memCourseId;
    /**
     * 会员主键 
     */
    private Long memId;
    /**
     * 会员编号 
     */
    private String memCardNo;
    /**
     * 课程主键 
     */
    private Long courseId;
    /**
     * 课程编码 
     */
    private String courseNo;
    /**
     * 课程名称 
     */
    private String courseName;
    /**
     * 课程教练主键 
     */
    private Long coachId;
    /**
     * 课程教练编码 
     */
    private String coachNo;
    /**
     * 课程教练名称 
     */
    private String coachName;
    /**
     * 执行教练主键 
     */
    private Long execCoachId;
    /**
     * 执行教练编码 
     */
    private String execCoachNo;
    /**
     * 执行教练名称 
     */
    private String execCoachName;
    /**
     * 消耗课时数 
     */
    private Integer courseNum;
    /**
     * 消耗时间 
     */
    private Date consumeTime;
    /**
     * 积分 
     */
    private Integer integral;
    /**
     * 备注 
     */
    private String remark;
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

    @Transient
    private BigDecimal unitPrice;

    public AtpMemCourseConsume(){}

    public AtpMemCourseConsume(Long memId,String memCardNo,Long memCourseId,
                                Long courseId,String courseName,
                                Long coachId,String coachNo,String coachName,
                                Long execCoachId,String execCoachNo,String execCoachName,
                                Integer courseNum,Integer integral){
        this.memId = memId;
        this.memCardNo = memCardNo;
        this.memCourseId = memCourseId;
        this.courseId = courseId;
        this.courseName = courseName;
        this.coachId = coachId;
        this.coachNo = coachNo;
        this.coachName = coachName;
        this.execCoachId = execCoachId;
        this.execCoachNo = execCoachNo;
        this.execCoachName = execCoachName;
        this.courseNum = courseNum;
        this.integral = integral;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setMemId(Long memId) {
        this.memId = memId;
    }

    public Long getMemId() {
        return this.memId;
    }
    public void setMemCardNo(String memCardNo) {
        this.memCardNo = memCardNo;
    }

    public String getMemCardNo() {
        return this.memCardNo;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return this.courseId;
    }
    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseNo() {
        return this.courseNo;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return this.courseName;
    }
    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Long getCoachId() {
        return this.coachId;
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
    public void setExecCoachId(Long execCoachId) {
        this.execCoachId = execCoachId;
    }

    public Long getExecCoachId() {
        return this.execCoachId;
    }
    public void setExecCoachNo(String execCoachNo) {
        this.execCoachNo = execCoachNo;
    }

    public String getExecCoachNo() {
        return this.execCoachNo;
    }
    public void setExecCoachName(String execCoachName) {
        this.execCoachName = execCoachName;
    }

    public String getExecCoachName() {
        return this.execCoachName;
    }
    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }

    public Integer getCourseNum() {
        return this.courseNum;
    }
    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Date getConsumeTime() {
        return this.consumeTime;
    }
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getIntegral() {
        return this.integral;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
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

    public Long getMemCourseId() {
        return memCourseId;
    }

    public void setMemCourseId(Long memCourseId) {
        this.memCourseId = memCourseId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}

