package org.codingworld.time.service.base;

import java.util.List;

import org.codingworld.time.entity.base.AtpCourse;
import org.codingworld.time.dto.base.AtpCourseDTO;


/**
 * @Description: AtpCourseService
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:08
 */
public interface AtpCourseService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return AtpCourse 对象信息
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:08
     */
    AtpCourse getById(Long id) ;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpCoursedto查询对象
     * @return List<AtpCourse> AtpCourse对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:08
     */
    List<AtpCourse> queryList(AtpCourseDTO dto) ;

    /**
     * 保存对象信息
     * 
     * @param  AtpCourse对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:08
     */
    int save(AtpCourse record);

    /**
     * 批量保存对象信息
     * 
     * @param List AtpCourse对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:08
     */
    int saveBatch(List<AtpCourse> recordList);

    /**
     * 根据Id修改对象信息
     * 
     * @param  AtpCourse对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:08
     */
    int updateById(AtpCourse record);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id AtpCourse对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:08
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpCourse对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:08
     */
    int deleteBatchByIds(List<Long> ids);
}
