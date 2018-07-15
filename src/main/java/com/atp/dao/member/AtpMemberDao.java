package com.atp.dao.member;

import com.atp.dto.member.AtpMemCourseDTO;
import com.atp.util.MyMapper;
import com.atp.dto.base.AtpCourseDTO;
import com.atp.dto.member.AtpMemberDTO;
import com.atp.entity.member.AtpMember;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


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
    int updateById(AtpMember atpMember);

    List<AtpMemberDTO> queryListByPhone(@Param("phone") String phone,@Param("excludId") Long id);

    List<AtpMemberDTO> queryListByCardNo(@Param("cardNo") String cardNo,@Param("excludId") Long id);

    List<AtpMemCourseDTO> queryCourseListByMemId(Long memberId);

    List<AtpMemberDTO> queryAllList(AtpMemberDTO atpMemberDTO);

    List<AtpMember> getMemberList();
}
