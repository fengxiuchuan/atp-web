package com.atp.service.member;

import com.atp.dto.member.AtpMemCourseConsumeDTO;
import com.atp.dto.member.AtpMemCourseDTO;
import com.atp.entity.member.AtpMemCourse;
import com.atp.exception.ATPException;

import java.util.List;


/**
 * @Description: AtpMemCourseService
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:26
 */
public interface AtpMemCourseService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return AtpMemCourse 对象信息
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:26
     */
    AtpMemCourse getById(Long id) ;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpMemCoursedto查询对象
     * @return List<AtpMemCourse> AtpMemCourse对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:26
     */
    List<AtpMemCourse> queryList(AtpMemCourseDTO dto) ;

    /**
     * 保存对象信息
     * 
     * @param  AtpMemCourse对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:26
     */
    int save(AtpMemCourse record);

    /**
     * 批量保存对象信息
     * 
     * @param List AtpMemCourse对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:26
     */
    int saveBatch(List<AtpMemCourse> recordList);

    /**
     * 根据Id修改对象信息
     * 
     * @param  AtpMemCourse对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:26
     */
    int updateById(AtpMemCourse record);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id AtpMemCourse对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:26
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpMemCourse对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:26
     */
    int deleteBatchByIds(List<Long> ids);

    void payCourse(AtpMemCourseDTO atpMemCourseDTO)throws ATPException;

    void consumeCourse(AtpMemCourseConsumeDTO consumeDTO) throws ATPException;
}
