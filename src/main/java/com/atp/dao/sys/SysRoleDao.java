package com.atp.dao.sys;

import java.util.List;

import com.atp.exception.ATPException;
import com.atp.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.atp.entity.sys.SysRole;
import com.atp.dto.sys.SysRoleDTO;
/**
 * @Description: SysRoleDao
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:46
 */
@Repository
public interface SysRoleDao extends MyMapper<SysRole> {



    /**
     * 根据条件查询对象列表
     * 
     * @param dto SysRoledto查询对象
     * @return List<SysRole> SysRole对象列表
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:46
     */
    List<SysRole> queryList(SysRoleDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  SysRole对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:46
     */
    int save(SysRole record) throws ATPException;

    /**
     * 批量保存对象信息
     * 
     * @param List SysRole对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:46
     */
    int saveBatch(List<SysRole> recordList) throws ATPException;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SysRole对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:46
     */
    int deleteBatchByIds(List<Long> ids) throws ATPException;

    /**
     * 根据Id修改对象信息
     *
     * @param dto SysRoleVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:46
     */
    int updateById(SysRoleDTO dto);

    /**
     *
     * 查询所有角色列表
     *
     * @param:
     * @return: 
     * @auther: fengxiuchuan
     * @date: 2018/8/2 14:58
     */
    List<SysRoleDTO> queryAllList(SysRoleDTO roleDTO);

    /**
     *
     * 根据角色编码查询角色记录
     *
     * @param:
     * @return: 
     * @auther: fengxiuchuan
     * @date: 2018/8/2 14:58
     */
    List<SysRoleDTO> queryRoleListByCode(@Param("roleCode") String roleCode, @Param("id")Long id);

    List<Long> queryRoleMenuList(String roleCode);

    List<SysRoleDTO> getRoleList();
}
