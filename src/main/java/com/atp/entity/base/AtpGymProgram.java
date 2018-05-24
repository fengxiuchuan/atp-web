package com.atp.entity.base;

import com.atp.dto.base.request.BasePageRequest;

import java.io.Serializable;

/**
 * @Description: AtpGymProgramentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:11
 */
public class AtpGymProgram extends BasePageRequest implements Serializable {

    /**
     * 主键 
     */
    private Long id;
    /**
     * 场馆主键 
     */
    private Long gymId;
    /**
     * 课程主键 
     */
    private Long courseId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    public Long getGymId() {
        return this.gymId;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return this.courseId;
    }
}

