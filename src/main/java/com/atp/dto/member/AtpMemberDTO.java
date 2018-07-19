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

    private BigDecimal[] courseAmountArr;

    private BigDecimal [] unitPriceArr;

    private BigDecimal [] discountAmountArr;

    private String label;

    private String value;

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

    public BigDecimal[] getCourseAmountArr() {
        return courseAmountArr;
    }

    public void setCourseAmountArr(BigDecimal[] courseAmountArr) {
        this.courseAmountArr = courseAmountArr;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BigDecimal[] getUnitPriceArr() {
        return unitPriceArr;
    }

    public void setUnitPriceArr(BigDecimal[] unitPriceArr) {
        this.unitPriceArr = unitPriceArr;
    }

    public BigDecimal[] getDiscountAmountArr() {
        return discountAmountArr;
    }

    public void setDiscountAmountArr(BigDecimal[] discountAmountArr) {
        this.discountAmountArr = discountAmountArr;
    }
}

