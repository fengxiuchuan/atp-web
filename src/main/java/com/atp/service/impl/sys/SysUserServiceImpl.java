package com.atp.service.impl.sys;

import java.util.List;

import com.atp.exception.ATPException;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atp.entity.sys.SysUser;
import com.atp.dto.sys.SysUserDTO;
import com.atp.service.sys.SysUserService;
import com.atp.dao.sys.SysUserDao;
/**
 * @Description: SysUserService 实现类
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    @Transactional(readOnly = true)
    public SysUser getById(Long id) throws ATPException {
        if (id == null) {
            return null;
        }
        return sysUserDao.selectByPrimaryKey(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<SysUser> queryList(SysUserDTO dto)  throws ATPException{
        if (dto == null) {
            return null;
        }
        return sysUserDao.queryList(dto);
    }
    


    @Override
    public int save(SysUser record)  throws ATPException{
        if (record == null) {
            return 0;
        }
        return sysUserDao.save(record);
    }

    @Override
    public int saveBatch(List<SysUser> recordList)  throws ATPException{
        if (CollectionUtils.isEmpty(recordList)) {
            return 0;
        }
        return sysUserDao.saveBatch(recordList);
    }

    @Override
    public int updateById(SysUser record)  throws ATPException{
        if (record == null) {
            return 0;
        }
        return sysUserDao.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(Long id)  throws ATPException{
        if (id == null) {
            return 0;
        }
        return sysUserDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByIds(List<Long> ids)  throws ATPException{
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return sysUserDao.deleteBatchByIds(ids);
    }
}
