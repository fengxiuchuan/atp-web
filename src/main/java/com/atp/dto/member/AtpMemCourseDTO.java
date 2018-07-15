package com.atp.dto.member;

import com.atp.entity.member.AtpMemCourse;

import java.io.Serializable;

/**
 * @Description: AtpMemCourseentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:26
 */
public class AtpMemCourseDTO extends AtpMemCourse implements Serializable {
    private Long [] courseIdArr;

    private Long [] coachIdArr;

    private Integer [] totalNumArr;

    private Double[] courseAmountArr;
    /**
     *  教练名称
     */
    private String coachName;

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Long[] getCourseIdArr() {
        return courseIdArr;
    }

    public void setCourseIdArr(Long[] courseIdArr) {
        this.courseIdArr = courseIdArr;
    }

    public Long[] getCoachIdArr() {
        return coachIdArr;
    }

    public void setCoachIdArr(Long[] coachIdArr) {
        this.coachIdArr = coachIdArr;
    }

    public Integer[] getTotalNumArr() {
        return totalNumArr;
    }

    public void setTotalNumArr(Integer[] totalNumArr) {
        this.totalNumArr = totalNumArr;
    }

    public Double[] getCourseAmountArr() {
        return courseAmountArr;
    }

    public void setCourseAmountArr(Double[] courseAmountArr) {
        this.courseAmountArr = courseAmountArr;
    }
}

