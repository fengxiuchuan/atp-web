package com.atp.entity.base;

import com.atp.dto.base.request.BasePageRequest;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: AtpCourseentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:08
 */

public class AtpCourse extends BasePageRequest implements Serializable {

    /**
     * 主键 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 课程名称 
     */
    private String courseName;
    /**
     * 课程编码 
     */
    private String courseNo;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return this.courseName;
    }
    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseNo() {
        return this.courseNo;
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

    public static void main(String[] args) {
        List<AtpCourse> courses = new ArrayList<AtpCourse>();
        AtpCourse course = new AtpCourse();
        course.setCourseNo("2");
        course.setCourseName("测试");
        courses.add(course);

        course = new AtpCourse();
        course.setCourseNo("4");
        course.setCourseName("测试4");
        courses.add(course);
        changeCourse(courses);
        System.out.println(courses.get(1).getCourseName());
        System.out.println(courses.get(0).getCourseName());
    }

    private static void changeCourse(List<AtpCourse> courses) {
        for (int i = 0; i < courses.size(); i++) {
            courses.get(i).setCourseName("balbal"+(i+8));
        }
    }
}

