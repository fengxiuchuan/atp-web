package com.atp.dto.coach;

import com.atp.entity.coach.AtpCoach;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: AtpCoachentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:34:16
 */
public class AtpCoachDTO extends AtpCoach implements Serializable {

    private List<AtpCoachCourseDTO> coachCourseDTOList;

    private String [] courseNoArr;

    public String[] getCourseNoArr() {
        return courseNoArr;
    }

    public void setCourseNoArr(String[] courseNoArr) {
        this.courseNoArr = courseNoArr;
    }

    public List<AtpCoachCourseDTO> getCoachCourseDTOList() {
        return coachCourseDTOList;
    }

    public void setCoachCourseDTOList(List<AtpCoachCourseDTO> coachCourseDTOList) {
        this.coachCourseDTOList = coachCourseDTOList;
    }
}

