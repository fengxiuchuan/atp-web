package com.atp.service.impl.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.atp.common.GlobalConstants;
import com.atp.dao.sys.SysRoleMenuDao;
import com.atp.dto.base.response.BasePageResponse;
import com.atp.dto.member.AtpMemCourseDTO;
import com.atp.dto.sys.SysMenuDTO;
import com.atp.entity.sys.SysRoleMenu;
import com.atp.exception.ATPException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

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

    @Override
    public BasePageResponse<SysRoleDTO> queryAllList(SysRoleDTO roleDTO) throws ATPException {
        Page<Object> page = PageHelper.startPage(roleDTO.getPage(), roleDTO.getPageSize(), StringUtils.isBlank(roleDTO.getOrderBy()) ? "":roleDTO.getOrderBy());
        List<SysRoleDTO> list = sysRoleDao.queryAllList(roleDTO);
        BasePageResponse<SysRoleDTO> response = new BasePageResponse<SysRoleDTO>();


        if (list != null) {
            response.setRows(list);
            response.setTotal((int) page.getTotal());
            response.setTotalPage(roleDTO.getPageSize());
            List<SysRoleMenu> roleMenuList = sysRoleMenuDao.selectAll();
            //
            for(SysRoleDTO iterRole : list){
                roleMenuList.stream().filter(sysRoleMenu -> Objects.equals(sysRoleMenu.getRoleCode(),iterRole.getRoleCode())).collect(Collectors.toList());
            }
        }

        return response;
    }

    @Override
    public void addRole(SysRole sysRole) throws ATPException {
        //1 校验
        validateAddForm(sysRole);
        //2 保存
        sysRoleDao.save(sysRole);
        //3 保存角色权限列表
        saveOrUpdateRoleMenu(sysRole,GlobalConstants.SUBMIT_FORM_TYPE.ADD.getCode());
    }

    /**
     *
     * 保存角色菜单权限列表
     *
     * @param:
     * @return: 
     * @auther: fengxiuchuan
     * @date: 2018/8/9 18:15
     */
    private void saveOrUpdateRoleMenu(SysRole sysRole,String type) throws ATPException{
        String roleCode = sysRole.getRoleCode();
        if(Objects.equals(GlobalConstants.SUBMIT_FORM_TYPE.EDIT.getCode(),type)){
            // 需要删除原来的角色菜单授权
            Long id = sysRole.getId();
            SysRole orginRole =  sysRoleDao.selectByPrimaryKey(id);
            sysRoleMenuDao.deleteByRoleCode(orginRole.getRoleCode());
        }
        if(ArrayUtils.isNotEmpty(sysRole.getMenuIdArr())){
            List<SysRoleMenu> roleMenuList = new ArrayList<>();
            for(Long menuId : sysRole.getMenuIdArr()){
                if(Objects.isNull(menuId)){
                    continue;
                }
                SysRoleMenu sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setRoleCode(roleCode);
                sysRoleMenu.setMenuId(menuId);

                //添加到待保存的集合中
                roleMenuList.add(sysRoleMenu);
            }

            if(CollectionUtils.isNotEmpty(roleMenuList)){
                sysRoleMenuDao.saveBatch(roleMenuList);
            }
        }
    }

    private void validateAddForm(SysRole sysRole) throws ATPException{
        if(Objects.isNull(sysRole)){
            throw new ATPException("请求参数不合法");
        }
        if(StringUtils.isBlank(sysRole.getRoleCode()) || StringUtils.isBlank(sysRole.getRoleName())){
            throw new ATPException("请填写角色编号和名称");
        }

        //唯一性校验
        List<SysRoleDTO> roleList = sysRoleDao.queryRoleListByCode(sysRole.getRoleCode(),sysRole.getId());
        if(CollectionUtils.isNotEmpty(roleList)){
            throw new ATPException("角色编码是唯一的");
        }
    }
    @Override
    public void editRole(SysRole sysRole) throws ATPException {
        //1 校验
        validateAddForm(sysRole);
        //2 更新
        sysRoleDao.updateByPrimaryKeySelective(sysRole);
        //3 保存角色权限列表
        saveOrUpdateRoleMenu(sysRole,GlobalConstants.SUBMIT_FORM_TYPE.EDIT.getCode());
    }

    @Override
    public void delRole(Long id) throws ATPException {
        if(Objects.isNull(id)){
            throw new ATPException("非法的请求");
        }
        sysRoleDao.deleteByPrimaryKey(id);
    }

    @Override
    public SysRoleDTO getRoleDetail(Long id) throws ATPException {
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("非法的请求参数");
        }
        SysRoleDTO sysRoleDTO = (SysRoleDTO) sysRoleDao.selectByPrimaryKey(id);
        List<Long> menuIdList = sysRoleDao.queryRoleMenuList(sysRoleDTO.getRoleCode());
        if(CollectionUtils.isNotEmpty(menuIdList)){
            sysRoleDTO.setMenuIdList(menuIdList);
        }
        return sysRoleDTO;
    }
}
