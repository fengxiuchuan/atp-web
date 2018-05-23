package org.codingworld.time.service.impl.member;

import org.apache.commons.collections4.CollectionUtils;
import org.codingworld.time.dao.member.AtpMemCourseDao;
import org.codingworld.time.dto.member.AtpMemCourseDTO;
import org.codingworld.time.entity.member.AtpMemCourse;
import org.codingworld.time.service.member.AtpMemCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: AtpMemCourseService 实现类
 * @author: fengxiuchuan
 * @date: 2018-05-23 18:51:26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtpMemCourseServiceImpl implements AtpMemCourseService {

    @Autowired
    private AtpMemCourseDao atpMemCourseDao;

    @Override
    @Transactional(readOnly = true)
    public AtpMemCourse getById(Long id) {
        if (id == null) {
            return null;
        }
        return atpMemCourseDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<AtpMemCourse> queryList(AtpMemCourseDTO dto)  {
        if (dto == null) {
            return null;
        }
        return atpMemCourseDao.queryList(dto);
    }
    


    @Override
    public int save(AtpMemCourse record)  {
        if (record == null) {
            return 0;
        }
        return atpMemCourseDao.save(record);
    }

    @Override
    public int saveBatch(List<AtpMemCourse> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpMemCourseDao.saveBatch(recordList);
    }

    @Override
    public int updateById(AtpMemCourse record)  {
        if (record == null) {
            return 0;
        }
        return atpMemCourseDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpMemCourseDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpMemCourseDao.deleteBatchByIds(ids);
    }
}
