package org.codingworld.time.dao.member;

import java.util.List;

import org.codingworld.time.common.MyMapper;
import org.springframework.stereotype.Repository;
import org.codingworld.time.entity.member.AtpMemCourse;
import org.codingworld.time.dto.member.AtpMemCourseDTO;


/**
 * @Description: AtpMemCourseDao
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:26
 */
@Repository
public interface AtpMemCourseDao extends MyMapper<AtpMemCourse> {



    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpMemCoursedto查询对象
     * @return List<AtpMemCourse> AtpMemCourse对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:26
     */
    List<AtpMemCourse> queryList(AtpMemCourseDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  AtpMemCourse对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:26
     */
    int save(AtpMemCourse record) ;

    /**
     * 批量保存对象信息
     * 
     * @param List AtpMemCourse对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:26
     */
    int saveBatch(List<AtpMemCourse> recordList) ;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpMemCourse对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:26
     */
    int deleteBatchByIds(List<Long> ids) ;

    /**
     * 根据Id修改对象信息
     *
     * @param dto AtpMemCourseVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:26
     */
    int updateById(AtpMemCourseDTO dto);
}
