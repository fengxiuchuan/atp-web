package org.codingworld.time.service.coach;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.codingworld.time.entity.coach.AtpCoach;
import org.codingworld.time.dto.coach.AtpCoachDTO;
import org.codingworld.time.service.coach.AtpCoachService;
import org.codingworld.time.dao.coach.AtpCoachDao;

/**
 * @Description: AtpCoachService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:34:16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpCoachServiceImpl implements AtpCoachService {

    @Autowired
    private AtpCoachDao atpCoachDao;

    @Override
    @Transactional(readOnly = true)
    public AtpCoach getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpCoachDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpCoach> queryList(AtpCoachDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpCoachDao.queryList(dto);
    }
    


    @Override
    public int save(AtpCoach record)  {
        if (record == null) {
            return 0;
        }
        return atpCoachDao.save(record);
    }

    @Override
    public int saveBatch(List<AtpCoach> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpCoachDao.saveBatch(recordList);
    }

    @Override
    public int updateById(AtpCoach record)  {
        if (record == null) {
            return 0;
        }
        return atpCoachDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpCoachDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpCoachDao.deleteBatchByIds(ids);
    }
}
