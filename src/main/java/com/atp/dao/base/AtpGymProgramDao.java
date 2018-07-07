package com.atp.dao.base;

import com.atp.util.MyMapper;
import com.atp.dto.base.AtpGymProgramDTO;
import com.atp.entity.base.AtpGymProgram;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Description: AtpGymProgramDao
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:11
 */
@Repository
public interface AtpGymProgramDao extends MyMapper<AtpGymProgram> {



    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpGymProgramdto查询对象
     * @return List<AtpGymProgram> AtpGymProgram对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:11
     */
    List<AtpGymProgram> queryList(AtpGymProgramDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  AtpGymProgram对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:11
     */
    int save(AtpGymProgram record) ;

    /**
     * 批量保存对象信息
     * 
     * @param List AtpGymProgram对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:11
     */
    int saveBatch(List<AtpGymProgram> recordList) ;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpGymProgram对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:11
     */
    int deleteBatchByIds(List<Long> ids) ;

    /**
     * 根据Id修改对象信息
     *
     * @param dto AtpGymProgramVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:11
     */
    int updateById(AtpGymProgramDTO dto);

    /**
     *
     * 功能描述: 根据场馆主键删除关联课程
     *
     * @param: id 场馆主键
     * @return: void
     * @auther: Administrator
     * @date: 2018/7/7 19:48
     */
    void deleteByGymId(Long id);
}
