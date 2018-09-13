package com.atp.controller.sys;


import javax.annotation.Resource;
import java.util.List;

import com.atp.common.GlobalConstants;
import com.atp.common.ResultMessage;
import com.atp.controller.BaseController;
import com.atp.dto.sys.SysRoleDTO;
import com.atp.exception.ATPException;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.atp.entity.sys.SysUser;
import com.atp.dto.sys.SysUserDTO;
import com.atp.service.sys. SysUserService;


/**
 * @Description: SysUsercontroller
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:47
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysUserService sysUserService;


    // 1 列表
    @PostMapping(value = "/queryAllList.json")
    public ResultMessage queryAllList(SysUserDTO userDTO) throws ATPException {
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",sysUserService.queryAllList(userDTO),true);
    }

    // 2 新增
    @PostMapping(value = "/addUser.do")
    public ResultMessage addUser(SysUser sysUser) throws ATPException{
        sysUserService.addUser(sysUser);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"新增用户成功");
    }

    // 3 编辑
    @PostMapping(value = "/editUser.do")
    public ResultMessage editUser(SysUser sysUser) throws ATPException{
        sysUserService.editUser(sysUser);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"更新用户成功");
    }

    //3 删除用户
    @DeleteMapping(value = "/delUser.do")
    public ResultMessage delUser(Long id) throws ATPException{
        sysUserService.delUser(id);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"新增用户成功");
    }

    //4 授权角色
    @PostMapping(value = "/grantRole.do")
    public ResultMessage grantRole(SysUserDTO sysUserDTO) throws ATPException{
        sysUserService.grantRole(sysUserDTO);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"分配角色成功");
    }
}
