package com.atp.service.impl.member;

import com.atp.dao.member.AtpMemberDao;
import com.atp.dto.member.AtpMemberDTO;
import com.atp.entity.member.AtpMember;
import com.atp.service.member.AtpMemberService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
