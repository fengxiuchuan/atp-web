package com.atp.dto.member;

import com.atp.entity.member.AtpMember;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: AtpMemberentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:29
 */
public class AtpMemberDTO extends AtpMember implements Serializable {

    private Long [] courseIdArr;

    private Long [] coachIdArr;

    private Integer [] totalNumArr;

    private Double[] courseAmountArr;

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

