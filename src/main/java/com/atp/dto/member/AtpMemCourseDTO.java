package com.atp.dto.member;

import com.atp.dto.coach.AtpCoachDTO;
import com.atp.entity.member.AtpMemCourse;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description: AtpMemCourseentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:26
 */
public class AtpMemCourseDTO extends AtpMemCourse implements Serializable {

    // 开始日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateStart;

    // 截止日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateEnd;



    private Long [] courseIdArr;

    private Long [] coachIdArr;
    // 课程名称
    private String []courseNameArr;

    private Integer [] totalNumArr;

    private BigDecimal[] courseAmountArr;

    private BigDecimal [] unitPriceArr;

    private BigDecimal [] discountAmountArr;

    // 授课教练编号
    private String []coachNoArr;
    // 授课教练名称
    private String []coachNameArr;

    private String label;

    private String value;

    private List<AtpCoachDTO> coachList;


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

    public List<AtpCoachDTO> getCoachList() {
        return coachList;
    }

    public void setCoachList(List<AtpCoachDTO> coachList) {
        this.coachList = coachList;
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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String[] getCourseNameArr() {
        return courseNameArr;
    }

    public void setCourseNameArr(String[] courseNameArr) {
        this.courseNameArr = courseNameArr;
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
}

