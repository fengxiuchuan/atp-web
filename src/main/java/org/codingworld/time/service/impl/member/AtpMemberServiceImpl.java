package org.codingworld.time.service.impl.member;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.codingworld.time.entity.member.AtpMember;
import org.codingworld.time.dto.member.AtpMemberDTO;
import org.codingworld.time.service.member.AtpMemberService;
import org.codingworld.time.dao.member.AtpMemberDao;

/**
 * @Description: AtpMemberService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpMemberServiceImpl implements AtpMemberService {

    @Autowired
    private AtpMemberDao atpMemberDao;

    @Override
    @Transactional(readOnly = true)
    public AtpMember getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpMemberDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpMember> queryList(AtpMemberDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpMemberDao.queryList(dto);
    }
    


    @Override
    public int save(AtpMember record)  {
        if (record == null) {
            return 0;
        }
        return atpMemberDao.save(record);
    }

    @Override
    public int saveBatch(List<AtpMember> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpMemberDao.saveBatch(recordList);
    }

    @Override
    public int updateById(AtpMember record)  {
        if (record == null) {
            return 0;
        }
        return atpMemberDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpMemberDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpMemberDao.deleteBatchByIds(ids);
    }
}
