package org.codingworld.time.service.impl.base;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.codingworld.time.entity.base.AtpGymProgram;
import org.codingworld.time.dto.base.AtpGymProgramDTO;
import org.codingworld.time.service.base.AtpGymProgramService;
import org.codingworld.time.dao.base.AtpGymProgramDao;

/**
 * @Description: AtpGymProgramService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpGymProgramServiceImpl implements AtpGymProgramService {

    @Autowired
    private AtpGymProgramDao atpGymProgramDao;

    @Override
    @Transactional(readOnly = true)
    public AtpGymProgram getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpGymProgramDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpGymProgram> queryList(AtpGymProgramDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpGymProgramDao.queryList(dto);
    }
    


    @Override
    public int save(AtpGymProgram record)  {
        if (record == null) {
            return 0;
        }
        return atpGymProgramDao.save(record);
    }

    @Override
    public int saveBatch(List<AtpGymProgram> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpGymProgramDao.saveBatch(recordList);
    }

    @Override
    public int updateById(AtpGymProgram record)  {
        if (record == null) {
            return 0;
        }
        return atpGymProgramDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpGymProgramDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpGymProgramDao.deleteBatchByIds(ids);
    }
}
