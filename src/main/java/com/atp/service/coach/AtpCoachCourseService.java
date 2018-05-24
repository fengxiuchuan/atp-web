package com.atp.service.coach;

import com.atp.dto.coach.AtpCoachCourseDTO;
import com.atp.entity.coach.AtpCoachCourse;

import java.util.List;


/**
 * @Description: AtpCoachCourseService
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:39:01
 */
public interface AtpCoachCourseService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return AtpCoachCourse 对象信息
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    AtpCoachCourse getById(Long id) ;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpCoachCoursedto查询对象
     * @return List<AtpCoachCourse> AtpCoachCourse对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    List<AtpCoachCourse> queryList(AtpCoachCourseDTO dto) ;

    /**
     * 保存对象信息
     * 
     * @param  AtpCoachCourse对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    int save(AtpCoachCourse record);

    /**
     * 批量保存对象信息
     * 
     * @param List AtpCoachCourse对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    int saveBatch(List<AtpCoachCourse> recordList);

    /**
     * 根据Id修改对象信息
     * 
     * @param  AtpCoachCourse对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    int updateById(AtpCoachCourse record);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id AtpCoachCourse对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpCoachCourse对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    int deleteBatchByIds(List<Long> ids);
}
