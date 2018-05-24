package com.atp.dto.base;

import com.atp.dto.coach.AtpCoachDTO;
import com.atp.entity.base.AtpCourse;
import com.atp.entity.base.AtpGym;
import com.atp.entity.coach.AtpCoach;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: AtpGymentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:10
 */
public class AtpGymDTO extends AtpGym implements Serializable {


    /**
     *
     *教练列表
     */
    private List<AtpCoachDTO> coachList;

    /**
     * 经营课程列表
     */
    private List<AtpCourseDTO> courseList;

    public List<AtpCoachDTO> getCoachList() {
        return coachList;
    }

    public void setCoachList(List<AtpCoachDTO> coachList) {
        this.coachList = coachList;
    }

    public List<AtpCourseDTO> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<AtpCourseDTO> courseList) {
        this.courseList = courseList;
    }
}

