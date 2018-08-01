package com.atp.service.impl.sys;

import java.util.List;

import com.atp.exception.ATPException;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atp.entity.sys.SysMenu;
import com.atp.dto.sys.SysMenuDTO;
import com.atp.service.sys.SysMenuService;
import com.atp.dao.sys.SysMenuDao;
/**
 * @Description: SysMenuService 实现类
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:45
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    @Transactional(readOnly = true)
    public SysMenu getById(Long id) throws ATPException {
        if (id == null) {
            return null;
        }
        return sysMenuDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<SysMenu> queryList(SysMenuDTO dto)  throws ATPException{
        if (dto == null) {
            return null;
        }
        return sysMenuDao.queryList(dto);
    }
    


    @Override
    public int save(SysMenu record)  throws ATPException{
        if (record == null) {
            return 0;
        }
        return sysMenuDao.save(record);
    }

    @Override
    public int saveBatch(List<SysMenu> recordList)  throws ATPException{
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return sysMenuDao.saveBatch(recordList);
    }

    @Override
    public int updateById(SysMenu record)  throws ATPException{
        if (record == null) {
            return 0;
        }
        return sysMenuDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  throws ATPException{
        if (id == null) {
            return 0;
        }
        return sysMenuDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  throws ATPException{
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return sysMenuDao.deleteBatchByIds(ids);
    }
}
