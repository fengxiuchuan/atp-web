package com.atp.service.impl.sys;

import java.util.List;

import com.atp.exception.ATPException;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atp.entity.sys.SysUserPermission;
import com.atp.dto.sys.SysUserPermissionDTO;
import com.atp.service.sys.SysUserPermissionService;
import com.atp.dao.sys.SysUserPermissionDao;
/**
 * @Description: SysUserPermissionService 实现类
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserPermissionServiceImpl implements SysUserPermissionService {

    @Autowired
    private SysUserPermissionDao sysUserPermissionDao;

    @Override
    @Transactional(readOnly = true)
    public SysUserPermission getById(Long id) throws ATPException {
        if (id == null) {
            return null;
        }
        return sysUserPermissionDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<SysUserPermission> queryList(SysUserPermissionDTO dto)  throws ATPException{
        if (dto == null) {
            return null;
        }
        return sysUserPermissionDao.queryList(dto);
    }
    


    @Override
    public int save(SysUserPermission record)  throws ATPException{
        if (record == null) {
            return 0;
        }
        return sysUserPermissionDao.save(record);
    }

    @Override
    public int saveBatch(List<SysUserPermission> recordList)  throws ATPException{
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return sysUserPermissionDao.saveBatch(recordList);
    }

    @Override
    public int updateById(SysUserPermission record)  throws ATPException{
        if (record == null) {
            return 0;
        }
        return sysUserPermissionDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  throws ATPException{
        if (id == null) {
            return 0;
        }
        return sysUserPermissionDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  throws ATPException{
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return sysUserPermissionDao.deleteBatchByIds(ids);
    }
}
