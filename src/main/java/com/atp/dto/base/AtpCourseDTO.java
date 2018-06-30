package com.atp.dto.base;

import com.atp.entity.base.AtpCourse;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: AtpCourseentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:08
 */
public class AtpCourseDTO extends AtpCourse implements Serializable {

    /*查询参数*/
    private String queryStr;


    public String getQueryStr() {
        return queryStr;
    }

    public void setQueryStr(String queryStr) {
        this.queryStr = queryStr;
    }

}

