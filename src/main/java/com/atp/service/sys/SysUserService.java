package com.atp.service.sys;

import java.util.List;

import com.atp.dto.base.response.BasePageResponse;
import com.atp.entity.sys.SysUser;
import com.atp.dto.sys.SysUserDTO;
import com.atp.exception.ATPException;

/**
 * @Description: SysUserService
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
public interface SysUserService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return SysUser 对象信息
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    SysUser getById(Long id) throws ATPException;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto SysUserdto查询对象
     * @return List<SysUser> SysUser对象列表
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    List<SysUser> queryList(SysUserDTO dto) throws ATPException;

    /**
     * 保存对象信息
     * 
     * @param  SysUser对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int save(SysUser record)throws ATPException;

    /**
     * 批量保存对象信息
     * 
     * @param List SysUser对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int saveBatch(List<SysUser> recordList)throws ATPException;

    /**
     * 根据Id修改对象信息
     * 
     * @param  SysUser对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int updateById(SysUser record)throws ATPException;
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id SysUser对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int deleteById(Long id)throws ATPException;

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SysUser对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int deleteBatchByIds(List<Long> ids)throws ATPException;

    /**
     *
     * 根据条件查询用户列表
     *
     * @param:
     * @return: 
     * @auther: fengxiuchuan
     * @date: 2018/8/2 12:42
     */
    BasePageResponse<SysUserDTO> queryAllList(SysUserDTO userDTO)throws ATPException;
    /**
     *
     * 新增用户
     *
     * @param:
     * @return:
     * @auther: fengxiuchuan
     * @date: 2018/8/2 12:42
     */
    void addUser(SysUser sysUser)throws ATPException;
    /**
     *
     * 编辑用户
     *
     * @param:
     * @return:
     * @auther: fengxiuchuan
     * @date: 2018/8/2 12:42
     */
    void editUser(SysUser sysUser)throws ATPException;

    /**
     *
     * 根据主键删除用户
     *
     * @param:
     * @return:
     * @auther: fengxiuchuan
     * @date: 2018/8/2 12:42
     */
    void delUser(Long id)throws ATPException;
    /**
     *
     * 给用户分配角色
     *
     * @param:
     * @return:
     * @auther: fengxiuchuan
     * @date: 2018/8/2 12:42
     */
    void grantRole(SysUserDTO sysUserDTO)throws ATPException;

    /**
     *
     * 用户登录
     *
     * @param:
     * @return: 
     * @auther: fengxiuchuan
     * @date: 2018/9/20 15:10
     */
    SysUserDTO login(SysUserDTO sysUserDTO)throws ATPException;
}
