package com.atp.service.impl.sys;

import java.util.List;

import com.atp.exception.ATPException;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atp.entity.sys.SysRole;
import com.atp.dto.sys.SysRoleDTO;
import com.atp.service.sys.SysRoleService;
import com.atp.dao.sys.SysRoleDao;
/**
 * @Description: SysRoleService 实现类
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:46
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    @Transactional(readOnly = true)
    public SysRole getById(Long id) throws ATPException {
        if (id == null) {
            return null;
        }
        return sysRoleDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<SysRole> queryList(SysRoleDTO dto)  throws ATPException{
        if (dto == null) {
            return null;
        }
        return sysRoleDao.queryList(dto);
    }
    


    @Override
    public int save(SysRole record)  throws ATPException{
        if (record == null) {
            return 0;
        }
        return sysRoleDao.save(record);
    }

    @Override
    public int saveBatch(List<SysRole> recordList)  throws ATPException{
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return sysRoleDao.saveBatch(recordList);
    }

    @Override
    public int updateById(SysRole record)  throws ATPException{
        if (record == null) {
            return 0;
        }
        return sysRoleDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  throws ATPException{
        if (id == null) {
            return 0;
        }
        return sysRoleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  throws ATPException{
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return sysRoleDao.deleteBatchByIds(ids);
    }
}
