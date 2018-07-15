package com.atp.service.coach;

import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.base.response.BasePageResponse;
import com.atp.dto.coach.AtpCoachDTO;
import com.atp.entity.coach.AtpCoach;
import com.atp.exception.ATPException;

import java.util.List;


/**
 * @Description: AtpCoachService
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:34:16
 */
public interface AtpCoachService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return AtpCoach 对象信息
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:34:16
     */
    AtpCoach getById(Long id) ;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpCoachdto查询对象
     * @return List<AtpCoach> AtpCoach对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:34:16
     */
    List<AtpCoach> queryList(AtpCoachDTO dto) ;

    /**
     * 保存对象信息
     * 
     * @param  AtpCoach对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:34:16
     */
    int save(AtpCoach record);

    /**
     * 批量保存对象信息
     * 
     * @param List AtpCoach对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:34:16
     */
    int saveBatch(List<AtpCoach> recordList);

    /**
     * 根据Id修改对象信息
     * 
     * @param  AtpCoach对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:34:16
     */
    int updateById(AtpCoach record);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id AtpCoach对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:34:16
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpCoach对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:34:16
     */
    int deleteBatchByIds(List<Long> ids);

    BasePageResponse<AtpCoachDTO> queryAllList(AtpCoachDTO atpCoachDTO)throws ATPException;

    void addCoach(AtpCoachDTO atpCoachDTO)throws ATPException;

    void updateCoach(AtpCoachDTO atpCoachDTO)throws ATPException;

    List<AtpCourseDTO> queryCourseListByCoachId(Long coachId)throws ATPException;

    AtpCoachDTO queryDetailById(Long coachId)throws ATPException;

    /**
     *
     * 功能描述: 根据主键（教练课程主键）删除课程关联记录
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/6/30 16:22
     */
    int delCoachCourseById(Long coachCourseId)throws ATPException;
    /**
     *
     * 功能描述: 查询所有教练列表
     *
     * @param:
     * @return: List
     * @auther: Administrator
     * @date: 2018/7/7 16:41
     */
    List<AtpCourseDTO> getCoachList()throws ATPException;
    
    /**
     *
     * 功能描述: 根据课程主键查询教练集合
     *
     * @param:
     * @return: 
     * @auther: Administrator
     * @date: 2018/7/13 11:26
     */
    List<AtpCoachDTO> queryCoachListByCourseId(Long courseId)throws ATPException;
}
