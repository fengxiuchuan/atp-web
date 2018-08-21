package com.atp.controller.sys;


import javax.annotation.Resource;
import java.util.List;

import com.atp.common.GlobalConstants;
import com.atp.common.ResultMessage;
import com.atp.controller.BaseController;
import com.atp.dto.member.AtpMemberDTO;
import com.atp.exception.ATPException;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.atp.entity.sys.SysRole;
import com.atp.dto.sys.SysRoleDTO;
import com.atp.service.sys. SysRoleService;


/**
 * @Description: SysRolecontroller
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:46
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysRoleService sysRoleService;


    // 1 列表
    @PostMapping(value = "/queryAllList.json")
    public ResultMessage queryAllList(SysRoleDTO roleDTO) throws ATPException {
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",sysRoleService.queryAllList(roleDTO),true);
    }
    // 2 新增
    @PostMapping(value = "/addRole.do")
    public ResultMessage addRole(SysRole sysRole) throws ATPException{
        sysRoleService.addRole(sysRole);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"保存成功");
    }

    //3 编辑
    @PostMapping(value = "/editRole.do")
    public ResultMessage editRole(SysRole sysRole) throws ATPException{
        sysRoleService.editRole(sysRole);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"编辑成功");
    }
    //4 删除
    @DeleteMapping(value = "delRole.do")
    public ResultMessage delRole(Long id) throws ATPException{
        sysRoleService.delRole(id);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"删除成功");
    }

    //5 根据Id查询详情
    @PostMapping(value = "/getRoleDetail.json")
    public ResultMessage getRoleDetail(Long id) throws ATPException{
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",sysRoleService.getRoleDetail(id),true);
    }

    @PostMapping(value = "/getRoleList.json")
    public ResultMessage getRoleList() throws ATPException{
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",sysRoleService.getRoleList(),true);
    }
}
