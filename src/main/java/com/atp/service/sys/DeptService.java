package com.atp.service.sys;

import java.util.List;

import com.atp.entity.sys.Dept;
import com.atp.dto.sys.DeptDTO;

/**
 * @Description: DeptService
 * @author: fengxiuchuan
 * @date: 2018-11-04 19:54:54
 */
public interface DeptService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return Dept 对象信息
     * @author: fengxiuchuan
     * @date: 2018-11-04 19:54:54
     */
    Dept getById(Long id) ;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto Deptdto查询对象
     * @return List<Dept> Dept对象列表
     * @author: fengxiuchuan
     * @date: 2018-11-04 19:54:54
     */
    List<Dept> queryList(DeptDTO dto) ;

    /**
     * 保存对象信息
     * 
     * @param  Dept对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-11-04 19:54:54
     */
    int save(Dept record);

    /**
     * 批量保存对象信息
     * 
     * @param List Dept对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-11-04 19:54:54
     */
    int saveBatch(List<Dept> recordList);

    /**
     * 根据Id修改对象信息
     * 
     * @param  Dept对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-11-04 19:54:54
     */
    int updateById(Dept record);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id Dept对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-11-04 19:54:54
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids Dept对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-11-04 19:54:54
     */
    int deleteBatchByIds(List<Long> ids);
}
