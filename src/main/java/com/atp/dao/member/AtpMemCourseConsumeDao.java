package com.atp.dao.member;

import com.atp.common.MyMapper;
import com.atp.dto.member.AtpMemCourseConsumeDTO;
import com.atp.entity.member.AtpMemCourseConsume;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Description: AtpMemCourseConsumeDao
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:28
 */
@Repository
public interface AtpMemCourseConsumeDao extends MyMapper<AtpMemCourseConsume> {



    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpMemCourseConsumedto查询对象
     * @return List<AtpMemCourseConsume> AtpMemCourseConsume对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:28
     */
    List<AtpMemCourseConsume> queryList(AtpMemCourseConsumeDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  AtpMemCourseConsume对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:28
     */
    int save(AtpMemCourseConsume record) ;

    /**
     * 批量保存对象信息
     * 
     * @param List AtpMemCourseConsume对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:28
     */
    int saveBatch(List<AtpMemCourseConsume> recordList) ;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpMemCourseConsume对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:28
     */
    int deleteBatchByIds(List<Long> ids) ;

    /**
     * 根据Id修改对象信息
     *
     * @param dto AtpMemCourseConsumeVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:28
     */
    int updateById(AtpMemCourseConsumeDTO dto);
}
