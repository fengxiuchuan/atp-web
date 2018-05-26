package com.atp.dto.member;

import com.atp.entity.member.AtpMemCourse;

import java.io.Serializable;

/**
 * @Description: AtpMemCourseentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:26
 */
public class AtpMemCourseDTO extends AtpMemCourse implements Serializable {

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
}

