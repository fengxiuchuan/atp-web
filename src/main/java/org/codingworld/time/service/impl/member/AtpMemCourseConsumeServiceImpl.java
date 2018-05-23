package org.codingworld.time.service.impl.member;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.codingworld.time.entity.member.AtpMemCourseConsume;
import org.codingworld.time.dto.member.AtpMemCourseConsumeDTO;
import org.codingworld.time.service.member.AtpMemCourseConsumeService;
import org.codingworld.time.dao.member.AtpMemCourseConsumeDao;

/**
 * @Description: AtpMemCourseConsumeService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:28
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpMemCourseConsumeServiceImpl implements AtpMemCourseConsumeService {

    @Autowired
    private AtpMemCourseConsumeDao atpMemCourseConsumeDao;

    @Override
    @Transactional(readOnly = true)
    public AtpMemCourseConsume getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpMemCourseConsumeDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpMemCourseConsume> queryList(AtpMemCourseConsumeDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpMemCourseConsumeDao.queryList(dto);
    }
    


    @Override
    public int save(AtpMemCourseConsume record)  {
        if (record == null) {
            return 0;
        }
        return atpMemCourseConsumeDao.save(record);
    }

    @Override
    public int saveBatch(List<AtpMemCourseConsume> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpMemCourseConsumeDao.saveBatch(recordList);
    }

    @Override
    public int updateById(AtpMemCourseConsume record)  {
        if (record == null) {
            return 0;
        }
        return atpMemCourseConsumeDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpMemCourseConsumeDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpMemCourseConsumeDao.deleteBatchByIds(ids);
    }
}
