package com.atp.service.sys;

import com.atp.dto.base.response.BasePageResponse;
import com.atp.dto.sys.SysRoleDTO;
import com.atp.entity.sys.SysRole;
import com.atp.exception.ATPException;

import java.util.List;


/**
 * @Description: SysRoleService
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:46
 */
public interface SysRoleService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return SysRole 对象信息
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:46
     */
    SysRole getById(Long id) throws ATPException;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto SysRoledto查询对象
     * @return List<SysRole> SysRole对象列表
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:46
     */
    List<SysRole> queryList(SysRoleDTO dto) throws ATPException;

    /**
     * 保存对象信息
     * 
     * @param  SysRole对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:46
     */
    int save(SysRole record)throws ATPException;

    /**
     * 批量保存对象信息
     * 
     * @param List SysRole对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:46
     */
    int saveBatch(List<SysRole> recordList)throws ATPException;

    /**
     * 根据Id修改对象信息
     * 
     * @param  SysRole对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:46
     */
    int updateById(SysRole record)throws ATPException;
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id SysRole对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:46
     */
    int deleteById(Long id)throws ATPException;

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SysRole对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:46
     */
    int deleteBatchByIds(List<Long> ids)throws ATPException;

    /**
     *
     * 根据提交查询角色列表
     *
     * @param: 
     * @return: 
     * @auther: fengxiuchuan
     * @date: 2018/8/2 12:48
     */
    BasePageResponse<SysRoleDTO> queryAllList(SysRoleDTO roleDTO)throws ATPException;
    /**
     *
     * 新增角色
     *
     * @param:sysRole
     * @return:void
     * @auther: fengxiuchuan
     * @date: 2018/8/2 12:48
     */
    void addRole(SysRole sysRole)throws ATPException;
    /**
     *
     * 编辑角色
     *
     * @param:sysRole
     * @return:void
     * @auther: fengxiuchuan
     * @date: 2018/8/2 12:48
     */
    void editRole(SysRole sysRole)throws ATPException;
    /**
     *
     * 根据主键删除角色
     *
     * @param:id 主键
     * @return:void
     * @auther: fengxiuchuan
     * @date: 2018/8/2 12:48
     */
    void delRole(Long id)throws ATPException;
    /**
     *
     * 根据主键查询详情
     *
     * @param:id 主键
     * @return:void
     * @auther: fengxiuchuan
     * @date: 2018/8/2 12:48
     */
    SysRoleDTO getRoleDetail(Long id)throws ATPException;
    /**
     *
     * 角色列表
     *
     * @return:void
     * @auther: fengxiuchuan
     * @date: 2018/8/2 12:48
     */
    List<SysRoleDTO> getRoleList()throws ATPException;
}
