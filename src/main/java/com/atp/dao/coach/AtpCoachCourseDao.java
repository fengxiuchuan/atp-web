package com.atp.dao.coach;

import com.atp.util.MyMapper;
import com.atp.dto.coach.AtpCoachCourseDTO;
import com.atp.entity.coach.AtpCoachCourse;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Description: AtpCoachCourseDao
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:39:01
 */
@Repository
public interface AtpCoachCourseDao extends MyMapper<AtpCoachCourse> {



    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpCoachCoursedto查询对象
     * @return List<AtpCoachCourse> AtpCoachCourse对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    List<AtpCoachCourse> queryList(AtpCoachCourseDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  AtpCoachCourse对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    int save(AtpCoachCourse record) ;

    /**
     * 批量保存对象信息
     * 
     * @param List AtpCoachCourse对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    int saveBatch(List<AtpCoachCourse> recordList) ;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpCoachCourse对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    int deleteBatchByIds(List<Long> ids) ;

    /**
     * 根据Id修改对象信息
     *
     * @param dto AtpCoachCourseVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    int updateById(AtpCoachCourseDTO dto);
    /**
     * 根据教练主键删除关联课程
     *
     * @param  coachId 教练主键ID
     * @return void
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    void deleteByCoachId(Long coachId);
}
