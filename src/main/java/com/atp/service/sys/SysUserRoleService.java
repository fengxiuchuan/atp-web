package com.atp.service.sys;

import java.util.List;

import com.atp.entity.sys.SysUserRole;
import com.atp.dto.sys.SysUserRoleDTO;
import com.atp.exception.ATPException;

/**
 * @Description: SysUserRoleService
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
public interface SysUserRoleService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return SysUserRole 对象信息
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    SysUserRole getById(Long id) throws ATPException;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto SysUserRoledto查询对象
     * @return List<SysUserRole> SysUserRole对象列表
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    List<SysUserRole> queryList(SysUserRoleDTO dto) throws ATPException;

    /**
     * 保存对象信息
     * 
     * @param  SysUserRole对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int save(SysUserRole record)throws ATPException;

    /**
     * 批量保存对象信息
     * 
     * @param List SysUserRole对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int saveBatch(List<SysUserRole> recordList)throws ATPException;

    /**
     * 根据Id修改对象信息
     * 
     * @param  SysUserRole对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int updateById(SysUserRole record)throws ATPException;
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id SysUserRole对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int deleteById(Long id)throws ATPException;

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SysUserRole对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int deleteBatchByIds(List<Long> ids)throws ATPException;
}
