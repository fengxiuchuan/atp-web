package org.codingworld.time.dao.member;

import java.util.List;

import org.codingworld.time.common.MyMapper;
import org.springframework.stereotype.Repository;
import org.codingworld.time.entity.member.AtpMember;
import org.codingworld.time.dto.member.AtpMemberDTO;


/**
 * @Description: AtpMemberDao
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:29
 */
@Repository
public interface AtpMemberDao extends MyMapper<AtpMember> {



    /**
     * 根据条件查询对象列表
     * 
     * @param dto AtpMemberdto查询对象
     * @return List<AtpMember> AtpMember对象列表
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:29
     */
    List<AtpMember> queryList(AtpMemberDTO dto);
    

    /**
     * 保存对象信息
     * 
     * @param  AtpMember对象信息
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:29
     */
    int save(AtpMember record) ;

    /**
     * 批量保存对象信息
     * 
     * @param List AtpMember对象列表
     * @return int 保存成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:29
     */
    int saveBatch(List<AtpMember> recordList) ;


    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AtpMember对象Id集合
     * @return int 删除成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:29
     */
    int deleteBatchByIds(List<Long> ids) ;

    /**
     * 根据Id修改对象信息
     *
     * @param dto AtpMemberVO对象
     * @return int 修改成功的记录条数
     * @author: fengxiuchuan
     * @date: 2018-05-23 18:51:29
     */
    int updateById(AtpMemberDTO dto);
}
