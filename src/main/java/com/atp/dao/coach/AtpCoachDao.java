package com.atp.dao.coach;

import com.atp.util.MyMapper;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.coach.AtpCoachDTO;
import com.atp.entity.coach.AtpCoach;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Description: AtpCoachDao
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:34:16
 */
@Repository
public interface AtpCoachDao extends MyMapper<AtpCoach> {



    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpCoachdto查询对象
     * @return List<AtpCoach> AtpCoach对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:34:16
     */
    List<AtpCoach> queryList(AtpCoachDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  AtpCoach对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:34:16
     */
    int save(AtpCoach record) ;

    /**
     * 批量保存对象信息
     * 
     * @param List AtpCoach对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:34:16
     */
    int saveBatch(List<AtpCoach> recordList) ;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpCoach对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:34:16
     */
    int deleteBatchByIds(List<Long> ids) ;

    /**
     * 根据Id修改对象信息
     *
     * @param dto AtpCoachVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:34:16
     */
    int updateById(AtpCoach atpCoach);

    List<AtpCoachDTO> queryAllList(AtpCoachDTO atpCoachDTO);

    List<AtpCoachDTO> queryByNoOrName(@Param("coachNo") String coachNo, @Param("coachName") String coachName,@Param("excludId") Long id);

    List<AtpCourseDTO> queryCourseListByCoachId(Long coachId);

    AtpCoachDTO queryDetailById(Long coachId);
    /**
     * 根据课程主键查询教授此课程的教练
     *
     * @param
     * @return list
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:39:01
     */
    List<AtpCoachDTO> queryCoachListByCourseId(Long courseId);

    List<AtpCoachDTO>  getCoachList(@Param("gymId") Long gymId);

    List<AtpCoachDTO> getCourseCoachsByGymId(Long gymId);
}
