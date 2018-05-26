package com.atp.service.impl.member;

import com.atp.common.GlobalConstants;
import com.atp.dao.member.AtpMemCourseDao;
import com.atp.dto.member.AtpMemCourseConsumeDTO;
import com.atp.dto.member.AtpMemCourseDTO;
import com.atp.entity.member.AtpMemCourse;
import com.atp.service.member.AtpMemCourseConsumeService;
import com.atp.service.member.AtpMemCourseService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    private AtpMemCourseConsumeService atpMemCourseConsumeService;

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
    @Transactional(rollbackFor = Exception.class)
    public int save(AtpMemCourse record)  {
        if (record == null) {
            return 0;
        }
        return atpMemCourseDao.save(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveBatch(List<AtpMemCourse> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return atpMemCourseDao.saveBatch(recordList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(AtpMemCourse record)  {
        if (record == null) {
            return 0;
        }
        return atpMemCourseDao.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return atpMemCourseDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return atpMemCourseDao.deleteBatchByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void payCourse(AtpMemCourseDTO atpMemCourseDTO) {
        atpMemCourseDTO.setCreatedBy(GlobalConstants.SUPER_ADMIN_ID);
        atpMemCourseDTO.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
        atpMemCourseDTO.setCreatedTime(new Date());
        atpMemCourseDao.save(atpMemCourseDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void consumeCourse(AtpMemCourseConsumeDTO consumeDTO) {
        consumeDTO.setCreatedBy(GlobalConstants.SUPER_ADMIN_ID);
        consumeDTO.setCreatedName(GlobalConstants.SUPER_ADMIN_NAME);
        consumeDTO.setCreatedTime(new Date());
        consumeDTO.setConsumeTime(new Date());
        atpMemCourseConsumeService.save(consumeDTO);
    }

}
