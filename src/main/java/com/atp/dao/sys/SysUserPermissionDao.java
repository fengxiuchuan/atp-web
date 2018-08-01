package com.atp.dao.sys;

import java.util.List;

import com.atp.exception.ATPException;
import com.atp.util.MyMapper;
import org.springframework.stereotype.Repository;
import com.atp.entity.sys.SysUserPermission;
import com.atp.dto.sys.SysUserPermissionDTO;
/**
 * @Description: SysUserPermissionDao
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
@Repository
public interface SysUserPermissionDao extends MyMapper<SysUserPermission> {



    /**
     * 根据条件查询对象列表
     * 
     * @param dto SysUserPermissiondto查询对象
     * @return List<SysUserPermission> SysUserPermission对象列表
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    List<SysUserPermission> queryList(SysUserPermissionDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  SysUserPermission对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int save(SysUserPermission record) throws ATPException;

    /**
     * 批量保存对象信息
     * 
     * @param List SysUserPermission对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int saveBatch(List<SysUserPermission> recordList) throws ATPException;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SysUserPermission对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int deleteBatchByIds(List<Long> ids) throws ATPException;

    /**
     * 根据Id修改对象信息
     *
     * @param dto SysUserPermissionVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int updateById(SysUserPermissionDTO dto);
}
