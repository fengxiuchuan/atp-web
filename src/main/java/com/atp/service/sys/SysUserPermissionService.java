package com.atp.service.sys;

import java.util.List;

import com.atp.entity.sys.SysUserPermission;
import com.atp.dto.sys.SysUserPermissionDTO;
import com.atp.exception.ATPException;

/**
 * @Description: SysUserPermissionService
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
public interface SysUserPermissionService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return SysUserPermission 对象信息
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    SysUserPermission getById(Long id) throws ATPException;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto SysUserPermissiondto查询对象
     * @return List<SysUserPermission> SysUserPermission对象列表
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    List<SysUserPermission> queryList(SysUserPermissionDTO dto) throws ATPException;

    /**
     * 保存对象信息
     * 
     * @param  SysUserPermission对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int save(SysUserPermission record)throws ATPException;

    /**
     * 批量保存对象信息
     * 
     * @param List SysUserPermission对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int saveBatch(List<SysUserPermission> recordList)throws ATPException;

    /**
     * 根据Id修改对象信息
     * 
     * @param  SysUserPermission对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int updateById(SysUserPermission record)throws ATPException;
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id SysUserPermission对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int deleteById(Long id)throws ATPException;

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SysUserPermission对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int deleteBatchByIds(List<Long> ids)throws ATPException;
}
