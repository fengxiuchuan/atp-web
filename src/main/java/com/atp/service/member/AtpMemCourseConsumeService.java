package com.atp.service.member;

import com.atp.dto.member.AtpMemCourseConsumeDTO;
import com.atp.entity.member.AtpMemCourseConsume;

import java.util.List;


/**
 * @Description: AtpMemCourseConsumeService
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:28
 */
public interface AtpMemCourseConsumeService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return AtpMemCourseConsume 对象信息
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:28
     */
    AtpMemCourseConsume getById(Long id) ;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpMemCourseConsumedto查询对象
     * @return List<AtpMemCourseConsume> AtpMemCourseConsume对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:28
     */
    List<AtpMemCourseConsume> queryList(AtpMemCourseConsumeDTO dto) ;

    /**
     * 保存对象信息
     * 
     * @param  AtpMemCourseConsume对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:28
     */
    int save(AtpMemCourseConsume record);

    /**
     * 批量保存对象信息
     * 
     * @param List AtpMemCourseConsume对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:28
     */
    int saveBatch(List<AtpMemCourseConsume> recordList);

    /**
     * 根据Id修改对象信息
     * 
     * @param  AtpMemCourseConsume对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:28
     */
    int updateById(AtpMemCourseConsume record);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id AtpMemCourseConsume对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:28
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpMemCourseConsume对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:28
     */
    int deleteBatchByIds(List<Long> ids);
}
