package org.codingworld.time.service.base;

import java.util.List;

import org.codingworld.time.entity.base.AtpGymProgram;
import org.codingworld.time.dto.base.AtpGymProgramDTO;


/**
 * @Description: AtpGymProgramService
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:11
 */
public interface AtpGymProgramService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return AtpGymProgram 对象信息
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:11
     */
    AtpGymProgram getById(Long id) ;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpGymProgramdto查询对象
     * @return List<AtpGymProgram> AtpGymProgram对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:11
     */
    List<AtpGymProgram> queryList(AtpGymProgramDTO dto) ;

    /**
     * 保存对象信息
     * 
     * @param  AtpGymProgram对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:11
     */
    int save(AtpGymProgram record);

    /**
     * 批量保存对象信息
     * 
     * @param List AtpGymProgram对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:11
     */
    int saveBatch(List<AtpGymProgram> recordList);

    /**
     * 根据Id修改对象信息
     * 
     * @param  AtpGymProgram对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:11
     */
    int updateById(AtpGymProgram record);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id AtpGymProgram对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:11
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpGymProgram对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:11
     */
    int deleteBatchByIds(List<Long> ids);
}
