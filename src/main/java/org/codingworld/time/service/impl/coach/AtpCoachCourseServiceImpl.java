package org.codingworld.time.service.impl.coach;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.codingworld.time.entity.coach.AtpCoachCourse;
import org.codingworld.time.dto.coach.AtpCoachCourseDTO;
import org.codingworld.time.service.coach.AtpCoachCourseService;
import org.codingworld.time.dao.coach.AtpCoachCourseDao;

/**
 * @Description: AtpCoachCourseService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:39:01
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpCoachCourseServiceImpl implements AtpCoachCourseService {

    @Autowired
    private AtpCoachCourseDao atpCoachCourseDao;

    @Override
    @Transactional(readOnly = true)
    public AtpCoachCourse getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpCoachCourseDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpCoachCourse> queryList(AtpCoachCourseDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpCoachCourseDao.queryList(dto);
    }
    


    @Override
    public int save(AtpCoachCourse record)  {
        if (record == null) {
            return 0;
        }
        return atpCoachCourseDao.save(record);
    }

    @Override
    public int saveBatch(List<AtpCoachCourse> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpCoachCourseDao.saveBatch(recordList);
    }

    @Override
    public int updateById(AtpCoachCourse record)  {
        if (record == null) {
            return 0;
        }
        return atpCoachCourseDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpCoachCourseDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpCoachCourseDao.deleteBatchByIds(ids);
    }
}
