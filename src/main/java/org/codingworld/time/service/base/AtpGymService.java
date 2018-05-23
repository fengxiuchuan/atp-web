package org.codingworld.time.service.base;

import java.util.List;

import org.codingworld.time.entity.base.AtpGym;
import org.codingworld.time.dto.base.AtpGymDTO;


/**
 * @Description: AtpGymService
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:10
 */
public interface AtpGymService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return AtpGym 对象信息
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:10
     */
    AtpGym getById(Long id) ;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpGymdto查询对象
     * @return List<AtpGym> AtpGym对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:10
     */
    List<AtpGym> queryList(AtpGymDTO dto) ;

    /**
     * 保存对象信息
     * 
     * @param  AtpGym对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:10
     */
    int save(AtpGym record);

    /**
     * 批量保存对象信息
     * 
     * @param List AtpGym对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:10
     */
    int saveBatch(List<AtpGym> recordList);

    /**
     * 根据Id修改对象信息
     * 
     * @param  AtpGym对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:10
     */
    int updateById(AtpGym record);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id AtpGym对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:10
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpGym对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:10
     */
    int deleteBatchByIds(List<Long> ids);
}
