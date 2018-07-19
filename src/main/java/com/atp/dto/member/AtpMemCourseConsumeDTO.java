package com.atp.dto.member;

import com.atp.dto.coach.AtpCoachDTO;
import com.atp.entity.member.AtpMemCourseConsume;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: AtpMemCourseConsumeentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:28
 */
public class AtpMemCourseConsumeDTO extends AtpMemCourseConsume implements Serializable {


    // 会员课程报名课程主键
    private Long []memCourseIdArr;
    // 课程主键
    private Long [] courseIdArr;
    // 课程名称
    private String []courseNameArr;
    // 授课教练主键
    private Long []coachIdArr;
    // 授课教练编号
    private String []coachNoArr;
    // 授课教练名称
    private String []coachNameArr;
    // 销课课时
    private Integer []courseNumArr;
    // 销课积分
    private Integer []integralArr;
    // 执行教练
    private Long []execCoachIdArr;
    // 执行教练编号
    private String []execCoachNoArr;
    // 执行教练名称
    private String []execCoachNameArr;
    // 当前课程单价
    private BigDecimal [] unitPriceArr;

    public Long[] getMemCourseIdArr() {
        return memCourseIdArr;
    }

    public void setMemCourseIdArr(Long[] memCourseIdArr) {
        this.memCourseIdArr = memCourseIdArr;
    }

    public String[] getCourseNameArr() {
        return courseNameArr;
    }

    public void setCourseNameArr(String[] courseNameArr) {
        this.courseNameArr = courseNameArr;
    }

    public Long[] getCoachIdArr() {
        return coachIdArr;
    }

    public void setCoachIdArr(Long[] coachIdArr) {
        this.coachIdArr = coachIdArr;
    }

    public String[] getCoachNoArr() {
        return coachNoArr;
    }

    public void setCoachNoArr(String[] coachNoArr) {
        this.coachNoArr = coachNoArr;
    }

    public String[] getCoachNameArr() {
        return coachNameArr;
    }

    public void setCoachNameArr(String[] coachNameArr) {
        this.coachNameArr = coachNameArr;
    }

    public Integer[] getCourseNumArr() {
        return courseNumArr;
    }

    public void setCourseNumArr(Integer[] courseNumArr) {
        this.courseNumArr = courseNumArr;
    }

    public Integer[] getIntegralArr() {
        return integralArr;
    }

    public void setIntegralArr(Integer[] integralArr) {
        this.integralArr = integralArr;
    }

    public Long[] getExecCoachIdArr() {
        return execCoachIdArr;
    }

    public void setExecCoachIdArr(Long[] execCoachIdArr) {
        this.execCoachIdArr = execCoachIdArr;
    }

    public String[] getExecCoachNoArr() {
        return execCoachNoArr;
    }

    public void setExecCoachNoArr(String[] execCoachNoArr) {
        this.execCoachNoArr = execCoachNoArr;
    }

    public String[] getExecCoachNameArr() {
        return execCoachNameArr;
    }

    public void setExecCoachNameArr(String[] execCoachNameArr) {
        this.execCoachNameArr = execCoachNameArr;
    }

    public Long[] getCourseIdArr() {
        return courseIdArr;
    }

    public void setCourseIdArr(Long[] courseIdArr) {
        this.courseIdArr = courseIdArr;
    }

    public BigDecimal[] getUnitPriceArr() {
        return unitPriceArr;
    }

    public void setUnitPriceArr(BigDecimal[] unitPriceArr) {
        this.unitPriceArr = unitPriceArr;
    }
}

