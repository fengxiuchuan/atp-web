package com.atp.service.sys;

import java.util.List;

import com.atp.dto.sys.SysMenuDTO;
import com.atp.entity.sys.SysMenu;
import com.atp.exception.ATPException;

/**
 * @Description: SysMenuService
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:45
 */
public interface SysMenuService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return SysMenu 对象信息
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:45
     */
    SysMenu getById(Long id) throws ATPException;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto SysMenudto查询对象
     * @return List<SysMenu> SysMenu对象列表
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:45
     */
    List<SysMenu> queryList(SysMenuDTO dto) throws ATPException;

    /**
     * 保存对象信息
     * 
     * @param  SysMenu对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:45
     */
    int save(SysMenu record)throws ATPException;

    /**
     * 批量保存对象信息
     * 
     * @param List SysMenu对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:45
     */
    int saveBatch(List<SysMenu> recordList)throws ATPException;

    /**
     * 根据Id修改对象信息
     * 
     * @param  SysMenu对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:45
     */
    int updateById(SysMenu record)throws ATPException;
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id SysMenu对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:45
     */
    int deleteById(Long id)throws ATPException;

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SysMenu对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:45
     */
    int deleteBatchByIds(List<Long> ids)throws ATPException;
}
