package com.atp.dao.base;

import com.atp.common.MyMapper;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.entity.base.AtpCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Description: AtpCourseDao
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:08
 */
@Repository
public interface AtpCourseDao extends MyMapper<AtpCourse> {



    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpCoursedto查询对象
     * @return List<AtpCourse> AtpCourse对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:08
     */
    List<AtpCourse> queryList(AtpCourseDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  AtpCourse对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:08
     */
    int save(AtpCourse record) ;

    /**
     * 批量保存对象信息
     * 
     * @param List AtpCourse对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:08
     */
    int saveBatch(List<AtpCourse> recordList) ;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpCourse对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:08
     */
    int deleteBatchByIds(List<Long> ids) ;

    /**
     * 根据Id修改对象信息
     *
     * @param dto AtpCourseVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:47:08
     */
    int updateById(AtpCourseDTO dto);

    /**
     *
     * 功能描述: 根据课程编码或者课程名称、主键ID查询课程
     *
     * @param: courseNo（必填）
     *                  课程编码
     * @param courseName（必填）
     *                  课程名称
     * @param id （可选）
     *                  主键ID
     * @return:
     * @auther: Administrator
     * @date: 2018/5/24 16:47
     */
    List<AtpCourseDTO> queryByNoOrName(@Param("courseNo") String courseNo, @Param("courseName")String courseName,@Param("excludId")Long id);
    
    /**
     *
     * 功能描述: 查询所有课程
     *
     * @param:
     * @return: 
     * @auther: Administrator
     * @date: 2018/5/24 16:57
     */
    List<AtpCourseDTO> queryAllList(AtpCourseDTO atpCourseDTO);
}
