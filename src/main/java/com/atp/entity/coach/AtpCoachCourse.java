package com.atp.entity.coach;

import com.atp.dto.base.request.BasePageRequest;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: AtpCoachCourseentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:39:01
 */
public class AtpCoachCourse extends BasePageRequest implements Serializable {

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
     * 教练主键 
     */
    private Long coachId;
    /**
     * 课程主键 
     */
    private String courseName;
    /**
     * 课程主键
     */
    private Long courseId;
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

    public AtpCoachCourse(){}

    public AtpCoachCourse(Long coachId, Long courseId,String courseName){
        this.coachId = coachId;
        this.courseId = courseId;
        this.courseName = courseName;
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
    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Long getCoachId() {
        return this.coachId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

