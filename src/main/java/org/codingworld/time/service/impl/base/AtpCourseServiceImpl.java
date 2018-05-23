package org.codingworld.time.service.impl.base;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.codingworld.time.entity.base.AtpCourse;
import org.codingworld.time.dto.base.AtpCourseDTO;
import org.codingworld.time.service.base.AtpCourseService;
import org.codingworld.time.dao.base.AtpCourseDao;

/**
 * @Description: AtpCourseService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:47:08
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpCourseServiceImpl implements AtpCourseService {

    @Autowired
    private AtpCourseDao atpCourseDao;

    @Override
    @Transactional(readOnly = true)
    public AtpCourse getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpCourseDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpCourse> queryList(AtpCourseDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpCourseDao.queryList(dto);
    }
    


    @Override
    public int save(AtpCourse record)  {
        if (record == null) {
            return 0;
        }
        return atpCourseDao.save(record);
    }

    @Override
    public int saveBatch(List<AtpCourse> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpCourseDao.saveBatch(recordList);
    }

    @Override
    public int updateById(AtpCourse record)  {
        if (record == null) {
            return 0;
        }
        return atpCourseDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpCourseDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpCourseDao.deleteBatchByIds(ids);
    }
}
