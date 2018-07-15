package com.atp.dto.base;

import com.atp.dto.coach.AtpCoachDTO;
import com.atp.entity.base.AtpCourse;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: AtpCourseentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:08
 */
public class AtpCourseDTO extends AtpCourse implements Serializable {

    /*查询参数*/
    private String queryStr;
    /*教练列表*/
    private List<AtpCoachDTO> coachList;
    public String getQueryStr() {
        return queryStr;
    }

    public void setQueryStr(String queryStr) {
        this.queryStr = queryStr;
    }

    public List<AtpCoachDTO> getCoachList() {
        return coachList;
    }

    public void setCoachList(List<AtpCoachDTO> coachList) {
        this.coachList = coachList;
    }
}

