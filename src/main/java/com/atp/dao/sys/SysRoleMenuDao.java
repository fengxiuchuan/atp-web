package com.atp.dao.sys;

import java.util.List;

import com.atp.exception.ATPException;
import com.atp.util.MyMapper;
import org.springframework.stereotype.Repository;
import com.atp.entity.sys.SysRoleMenu;
import com.atp.dto.sys.SysRoleMenuDTO;
/**
 * @Description: SysRoleMenuDao
 * @author: fengxiuchuan
 * @date: 2018-08-09 17:04:19
 */
@Repository
public interface SysRoleMenuDao extends MyMapper<SysRoleMenu> {



    /**
     * 根据条件查询对象列表
     * 
     * @param dto SysRoleMenudto查询对象
     * @return List<SysRoleMenu> SysRoleMenu对象列表
     * @author: fengxiuchuan
     * @date: 2018-08-09 17:04:19
     */
    List<SysRoleMenu> queryList(SysRoleMenuDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  SysRoleMenu对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-09 17:04:19
     */
    int save(SysRoleMenu record) throws ATPException;

    /**
     * 批量保存对象信息
     * 
     * @param List SysRoleMenu对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-09 17:04:19
     */
    int saveBatch(List<SysRoleMenu> recordList) throws ATPException;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SysRoleMenu对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-09 17:04:19
     */
    int deleteBatchByIds(List<Long> ids) throws ATPException;

    /**
     * 根据Id修改对象信息
     *
     * @param dto SysRoleMenuVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-09 17:04:19
     */
    int updateById(SysRoleMenuDTO dto);

    /**
     *
     * 根据角色编码删除资源
     *
     * @param:
     * @return: 
     * @auther: fengxiuchuan
     * @date: 2018/8/9 18:06
     */
    int deleteByRoleCode(String roleCode) throws ATPException;
}
