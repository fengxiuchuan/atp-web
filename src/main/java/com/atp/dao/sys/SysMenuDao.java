package com.atp.dao.sys;

import java.util.List;

import com.atp.exception.ATPException;
import com.atp.util.MyMapper;
import org.springframework.stereotype.Repository;
import com.atp.entity.sys.SysMenu;
import com.atp.dto.sys.SysMenuDTO;

/**
 * @Description: SysMenuDao
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:45
 */
@Repository
public interface SysMenuDao extends MyMapper<SysMenu> {



    /**
     * 根据条件查询对象列表
     * 
     * @param dto SysMenudto查询对象
     * @return List<SysMenu> SysMenu对象列表
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:45
     */
    List<SysMenu> queryList(SysMenuDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  SysMenu对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:45
     */
    int save(SysMenu record) throws ATPException;

    /**
     * 批量保存对象信息
     * 
     * @param List SysMenu对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:45
     */
    int saveBatch(List<SysMenu> recordList) throws ATPException;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SysMenu对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:45
     */
    int deleteBatchByIds(List<Long> ids) throws ATPException;

    /**
     * 根据Id修改对象信息
     *
     * @param dto SysMenuVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:45
     */
    int updateById(SysMenuDTO dto);
}
