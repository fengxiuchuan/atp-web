package org.codingworld.time.service.coach;

import java.util.List;

import org.codingworld.time.entity.coach.AtpCoach;
import org.codingworld.time.dto.coach.AtpCoachDTO;


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
}