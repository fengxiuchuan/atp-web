package com.atp.service.impl.sys;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.atp.common.GlobalConstants;
import com.atp.common.SystemContext;
import com.atp.dao.sys.SysMenuDao;
import com.atp.dao.sys.SysRoleMenuDao;
import com.atp.dao.sys.SysUserRoleDao;
import com.atp.dto.base.response.BasePageResponse;
import com.atp.dto.sys.SysMenuDTO;
import com.atp.dto.sys.SysRoleDTO;
import com.atp.dto.sys.SysUserRoleDTO;
import com.atp.entity.sys.SysUserRole;
import com.atp.exception.ATPException;
import com.atp.service.TokenService;
import com.atp.util.MD5Util;
import com.atp.util.StringUtil;
import com.atp.util.TreeUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Autowired
    private SysMenuDao sysMenuDao;

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Autowired
    private TokenService tokenService;


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

    @Override
    public BasePageResponse<SysUserDTO> queryAllList(SysUserDTO userDTO) throws ATPException {
        Page<Object> page = PageHelper.startPage(userDTO.getPage(), userDTO.getPageSize(), StringUtils.isBlank(userDTO.getOrderBy()) ? "":userDTO.getOrderBy());
        List<SysUserDTO> list = sysUserDao.queryAllList(userDTO);
        BasePageResponse<SysUserDTO> response = new BasePageResponse<SysUserDTO>();


        if (list != null) {
            response.setRows(list);
            response.setTotal((int) page.getTotal());
            response.setTotalPage(userDTO.getPageSize());

            //设置选中的角色
           List<SysUserRoleDTO>  userRoleList = sysUserRoleDao.getUserGroupRoleList();
           if(CollectionUtils.isNotEmpty(userRoleList)){
               for (SysUserDTO iterUser : list) {
                   List<SysUserRoleDTO>  iterUserRoleList = userRoleList.stream().filter(sysUserRoleDTO -> Objects.equals(iterUser.getId(),sysUserRoleDTO.getUserId())).collect(Collectors.toList());
                   if(CollectionUtils.isEmpty(iterUserRoleList) || StringUtils.isBlank(iterUserRoleList.get(0).getRoleCodes())){
                       iterUser.setUserRoleArr(new String[]{});
                       continue;
                   }
                   iterUser.setUserRoleArr(iterUserRoleList.get(0).getRoleCodes().split(","));
               }
           }

        }

        return response;
    }

    @Override
    public void addUser(SysUser sysUser) throws ATPException {
        // 1 校验
        validateUser(sysUser);
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        // 2 保存
        sysUserDao.save(sysUser);
    }

    private void validateUser(SysUser sysUser) throws ATPException{
        if(Objects.isNull(sysUser)){
            throw new ATPException("非法的请求参数");
        }
        if(StringUtils.isBlank(sysUser.getUserName())){
            throw new ATPException("请填写用户名");
        }
        if(Objects.isNull(sysUser.getId()) && StringUtils.isBlank(sysUser.getUserPwd())){
            throw new ATPException("请填写用户密码");
        }
        if(StringUtils.isBlank(sysUser.getPhone())){
            throw new ATPException("请填写联系方式");
        }
        List<SysUser> userList = sysUserDao.authUserByUserName(sysUser.getUserName(),sysUser.getId());
        if(CollectionUtils.isNotEmpty(userList)){
            throw new ATPException("用户名重复");
        }

        List<SysUser> userList2 = sysUserDao.authUserByUserPhone(sysUser.getPhone(),sysUser.getId());
        if(CollectionUtils.isNotEmpty(userList2)){
            throw new ATPException("手机号重复");
        }
    }
    @Override
    public void editUser(SysUser sysUser) throws ATPException {
        //1 校验
        validateUser(sysUser);
        //2 更新
        SysUser tempUser = new SysUser();
        tempUser.setUserName(sysUser.getUserName());
        tempUser.setEnabled(sysUser.getEnabled());
        tempUser.setFaceImg(sysUser.getFaceImg());
        tempUser.setPhone(sysUser.getPhone());
        tempUser.setRemark(sysUser.getPhone());
        sysUserDao.updateByPrimaryKeySelective(tempUser);
    }

    @Override
    public void delUser(Long id) throws ATPException {
        if(Objects.isNull(id)){
            throw new ATPException("请求参数为空");
        }
        sysUserDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void grantRole(SysUserDTO sysUserDTO) throws ATPException {
        if(Objects.isNull(sysUserDTO) || Objects.isNull(sysUserDTO.getId())){
            throw new IllegalArgumentException("非法的请求参数");
        }
        Long userId = sysUserDTO.getId();
        this.sysUserRoleDao.delByUserId(userId);
        String roleCodes = sysUserDTO.getRoleCodes();

        if(StringUtils.isNotEmpty(roleCodes)){
            for(String roleCode : roleCodes.split(",")){
                if(StringUtils.isNotBlank(roleCode)){
                    SysUserRole userRole = new SysUserRole();
                    userRole.setUserId(userId);
                    userRole.setRoleCode(roleCode);
                    sysUserRoleDao.save(userRole);
                }
            }
        }
    }

    @Override
    public SysUserDTO login(SysUserDTO sysUserDTO) throws ATPException {
        if(StringUtils.isBlank(sysUserDTO.getUserName()) || StringUtils.isBlank(sysUserDTO.getUserPwd())){
            throw new IllegalArgumentException("请输入用户名和密码");
        }
        boolean isSuperAdmin = false;
        // 根据用户角色获取菜单

        String userPwd = sysUserDTO.getUserPwd();
        sysUserDTO.setUserPwd(MD5Util.encrypt(userPwd));
        SysUserDTO curUser = sysUserDao.authByPwd(sysUserDTO);
        if(Objects.isNull(curUser)){
            throw new ATPException("用户名或密码错误");
        }

        if(Objects.equals(GlobalConstants.SUPER_ADMIN_NAME,sysUserDTO.getUserName())
                || (StringUtils.isNotBlank(curUser.getRoleCodes()) && curUser.getRoleCodes().indexOf(GlobalConstants.SUPER_ADMIN_NAME) > -1)){
            isSuperAdmin = true;
        }

        String token = tokenService.getToken(curUser);
        SystemContext.getRequest().getSession().setMaxInactiveInterval(2 * 60 * 60);
        SystemContext.getRequest().getSession().setAttribute(GlobalConstants.GLOBAL_TOKEN,token);
        SystemContext.getRequest().getSession().setAttribute(token, JSON.toJSONString(curUser, SerializerFeature.WriteMapNullValue));
        curUser.setToken(token);
        if(!isSuperAdmin && StringUtils.isBlank(curUser.getRoleCodes())){
            return curUser;
        }

        List<SysMenuDTO> menuList = sysMenuDao.queryMenuTree(new SysMenuDTO());
        if(!isSuperAdmin){
            String menuIds =  sysRoleMenuDao.getMenuIdsByRoleCodes(curUser.getRoleCodes().split(","));
            if(StringUtils.isNotBlank(menuIds)){
                menuList = menuList.stream().filter(SysMenuDTO -> menuIds.indexOf(String.valueOf(SysMenuDTO.getId())) > 0).collect(Collectors.toList());;
            }
        }
        menuList = TreeUtil.getTreeList(-1L,menuList);
        curUser.setMenuList(menuList);
        return curUser;
    }

    @Override
    public SysUser findByUserName(String userName) throws ATPException {
        if(StringUtils.isBlank(userName)){
            return null;
        }
        return sysUserDao.findByUserName(userName);
    }
}
