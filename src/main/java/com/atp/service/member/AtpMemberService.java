package com.atp.service.member;

import com.atp.dto.member.AtpMemberDTO;
import com.atp.entity.member.AtpMember;

import java.util.List;


/**
 * @Description: AtpMemberService
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:29
 */
public interface AtpMemberService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return AtpMember 对象信息
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:29
     */
    AtpMember getById(Long id) ;


    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpMemberdto查询对象
     * @return List<AtpMember> AtpMember对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:29
     */
    List<AtpMember> queryList(AtpMemberDTO dto) ;

    /**
     * 保存对象信息
     * 
     * @param  AtpMember对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:29
     */
    int save(AtpMember record);

    /**
     * 批量保存对象信息
     * 
     * @param List AtpMember对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:29
     */
    int saveBatch(List<AtpMember> recordList);

    /**
     * 根据Id修改对象信息
     * 
     * @param  AtpMember对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:29
     */
    int updateById(AtpMember record);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id AtpMember对象Id
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:29
     */
    int deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpMember对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:29
     */
    int deleteBatchByIds(List<Long> ids);
}
