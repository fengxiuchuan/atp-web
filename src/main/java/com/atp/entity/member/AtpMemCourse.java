package com.atp.entity.member;

import com.atp.dto.base.request.BasePageRequest;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: AtpMemCourseentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:26
 */
public class AtpMemCourse extends BasePageRequest implements Serializable {

    /**
     * 主键 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 订单编号 
     */
    private String orderNo;
    /**
     * 会员号码 
     */
    private String cardNo;
    /**
     * 会员主键 
     */
    private Long memId;
    /**
     * 课程主键 
     */
    private Long courseId;
    /**
     * 课程名称 
     */
    private String courseName;
    /**
     * 教练主键 
     */
    private Long coachId;
    /**
     * 教练编码 
     */
    private String coachNo;
    /**
     * 总课时 
     */
    private Integer totalNum;
    /**
     * 剩余课时 
     */
    private Integer freeNum;
    /**
     * 消耗课时 
     */
    private Integer usedNum;
    /**
     * 课程总金额 
     */
    private Double courseAmount;
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
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return this.orderNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return this.cardNo;
    }
    public void setMemId(Long memId) {
        this.memId = memId;
    }

    public Long getMemId() {
        return this.memId;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return this.courseId;
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
    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalNum() {
        return this.totalNum;
    }
    public void setFreeNum(Integer freeNum) {
        this.freeNum = freeNum;
    }

    public Integer getFreeNum() {
        return this.freeNum;
    }
    public void setUsedNum(Integer usedNum) {
        this.usedNum = usedNum;
    }

    public Integer getUsedNum() {
        return this.usedNum;
    }
    public void setCourseAmount(Double courseAmount) {
        this.courseAmount = courseAmount;
    }

    public Double getCourseAmount() {
        return this.courseAmount;
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

