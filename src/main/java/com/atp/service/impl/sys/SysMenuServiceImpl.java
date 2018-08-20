package com.atp.service.impl.sys;

import java.util.List;
import java.util.Objects;

import com.atp.exception.ATPException;
import com.atp.util.TreeUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public List<SysMenuDTO> queryMenuTree(SysMenuDTO menuDTO) throws ATPException {
        List<SysMenuDTO> menuList = sysMenuDao.queryMenuTree(menuDTO);
        menuList = TreeUtil.getTreeList(-1L,menuList);
        return menuList;
    }

    @Override
    public void addMenu(SysMenu sysMenu) throws ATPException {
        // 1 校验
        validateForm(sysMenu);
        // 2 保存
        this.sysMenuDao.save(sysMenu);

        Long id = sysMenu.getId();
        Long parentId = sysMenu.getParentId();
        SysMenu tempSysMenu = new SysMenu();
        tempSysMenu.setId(id);
        if(Objects.isNull(parentId) || Objects.equals(-1L,parentId)){
            tempSysMenu.setLevel(1);
            tempSysMenu.setMenuPath(id +",");
        }else{
            SysMenu parentMenu =  sysMenuDao.selectByPrimaryKey(parentId);
            tempSysMenu.setLevel(parentMenu.getLevel()+1);
            tempSysMenu.setMenuPath(parentMenu.getMenuPath()+id+",");
        }
        sysMenuDao.updateByPrimaryKeySelective(tempSysMenu);
    }

    private void validateForm(SysMenu sysMenu) throws ATPException{
        if(Objects.isNull(sysMenu)){
            throw new IllegalArgumentException("非法的请求参数");
        }
        if(StringUtils.isEmpty(sysMenu.getName())){
            throw new ATPException("请填写资源名称");
        }
        if(Objects.isNull(sysMenu.getState())){
            throw new ATPException("请选择状态");
        }
        if(StringUtils.isBlank(sysMenu.getMenuType())){
            throw new ATPException("请选择资源类型");
        }
        if(StringUtils.isNotBlank(sysMenu.getMenuType()) && Objects.equals("menu",sysMenu.getMenuType()) ){
            if(StringUtils.isEmpty(sysMenu.getComponent())){
                throw new ATPException("请填写组件名称");
            }
        }
    }

    @Override
    public void delMenu(Long id) throws ATPException{
        this.sysMenuDao.deleteByPrimaryKey(id);
    }

    @Override
    public void editMenu(SysMenu sysMenu) throws ATPException{
        // 1 校验
        validateForm(sysMenu);
        // 2 保存
        this.sysMenuDao.updateByPrimaryKeySelective(sysMenu);
        Long id = sysMenu.getId();
        Long parentId = sysMenu.getParentId();
        SysMenu tempSysMenu = new SysMenu();
        tempSysMenu.setId(id);
        if(Objects.isNull(parentId)|| Objects.equals(-1,parentId)){
            tempSysMenu.setLevel(1);
            tempSysMenu.setMenuPath(id +",");
        }else{
            SysMenu parentMenu =  sysMenuDao.selectByPrimaryKey(parentId);
            tempSysMenu.setLevel(parentMenu.getLevel()+1);
            tempSysMenu.setMenuPath(parentMenu.getMenuPath()+id+",");
        }
        sysMenuDao.updateByPrimaryKeySelective(tempSysMenu);
    }
}
