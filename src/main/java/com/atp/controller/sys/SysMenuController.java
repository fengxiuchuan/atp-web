package com.atp.controller.sys;


import javax.annotation.Resource;
import java.util.List;

import com.atp.common.GlobalConstants;
import com.atp.common.ResultMessage;
import com.atp.controller.BaseController;
import com.atp.exception.ATPException;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.atp.entity.sys.SysMenu;
import com.atp.dto.sys.SysMenuDTO;
import com.atp.service.sys. SysMenuService;


/**
 * @Description: SysMenucontroller
 * @author: fengxiuchuan
 * @date: 2018-08-01 17:57:45
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysMenuService sysMenuService;

    // 1 查询资源树
    @PostMapping(value = "/queryMenuTree.json")
    public ResultMessage queryMenuTree(SysMenuDTO menuDTO) throws ATPException{
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功",sysMenuService.queryMenuTree(menuDTO),true);
    }
    //2 新增资源节点
    @PostMapping(value = "/addMenu.do")
    public ResultMessage addMenu(SysMenu sysMenu) throws ATPException{
        sysMenuService.addMenu(sysMenu);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"查询成功");
    }
    //3 删除资源节点
    @DeleteMapping(value = "/delMenu.do")
    public ResultMessage delMenu(Long id) throws ATPException{
        sysMenuService.delMenu(id);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"删除成功");
    }
    //4 更新资源节点
    @PostMapping(value = "/editMenu.do")
    public ResultMessage editMenu(SysMenu sysMenu) throws ATPException{
        sysMenuService.editMenu(sysMenu);
        return new ResultMessage(GlobalConstants.RESPONSE_CODE_SUCCESS_DEFAULT,"更新成功");
    }
}
