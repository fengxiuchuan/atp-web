package com.atp.service.impl.sys;

import java.util.List;

import com.atp.exception.ATPException;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atp.entity.sys.SysRoleMenu;
import com.atp.dto.sys.SysRoleMenuDTO;
import com.atp.service.sys.SysRoleMenuService;
import com.atp.dao.sys.SysRoleMenuDao;
/**
 * @Description: SysRoleMenuService 实现类
 * @author: fengxiuchuan
 * @date: 2018-08-09 17:04:19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    @Transactional(readOnly = true)
    public SysRoleMenu getById(Long id) throws ATPException {
        if (id == null) {
            return null;
        }
        return sysRoleMenuDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<SysRoleMenu> queryList(SysRoleMenuDTO dto)  throws ATPException{
        if (dto == null) {
            return null;
        }
        return sysRoleMenuDao.queryList(dto);
    }
    


    @Override
    public int save(SysRoleMenu record)  throws ATPException{
        if (record == null) {
            return 0;
        }
        return sysRoleMenuDao.save(record);
    }

    @Override
    public int saveBatch(List<SysRoleMenu> recordList)  throws ATPException{
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return sysRoleMenuDao.saveBatch(recordList);
    }

    @Override
    public int updateById(SysRoleMenu record)  throws ATPException{
        if (record == null) {
            return 0;
        }
        return sysRoleMenuDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  throws ATPException{
        if (id == null) {
            return 0;
        }
        return sysRoleMenuDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  throws ATPException{
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return sysRoleMenuDao.deleteBatchByIds(ids);
    }
}
