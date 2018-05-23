package org.codingworld.time.service.impl.base;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.codingworld.time.entity.base.AtpGym;
import org.codingworld.time.dto.base.AtpGymDTO;
import org.codingworld.time.service.base.AtpGymService;
import org.codingworld.time.dao.base.AtpGymDao;

/**
 * @Description: AtpGymService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpGymServiceImpl implements AtpGymService {

    @Autowired
    private AtpGymDao atpGymDao;

    @Override
    @Transactional(readOnly = true)
    public AtpGym getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpGymDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpGym> queryList(AtpGymDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpGymDao.queryList(dto);
    }
    


    @Override
    public int save(AtpGym record)  {
        if (record == null) {
            return 0;
        }
        return atpGymDao.save(record);
    }

    @Override
    public int saveBatch(List<AtpGym> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpGymDao.saveBatch(recordList);
    }

    @Override
    public int updateById(AtpGym record)  {
        if (record == null) {
            return 0;
        }
        return atpGymDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpGymDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpGymDao.deleteBatchByIds(ids);
    }
}
