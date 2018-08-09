package com.atp.service.sys;

import java.util.List;

import com.atp.entity.sys.SysRoleMenu;
import com.atp.dto.sys.SysRoleMenuDTO;
import com.atp.exception.ATPException;

/**
 * @Description: SysRoleMenuService
 * @author: fengxiuchuan
 * @date: 2018-08-09 17:04:19
 */
public interface SysRoleMenuService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return SysRoleMenu 对象信息
     * @author: fengxiuchuan
     * @date: 2018-08-09 17:04:19
     */
    SysRoleMenu getById(Long id) throws ATPException;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto SysRoleMenudto查询对象
     * @return List<SysRoleMenu> SysRoleMenu对象列表
     * @author: fengxiuchuan
     * @date: 2018-08-09 17:04:19
     */
    List<SysRoleMenu> queryList(SysRoleMenuDTO dto) throws ATPException;

    /**
     * 保存对象信息
     * 
     * @param  SysRoleMenu对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-09 17:04:19
     */
    int save(SysRoleMenu record)throws ATPException;

    /**
     * 批量保存对象信息
     * 
     * @param List SysRoleMenu对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-09 17:04:19
     */
    int saveBatch(List<SysRoleMenu> recordList)throws ATPException;

    /**
     * 根据Id修改对象信息
     * 
     * @param  SysRoleMenu对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-09 17:04:19
     */
    int updateById(SysRoleMenu record)throws ATPException;
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id SysRoleMenu对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-09 17:04:19
     */
    int deleteById(Long id)throws ATPException;

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SysRoleMenu对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-09 17:04:19
     */
    int deleteBatchByIds(List<Long> ids)throws ATPException;
}
