package com.atp.service.impl.sys;

import java.util.List;

import com.atp.exception.ATPException;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atp.entity.sys.SysUserRole;
import com.atp.dto.sys.SysUserRoleDTO;
import com.atp.service.sys.SysUserRoleService;
import com.atp.dao.sys.SysUserRoleDao;
/**
 * @Description: SysUserRoleService 实现类
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    @Transactional(readOnly = true)
    public SysUserRole getById(Long id) throws ATPException {
        if (id == null) {
            return null;
        }
        return sysUserRoleDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<SysUserRole> queryList(SysUserRoleDTO dto)  throws ATPException{
        if (dto == null) {
            return null;
        }
        return sysUserRoleDao.queryList(dto);
    }
    


    @Override
    public int save(SysUserRole record)  throws ATPException{
        if (record == null) {
            return 0;
        }
        return sysUserRoleDao.save(record);
    }

    @Override
    public int saveBatch(List<SysUserRole> recordList)  throws ATPException{
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return sysUserRoleDao.saveBatch(recordList);
    }

    @Override
    public int updateById(SysUserRole record)  throws ATPException{
        if (record == null) {
            return 0;
        }
        return sysUserRoleDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  throws ATPException{
        if (id == null) {
            return 0;
        }
        return sysUserRoleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  throws ATPException{
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return sysUserRoleDao.deleteBatchByIds(ids);
    }
}
