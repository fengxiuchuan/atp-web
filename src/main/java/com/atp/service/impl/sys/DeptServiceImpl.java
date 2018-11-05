package com.atp.service.impl.sys;

import java.util.List;

import com.atp.dto.sys.DeptDTO;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atp.entity.sys.Dept;
import com.atp.service.sys.DeptService;
import com.atp.dao.sys.DeptDao;
/*
* @Description: DeptService 实现类
 * @author: fengxiuchuan
 * @date: 2018-11-04 19:54:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    @Transactional(readOnly = true)
    public Dept getById(Long id) {
        if (id == null) {
            return null;
        }
        return deptDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<Dept> queryList(DeptDTO dto)  {
        if (dto == null) {
            return null;
        }
        return deptDao.queryList(dto);
    }
    


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(Dept record)  {
        if (record == null) {
            return 0;
        }
        return deptDao.save(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveBatch(List<Dept> recordList)  {
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return deptDao.saveBatch(recordList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(Dept record)  {
        if (record == null) {
            return 0;
        }
        return deptDao.updateById(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long id)  {
        if (id == null) {
            return 0;
        }
        return deptDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatchByIds(List<Long> ids)  {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return deptDao.deleteBatchByIds(ids);
    }
}
