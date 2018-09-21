package com.atp.dao.sys;

import java.util.List;

import com.atp.exception.ATPException;
import com.atp.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.atp.entity.sys.SysUser;
import com.atp.dto.sys.SysUserDTO;
/**
 * @Description: SysUserDao
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
@Repository
public interface SysUserDao extends MyMapper<SysUser> {



    /**
     * 根据条件查询对象列表
     * 
     * @param dto SysUserdto查询对象
     * @return List<SysUser> SysUser对象列表
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    List<SysUser> queryList(SysUserDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  SysUser对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int save(SysUser record) throws ATPException;

    /**
     * 批量保存对象信息
     * 
     * @param List SysUser对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int saveBatch(List<SysUser> recordList) throws ATPException;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SysUser对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int deleteBatchByIds(List<Long> ids) throws ATPException;

    /**
     * 根据Id修改对象信息
     *
     * @param dto SysUserVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-08-01 17:57:47
     */
    int updateById(SysUserDTO dto);

    List<SysUserDTO> queryAllList(SysUserDTO userDTO);

    List<SysUser> authUserByUserName(@Param("userName") String userName,@Param("id") Long id);

    List<SysUser> authUserByUserPhone(@Param("phone")String phone,@Param("id") Long id);

    SysUserDTO authByPwd(SysUserDTO sysUserDTO);

    SysUser findByUserName(String userName);
}
